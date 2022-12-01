package com.goteatfproject.appgot.vo;

import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;


public class Party {


  private int no;
  private String meal; // 모임시간
  private String food; // 음식종류
  private String title;
  private String content;
  //  private String nick;
  private String gender;
  private int max;

  //  @DateTimeFormat(pattern = "yyyy-MM-dd")
  //  @JsonProperty("time")
  //  @JsonFormat(shape= Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
  //  private LocalDateTime time;
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
  private Date time; // 모임시간
  private int age;
  private int limit;
  private String location;
  private String post;
  private String address;
  private int viewCnt;
  private boolean pub;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createDate;
  private String thumbnail;

  private Member writer;

  private List<AttachedFile> attachedFiles;

  private Comment commentList;

  private Volunteer volunteerList; // 1124 확인중

  Party() {
    this.meal=null;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getMeal() {
    return meal;
  }

  public void setMeal(String meal) {
    this.meal = meal;
  }

  public String getFood() {
    return food;
  }

  public void setFood(String food) {
    this.food = food;
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

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public int getMax() {
    return max;
  }

  public void setMax(int max) {
    this.max = max;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getPost() {
    return post;
  }

  public void setPost(String post) {
    this.post = post;
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

  public Member getWriter() {
    return writer;
  }

  public void setWriter(Member writer) {
    this.writer = writer;
  }

  public List<AttachedFile> getAttachedFiles() {
    return attachedFiles;
  }

  public void setAttachedFiles(List<AttachedFile> attachedFiles) {
    this.attachedFiles = attachedFiles;
  }

  public Comment getCommentList() {
    return commentList;
  }

  public void setCommentList(Comment commentList) {
    this.commentList = commentList;
  }

  public Volunteer getVolunteerList() {
    return volunteerList;
  }

  public void setVolunteerList(Volunteer volunteerList) {
    this.volunteerList = volunteerList;
  }

  @Override
  public String toString() {
    return "Party [no=" + no + ", meal=" + meal + ", food=" + food + ", title=" + title
        + ", content=" + content + ", gender=" + gender + ", max=" + max + ", time=" + time
        + ", age=" + age + ", limit=" + limit + ", location=" + location + ", post=" + post
        + ", address=" + address + ", viewCnt=" + viewCnt + ", pub=" + pub + ", createDate="
        + createDate + ", thumbnail=" + thumbnail + ", writer=" + writer + ", attachedFiles="
        + attachedFiles + ", commentList=" + commentList + ", volunteerList=" + volunteerList + "]";
  }



}
