package prob6;

import java.util.Scanner;

public class Prob06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print(">>");
			String expr = scanner.nextLine();
			
			if(expr.equals("quit")) {
				break;
			}

			String[] tokens = expr.split(" ");
			
			if(tokens.length < 3) {
				System.out.println(">> 계산할 수 없는 연산식입니다.");
				continue;
			}
			
			int lValue = Integer.parseInt(tokens[0]);
			int rValue = Integer.parseInt(tokens[2]);
			int result = 0;
			
			switch(tokens[1]) {
			case "+":
				Add add = new Add();
				add.setValue(lValue, rValue);
				result = add.calculate();
				System.out.println(">> " + result);
				break;
			case "-":
				Sub sub = new Sub();
				sub.setValue(lValue, rValue);
				result = sub.calculate();
				System.out.println(">> " + result);
				break;
			case "*":
				Mul mul = new Mul();
				mul.setValue(lValue, rValue);
				result = mul.calculate();
				System.out.println(">> " + result);
				break;
			case "/":
				Div div = new Div();
				div.setValue(lValue, rValue);
				double result2 = div.calculate();
				System.out.println(">> " + result2);
				break;
			}
		}
		scanner.close();
	}
	
}
