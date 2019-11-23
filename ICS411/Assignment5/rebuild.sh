hadoop fs -rm -R /user/fisher/Assign5/output
rm assignment5jobs.jar
jar -cvf assignment5jobs.jar -C bin .
chmod 777 assignment5jobs.jar
