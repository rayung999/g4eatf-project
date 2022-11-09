package com.goteatfproject.appgot.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.goteatfproject.appgot.service.PartyService;
import com.goteatfproject.appgot.vo.AttachedFile;
import com.goteatfproject.appgot.vo.Member;
import com.goteatfproject.appgot.vo.Party;

@Controller
@RequestMapping("/party/")
public class PartyController {

  PartyService partyService;
  ServletContext sc;

  public PartyController(PartyService partyService, ServletContext sc) {
    System.out.println("BoardController() 호출됨!!");
    System.out.println("ServletContext() 호출됨!!");
    this.partyService = partyService;
    this.sc = sc;
  }

  // 파티 리스트
  //  @GetMapping("list")
  //  public String partyList(Model model) throws Exception {
  //    model.addAttribute("parties", partyService.list());
  //    System.out.println(model.getAttribute("parties"));
  //    return "party/partyList";
  //  }

  @GetMapping("list")
  public String partyList(Model model, String meal, String food) throws Exception {
    //    if(meal.length() == 0) { // 파라미터의 값이 없으면 = > 전체 리스트 출력
    //      meal = null;
    //    } // xml if 조건문 설정
    model.addAttribute("parties", partyService.list2(meal, food));
    model.addAttribute("meal", meal);
    model.addAttribute("food", food);
    //        System.out.println(model.getAttribute("parties"));
    return "party/partyList";
  }

  // 파티 리스트 게시물 등록
  @GetMapping("form")
  public String partyFrom() throws Exception {
    return "party/partyAdd";
  }

  // 파티 리스트 게시물 등록 post
  @PostMapping("add")
  public String partyAdd(Party party, HttpSession session,
      @RequestParam("files") MultipartFile[] files) throws Exception {

    party.setAttachedFiles(saveAttachedFiles(files));
    party.setWriter((Member) session.getAttribute("loginMember"));

    System.out.println("filename = " + Arrays.toString(files));
    System.out.println("filename2 = " + files);

    partyService.add(party);
    return "redirect:list";
  }

  private List<AttachedFile> saveAttachedFiles(Part[] files)
      throws IOException, ServletException {
    List<AttachedFile> attachedFiles = new ArrayList<>();
    String dirPath = sc.getRealPath("/party/files");

    for (Part part : files) {
      if (part.getSize() == 0) {
        continue;
      }
      String filename = UUID.randomUUID().toString();
      part.write(dirPath + "/" + filename);
      attachedFiles.add(new AttachedFile(filename));
    }
    return attachedFiles;
  }

  private List<AttachedFile> saveAttachedFiles(MultipartFile[] files)
      throws IOException, ServletException {
    List<AttachedFile> attachedFiles = new ArrayList<>();
    String dirPath = sc.getRealPath("/party/files");


    for (MultipartFile part : files) {
      if (part.isEmpty()) {
        continue;
      }

      System.out.println("filename3 = " + Arrays.toString(files));
      System.out.println("filename4 = " + files);
      System.out.println("dirPath = " + dirPath);

      String filename = UUID.randomUUID().toString();
      part.transferTo(new File(dirPath + "/" + filename));
      attachedFiles.add(new AttachedFile(filename));
    }
    return attachedFiles;
  }

  // 파티 게시물 상세보기
  @GetMapping("detail")
  public Map detail(int no) throws Exception {
    Party party = partyService.get(no);

    if (party == null) {
      throw new Exception("해당 번호의 게시글이 없습니다!");
    }
    Map map = new HashMap();
    map.put("party", party);
    return map;
  }

  // 파티 게시물 수정
  @PostMapping("update")
  public String update(Party party, HttpSession session,
      Part[] files) throws Exception {

    party.setAttachedFiles(saveAttachedFiles(files));

    // detail.html : <input name="no" type="number" value="1" th:value="${party.no}" readonly hidden/>
    // 위에 추가해야 party.getNo() 가져오기 가능 System.out.println("partyNo = " + party.getNo());
    checkOwner(party.getNo(), session);

    if (!partyService.update(party)) {
      throw new Exception("게시글을 변경할 수 없습니다.");
    }
    return "redirect:list";
  }

  private void checkOwner(int partyNo, HttpSession session) throws Exception {
    Member loginMember = (Member) session.getAttribute("loginMember");
    // 개인이해메모
    // getWriter().getNo() != loginMember.getNo() // 로그인 멤버no 꺼내서 party에 있는 Member writer 이용해서 일치여부 확인
    // 방향 ----->
    if (partyService.get(partyNo).getWriter().getNo() != loginMember.getNo()) {
      throw new Exception("게시글 작성자가 아닙니다.");
    }
  }

  @GetMapping("delete")
  public String delete(int no, HttpSession session) throws Exception {
    checkOwner(no, session);
    if (!partyService.delete(no)) {
      throw new Exception("게시글을 삭제할 수 없습니다.");
    }
    return "redirect:list";
  }

  @GetMapping("fileDelete")
  public String fileDelete(int no, HttpSession session) throws Exception {

    // 첨부파일 정보 가져오기
    AttachedFile attachedFile = partyService.getAttachedFile(no);

    System.out.println("attachedFile.getNo() = " + attachedFile.getNo());
    System.out.println("attachedFile.getNo() = " + attachedFile.getFilepath());
    System.out.println("attachedFile.getNo() = " + attachedFile.getPartyNo());


    // 게시글 작성자 일치여부
    Member loginMember = (Member) session.getAttribute("loginMember");
    Party party = partyService.get(attachedFile.getPartyNo());
    System.out.println("party = " + party);

    // partyVO의 getWriter 통해서 member getNo 접근 != 로그인No 와 일치여부
    if (party.getWriter().getNo() != loginMember.getNo()) {
      throw new Exception("게시글 작성자가 아닙니다.");
    }
    // 첨부파일 삭제
    if (!partyService.deleteAttachedFile(no)) {
      throw new Exception("게시글 첨부파일을 삭제할 수 없습니다.");
    }
    return "redirect:detail?no=" + party.getNo();
  }
}
