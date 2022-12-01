package com.goteatfproject.appgot.vo;

public class FeedAttachedFile {

  private int no;
  private String fileName;
  private String filepath;
  private String saveName;
  private int feedNo;

  public FeedAttachedFile() {}

  // FeedController - feedAttachedFiles.add(new FeedAttachedFile(filename));
  public FeedAttachedFile(String filepath) {
    this.filepath = filepath;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getFilepath() {
    return filepath;
  }

  public void setFilepath(String filepath) {
    this.filepath = filepath;
  }

  public String getSaveName() {
    return saveName;
  }

  public void setSaveName(String saveName) {
    this.saveName = saveName;
  }

  public int getFeedNo() {
    return feedNo;
  }

  public void setFeedNo(int feedNo) {
    this.feedNo = feedNo;
  }

  @Override
  public String toString() {
    return "FeedAttachedFile [no=" + no + ", fileName=" + fileName + ", filepath=" + filepath
        + ", saveName=" + saveName + ", feedNo=" + feedNo + "]";
  }



}
