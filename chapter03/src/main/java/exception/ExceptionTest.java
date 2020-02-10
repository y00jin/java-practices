package exception;

public class ExceptionTest {

	public static void main(String[] args) {

		int a = 10;
		int b = 10 - a;
		int result = 0;
		System.out.println("some codes0");
		
		try {
			System.out.println("some codes1");
			result = (1 + 2 + 3) / b;
			System.out.println("some codes2");
		} catch (ArithmeticException ex) {
//			1. 사용자한테 사과하기
			System.err.println("죄송합니다ㅠㅠㅠㅠ흑흑 에러를 발견하셨네요ㅠㅠㅠㅠ");
//			2. 로그 남기기(파일,DB)
			System.out.println(ex);
//			3. 정상종료해주기
			return;
		} finally {
			System.out.println("some codes4 / finally = option");
		}
		
		System.out.println("some codes5");
		System.out.println(result);
		
	}

}
