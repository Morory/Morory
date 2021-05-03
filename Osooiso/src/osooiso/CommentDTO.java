package osooiso;

import java.util.HashMap;

public class CommentDTO {
	
	public HashMap<String, String> commentTarget = new HashMap<String, String>();
	public HashMap<String, String> commentTargetNo = new HashMap<String, String>();
	private String upBbscttNo;
	private String contents;
	private String hashcode;
	
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getHashcode() {
		return hashcode;
	}
	public void setHashcode(String hashcode) {
		this.hashcode = hashcode;
	}
	public String getUpBbscttNo() {
		return upBbscttNo;
	}
	public void setUpBbscttNo(String upBbscttNo) {
		this.upBbscttNo = upBbscttNo;
	}

}
