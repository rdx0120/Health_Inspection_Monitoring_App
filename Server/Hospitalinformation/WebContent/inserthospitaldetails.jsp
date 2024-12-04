<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="insertlocation" method="post" >
					<input type="hidden"  name="type" value="user">
<label for="cars">Choose a Hospitalname:</label>


<div class="user">
							<i> </i> <input type="text" placeholder="Hospital name" name="hospitalname" required onblur="updateOutput(this.value)">
						
						</div>
 
<div class="user">
							<i> </i> <input type="text" placeholder="Phone number" name="phonenumber" required onblur="updateOutput(this.value)">
						
						</div>
						
						<div class="user">
							<i> </i> <input type="text" placeholder="Location" name="location" required>
						</div>
						
						<div class="user">
							<i> </i> <input type="text" placeholder="Type of facility comma separated" name="facility" required>
						</div>
						
						
						<div class="user">
							<i> </i> <input type="text" placeholder="Number of beds" name="beds" required>
						</div>
						<div class="user">
							<i> </i> <input type="text" placeholder="Operation Theaters Provided" name="operations" required>
						</div>
						
						<div class="user1">
							<i> </i> <input type="text" placeholder="lattitude" name="lattitude" required>
						</div>
					<div class="user1">
							<i> </i> <input type="text" placeholder="Longitude" name="longitude" required>
						</div>
						<span id="userNameMessage" style="margin-left:10px;"></span>
						<div class="user2">
							<input type="submit" value="Submit">
						</div>
					</form>
   	 		
</body>
</html>