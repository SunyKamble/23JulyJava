package com.connectiondemo;

public class Quetions {

	
	private String Que_Statement;
	private String A;
	private String B;
	private String C;
	private String D;
	
	public Quetions() {
		
	}
	
	public Quetions(String que_Statement, String a, String b, String c, String d) {
		super();
		Que_Statement = que_Statement;
		A = a;
		B = b;
		C = c;
		D = d;
	}

	public String getQue_Statement() {
		return Que_Statement;
	}

	public void setQue_Statement(String que_Statement) {
		Que_Statement = que_Statement;
	}

	public String getA() {
		return A;
	}

	public void setA(String a) {
		A = a;
	}

	public String getB() {
		return B;
	}

	public void setB(String b) {
		B = b;
	}

	public String getC() {
		return C;
	}

	public void setC(String c) {
		C = c;
	}

	public String getD() {
		return D;
	}

	public void setD(String d) {
		D = d;
	}

	@Override
	public String toString() {
		return "Quetions [Que_Statement=" + Que_Statement + ", A=" + A + ", B=" + B + ", C=" + C + ", D=" + D + "]";
	}
	

	
}
