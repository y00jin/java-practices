package com.douzone.paint.point;

public class ColorPoint extends Point {

	private String color;
	
	public ColorPoint(int x,int y,String color) {
//		super(); // 기본생성자가 Point class에 존재하지 않기 때문에 오류가 남
		super(x,y); // 기본생성자를 대신할 수 있는 생성자를 명시하면 오류가 나지 않음
		setX(x);
		setY(y);
		this.color = color;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("점[x=" + getX() + ",y=" + getY() +",color="+color+"]을 그렸습니다.");
	}
	
}
