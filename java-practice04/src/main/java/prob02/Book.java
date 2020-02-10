package prob02;

public class Book {

	private int bookNo; // 번호
	private String title; // 제목
	private String author; // 작가
	private int stateCode; // 상태코드 (대여유무)
	
	public Book(int bookNo, String title, String author){
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		this.stateCode = 1;
	}
	
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getStateCode() {
		return stateCode;
	}
	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}

	public void rent() {
		this.stateCode = 0;
		System.out.println(this.title + "이(가) 대여 됐습니다.");
	}
	
	public void print() {
		System.out.print("책 제목 : " + this.title + ", 작가 : " + this.author + ", 대여 유무 : ");
		if(this.stateCode == 1)
			System.out.print("재고있음");
		else
			System.out.print("대여중");
		System.out.println();
	}
}
