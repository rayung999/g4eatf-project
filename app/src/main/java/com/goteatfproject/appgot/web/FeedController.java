package com.goteatfproject.appgot.web;

import com.goteatfproject.appgot.service.FeedService;
import com.goteatfproject.appgot.service.FollowerService;
import com.goteatfproject.appgot.vo.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/feed")
public class FeedController {

  FeedService feedService;
  ServletContext sc;
  FollowerService followerService;

  public FeedController(FeedService feedService, ServletContext sc, FollowerService followerService) {
    System.out.println("FeedController() 호출됨!");
    System.out.println("ServletContext() 호출됨!!");
    this.feedService = feedService;
    this.sc = sc;
    this.followerService = followerService;
  }

  @GetMapping("/list")
  public String list(Model model, HttpSession session) throws Exception {

    // 피드 팔로우 기능
    Member member = (Member) session.getAttribute("loginMember");

    List<Follower> followList = followerService.selectFollowList(member.getNo());
    model.addAttribute("follows", followList);

    // 피드 리스트 출력
    model.addAttribute("feeds", feedService.list());

    return "feed/Feed";

  }
  @GetMapping("/form")
  public void form() throws Exception {
  }

  @PostMapping("/add")
  public String feedAdd(Feed feed, HttpSession session,
                        @RequestParam("files") MultipartFile[] files) throws Exception {

    feed.setFeedAttachedFiles(saveFeedAttachedFiles(files));
    feed.setWriter((Member) session.getAttribute("loginMember"));

    System.out.println("filename = " + Arrays.toString(files));
    System.out.println("filename2 = " + files);

    feedService.add(feed);
    return "feed/Feed";
  }

  private List<FeedAttachedFile> saveFeedAttachedFiles(Part[] files)
      throws IOException, ServletException {
    List<FeedAttachedFile> feedAttachedFiles = new ArrayList<>();
    String dirPath = sc.getRealPath("/feed/files");

    for (Part part : files) {
      if (part.getSize() == 0) {
        continue;
      }
      String filename = UUID.randomUUID().toString();
      part.write(dirPath + "/" + filename);
      feedAttachedFiles.add(new FeedAttachedFile(filename));
    }
    return feedAttachedFiles;
  }

  private List<FeedAttachedFile> saveFeedAttachedFiles(MultipartFile[] files)
      throws IOException, ServletException {
    List<FeedAttachedFile> feedAttachedFiles = new ArrayList<>();
    String dirPath = sc.getRealPath("/feed/files");


    for (MultipartFile part : files) {
      if (part.isEmpty()) {
        continue;
      }

      System.out.println("filename3 = " + Arrays.toString(files));
      System.out.println("filename4 = " + files);
      System.out.println("dirPath = " + dirPath);

      String filename = UUID.randomUUID().toString();
      part.transferTo(new File(dirPath + "/" + filename));
      feedAttachedFiles.add(new FeedAttachedFile(filename));
    }
    return feedAttachedFiles;
  }

  // 파티 게시물 상세보기
  @GetMapping("detail")
  public Map detail(int no) throws Exception {

    Feed feed = feedService.get(no);

    if (feed == null) {
      throw new Exception("해당 번호의 게시글이 없습니다!");
    }
    Map map = new HashMap();
    map.put("feed", feed);
    return map;
  }

  // 파티 게시물 수정
  @PostMapping("update")
  public String update(Feed feed, HttpSession session,
                       Part[] files) throws Exception {

    feed.setFeedAttachedFiles(saveFeedAttachedFiles(files));

    // detail.html : <input name="no" type="number" value="1" th:value="${party.no}" readonly hidden/>
    // 위에 추가해야 party.getNo() 가져오기 가능 System.out.println("partyNo = " + party.getNo());
    checkOwner(feed.getNo(), session);

    if (!feedService.update(feed)) {
      throw new Exception("게시글을 변경할 수 없습니다.");
    }
    return "feed/Feed";
  }

  private void checkOwner(int feedNo, HttpSession session) throws Exception {
    Member loginMember = (Member) session.getAttribute("loginMember");
    // 개인이해메모
    // getWriter().getNo() != loginMember.getNo() // 로그인 멤버no 꺼내서 party에 있는 Member writer 이용해서 일치여부 확인
    // 방향 ----->
    if (feedService.get(feedNo).getWriter().getNo() != loginMember.getNo()) {
      throw new Exception("게시글 작성자가 아닙니다.");
    }
  }

  @GetMapping("delete")
  public String delete(int no, HttpSession session) throws Exception {
    checkOwner(no, session);
    if (!feedService.delete(no)) {
      throw new Exception("게시글을 삭제할 수 없습니다.");
    }
    return "feed/Feed";
  }

  @GetMapping("fileDelete")
  public String fileDelete(int no, HttpSession session) throws Exception {

    // 첨부파일 정보 가져오기
    FeedAttachedFile feedAttachedFile = feedService.getFeedAttachedFile(no);

    System.out.println("feedAttachedFile.getNo() = " + feedAttachedFile.getNo());
    System.out.println("feedAttachedFile.getNo() = " + feedAttachedFile.getFilepath());
    System.out.println("feedAttachedFile.getNo() = " + feedAttachedFile.getFeedNo());


    // 게시글 작성자 일치여부
    Member loginMember = (Member) session.getAttribute("loginMember");
    Feed feed = feedService.get(feedAttachedFile.getFeedNo());
    System.out.println("feed = " + feed);

    // feedVO의 getWriter 통해서 member getNo 접근 != 로그인No 와 일치여부
    if (feed.getWriter().getNo() != loginMember.getNo()) {
      throw new Exception("게시글 작성자가 아닙니다.");
    }
    // 첨부파일 삭제
    if (!feedService.deleteFeedAttachedFile(no)) {
      throw new Exception("게시글 첨부파일을 삭제할 수 없습니다.");
    }
    return "redirect:detail?no=" + feed.getNo();
  }







}
