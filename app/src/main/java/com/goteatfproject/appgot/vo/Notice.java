package com.goteatfproject.appgot.vo;

import java.util.Date;

public class Notice {

  private int no;
  private String title;
  private String content;
  private String tname;
  private Date createDate;
  private Member writer;
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
  public String getTname() {
    return tname;
  }
  public void setTname(String tname) {
    this.tname = tname;
  }
  public Date getCreateDate() {
    return createDate;
  }
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
  public Member getWriter() {
    return writer;
  }
  public void setWriter(Member writer) {
    this.writer = writer;
  }
  @Override
  public String toString() {
    return "Notice [no=" + no + ", title=" + title + ", content=" + content + ", tname=" + tname
        + ", createDate=" + createDate + ", writer=" + writer + "]";
  }



}