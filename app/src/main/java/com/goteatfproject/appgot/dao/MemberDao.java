package com.goteatfproject.appgot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.goteatfproject.appgot.vo.Member;

@Mapper
public interface MemberDao {

  int insert(Member member) throws Exception;

  int update(Member member) throws Exception;

  Member findByNo(int no) throws Exception;

  List<Member> findAll() throws Exception;

  Member findByEmailPassword(@Param("id") String id, @Param("password") String password) throws Exception;



  // 밑에부터는 피드에 필요한 기능들

  // 로그인하지 않았을 시 랜덤으로 출력되는 팔로우박스
  List<Member> userList() throws Exception;

  // 아이디로 회원 정보 조회 기능 (후에 필요없으면 뺄수도 )
  Member profileByNick(String nick) throws Exception;

  // 유저 번호로 유저 프로필 조회 기능
  Member profileByNo(int no) throws Exception;

}
