package chapter03_0108;

public class StaticMethod {
	int n;
	static int m;
	
	void f1() {
		System.out.println(n);
	}
	
	// instance method to static variable access O
	void f2() {
		System.out.println(m);
//		System.out.println(StaticMethod.m); 이게찐접근방법 하지만 생략가능
	}

//	ERROR
// 	static method -> instance variable access X
//	static void f2() {
//		System.out.println(n);
//	}
	
	void f3() {
		f2();
	}
	
	void f4() {
		StaticMethod.s1();
		s1();
	}
	
	static void s1() {
//		System.out.println(n);
	}
//	static method to static variable access O
	static void s2() {
		System.out.println(m);
//		System.out.println(StaticMethod.m); 찐접근방법 하지만 생략가능
	}
	
	static void s3() {
		// ERROR : static method to instance method access X
//		f1();
	}
	
	static void s4() {
		StaticMethod.s1();
		// 같은 클래스의 클래스변수 접근에서는 클랙스 이름 생략이 가능
		s1();
	}
	
}
