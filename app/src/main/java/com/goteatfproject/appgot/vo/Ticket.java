package com.goteatfproject.appgot.vo;

import java.util.Date;

public class Ticket {

  int ticketNo;
  String pay;
  Date paydate;
  int paycnt;
  boolean cancel;
  int totalcost;
  int mno;
  int eno;
  Event event;
  String title;

  Ticket(){
    this.ticketNo=0;
  }

  public int getTicketNo() {
    return ticketNo;
  }

  public void setTicketNo(int ticketNo) {
    this.ticketNo = ticketNo;
  }

  public String getPay() {
    return pay;
  }

  public void setPay(String pay) {
    this.pay = pay;
  }

  public Date getPaydate() {
    return paydate;
  }

  public void setPaydate(Date paydate) {
    this.paydate = paydate;
  }

  public int getPaycnt() {
    return paycnt;
  }

  public void setPaycnt(int paycnt) {
    this.paycnt = paycnt;
  }

  public boolean isCancel() {
    return cancel;
  }

  public void setCancel(boolean cancel) {
    this.cancel = cancel;
  }

  public int getTotalcost() {
    return totalcost;
  }

  public void setTotalcost(int totalcost) {
    this.totalcost = totalcost;
  }

  public int getMno() {
    return mno;
  }

  public void setMno(int mno) {
    this.mno = mno;
  }

  public int getEno() {
    return eno;
  }

  public void setEno(int eno) {
    this.eno = eno;
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return "Ticket [ticketNo=" + ticketNo + ", pay=" + pay + ", paydate=" + paydate + ", paycnt="
        + paycnt + ", cancel=" + cancel + ", totalcost=" + totalcost + ", mno=" + mno + ", eno="
        + eno + ", event=" + event + ", title=" + title + "]";
  }



}