package prob3;

public class CurrencyConverter {
	private static double rate;
	
	public static double toDollar(double won) {
		return won*rate;
	}
	public static double toKRW(double dollar) {
		return dollar/rate; // 뭐지 어케하지
	}
	public static void setRate(double r) {
		rate = r;
	}
	

}
