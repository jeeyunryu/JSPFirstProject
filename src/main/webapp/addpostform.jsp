<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Add New Post</h1>
<form action="addpost.jsp" method="post" enctype="multipart/form-data">
<table>
<tr><td>Album Photo:</td><td><input type="file" id="albumPhoto" name="albumPhoto" accept="image/png, image/jpeg"/></td></tr>
<tr><td>Title:</td><td><input type="text" name="title"/></td></tr>
    <tr><td>Singer:</td><td><input type="text" name="singer"/></td></tr>
    <tr><td>Album Title:</td><td><input type="text" name="albumTitle"/></td></tr>
    <tr><td>Released Date:</td><td><input type="date" name="releasedDate"/></td></tr>
    <tr><td>Ranking:</td><td><input type="text" name="ranking"/></td></tr>
    <tr><td>Running Time:</td><td><input type="text" name="runningTime"/></td></tr>
    <tr><td>Song Writer:</td><td><input type="text" name="songWriter"/></td></tr>
    <tr><td>lyrics:</td><td><textarea cols="50" rows="5" name="lyrics"></textarea></td></tr>
<tr><td><a href="posts.jsp">View All Records</a></td><td align="right"><input type="submit" value="Add Post"/></td></tr>
</table>
</form>

</body>
</html>