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
		response.setCharacterEncoding("UTF-8"); // 이는 사용자에게 보낼 코딩 방식
		response.setContentType("text/html; charset = UTF-8"); // 인코딩 해야하는 형식
		PrintWriter out = response.getWriter();
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		
		Cookie[] cookies = request.getCookies(); // 사용자에게서 쿠키를 받음
		
		
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
			
			int y = v; // 사용자 입력
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
			out.println("결과" + result);
		}
		else
		{
			//application.setAttribute("value", v);
			//application.setAttribute("op", op);
			
			//session.setAttribute("value", v);
			//session.setAttribute("op", op);

			Cookie valuecookie = new Cookie("vaule",String.valueOf(v));
			Cookie opcookie = new Cookie("op",op);
			valuecookie.setPath("/calc2");  // Cookies 경로 설정 즉 이 쪽에 올 때만 사용 가능 
			valuecookie.setMaxAge(60*3);
			opcookie.setPath("/calc2");  // /~/ 라고 하면 해당 안에서만 사용 가능
			response.addCookie(valuecookie);
			response.addCookie(opcookie);
			// 사용자 브라우저에게 값을 저장
			response.sendRedirect("calc2.html");
		}
	
	}
		
}
