<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>
 <!DOCTYPE html>
 <html>
 <head>
     <title>Registration Form</title>
     <link rel="stylesheet" href="styles.css" type="text/css">
 </head>

 <body>

 <div class="main">
     <div class="register">
         <h2>Register Here</h2>
         <form:form id="register" action="addreceptionist" method="post" modelAttribute="rep">
             <label>Full Name : </label>
             <br>
             <form:input path="name" required="required" placeholder="Enter Your Name"></form:input>
             <br><br>
             <label>Username : </label>
             <br>
             <form:input path="username" required="required" placeholder="Username"></form:input>
             <br><br>
             <label>Password : </label>
             <br>
             <form:password path="password" required="required" placeholder="Password"></form:password>
             <br><br>
             <label>Gender : </label>
             <br>
             &nbsp;&nbsp;&nbsp;
             <input type="radio" name="gender" id="male" path="gender" value="Male" required="required">
             &nbsp;
             <span id="male">Male</span>
             &nbsp;&nbsp;&nbsp;&nbsp;
             <input type="radio" name="gender" id="female" path="gender" value="Female" required="required">
             &nbsp;
             <span id="male">Female</span>
             <br><br>
             <label>Age : </label>
             <br>
             <form:input path="age" required="required" id="name" placeholder="How old are you?"></form:input>
             <br><br>
             <label>Qualification : </label>
             <br>
             <form:input path="qualification" required="required" placeholder="Enter your Qualification"></form:input>
             <br><br>
             <label>Year of join : </label>
             <br>
             <form:input path="yearofjoin" required="required" placeholder="YYYY"></form:input>
             <br><br>
             <label>Contact Number : </label>
             <br>
             <form:input path="contactno" required="required" placeholder="Enter your Contact Number"></form:input>
             <br><br>
             <label>EmailId : </label>
             <br>
             <form:input path="emailid" required="required" placeholder="Enter your Email ID"></form:input>
             <br><br>
             
             <input type="submit" value="Register" name="submit" id="submit">
         </form:form>
     </div>

 </div>

 </body>
 </html>