package com.goteatfproject.appgot.vo;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;


public class Volunteer {

  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
  private Date date;
  private Boolean state;
  private String etc;

  private int partyNo; // 컬럼 vno
  private int memberNo; // 컬럼 mno

  private Member writer;
  private int urlNo;

  private int fcfs; // 파티참여순서

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Boolean getState() {
    return state;
  }

  public void setState(Boolean state) {
    this.state = state;
  }

  public String getEtc() {
    return etc;
  }

  public void setEtc(String etc) {
    this.etc = etc;
  }

  public int getPartyNo() {
    return partyNo;
  }

  public void setPartyNo(int partyNo) {
    this.partyNo = partyNo;
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

  public int getUrlNo() {
    return urlNo;
  }

  public void setUrlNo(int urlNo) {
    this.urlNo = urlNo;
  }

  public int getFcfs() {
    return fcfs;
  }

  public void setFcfs(int fcfs) {
    this.fcfs = fcfs;
  }

  @Override
  public String toString() {
    return "Volunteer [date=" + date + ", state=" + state + ", etc=" + etc + ", partyNo=" + partyNo
        + ", memberNo=" + memberNo + ", writer=" + writer + ", urlNo=" + urlNo + ", fcfs=" + fcfs
        + "]";
  }



}


