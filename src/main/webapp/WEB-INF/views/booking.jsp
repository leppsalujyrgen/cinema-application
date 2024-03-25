<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">

	<title>Movie Review | Single</title>

	<!-- Loading third party fonts -->
	<link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|" rel="stylesheet" type="text/css">
	<link href="fonts/font-awesome.min.css" rel="stylesheet" type="text/css">

	<!-- Loading main css file -->
	<link rel="stylesheet" href="/css/style.css">

	<!--[if lt IE 9]>
		<script src="js/ie-support/html5.js"></script>
		<script src="js/ie-support/respond.js"></script>
		<![endif]-->

</head>


<body>


	<div id="site-content">
		<header class="site-header">
			<div class="container">
				<a href="index.jsp" id="branding">
					<img alt="" class="logo">
					<div class="logo-copy">
						<h1 class="site-title">Company Name</h1>
						<small class="site-description">Tagline goes here</small>
					</div>
				</a> <!-- #branding -->

				<div class="main-navigation">
					<button type="button" class="menu-toggle"><i class="fa fa-bars"></i></button>
					<ul class="menu">
						<li class="menu-item"><a href="index.jsp">Home</a></li>
						<li class="menu-item"><a href="about.jsp">About</a></li>
						<li class="menu-item current-menu-item"><a href="review.jsp">Movie reviews</a></li>
						<li class="menu-item"><a href="joinus.jsp">Join us</a></li>
						<li class="menu-item"><a href="contact.jsp">Contact</a></li>
					</ul> <!-- .menu -->

					<form action="#" class="search-form">
						<input type="text" placeholder="Search...">
						<button><i class="fa fa-search"></i></button>
					</form>n><i class="fa fa-search"></i></button>
					</form>
				</div> <!-- .main-navigation -->

				<div class="mobile-navigation"></div>
			</div>
		</header>
		<main class="main-content">
			<div class="container">
				<div class="page">
					<div class="breadcrumbs">
						<a href="index.jsp">Home</a>
						<a href="review.jsp">Movie Review</a>
						<span>The Croods</span>
					</div>

					<select id="movie" hidden>
						<option value="220">Godzilla vs Kong (RS.220)</option>
						<option value="320">Radhe (RS.320)</option>
						<option value="250">RRR (RS.250)</option>
						<option value="260">F9 (RS.260)</option>
					</select>

					<ul class="showcase">
						<li>
							<div class="seat"></div>
							<small>Available</small>
						</li>
						<li>
							<div class="seat selected"></div>
							<small>Selected</small>
						</li>
						<li>
							<div class="seat sold"></div>
							<small>Sold</small>
						</li>
					</ul>
					<div class="movie-container ">
						<div class="screen"></div>

						<div class="row">
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat"></div>
						</div>

						<div class="row">
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat sold"></div>
							<div class="seat sold"></div>
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat"></div>
						</div>
						<div class="row">
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat sold"></div>
							<div class="seat sold"></div>
						</div>
						<div class="row">
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat"></div>
						</div>
						<div class="row">
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat sold"></div>
							<div class="seat sold"></div>
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat"></div>
						</div>
						<div class="row">
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat"></div>
							<div class="seat sold"></div>
							<div class="seat sold"></div>
							<div class="seat sold"></div>
							<div class="seat"></div>
						</div>
					</div>

					<p class="text">
						You have selected <span id="count">0</span> seat for a price of RS.<span id="total">0</span>
					</p>
				</div>
			</div> <!-- .container -->
		</main>
		<footer class="site-footer">
			<div class="container">
				<div class="row">
					<div class="col-md-2">
						<div class="widget">
							<h3 class="widget-title">About Us</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quia tempore vitae mollitia
								nesciunt saepe cupiditate</p>
						</div>
					</div>
					<div class="col-md-2">
						<div class="widget">
							<h3 class="widget-title">Recent Review</h3>
							<ul class="no-bullet">
								<li>Lorem ipsum dolor</li>
								<li>Sit amet consecture</li>
								<li>Dolorem respequem</li>
								<li>Invenore veritae</li>
							</ul>
						</div>
					</div>
					<div class="col-md-2">
						<div class="widget">
							<h3 class="widget-title">Help Center</h3>
							<ul class="no-bullet">
								<li>Lorem ipsum dolor</li>
								<li>Sit amet consecture</li>
								<li>Dolorem respequem</li>
								<li>Invenore veritae</li>
							</ul>
						</div>
					</div>
					<div class="col-md-2">
						<div class="widget">
							<h3 class="widget-title">Join Us</h3>
							<ul class="no-bullet">
								<li>Lorem ipsum dolor</li>
								<li>Sit amet consecture</li>
								<li>Dolorem respequem</li>
								<li>Invenore veritae</li>
							</ul>
						</div>
					</div>
					<div class="col-md-2">
						<div class="widget">
							<h3 class="widget-title">Social Media</h3>
							<ul class="no-bullet">
								<li>Facebook</li>
								<li>Twitter</li>
								<li>Google+</li>
								<li>Pinterest</li>
							</ul>
						</div>
					</div>
					<div class="col-md-2">
						<div class="widget">
							<h3 class="widget-title">Newsletter</h3>
							<form action="#" class="subscribe-form">
								<input type="text" placeholder="Email Address">
							</form>
						</div>
					</div>
				</div> <!-- .row -->

				<div class="colophon">Copyright 2014 Company name, Designed by Themezy. All rights reserved</div>
			</div> <!-- .container -->

		</footer>
	</div>
	<!-- Default snippet for navigation -->



	<script src="/js/jquery-1.11.1.min.js"></script>
	<script src="/js/plugins.js"></script>
	<script src="/js/app.js"></script>

</body>

</html>