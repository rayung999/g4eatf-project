package com.goteatfproject.appgot.vo;

import java.util.Date;
import java.util.List;

public class Feed {

  private int no;
  private String title;
  private String content;
  private Date date;
  private String thumbnail;
  private boolean pub;

  private Member writer;

  // 추가
  private List<FeedAttachedFile> feedAttachedFiles;
  // 추가 - 라윤
  private List<FeedLike> feedLikeList;

  // 추가 - 라윤
  private int likeCnt;
  private String checkLike;
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }
  public String getThumbnail() {
    return thumbnail;
  }
  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }
  public boolean isPub() {
    return pub;
  }
  public void setPub(boolean pub) {
    this.pub = pub;
  }
  public Member getWriter() {
    return writer;
  }
  public void setWriter(Member writer) {
    this.writer = writer;
  }
  public List<FeedAttachedFile> getFeedAttachedFiles() {
    return feedAttachedFiles;
  }
  public void setFeedAttachedFiles(List<FeedAttachedFile> feedAttachedFiles) {
    this.feedAttachedFiles = feedAttachedFiles;
  }
  public List<FeedLike> getFeedLikeList() {
    return feedLikeList;
  }
  public void setFeedLikeList(List<FeedLike> feedLikeList) {
    this.feedLikeList = feedLikeList;
  }
  public int getLikeCnt() {
    return likeCnt;
  }
  public void setLikeCnt(int likeCnt) {
    this.likeCnt = likeCnt;
  }
  public String getCheckLike() {
    return checkLike;
  }
  public void setCheckLike(String checkLike) {
    this.checkLike = checkLike;
  }
  @Override
  public String toString() {
    return "Feed [no=" + no + ", title=" + title + ", content=" + content + ", date=" + date
        + ", thumbnail=" + thumbnail + ", pub=" + pub + ", writer=" + writer
        + ", feedAttachedFiles=" + feedAttachedFiles + ", feedLikeList=" + feedLikeList
        + ", likeCnt=" + likeCnt + ", checkLike=" + checkLike + "]";
  }


}
