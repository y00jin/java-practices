package com.douzone.paint.point;

import com.douzone.paint.i.Drawable;

public class Point implements Drawable {

	private int x;
	private int y;

/* ### 기본 생성자
 * 하위 자식 클래스에서 명시하지 않으면 자동으로 불러들이는 기본 생성자
 * 기본적으로 자식 클래스에서는 super()를 통해 이러한 기본 생성자를 불러들인다
 * */
//	public Point() {
//	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void show() {
		System.out.println("점[x=" + x + ",y=" + y +"]을 그렸습니다.");
	}
	
	public void show(boolean visible) {
		if(visible)
			show();
		else
			System.out.println("점[x=" + x + ",y=" + y +"]을 지웠습니다.");
	}
	
	@Override
	public void draw() {
		show();
	}
}
