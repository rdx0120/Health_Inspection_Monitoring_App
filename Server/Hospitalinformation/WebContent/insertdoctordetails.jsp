<!DOCTYPE html>
<html lang="en">
<head>
<title>Hospital information</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords" content="Grand Tour Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
	
	<!-- css files -->
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css' /><!-- bootstrap css -->
    <link href="css/style.css" rel='stylesheet' type='text/css' /><!-- custom css -->
    <link href="css/font-awesome.min.css" rel="stylesheet"><!-- fontawesome css -->
	<!-- //css files -->
	
	<!-- google fonts -->
	<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
	<!-- //google fonts -->
	
</head>
<body>

<!-- header -->
<header>
	<div class="container">
		<!-- nav -->
		<nav class="py-md-4 py-3 d-lg-flex">
			<div id="logo">
				<h1 class="mt-md-0 mt-2"> <a href="index.jsp"><span class="fa fa-map-signs"></span> Hospital Info </a></h1>
			</div>
			<label for="drop" class="toggle"><span class="fa fa-bars"></span></label>
			<input type="checkbox" id="drop" />
			<ul class="menu ml-auto mt-1">
				<li class="active"><a href="index.jsp">Home</a></li>
				<li class=""><a href="insertdoctordetails.jsp">Doctors</a></li>
				<li class=""><a href="inserthospital.jsp">Hospital</a></li>
				<li class=""><a href="insertspecialist.jsp">Specialist</a></li>
			</ul>
		</nav>
		<!-- //nav -->
	</div>
</header>
<!-- //header -->

<!-- banner -->
<section class="banner_inner" id="home">
	<div class="banner_inner_overlay">
	</div>
</section>
<!-- //banner -->


<!-- Contact -->
<section class="contact py-5">
	<div class="container py-lg-5 py-sm-3">
			<h2 class="heading text-capitalize text-center mb-sm-5 mb-4">Add doctor information</h2>
				<div class="col-xl-5 col-lg-6 col-md-8 col-sm-10 mx-auto text-center">
						<form action="insertdoctorsdetails" method="post">
							<div class=" form-group contact-forms">
							  <input type="text" class="form-control" placeholder="Doctor Name" name="doctorname" required="">
							</div>
							<div class="form-group contact-forms">
							  <input type="text" class="form-control" placeholder="Hospital name where doctor works" name="hospitalname" required="">
							</div>
							<div class="form-group contact-forms">
							  <input type="text" class="form-control" placeholder="Doctors Availibility" name="availability" required> 
							</div>
							<div class="form-group contact-forms">
							  <input type="text" class="form-control" placeholder="Doctors specilization" name="Specilization" required> 
							</div>
							<div class=" form-group contact-forms">
							  <input type="text" class="form-control"  placeholder="Educational Qualification of doctor" name="education" required>
							</div>
							<div class="form-group contact-forms">
							  <input type="text" class="form-control"  placeholder="Phone number" name="phonenumber" required>
							</div>
							<div class="form-group contact-forms">
							  <input type="text" class="form-control"  placeholder="Operation by doctor" name="operation" required> 
							</div>
							
							<div class="form-group contact-forms">
							  <input type="text" class="form-control" placeholder="About doctor" name="about" required> 
							</div>
							<div class="form-group contact-forms">
							  <input type="password" class="form-control" placeholder="password" name="password" required> 
							</div>
							<div class="form-group contact-forms">
							  <input type="submit" class=" btn-success"> 
							</div>
						</form>
					</div>
			</div>			
	</div>
</section>

<!-- copyright -->
<div class="copyright py-3 text-center">
	<p>© 2020 Hospital information </p>
</div>
<!-- //copyright -->

<!-- move top -->
<div class="move-top text-right">
	<a href="#home" class="move-top"> 
		<span class="fa fa-angle-up  mb-3" aria-hidden="true"></span>
	</a>
</div>
<!-- move top -->

	
</body>
</html>