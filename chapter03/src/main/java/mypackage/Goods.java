package mypackage;

public class Goods {

	public static int countOfGoods;

	public Goods() {
		Goods.countOfGoods += 1;
		System.out.println(countOfGoods);
	}
	
	public String name;		// 모든 접근 가능 | 접근 제한이 없음
	protected int price;	// 같은 패키지 + 자식 접근 가능
	int countSold;			// (default) 같은 패키지에서만 접근이 가능
	private int countStock;	// 하나의 클래스에서만 겁근 가능
	
}

