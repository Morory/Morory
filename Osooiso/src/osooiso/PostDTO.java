package osooiso;

public class PostDTO {
	
	private String title;
	private String contents;
	private String photoAddress = " ";
	private String category;
	private String hashcode;
	private String postNo;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getPhotoAddress() {
		return photoAddress;
	}
	public void setPhotoAddress(String photoAddress) {
		this.photoAddress = photoAddress;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getHashcode() {
		return hashcode;
	}
	public void setHashcode(String hashcode) {
		this.hashcode = hashcode;
	}
	public String getPostNo() {
		return postNo;
	}
	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

}
