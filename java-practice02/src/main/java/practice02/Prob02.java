package practice02;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[5];
		double sum = 0;
		int i;
		
		System.out.println("5개의 숫자를 입력하세요.");
		for(i=0;i<intArray.length;i++) {
			intArray[i] = scanner.nextInt();
		}
		
		for(i=0;i<intArray.length;i++) {
			sum += intArray[i];
		}
		
		System.out.println("평균은 " + sum/intArray.length + " 입니다.");
		
	}

}