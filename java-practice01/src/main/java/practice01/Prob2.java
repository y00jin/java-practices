package practice01;

public class Prob2 {
	public static void main(String[] args) {
		
		int i,j;
		for(i=0;i<9;i++) {
			for(j=i+1;j<=10+i;j++) {
				System.out.printf("%3d",j);
			}
			System.out.println();
		}
		
	}
}
