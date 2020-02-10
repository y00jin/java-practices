package prob2;

public class Goods {
	
	private String kindDrink;
	private int price;
	private int count;
	
	public String getKindDrink() {
		return kindDrink;
	}
	public void setKindDrink(String kindDrink) {
		this.kindDrink = kindDrink;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Goods() {
		
	}
	public Goods(String kindDrink, int price, int count) {
		this.kindDrink = kindDrink;
		this.price = price;
		this.count = count;
	}
	public void print() {
		System.out.println(this.kindDrink+"(가격:"+this.price+"원)이 "+this.count+"개 입고 되었습니다.");
	}
	
}
