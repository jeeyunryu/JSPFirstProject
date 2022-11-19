<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.example.dao.BoardDAO,com.example.bean.BoardVO,java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	BoardDAO boardDAO = new BoardDAO();
	List<BoardVO> list = boardDAO.getBoardList();
	request.setAttribute("list",list);
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>free board</title>
<style>
#list {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
#list td, #list th {
  border: 1px solid #ddd;
  padding: 8px;
  text-align:center;
}
#list tr:nth-child(even){background-color: #f2f2f2;}
#list tr:hover {background-color: #ddd;}
#list th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #006bb3;
  color: white;
}
</style>
<script>
	function delete_ok(id){
		var a = confirm("정말로 삭제하겠습니까?");
		if(a) location.href='deletepost.jsp?id=' + id;
	}
</script>
</head>
<body>
<h1>My Playlist</h1>

<table id="list" width="90%">
<tr>
	<th>songID</th>
	<th>albumPhoto</th>
	<th>title</th>
	<th>singer</th>
	<th>albumTitle</th>
	<th>releasedDate</th>
	<th>ranking</th>
	<th>runningTime</th>
	<th>songWriter</th>
	<th>lyrics</th>
	<th>Edit</th>
	<th>Delete</th>
</tr>
<c:forEach items="${list}" var="u">
	<tr>
		<td>${u.getSongID()}</td>
<%--		<td>${u.getAlbumPhoto()}</td>--%>
<%--		<td><c:if test="${vo.getAlbumPhoto() ne ''}"><br/><img src=""${pageContext.request.contextPath}/upload/${vo.getAlbumPhoto()}" class="albumPhoto"></c:if></td>--%>
		<td><img src="${pageContext.request.contextPath}/upload/${u.getAlbumPhoto()}"></td>
		<td>${u.getTitle()}</td>
		<td>${u.getSinger()}</td>
		<td>${u.getAlbumTitle()}</td>
		<td>${u.getReleasedDate()}</td>
		<td>${u.getRanking()}</td>
		<td>${u.getRunningTime()}</td>
		<td>${u.getSongWriter()}</td>
		<td>${u.getLyrics()}</td>
		<td><a href="editform.jsp?id=${u.getSongID()}">Edit</a></td>
		<td><a href="javascript:delete_ok('${u.getSongID()}')">Delete</a></td>
	</tr>
</c:forEach>
</table>
<br/><a href="addpostform.jsp">Add New Post</a>
</body>
</html>