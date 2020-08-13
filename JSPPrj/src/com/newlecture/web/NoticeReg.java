package com.newlecture.web;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setCharacterEncoding("UTF-8"); // �̴� ����ڿ��� ���� �ڵ� ���
		response.setContentType("text/html; charset = UTF-8"); // ���ڵ� �ؾ��ϴ� ����
		// character�� UTF-8�� �ǰ�, text/html �� html �����̴� ~ ��� �ϴ� ��
		// �̷��� �ѱ��� UTF-8�� ���� ���̰�, html�� html�� �о br ó���� ����
		// request.setCharacterEncoding("UTF-8");
		// �� �κ��� ���Ϳ��� �� �� �ִ� ����
		PrintWriter out = response.getWriter();
		
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		out.println(title);
		out.println(content);
		
	}	
		
}
