package prob5;

public class Prob05 {

	public static void main(String[] args) {
		
		Account ac = new Account("078-3762-293");
		System.out.println(ac.getAccountNo() + " 계좌가 개설되었습니다.");
		System.out.println(ac.getAccountNo() + " 계좌의 잔고는 " + ac.getBalance() + "만원입니다.");
		
		ac.save(100);
		System.out.println(ac.getAccountNo() + " 계좌의 잔고는 " + ac.getBalance() + "만원입니다.");

		ac.deposit(30);
		System.out.println(ac.getAccountNo() + " 계좌의 잔고는 " + ac.getBalance() + "만원입니다.");
		
	}
	
}
