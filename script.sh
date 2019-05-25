#! /bin/bash
rm -r ../apache-tomcat-9.0.20/webapps/web*
rm -r ../apache-tomcat-9.0.20/webapps/project123*
cp web.war ../apache-tomcat-9.0.20/webapps/
