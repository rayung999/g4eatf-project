package com.goteatfproject.appgot.vo;

import java.util.Date;


// 관리자페이지 파티, 피드, 이벤트 게시글을 담을 필드 설정
public class Board {
  int no;
  String tableName;
  String title;
  String cont;
  Date date;
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTableName() {
    return tableName;
  }
  public void setTableName(String tableName) {
    this.tableName = tableName;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getCont() {
    return cont;
  }
  public void setCont(String cont) {
    this.cont = cont;
  }
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }
  @Override
  public String toString() {
    return "Board [no=" + no + ", tableName=" + tableName + ", title=" + title + ", cont=" + cont
        + ", date=" + date + "]";
  }


}
