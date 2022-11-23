package com.goteatfproject.appgot.service;

import com.goteatfproject.appgot.vo.AttachedFile;
import com.goteatfproject.appgot.vo.Criteria;
import com.goteatfproject.appgot.vo.Event;
import java.util.List;
import java.util.Map;

public interface EventService {

  void add(Event event) throws Exception;
  List<Event> list() throws Exception;

  //페이징
  List<Map<String, Object>> selectEventList(Criteria criteria);
  Event get(int no) throws Exception;
  boolean update(Event event) throws Exception;
  boolean delete(int no) throws Exception;
  AttachedFile getAttachedFile(int fileNo) throws Exception;
  boolean deleteAttachedFile(int fileNo) throws Exception;

  // 마이페이지 본인 작성 글 리스트
  List<Map<String, Object>> selectEventList2(Map<String, Object> map);

  // 관리자페이지 전체 리스트 출력
  List<Map<String, Object>> selectEventList3(Criteria criteria);

  // 관리자페이지 이벤트게시글 비활성화
  boolean eventBlock(int no);

  //메인페이지 이벤트게시글 조회
  List<Event> mainList() throws Exception;

  //결제 수량
  int getPayCnt();

  //결제 했는지 안했는지
  boolean ticketing(Map<String,Object> ticket);


  // 관리자페이지 이벤트게시글 상세보기
  // 사용안함
  Event getAdminEventListDetail(int no);

}

