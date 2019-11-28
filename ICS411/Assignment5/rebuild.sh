hadoop fs -rm -R /user/fisher/Assign5/output*
hadoop fs -rm -R /user/fisher/Assign5/job/lib/assignment5jobs.jar
rm assignment5jobs.jar
jar -cvf assignment5jobs.jar -C bin .
chmod 777 assignment5jobs.jar
hadoop fs -copyFromLocal /home/cloudera/workspace/Assignment5/assignment5jobs.jar /user/fisher/Assign5/job/lib/assignment5jobs.jar
