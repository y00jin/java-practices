package collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		
		Queue<String> q = new LinkedList<>();
		
		q.offer("뚤리뚤리");
		q.offer("마이콜이콜");
		q.offer("또치또치");
		
		while(!q.isEmpty()) {
			String s = q.poll();
			System.out.println(s);
		}
		
//		뚤리뚤리
//		마이콜이콜
//		또치또치

		// 비어있는 경우에는 null 반환
		System.out.println(q.poll()); // null
		
		q.offer("뚤리뚤리");
		q.offer("마이콜이콜");
		q.offer("또치또치");

		System.out.println(q.poll());
		System.out.println(q.peek());
		System.out.println(q.poll());
		
	}
	
}
