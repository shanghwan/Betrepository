package domain;

import java.sql.Date;

public class Comment {
	
	private String CommentId;
	private String userId;
	private String content;
	private String photo;
	private Date regDate;
	
	public Comment() {}

	public Comment(String commentId, String userId, String content, String photo, Date regDate) {
		super();
		CommentId = commentId;
		this.userId = userId;
		this.content = content;
		this.photo = photo;
		this.regDate = regDate;
	}

	public String getCommentId() {
		return CommentId;
	}

	public void setCommentId(String commentId) {
		CommentId = commentId;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	

}
