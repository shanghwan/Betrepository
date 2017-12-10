package domain;

import java.sql.Date;


public class Comment {

   private String betId;
   private String commentId;
   private String userId;
   private String content;
   private Date regDate;

   public Comment() {
   }

   public Comment(String betId, String commentId, String userId, String content, Date regDate) {
      super();
      this.betId = betId;
      this.commentId = commentId;
      this.userId = userId;
      this.content = content;
      this.regDate = regDate;
   }

   public String getBetId() {
      return betId;
   }

   public void setBetId(String betId) {
      this.betId = betId;
   }

   public String getCommentId() {
      return commentId;
   }

   public void setCommentId(String commentId) {
      this.commentId = commentId;
   }

   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public Date getRegDate() {
      return regDate;
   }

   public void setRegDate(Date regDate) {
      this.regDate = regDate;
   }

}