package chapter04;

public class StringTest02 {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "def";
		String s3 = s2;
		
		s2 = s1.toUpperCase();
		String s4 = s2.concat("??");
		String s5 = "!".concat(s2).concat("@");

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		
		//equals method danger
		System.out.println(equalHello("hello"));
		System.out.println(equalHello(null));
		
	}
	
	public static boolean equalHello(String s) {
//		return s.equals("hello"); // "hello"가 뒤에 있으면 null값이 들어올 때 오류가 생김
		return "hello".equals(s);
	}
}
