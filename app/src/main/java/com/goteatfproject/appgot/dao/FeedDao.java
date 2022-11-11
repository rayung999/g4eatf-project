package com.goteatfproject.appgot.dao;

import com.goteatfproject.appgot.vo.AttachedFile;
import com.goteatfproject.appgot.vo.Feed;
import com.goteatfproject.appgot.vo.FeedAttachedFile;
import com.goteatfproject.appgot.vo.Party;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface FeedDao {

  List<Feed> selectListByNick(String nick) throws Exception;
  List<Feed> randomfindAll() throws Exception;

  List<Feed> followFindAll(int no) throws Exception;

  List<Feed> findAll() throws Exception;

  Feed findByNo(int no) throws Exception;

  int insert(Feed feed) throws Exception;

  int update(Feed feed) throws Exception;

  int delete(int no) throws Exception;

  int insertFiles(Feed feed) throws Exception;

  FeedAttachedFile findFileByNo(int fileNo) throws Exception;

  List<FeedAttachedFile> findFilesByParty(int feedNo) throws Exception;

  int deleteFile(int fileNo) throws Exception;

  int deleteFiles(int feedNo) throws Exception;

  int deleteFilesByMemberFeeds(int memberNo) throws Exception;
}

