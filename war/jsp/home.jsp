<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<<<<<<< HEAD
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
=======
<title>Insert title here</title>
</head>
<body>
<p> Welcome b2a ya ${it.name} </p>
<p> This is should be user home page </p>
<p> Current implemented services "http://fci-swe-apps.appspot.com/rest/RegistrationService --- {requires: uname, email, password}" </p>
<p> and "http://fci-swe-apps.appspot.com/rest/LoginService --- {requires: uname,  password}" </p>
<p> you should implement sendFriendRequest service and addFriend service
>>>>>>> 93d379e49e7e6d965ecc4a4c763696b8990162e4
</body>
</html>