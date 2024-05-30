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
         <form:form id="register" action="addpatient" method="post" modelAttribute="pat">
             <label>Full Name : </label>
             <br>
             <form:input path="fullname" required="required" placeholder="Enter Your Name"></form:input>
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
             <label>Blood Group : </label>
             <br>
             <form:input path="bloodgroup" required="required" placeholder="Enter your Blood Group"></form:input>
             <br><br>
             <label>Contact Number : </label>
             <br>
             <form:input path="contactno" required="required" placeholder="Enter your Contact Number"></form:input>
             <br><br>
             <label>Register Date : </label>
             <br>
             <form:input path="registerdate" required="required" placeholder="DD/MM/YYYY"></form:input>
             <br><br>
             <label>Location : </label>
             <br>
             <form:input path="location" required="required" placeholder="Enter your Location"></form:input>
             <br><br>
             <label>Username : </label>
             <br>
             <form:input path="username" required="required" placeholder="Username"></form:input>
             <br><br>
             <label>Password : </label>
             <br>
             <form:password path="password" required="required" placeholder="Password"></form:password>
             <br><br>
             <input type="submit" value="Registere" name="submit" id="submit">
         </form:form>
     </div>

 </div>

 </body>
 </html>