package com.newlecture.web;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hi")
public class Nana extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setCharacterEncoding("UTF-8"); // �̴� ����ڿ��� ���� �ڵ� ���
		response.setContentType("text/html; charset = UTF-8"); // ���ڵ� �ؾ��ϴ� ����
		// character�� UTF-8�� �ǰ�, text/html �� html �����̴� ~ ��� �ϴ� ��
		// �̷��� �ѱ��� UTF-8�� ���� ���̰�, html�� html�� �о br ó���� ����
		PrintWriter out = response.getWriter();
		out.println("Hello");
		
		String temp = request.getParameter("cnt");
		int cnt = 100;
		if(temp != null && temp != "")
	{
		cnt = Integer.parseInt(temp);
	}
		// �̰��� �׻� ���ڿ��̹Ƿ� Integer.parseInt�� ��ȯ�Ѱ���
		for (int i = 0; i < cnt ; i++ )
		{
			out.println(i + 1 + "�ȳ� !!<br>");
		}
	}
		
}
