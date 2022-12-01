package com.goteatfproject.appgot.vo;

import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;


public class Event {

  private int no;
  private String title;
  private String content;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date date;
  private String location;
  private String address;
  private int viewCnt;
  private boolean pub;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createDate;
  private String thumbnail;

  //  private String calrander;
  private String calendar;

  private int cost;


  private Member writer;

  private List<AttachedFile> attachedFiles;

  private EventComment commentList;

  public List<AttachedFile> getAttachedFiles() {
    return attachedFiles;
  }

  public void setAttachedFiles(List<AttachedFile> attachedFiles) {
    this.attachedFiles = attachedFiles;
  }

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

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getViewCnt() {
    return viewCnt;
  }

  public void setViewCnt(int viewCnt) {
    this.viewCnt = viewCnt;
  }

  public boolean isPub() {
    return pub;
  }

  public void setPub(boolean pub) {
    this.pub = pub;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  public String getCalendar() {
    return calendar;
  }

  public void setCalendar(String calendar) {
    this.calendar = calendar;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public Member getWriter() {
    return writer;
  }

  public void setWriter(Member writer) {
    this.writer = writer;
  }

  public EventComment getCommentList() {
    return commentList;
  }

  public void setCommentList(EventComment commentList) {
    this.commentList = commentList;
  }

  @Override
  public String toString() {
    return "Event [no=" + no + ", title=" + title + ", content=" + content + ", date=" + date
        + ", location=" + location + ", address=" + address + ", viewCnt=" + viewCnt + ", pub="
        + pub + ", createDate=" + createDate + ", thumbnail=" + thumbnail + ", calendar=" + calendar
        + ", cost=" + cost + ", writer=" + writer + ", attachedFiles=" + attachedFiles
        + ", commentList=" + commentList + "]";
  }



}