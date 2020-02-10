package thread;

public class ThreadEx02 {

	public static void main(String[] args) {

		// thread를 객체로 만들어서 각각 실행이 가능해진다.
		
		Thread thread1 = new DigitalThread();
		Thread thread2 = new AlphabetThread();
		Thread thread3 = new DigitalThread();
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}

}
