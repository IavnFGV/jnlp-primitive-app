# jnlp-primitive-app

---

*This app is a part of investigation to move some of users to Java WebStart, who use desktop java apps*


##Java web start simple application

---

Few months ago I received a Swing application for development. 
And after 2 releases and about of 5-6 test assemblies my 
patience has come to an end. 
Passing the test version to client: 
* an assembly
* archiving with dependencies libs 
* putting in repository download or on the file-exchanger. 
And if there were changes in the resources that the client uses to on production.
Its a user headache what file to change, place or replace.

First .cmd scripts were helping... But we can do better!
So I decided to at least test releases translate to Java WebStart. 
And this app - my first steps.

##Steps to run

---

* Clone rep
```bash
git clone  https://github.com/IavnFGV/jnlp-primitive-app.git
```

* Open in your IDE or use Maven (I used IntelliJ IDEA and Tomcat 9 for testing)
* For autodeploy configure Tomcat (7-9) for deploying from Maven:
    TOMCAT_HOME/conf/tomcat-users.xml must contains something like:

```xml
<!-- Role to manage WAR files via HTML /manager. The name should be as is! -->
<role rolename="manager-gui"/>
<!-- Role to manage WAR files via script like Maven. The name should be as is! -->
<role rolename="manager-script"/>
<!-- One user cannot have manager-gui and manager-script roles -->
<user username="managerGui" password="managerPwd" roles="manager-gui"/>
<user username="manager" password="managerPwd" roles="manager-script"/>
```
* Configure your Maven /settings.xml to include the password.
  
```xml
  <settings>
      <servers>
          <server>
              <id>local-tomcat-9-8080-maven-deploy</id>
              <username>manager</username>
              <password>managerPwd</password>
          </server>
      </servers>  
  </settings>
```

* After *mvn clean tomcat:redeploy* unzip files from archived client module jnlp-primitive-client-${version}.zip
into  tomcat/webapps/${path}/webstart folder.
In my case ${path} = **/PrimitiveWebstartMaven-Web** 
* open http://localhost:8080/PrimitiveWebstartMaven-Web/webstart/launch.jnlp and start app

Actually you will need to set up Java Security params. Simple add http://localhost:8080 to Exception site list.

##Links:
1. [Example of same application](http://www.shaunabram.com/swing-webstart-maven-example/)
2. [Stackoverflow instruction how to set up Maven and Tomcat](http://stackoverflow.com/a/16292897/5645883)
3. [Jnlp syntax](http://docs.oracle.com/javase/1.5.0/docs/guide/javaws/developersguide/syntax.html)










