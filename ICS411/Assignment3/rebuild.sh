hadoop fs -rm -R /user/fisher/weblogcount/output
rm weblogcount.jar
jar -cvf weblogcount.jar -C bin .
chmod 777 weblogcount.jar

