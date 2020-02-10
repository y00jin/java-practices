package prob3;

public class Prob03 {
	public static void main(String[] args) {
		
		CurrencyConverter.setRate(0.00086);
		System.out.println("백만원은 " +  CurrencyConverter.toDollar(1000000) + "달러입니다.");
		System.out.println("백달러는 " + CurrencyConverter.toKRW(100) + "원입니다.");
	}
}
