package com.newlecture.web;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/calc2")
public class Calc2 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setCharacterEncoding("UTF-8"); // �̴� ����ڿ��� ���� �ڵ� ���
		response.setContentType("text/html; charset = UTF-8"); // ���ڵ� �ؾ��ϴ� ����
		PrintWriter out = response.getWriter();
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		
		Cookie[] cookies = request.getCookies(); // ����ڿ��Լ� ��Ű�� ����
		
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		
		int v = 0;
		
		if(!v_.equals(""))
		{
			v = Integer.parseInt(v_);
		}
		if(op.equals("="))
		{
		//	int x = (Integer)application.getAttribute("value");
		//	int x = (Integer)session.getAttribute("value");
			int x = 0;
			for (Cookie c: cookies)
			{
			if (c.getName().equals("vaule"))
			{
				x = Integer.parseInt(c.getValue());
				break;
			}
			}
			
			int y = v; // ����� �Է�
		//	String op_ = (String)application.getAttribute("op");
		//	String op_ = (String)session.getAttribute("op");
			
			String op_ ="";
			
			for (Cookie c: cookies)
			{
				if (c.getName().equals("op"))
			{
					op_ = c.getValue();
					break;
				}
			}
			int result = 0;
			
			if(op_.equals("+"))
			{
				result = x + y;
			}
			else
			{
				result = x - y;
				
			}
			out.println("���" + result);
		}
		else
		{
			//application.setAttribute("value", v);
			//application.setAttribute("op", op);
			
			//session.setAttribute("value", v);
			//session.setAttribute("op", op);

			Cookie valuecookie = new Cookie("vaule",String.valueOf(v));
			Cookie opcookie = new Cookie("op",op);
			valuecookie.setPath("/calc2");  // Cookies ��� ���� �� �� �ʿ� �� ���� ��� ���� 
			valuecookie.setMaxAge(60*3);
			opcookie.setPath("/calc2");  // /~/ ��� �ϸ� �ش� �ȿ����� ��� ����
			response.addCookie(valuecookie);
			response.addCookie(opcookie);
			// ����� ���������� ���� ����
			response.sendRedirect("calc2.html");
		}
	
	}
		
}
