# JSP - 정리 1일차

* 명령어 참조는 http://pad.haroopress.com/page.html?f=markdown-autocompletion
* 강의는 https://www.youtube.com/watch?v=arB7sQ9S7h0&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd&index=39

## JSP란?

### 1. 프레임워크에 대해
	-> 프레임워크란 특정 목적에 맞게 프로그래밍을 하기 위한 약속이라고 할 수 있다.
    -> 대표적으로 Spring 등이 있으며 JAVA 언어를 기반으로 어플리케이션을 제작하는 툴이라고 생각하면 편하다.

### 2. JSP에 대해
	-> Java Server Page란 PHP처럼 태그를 사용하여 html 코드 내부에 사용하는 것을 의미.
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "calculator" method = "get">
	<input type ="submit" value = "요청">
</form>
</body>
</html>
# 상단의 코드에서 보면 form action 등을 JSP 라고 한다.
```

### 3. 서블릿에 대해
	-> 서블릿이란 서버에 동적인 콘텐츠를 생성하기 위해 사용되는 기술을 의미한다. 즉 JAVA 서버에서 움직이는 작은 프로그램으로 JSP의 기반이 된다고 말할 수 있다.
    -> JSP는 Java 서버가 JSP 코드를 읽고 이를 서블릿 소슼 ㅗ드로 변환한다. 이 과정에서 HTML 태그 등을 println으로 출력하도록 변환한다.
== 정리하자면 JSP 파일 -> Servlet 파일 -> 클래스 파일 -> 실행 순으로 동적으로 파일을 생성하는 것을 의미한다. ==

```
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setCharacterEncoding("UTF-8"); // 이는 사용자에게 보낼 코딩 방식
		response.setContentType("text/html; charset = UTF-8"); // 인코딩 해야하는 형식
		PrintWriter out = response.getWriter();
		
		String exp = "0";
		Cookie[] cookies = request.getCookies(); // 사용자에게서 쿠키를 받음
		
		if (cookies != null)
		{
			for (Cookie c : cookies)
				if (c.getName().equals("exp"))
				{
					exp = c.getValue();
					break;
				}	
			
		}
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("<style>");
		out.write("input{");
		out.write("width:50px;");
		out.write("height:50px;");
		out.write("}");
		out.write(".output{");
		out.write("height:50px;");
		out.write("background: #e9e9e9;");
		out.write("font-size: 24px;");
		out.write("font-weight:bold;");
		out.write("text-align : right;");
		out.write("padding: 0px 5px;");
		out.write("}");
		out.write("</style>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form action =\"calc3\" method=\"post\">");
		out.write("	<table>");
		out.write("		<tr>");
		out.printf("		<td class = \"output\" colspan =\"4\">%s</td>",exp);
				out.write("		</tr>");
				out.write("		<tr>");
				out.write("			<td><input type =\"submit\" name =\"operator\" value = \"CE\"/></td>");
				out.write("			<td><input type =\"submit\" name =\"operator\" value = \"C\"/></td>");
				out.write("			<td><input type =\"submit\" name =\"operator\" value = \"BS\"/></td>");
				out.write("			<td><input type =\"submit\" name =\"operator\" value = \"/\"/></td>");
				out.write("			</tr>");
				out.write("			<tr>");
				out.write("				<td><input type =\"submit\" name =\"value\" value = \"7\"/></td>");
				out.write("				<td><input type =\"submit\" name =\"value\" value = \"8\"/></td>");
				out.write("				<td><input type =\"submit\" name =\"value\" value = \"9\"/></td>");
				out.write("				<td><input type =\"submit\" name =\"operator\" value = \"*\"/></td>");
				out.write("			</tr>");	
				out.write("			<tr>");
				out.write("			<td><input type =\"submit\" name =\"value\" value = \"4\"/></td>");
				out.write("					<td><input type =\"submit\" name =\"value\" value = \"5\"/></td>");
				out.write("					<td><input type =\"submit\" name =\"value\" value = \"6\"/></td>");
				out.write("					<td><input type =\"submit\" name =\"operator\" value = \"-\"/></td>");
				out.write("				</tr>");
				out.write("				<tr>");
				out.write("				<td><input type =\"submit\" name =\"value\" value = \"1\"/></td>");
				out.write("				<td><input type =\"submit\" name =\"value\" value = \"2\"/></td>");
				out.write("				<td><input type =\"submit\" name =\"value\" value = \"3\"/></td>");
				out.write("				<td><input type =\"submit\" name =\"operator\" value = \"+\"/></td>");
				out.write("				</tr>");	
				out.write("			<tr>");
				out.write("				<td></td>");
				out.write("				<td><input type =\"submit\" name =\"value\" value = \"0\"/></td>");
				out.write("				<td><input type =\"submit\" name =\"dot\" value = \".\"/></td>");
					out.write("					<td><input type =\"submit\" name =\"operator\" value = \"=\"/></td>");
					out.write("			</tr>");
					out.write("				</table>");
				out.write("			</form>");
				out.write("		</body>");
				out.write("	</html>");
	
	}
```
== 즉 서블릿을 쓰지 않으면 이런 식으로 모두 out.write or println 처리를 해주어야 한다. ==