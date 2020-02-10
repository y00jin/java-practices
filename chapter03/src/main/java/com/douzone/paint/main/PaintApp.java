//java -cp . com.douzone.paint.main.PaintApp

package com.douzone.paint.main;

import com.douzone.paint.i.Drawable;
import com.douzone.paint.point.ColorPoint;
import com.douzone.paint.point.Point;
import com.douzone.paint.shape.Circle;
import com.douzone.paint.shape.Rect;
import com.douzone.paint.shape.Shape;
import com.douzone.paint.shape.Triangle;
import com.douzone.paint.text.GraphicText;

public class PaintApp {
	
	public static void main(String[] args) {
		
		Point point1 = new Point(2,5);
		Point point2 = new Point(10,23);
		
//		drawPoint(point1);
		drawPoint(point2);
		
//		point1.disappear();
		point1.show(false);
		point1.show(true);
		
		draw(point2);
		
		ColorPoint point3 = new ColorPoint(50,100,"red");
		draw(point3);
		drawPoint(point3);
		point3.show(false);
		
		Rect rect = new Rect();
//		drawRect(rect);
		drawShape(rect);
		draw(rect);
		
		Triangle triangle = new Triangle();
//		drawTri(triangle);
		drawShape(triangle);
		draw(triangle);
		
		Circle circle = new Circle();
		drawShape(circle);
		draw(circle);
		
		draw(new GraphicText("HELLO"));
		
		// instanceof test
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
//		오류 : class는 hierachy 상위와 하위만 instanceof 연산자를 사용할 수 있다.
//		System.out.println(circle instanceof Rect);
	
		Shape s = new Circle();
		System.out.println(s instanceof Object);
		System.out.println(s instanceof Shape);
		System.out.println(s instanceof Circle);
		System.out.println(s instanceof Rect);
		
//		Interface는 hierachy 상관없이 instanceof 연산자를 사용할 수 있다
		System.out.println(s instanceof Drawable);
		System.out.println(s instanceof Runnable);
		
	}

	public static void draw(Drawable d) {
		d.draw();
	}
	
	public static void drawShape(Shape shape) {
		shape.draw();
	}
	
//	public static void drawTri(Triangle triangle) {
//		triangle.draw();
//	}
//	
//	public static void drawRect(Rect rect) {
//		rect.draw();
//	}
	
	public static void drawPoint(Point point) {
		point.show();
	}

	public static void drawPoint(ColorPoint point) {
		point.show();
	}
	
}
