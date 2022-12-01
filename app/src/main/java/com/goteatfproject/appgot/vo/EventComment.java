package com.goteatfproject.appgot.vo;

import java.util.Date;

public class EventComment {

  private int reviewNo; // 댓글 PK 번호
  private int eventNo; // 게시물 번호
  private String commentCont;
  private boolean pub;
  private Date date;
  private int memberNo; //

  private Member writer;

  public int getReviewNo() {
    return reviewNo;
  }

  public void setReviewNo(int reviewNo) {
    this.reviewNo = reviewNo;
  }

  public int getEventNo() {
    return eventNo;
  }

  public void setEventNo(int eventNo) {
    this.eventNo = eventNo;
  }

  public String getCommentCont() {
    return commentCont;
  }

  public void setCommentCont(String commentCont) {
    this.commentCont = commentCont;
  }

  public boolean isPub() {
    return pub;
  }

  public void setPub(boolean pub) {
    this.pub = pub;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getMemberNo() {
    return memberNo;
  }

  public void setMemberNo(int memberNo) {
    this.memberNo = memberNo;
  }

  public Member getWriter() {
    return writer;
  }

  public void setWriter(Member writer) {
    this.writer = writer;
  }

  @Override
  public String toString() {
    return "EventComment [reviewNo=" + reviewNo + ", eventNo=" + eventNo + ", commentCont="
        + commentCont + ", pub=" + pub + ", date=" + date + ", memberNo=" + memberNo + ", writer="
        + writer + "]";
  }

  //  private Party partyPage;



}
