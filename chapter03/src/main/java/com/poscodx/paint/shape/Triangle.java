package com.poscodx.paint.shape;

public class Triangle extends Shape{
//	private Point[] points;
//	private String lineColor;
//	private String fillColor;
	// shape 생성 후 공통 필드 삭제
	
	@Override
	public void draw() {
		System.out.println("삼각형을 그렸습니다.");
	}
}
