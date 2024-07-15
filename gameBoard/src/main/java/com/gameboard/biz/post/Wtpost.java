package com.gameboard.biz.post;

public class Wtpost {
   private int wtID;
   private String wtTitle;
   private String userID;
   private String wtDate;
   private String wtContent;
   private String searchCondition;
   private String searchKeyword;
   private int wtViews;


   public Wtpost() {
   }

   public Wtpost(int wtID, String wtTitle, String userID, String wtDate, String wtContent, String searchCondition,
         String searchKeyword, int wtViews) {
      super();
      this.wtID = wtID;
      this.wtTitle = wtTitle;
      this.userID = userID;
      this.wtDate = wtDate;
      this.wtContent = wtContent;
      this.searchCondition = searchCondition;
      this.searchKeyword = searchKeyword;
      this.wtViews = wtViews;
      

   }

   public int getWtID() {
      return wtID;
   }

   public void setWtID(int wtID) {
      this.wtID = wtID;
   }

   public String getWtTitle() {
      return wtTitle;
   }

   public void setWtTitle(String wtTitle) {
      this.wtTitle = wtTitle;
   }

   public String getUserID() {
      return userID;
   }

   public void setUserID(String userID) {
      this.userID = userID;
   }

   public String getWtDate() {
      return wtDate;
   }

   public void setWtDate(String wtDate) {
      this.wtDate = wtDate;
   }

   public String getWtContent() {
      return wtContent;
   }

   public void setWtContent(String wtContent) {
      this.wtContent = wtContent;
   }

   public String getSearchCondition() {
      return searchCondition;
   }

   public void setSearchCondition(String searchCondition) {
      this.searchCondition = searchCondition;
   }

   public String getSearchKeyword() {
      return searchKeyword;
   }

   public void setSearchKeyword(String searchKeyword) {
      this.searchKeyword = searchKeyword;
   }

   public int getWtViews() {
      return wtViews;
   }

   public void setWtViews(int wtViews) {
      this.wtViews = wtViews;
   }


}