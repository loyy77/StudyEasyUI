<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
    String protocal=request.getScheme();
	String localhost=request.getServerName();
    int ports=request.getServerPort();
    String ctx=request.getContextPath();
    String path=protocal+"://"+localhost+":"+ports+ctx+"/";
%>