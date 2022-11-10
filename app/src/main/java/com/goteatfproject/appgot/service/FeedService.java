package com.goteatfproject.appgot.service;

import com.goteatfproject.appgot.vo.AttachedFile;
import com.goteatfproject.appgot.vo.Feed;
import com.goteatfproject.appgot.vo.FeedAttachedFile;
import com.goteatfproject.appgot.vo.Party;

import java.util.List;

public interface FeedService {


  List<Feed> randomlist() throws Exception;
  List<Feed> list() throws Exception;
  void add(Feed feed) throws Exception;
  Feed get(int no) throws Exception;
  boolean update(Feed feed) throws Exception;
  boolean delete(int no) throws Exception;
  FeedAttachedFile getFeedAttachedFile(int fileNo) throws Exception;
  boolean deleteFeedAttachedFile(int fileNo) throws Exception;

}
