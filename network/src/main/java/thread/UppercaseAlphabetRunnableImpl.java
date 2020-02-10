package thread;

public class UppercaseAlphabetRunnableImpl extends UpperCaseAlphabet implements Runnable {

	@Override
	public void run() {
		print();
	}

}
