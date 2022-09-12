<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%

session.invalidate(); //모든 속성 한번에 삭제 
response.sendRedirect("golf.jsp");
%>
