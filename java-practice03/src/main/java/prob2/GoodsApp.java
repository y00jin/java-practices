package prob2;

import java.util.Scanner;

public class GoodsApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Goods[] goods = new Goods[3];
		
		for(int i=0; i < goods.length;i++) {
			goods[i] = new Goods();
			goods[i].setKindDrink(sc.next());
			goods[i].setPrice(sc.nextInt());
			goods[i].setCount(sc.nextInt());
		}
		
		for(int i=0;i<goods.length;i++) {
			goods[i].print();
		}
		sc.close();
	}
}
