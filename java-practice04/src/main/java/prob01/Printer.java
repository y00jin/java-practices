package prob01;

public class Printer{

//	public <T> void println(T t) {
//		System.out.println(t);
//	}
	
//	public void println(String str) {
//		System.out.println(str);
//	}
//	public void println(int i) {
//		System.out.println(i);
//	}
//	public void println(boolean bool) {
//		System.out.println(bool);
//	}
//	public void println(double d) {
//		System.out.println(d);
//	}
	
	// 가변변수
	public int sum(int... nums) {
		int sum = 0;
		for(int n : nums) {
			sum += n;
		}
		return sum;
	}

	public <T> void println(T... ts) {
		for(T t : ts) {
			System.out.println(t);
		}
	}
	
//	public void println(int i, int j, int k, int l, int m, String str, StringBuffer stringBuffer) {
//		
//	}
	
}
