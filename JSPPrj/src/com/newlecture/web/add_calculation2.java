package com.newlecture.web;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/add2")
public class add_calculation2 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setCharacterEncoding("UTF-8"); // 이는 사용자에게 보낼 코딩 방식
		response.setContentType("text/html; charset = UTF-8"); // 인코딩 해야하는 형식
		PrintWriter out = response.getWriter();
		out.println("Calculation");
		
		String[] temp_X = request.getParameterValues("x");z
		int result = 0;
		for (int i=0; i<temp_X.length; i++)
		{
			int num = Integer.parseInt(temp_X[i]);
			result = result + num;
		}
		out.println(result);
	}
		
}
