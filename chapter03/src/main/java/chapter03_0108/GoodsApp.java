package chapter03_0108;

import mypackage.Goods;

public class GoodsApp {

	public static void main(String[] args) {
		
		Goods goods1 = new Goods();

		// public은 접근 제한이 없다
		goods1.name = "Nikon";
		
		// protected는 같은 패키지 또는 자식에서 접근이 가능하다.
//		goods1.price = 400000;

		//defulat는 같은 패키지에서만 접근 가능하다.
//		goods1.countSold = 50;
		
		//private는 하나의 클래스 내부에서만 접근이 가능하다.
//		goods1.countStock = 30;
		
		System.out.print("상품이름 : " + goods1.name);
//		System.out.print(", 가격 : " + goods1.price);
//		System.out.print(", 재고개수 : " + goods1.countStock);
//		System.out.println(", 팔린 개수 : " + goods1.countSold);

		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		System.out.println(Goods.countOfGoods);
		
	}
	
}