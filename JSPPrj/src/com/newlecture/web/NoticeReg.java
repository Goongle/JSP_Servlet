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
		response.setCharacterEncoding("UTF-8"); // 이는 사용자에게 보낼 코딩 방식
		response.setContentType("text/html; charset = UTF-8"); // 인코딩 해야하는 형식
		// character가 UTF-8이 되고, text/html 은 html 문서이다 ~ 라고 하는 것
		// 이러면 한글을 UTF-8로 읽을 것이고, html은 html로 읽어서 br 처리가 가능
		// request.setCharacterEncoding("UTF-8");
		// 이 부분은 필터에서 할 수 있는 것임
		PrintWriter out = response.getWriter();
		
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		out.println(title);
		out.println(content);
		
	}	
		
}
