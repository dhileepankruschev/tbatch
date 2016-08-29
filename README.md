# tbatch
To run from command line:

0. cd SpringBatchExample4/

1. mvn package

2. java -cp "target/dependency-jars/*:target/spring-batch.jar" org.springframework.batch.core.launch.support.CommandLineJobRunner spring/batch/jobs/job-read-files.xml readMultiFileJob