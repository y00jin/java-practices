package exception;

import java.io.IOException;

public class MyClass {

	public void danger() throws IOException, MyException {
		System.out.println("come code1");
		System.out.println("come code2");

		if(5-5 == 0) {
			throw new MyException();
		}
		if (10 - 2 == 8) {
			throw new IOException();
		}

		System.out.println("come code3");
		System.out.println("come code4");

	}

}
