package com.goteatfproject.appgot.dao;

import com.goteatfproject.appgot.vo.AttachedFile;
import com.goteatfproject.appgot.vo.Feed;
import com.goteatfproject.appgot.vo.FeedAttachedFile;
import com.goteatfproject.appgot.vo.Party;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface FeedDao {

  List<Feed> randomfindAll();

  List<Feed> findAll();

  Feed findByNo(int no);

  int insert(Feed feed);

  int update(Feed feed);

  int delete(int no);

  int insertFiles(Feed feed);

  FeedAttachedFile findFileByNo(int fileNo);

  List<FeedAttachedFile> findFilesByParty(int feedNo);

  int deleteFile(int fileNo);

  int deleteFiles(int feedNo);

  int deleteFilesByMemberFeeds(int memberNo);
}

