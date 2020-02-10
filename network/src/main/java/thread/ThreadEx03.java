package thread;

public class ThreadEx03 {

	public static void main(String[] args) {

		Thread thread1 = new DigitalThread();
		Thread thread2 = new AlphabetThread();
		// 부모가 Thread가 아니라서 안 됨
//		Thread thread3 = new UppercaseAlphabetRunnableImpl();
		Thread thread3 = new Thread(new UppercaseAlphabetRunnableImpl());
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
