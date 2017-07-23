# springboot-lagency-struts-1
An example project for using old struts 1.x in springboot.

This project is created for who use the old Struts 1.x.

This example project, uses Struts Form / Action / JSP, and also shows some usages of the <%=   %> , <%   %>, etc.

To start, simple clone and start the main class SampleWebJspApplication, or run *maven:run* task.

If you like to start the main class instead of the *maven:run* task, you must set the **Working Directory** in IDEA or Eclipse, to 
**<GIT_PROJECT_HOME>\main** folder. Otherwise, you may got a 404 error, because SpringBoot cannot find the directory of <CurrentDIR>\src\main\webapp.

After the embeded Tomcat is started, open your browser and access
https://localhost:8080/test.do?state=test

** HTTPS enabled, so the protocol should be https.

That's all.
