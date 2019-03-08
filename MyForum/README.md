   Here is forum with user registration and login. To create the forum I used such elements as: Servlets, 
JSP, Expression language, JSTL, JDBC, JPA, as well as listeners of context, filters, entities.

   The whole thing is contained in a folder structure compatible with Maven. Verification of users is done 
by Tomcat mechanism called "j_security_check", which checks the compatibility of the password encoded by the 
MD5 algorithm. Passwords in MySQL database are also saved by encoding with MD5 algorithm during registration. 
Information about the logged user is stored as a cookie in an active session.

Subjects and user information are stored as tables in the MySQL database. When the user logs out, the session is cleared.
