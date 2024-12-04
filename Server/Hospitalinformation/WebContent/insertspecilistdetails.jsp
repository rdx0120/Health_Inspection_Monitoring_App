<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<html>
<head>
<!--part-2 start here-->
   <div class="part-2">
<!--block-5 strat here-->
   	<%
   	 	String username=(String)session.getAttribute("user"); 
	%>
		<div class="block-6 signs">
   	 	<div class="block-6-left">
   	 		<div class="block-6-top">
   	 			<h6><a href="#">Add  Doctor Information </a></h6>
   	 			<h3>Doctor Info</h3>
   	 		</div>
   	 		<div class="block-6-bottom">
   	 		<form action="insertspecialistdetails" method="post" >
					<input type="hidden"  name="type" value="user">
						<div class="user">
							<i> </i> <input type="text" placeholder="Specialist Name" name="doctorname" required onblur="updateOutput(this.value)">
						
						</div>
						
						<div class="user">
							<i> </i> <input type="text" placeholder="Hospital name where Specialist works" name="hospitalname" required>
						</div>
						<div class="user">
							<i> </i> <input type="text" placeholder="Specialist Availibility" name="availability" required>
						</div>
						<div class="user">
							<i> </i> <input type="text" placeholder=" specilization" name="specialization" required>
						</div>
						<div class="user">
							<i> </i> <input type="text" placeholder="Educational Qualification of Specialist" name="education" required>
						</div>
						<div class="user">
							<i> </i> <input type="text" placeholder="Operation by Specialist" name="operation" required>
						</div>
						<div class="user">
							<i> </i> <input type="text" placeholder="Phone number" name="phonenumber" required>
						</div>
						<div class="user">
							<i> </i> <input type="text" placeholder="About Specialist" name="about" required>
						</div>
					
						
						<div class="user2">
							<input type="submit" value="Submit">
						</div>
					</form>
   	 		
   	 		  <span class="sign-1-or-bar"> </span> 	 		 
   	 		  
   	 		</div>
   	 	</div>
   	 	
   	   <div class="clearfix"> </div>
   	 </div>
		
		
		
									
<!--pop-up-grid-->
<!--header end here-->
</body>
</html>


		