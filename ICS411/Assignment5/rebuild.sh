hadoop fs -rm -R /user/fisher/Assign5/output
rm Assign5.jar
jar -cvf Assign5.jar -C bin .
chmod 777 Assign5.jar
