package practice02;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Random r = new Random();
		int k = r.nextInt(100) + 1;
		
		int cnt = 1;
		
		A : while(true) {
			System.out.println("수를 결정하였습니다. 맞추어 보세요");
			System.out.println("1-100");
			
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.print(cnt + ">>");
				int inputk = sc.nextInt();
				if(inputk == k) {
					System.out.println("맞았습니다.");
					System.out.print("다시하시겠습니까(y/n)>>");
					String answer = sc.next();
					
					if(answer.equals("y")) {
						System.out.println("----------------------");
						System.out.println("새로운 게임을 시작합니다.\n");
						continue A;
					} else if(answer.equals("n")) {
						System.out.println("종료합니다");
						break A;
					} else {
						System.out.println("잘못 입력하였습니다. 자동종료합니다.");
						break A;
					}
				} else if(inputk < k) {
					System.out.println("더 높게");
				} else if(inputk > k) {
					System.out.println("더 낮게");
				}
				cnt++;
			}
		}
	}
}
