<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
  font-family: 'Lato', sans-serif;
  background: url(images/loginimg.jpg) no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}

.wrapper{
  position: fixed;
  top: 40%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.link_wrapper{
  position: relative;
}

a{
  display: block;
  width: 250px;
  height: 50px;
  line-height: 50px;
  font-weight: bold;
  text-decoration: none;
  background: #333;
  text-align: center;
  color: #fff;
  text-transform: uppercase;
  letter-spacing: 1px;
  border: 3px solid #333;
  transition: all .35s;
}

.icon{
  width: 50px;
  height: 50px;
  border: 3px solid transparent;
  position: absolute;
  transform: rotate(45deg);
  right: 0;
  top: 0;
  z-index: -1;
  transition: all .35s;
}

.icon svg{
  width: 30px;
  position: absolute;
  top: calc(50% - 15px);
  left: calc(50% - 15px);
  transform: rotate(-45deg);
  fill: black;
  transition: all .35s;
}

a:hover{
  width: 200px;
  border: 3px solid black;
  background: transparent;
  color: black;
}

a:hover + .icon{
  border: 3px solid black;
  right: -25%;
 } 
.wrapper1{
  position: fixed;
  top: 20%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.link_wrapper1{
  position: relative;
}
.wrapper2{
  position: fixed;
  top: 60%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.link_wrapper2{
  position: relative;
}
.wrapper3{
  position: fixed;
  top: 80%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.link_wrapper3{
  position: relative;
}
</style>
</head>
<body >
<div class="wrapper">
  <div class="link_wrapper">
    <a href="employeelogin">PATIENT</a>
    <div class="icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 268.832 268.832">
        <path d="M265.17 125.577l-80-80c-4.88-4.88-12.796-4.88-17.677 0-4.882 4.882-4.882 12.796 0 17.678l58.66 58.66H12.5c-6.903 0-12.5 5.598-12.5 12.5 0 6.903 5.597 12.5 12.5 12.5h213.654l-58.66 58.662c-4.88 4.882-4.88 12.796 0 17.678 2.44 2.44 5.64 3.66 8.84 3.66s6.398-1.22 8.84-3.66l79.997-80c4.883-4.882 4.883-12.796 0-17.678z"/>
      </svg>
    </div>
  </div>
  
</div>
<div class="wrapper1">
  <div class="link_wrapper1">
    <a href="adminlogin">ADMIN</a>
    <div class="icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 268.832 268.832">
        <path d="M265.17 125.577l-80-80c-4.88-4.88-12.796-4.88-17.677 0-4.882 4.882-4.882 12.796 0 17.678l58.66 58.66H12.5c-6.903 0-12.5 5.598-12.5 12.5 0 6.903 5.597 12.5 12.5 12.5h213.654l-58.66 58.662c-4.88 4.882-4.88 12.796 0 17.678 2.44 2.44 5.64 3.66 8.84 3.66s6.398-1.22 8.84-3.66l79.997-80c4.883-4.882 4.883-12.796 0-17.678z"/>
      </svg>
    </div>
  </div>
</div>
<div class="wrapper2">
  <div class="link_wrapper2">
    <a href="receptionistlogin">RECEPTIONIST</a>
    <div class="icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 268.832 268.832">
        <path d="M265.17 125.577l-80-80c-4.88-4.88-12.796-4.88-17.677 0-4.882 4.882-4.882 12.796 0 17.678l58.66 58.66H12.5c-6.903 0-12.5 5.598-12.5 12.5 0 6.903 5.597 12.5 12.5 12.5h213.654l-58.66 58.662c-4.88 4.882-4.88 12.796 0 17.678 2.44 2.44 5.64 3.66 8.84 3.66s6.398-1.22 8.84-3.66l79.997-80c4.883-4.882 4.883-12.796 0-17.678z"/>
      </svg>
    </div>
  </div>
</div>
<div class="wrapper3">
  <div class="link_wrapper3">
    <a href="doctorlogin">DOCTOR</a>
    <div class="icon">
      <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 268.832 268.832">
        <path d="M265.17 125.577l-80-80c-4.88-4.88-12.796-4.88-17.677 0-4.882 4.882-4.882 12.796 0 17.678l58.66 58.66H12.5c-6.903 0-12.5 5.598-12.5 12.5 0 6.903 5.597 12.5 12.5 12.5h213.654l-58.66 58.662c-4.88 4.882-4.88 12.796 0 17.678 2.44 2.44 5.64 3.66 8.84 3.66s6.398-1.22 8.84-3.66l79.997-80c4.883-4.882 4.883-12.796 0-17.678z"/>
      </svg>
    </div>
  </div>
</div>
</body>
</html>