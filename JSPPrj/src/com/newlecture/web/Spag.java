package com.newlecture.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spag")
public class Spag extends HttpServlet {
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	
	  int num = 0;
	  String temp = request.getParameter("n");
	  if (temp != null)
	  {
		 num = Integer.parseInt(request.getParameter("n"));
	  }
	 String result = "";
	 if (num % 2 != 0) {
		 result = "È¦¼ö";
	 }

	 else 
	 {
		 result = "Â¦¼ö";
	 }
	 
	 Map <String, Object> notice = new HashMap <String,Object>();
	 notice.put("id", 1);
	 notice.put("title", "Good Job");
	 request.setAttribute("notice", notice);
	request.setAttribute("result", result);
	String[] names = {"1","2","3"};
	request.setAttribute("names", names);
	RequestDispatcher dispatcher = request.getRequestDispatcher("spag.jsp");
	dispatcher.forward(request,response);
	}
}
