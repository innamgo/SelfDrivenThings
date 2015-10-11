<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>Airwolf Team EDISON-WEB-IDE</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="/resources/css/styles.css" rel="stylesheet">
		<meta name="_csrf" content="${_csrf.token}"/>
		<meta name="_csrf_header" content="${_csrf.headerName}"/>
		<!-- script references -->
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="/resources/js/bootstrap.min.js"></script>
		<script src="/resources/js/scripts.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				
				$("#btnRunScript").click(function() {
					var token = $("meta[name='_csrf']").attr("content");
					var header = $("meta[name='_csrf_header']").attr("content");
					$.ajax({ 
						type: 'post', 
						url: '/EdisonWebIDE/Run', 
						dataType: "text", 
						data: $("#scriptForm").serialize(),
						beforeSend: function(req) { req.setRequestHeader(header, token); }, 
						success: function(form) { alert(form)}, 
						error: function(xhr) { alert("Failed")}
						});					
					return false;
				});
			});
		</script>
	</head>
<body>

<header class="navbar navbar-default navbar-static-top" role="banner">
  <div class="container">
    <div class="navbar-header">
      <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a href="/" class="navbar-brand">Airwolf Team</a>
    </div>
    <nav class="collapse navbar-collapse" role="navigation">
      <ul class="nav navbar-nav">
        <li>
          <a href="#">About</a>
        </li>
      </ul>
    </nav>
  </div>
</header>

<!-- Begin Body -->
<div class="container">
	<div class="row">
  			<div class="col-md-3" id="leftCol">
              	
				<div class="well"> 
              	<ul class="nav nav-stacked" id="sidebar">
                  <li><a href="#sec1">Intel Edison Board Web IDE</a></li>
                  <li><a href="#sec2">Section 2</a></li>
              	</ul>
  				</div>

      		</div>  
      		<div class="col-md-9">
              	<h2 id="sec0">Execute javascript</h2>
                You can write to execute javascript in text area.
              	
            
           
              	<hr class="col-md-12">
              	
              	<h2 id="sec1"> Javascript Content</h2>
              	<p>
               
              	</p>
              	<div class="row">
                  <div class="col-md-9">
                    <div class="panel panel-default">
                      <div class="panel-heading">
                      	<a href="">
                      		<button class="btn btn-primary btn-lg" id="btnRunScript" name="btnRunScript">Run the script.</button>
                      	</a>
                      </div>
                      <div class="panel-body">
	                      <form class="form-inline" role="form" id="scriptForm" name="scriptForm">
	                      	<textarea  class="form-control" id='scriptTextArea' name='scriptTextArea' rows="20" cols="100">
var mraa = require('mraa'); //require mraa
console.log('MRAA Version: ' + mraa.getVersion()); 

//var myOnboardLed = new mraa.Gpio(3, false, true); 
var myOnboardLed = new mraa.Gpio(13); 
myOnboardLed.dir(mraa.DIR_OUT); 
var ledState = true; //Boolean to hold the state of Led
myOnboardLed.write(0);
//periodicActivity(); //call the periodicActivity function

function periodicActivity()
{
  myOnboardLed.write(ledState?1:0); 
  ledState = !ledState; //invert the ledState
  setTimeout(periodicActivity,300); 
}
	                      	</textarea>
	                      </form>
                      </div>
                    </div>
                  </div>
                  
              	</div>
              
              	<hr>
              
              	<h2 id="sec2">Section 2</h2>
              	<p>
              	</p>
              	<div class="row">
              		<div class="col-md-4"><img src="//placehold.it/300x300" class="img-responsive"></div>
                  	<div class="col-md-4"><img src="//placehold.it/300x300" class="img-responsive"></div>
                  	<div class="col-md-4"><img src="//placehold.it/300x300" class="img-responsive"></div>
              	</div>
              
              	<hr>
              	<h4><a href="http://airwolf.cloudapp.net:8080">Go To Airwolf Self Driven Things Search Engine</a></h4>
              	<hr>
              	
              	
      		</div> 
  	</div>
</div>

	</body>
</html>