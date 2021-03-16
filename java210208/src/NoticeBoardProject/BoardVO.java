package NoticeBoardProject;

public class BoardVO {
	private int    boardId    = 0;
	private String boardName  = null;
	private int    boardPri   = 0;
	private int    postId     = 0;                              
	private String postSub    = null;
	private String postTxt    = null;
	private String postDate   = null;
	private int    userId     = 0;     
	private String userName   = null;
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public int getBoardPri() {
		return boardPri;
	}
	public void setBoardPri(int boardPri) {
		this.boardPri = boardPri;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPostSub() {
		return postSub;
	}
	public void setPostSub(String postSub) {
		this.postSub = postSub;
	}
	public String getPostTxt() {
		return postTxt;
	}
	public void setPostTxt(String postTxt) {
		this.postTxt = postTxt;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
