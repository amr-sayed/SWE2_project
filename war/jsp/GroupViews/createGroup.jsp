<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Create A Group</title>
</head>
<body>
<h1><center>Create Your Own Project</center></h1>
  <form action="/social/CreateGroup" method="post">
  Name : <input type="text" name="name" /> <br>
  Description : <textarea rows="5" cols="5" name = "desc"></textarea> <br>
  Privacy : <select name = "privacy">
  				<option value = "public">Public</option>
  				<option value = "private">Private</option>
  				<option value = "closed">Closed</option>
  			</select>
  <input type="submit" value="Register">
  
  </form>
</body>
</html>
