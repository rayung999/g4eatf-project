package com.goteatfproject.appgot.vo;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Feed {

  private int no;
  private String title;
  private String content;
  private Date date;
  private String thumbnail;
  private int likeCnt;
  private String checkLike;

  private Member writer;

  private List<FeedLike> feedLikeList;
  // 추가
  private List<FeedAttachedFile> feedAttachedFiles;
}
