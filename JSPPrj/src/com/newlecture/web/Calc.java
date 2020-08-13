package com.newlecture.web;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calc")
public class Calc extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setCharacterEncoding("UTF-8"); // �̴� ����ڿ��� ���� �ڵ� ���
		response.setContentType("text/html; charset = UTF-8"); // ���ڵ� �ؾ��ϴ� ����
		PrintWriter out = response.getWriter();
		out.println("Calculation");
		
		String temp_calc = request.getParameter("button");
		String temp_X = request.getParameter("x");
		String temp_Y = request.getParameter("y");
		int X = Integer.parseInt(temp_X);
		int Y = Integer.parseInt(temp_Y);
		// �̰��� �׻� ���ڿ��̹Ƿ� Integer.parseInt�� ��ȯ�Ѱ���
		System.out.println(temp_calc);
		
		if (temp_calc.equals("����"))
		{
		out.println("X + Y = " + (X + Y));
		}
		else
		{
			
		out.println("X - Y = " + (X - Y));
		}
	}
		
}
