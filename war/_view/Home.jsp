<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>Independent Study Hub</title>

    <link href="./style.css" type="text/css" rel="stylesheet" />
    
</head>
<body>
    <header class="home">
        <h1>Independent Study Hub</h1>

        <p class="quote">Nothing in life is to be feared, it is only to be understood.  Now is the time to understand more, so that we may fear less. <span class="italic">-Marie Curie</span></p>
    </header>

    <section class="Description">
        <div class="protector">
            <h2 class="ribbon">
                <strong class="ribbon-content">Course Description</strong>
            </h2>
        </div>
        <p>
            Independent study is a semester long, student lead project to expand the knowledge of the <br />
            scientific community.  Students will select an advisor to work under and expand an area of<br />
            science.  Students will order their chemicals and design their own methodology (with the  <br />
            assistance of their advisor). <br />
        </p>
    </section>
    <!-- This section will contain all of the links to previous student work  -->
    <section>
        <div class="protector">
            <h2 class="ribbon">
                <strong class="ribbon-content">Previous Work</strong>
            </h2>
        </div>
        <p>
            See examples of previous student work, as well as, uploading you own work.  Students will <br />
            need to upload their files to the archive by the end of the semster.  A picture of your   <br />
            poster and your final study report are required at a minimum.  Additional pictures of lab <br />
            work or documentation is also welcomed. <br />
        </p>
        <a href="Upload.html"><button type="button">Upload!</button></a>
        	<div class="pictures">
	            <!-- This creates the 4-square of images that will link to the Previous work page is you click on any of the pictures (due to wraping in <a>) -->
	            <a href="./war/_view/Research.jsp" id="img1">
	                <img src="../style/FurBall.jpg" />
	                <img src="../style/FurBall.jpg" />
	                <img src="../style/FurBall.jpg" />
	                <img src="../style/FurBall.jpg" />
	            </a>
         
        	</div>
    </section>

    <section>
        <div class="protector">
            <h2 class="ribbon">
                <strong class="ribbon-content">Resources</strong>
            </h2>
        </div>
		<form action="${pageContext.servletContext.contextPath}/Resources" method="doGet">
        <p>Details and examples on what is required for independent research can be found here</p>
        	<table>
	        	<tr>
	        	<td> <input type="Submit" name="submit" value="Click Here!"></td>
	        	</tr>
        	</table>
        </form>
        
    </section>

    <section>
        <div class="protector">
            <h2 class="ribbon">
                <strong class="ribbon-content">Inventory</strong>
            </h2>
        </div>
        <p>A list of all available chemicals within the chemistry department's storage</p>
        <a href="./Inventory.html"><button type="button">Click Here!</button></a>
    </section>

</body>
</html>