package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {

		Set<String> s = new HashSet<>();
		
		String s1 = new String("또치");
		String s2 = new String("또치");
		String s3 = "또치";
		
		System.out.println(s1 == s2); // false
		
		s.add("둘리");
		s.add("마이클");
		s.add("또치");
		
		System.out.println(s.contains("또치")); // 동일성동질성이 아니라 내용을 따졌기때문에 true
		System.out.println(s.size());
		
		// 순회
		Iterator<String> it = s.iterator(); // Collection에 있는 iterator()
		while(it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}
	}

}
