package com.goteatfproject.appgot.vo;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "fileData")
public class Feed {

  private int no;
  private String title;
  private String content;
  private Date date;
  private String image;

  private Member writer;

  private List<FeedAttachedFile> feedAttachedFiles;

}
