<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>${it.name} Profile Page</title>
</head>
<body>
<h1><center>Welcome ${it.name} ! This is Your Home Page. </center></h1>

<a href="/social/group/">Create Group</a> <br>
<a href="/social/join/">Join Group</a> <br>
<a href="/social/logout/">Logout</a> <br>

<p><a href="/social/FriendRequsts">FriendRequsts</a></p>

<form action ="/social/addFriend" method="post">
<input type="submit" value="Add Friend" />
<input type="text" name="email" />
</form>
</body>
</html>