<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.example.dao.BoardDAO, com.example.bean.BoardVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>
<%
	BoardDAO boardDAO = new BoardDAO();
	String id=request.getParameter("id");	
	BoardVO u=boardDAO.getBoard(Integer.parseInt(id));
	request.setAttribute("vo", u);
%>

<h1>Edit Form</h1>
<form action="editpost.jsp" method="post" enctype="multipart/form-data">
<input type="hidden" name="songID" value="${vo.getSongID()}"/>
<table>
<tr>
<%--	<tr><td>Album Photo:</td><td><input type="file" id="albumPhoto" name="albumPhoto" accept="image/png, image/jpeg"/></td></tr>--%>
	<td>Album Photo:</td><td><input type="file" name="albumPhoto" value="${vo.getAlbumPhoto()}"/>
	<c:if test="${vo.getAlbumPhoto() ne ''}"><br/><img src="${pageContext.request.contextPath}/upload/${vo.getAlbumPhoto()}" class="albumPhoto"></c:if>
</td></tr>
<tr><td>Title:</td><td><input type="text" name="title" value="${vo.getTitle()}" /></td></tr>
	<tr><td>Singer:</td><td><input type="text" name="singer" value="${vo.getSinger()}" /></td></tr>
	<tr><td>Album Title:</td><td><input type="text" name="albumTitle" value="${vo.getAlbumTitle()}" /></td></tr>
	<tr><td>Released Date:</td><td><input type="date" name="releasedDate" value="${vo.getReleasedDate()}" /></td></tr>
	<tr><td>Ranking:</td><td><input type="text" name="ranking" value="${vo.getRanking()}" /></td></tr>
	<tr><td>Running Time:</td><td><input type="text" name="runningTime" value="${vo.getRunningTime()}" /></td></tr>
	<tr><td>Song Writer:</td><td><input type="text" name="songWriter" value="${vo.getSongWriter()}" /></td></tr>
<tr><td>Lyrics:</td><td><textarea cols="50" rows="5" name="lyrics">${vo.getLyrics()}</textarea></td></tr>
<tr><td colspan="2"><input type="submit" value="Edit Post"/>
<input type="button" value="Cancel" onclick="history.back()"/></td></tr>
</table>
</form>
</body>
</html>

