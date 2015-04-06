<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="project550.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script src="http://maps.googleapis.com/maps/api/js"></script>
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World - JSP tutorial</title>
 <script type="text/javascript">
 var directionsDisplay;
 var directionsService = new google.maps.DirectionsService();
 var map;
 function initialize() {

     directionsDisplay = new google.maps.DirectionsRenderer();
	  var mapProp = {
	    center:new google.maps.LatLng(51.508742,-0.120850),
	    zoom:5,
	    mapTypeId:google.maps.MapTypeId.ROADMAP
	  };
	   map=new google.maps.Map(document.getElementById("map-canvas"),mapProp);
	  directionsDisplay.setMap(map);	
 }


function calcRoute() {
    var start = document.getElementById('start').value;
    var end = document.getElementById('end').value;
    var request = {
        origin: start,
        destination: end,
        travelMode: google.maps.TravelMode.DRIVING
    };
    directionsService.route(request, function (response, status) {
        if (status == google.maps.DirectionsStatus.OK) {
            directionsDisplay.setDirections(response);
        }
    });
 function moveMarkertoDest(){
	 var myLatlng = new google.maps.LatLng(-25.363882,131.044922);
	 var mapOptions = {
			  zoom: 4,
			  center: myLatlng
			}
//	 map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);
	 var marker = new google.maps.Marker({
		    position: myLatlng,
		    map: map,
		    title:"Hello World!"
		});
	 marker.setMap(map);
	 
 }
 
}
google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>

  
<body>
	<input type="text" placeholder="Source" name="start" id="start">
    <input type="text" placeholder="Source" name="end" id="end">
    <input id="Button1" type="button" value="button" onclick="calcRoute()" />
    <div id="map-canvas" style="width:500px;height:380px;"></div>
    <% 
    ConnectDb con = new ConnectDb();
    ResultSet res = con.insertAndExtract();
     %>
    
</body>
</html>