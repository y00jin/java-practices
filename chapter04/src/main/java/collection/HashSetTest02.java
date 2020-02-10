package collection;

import java.util.HashSet;

public class HashSetTest02 {

	public static void main(String[] args) {
		
		HashSet<Gugudan> s = new HashSet<>();
		
		s.add(new Gugudan(2,3));
		s.add(new Gugudan(9,9));
		s.add(new Gugudan(3,2)); // 2단계. hashCode()랑 equals() 바꿨더니 요놈도 안들어감
		s.add(new Gugudan(2,3)); // 1단계. 요놈은 안들어감 
		
		for(Gugudan g : s) {
			System.out.println(g);
		}
		
	}
	
}
