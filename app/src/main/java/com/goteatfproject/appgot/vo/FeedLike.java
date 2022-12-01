package com.goteatfproject.appgot.vo;

public class FeedLike {

  private int flno;

  private Member member;

  private Feed feed;

  private int flmno;

  public int getFlno() {
    return flno;
  }

  public void setFlno(int flno) {
    this.flno = flno;
  }

  public Member getMember() {
    return member;
  }

  public void setMember(Member member) {
    this.member = member;
  }

  public Feed getFeed() {
    return feed;
  }

  public void setFeed(Feed feed) {
    this.feed = feed;
  }

  public int getFlmno() {
    return flmno;
  }

  public void setFlmno(int flmno) {
    this.flmno = flmno;
  }

  @Override
  public String toString() {
    return "FeedLike [flno=" + flno + ", member=" + member + ", feed=" + feed + ", flmno=" + flmno
        + "]";
  }



}
