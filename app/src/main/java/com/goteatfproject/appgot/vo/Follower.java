package com.goteatfproject.appgot.vo;

public class Follower {

  private int follow;

  private int following;

  private String nick;

  private String intro;

  private String thumbnail;

  public int getFollow() {
    return follow;
  }

  public void setFollow(int follow) {
    this.follow = follow;
  }

  public int getFollowing() {
    return following;
  }

  public void setFollowing(int following) {
    this.following = following;
  }

  public String getNick() {
    return nick;
  }

  public void setNick(String nick) {
    this.nick = nick;
  }

  public String getIntro() {
    return intro;
  }

  public void setIntro(String intro) {
    this.intro = intro;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  @Override
  public String toString() {
    return "Follower [follow=" + follow + ", following=" + following + ", nick=" + nick + ", intro="
        + intro + ", thumbnail=" + thumbnail + "]";
  }



}
