package com.goteatfproject.appgot.vo;

import java.util.Date;

public class Comment {

  private int partyReplyNo; // 댓글 PK 번호
  private int partyNo; // 게시물 번호
  private String commentCont;
  private boolean pub;
  private Date date;
  private int memberNo; //

  private Member writer;

  public int getPartyReplyNo() {
    return partyReplyNo;
  }

  public void setPartyReplyNo(int partyReplyNo) {
    this.partyReplyNo = partyReplyNo;
  }

  public int getPartyNo() {
    return partyNo;
  }

  public void setPartyNo(int partyNo) {
    this.partyNo = partyNo;
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
    return "Comment [partyReplyNo=" + partyReplyNo + ", partyNo=" + partyNo + ", commentCont="
        + commentCont + ", pub=" + pub + ", date=" + date + ", memberNo=" + memberNo + ", writer="
        + writer + "]";
  }

  //  private Party partyPage;



}
