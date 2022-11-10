package com.goteatfproject.appgot.dao;

import com.goteatfproject.appgot.vo.Follower;
import com.goteatfproject.appgot.vo.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface FollowerDao {

  void follow(Follower follower);

  void unfollow(Follower follower);

  int isFollow(Follower follower);

//  List<Follower> userList(int follow);

  List<Follower> selectFollowList(int follow);

  List<Follower> selectFollowingList(int following);


}