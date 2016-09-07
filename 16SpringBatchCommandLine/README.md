# tbatch
To run from command line:

0. cd 16SpringBatchCommandLine/

1. mvn package

2. java -cp "target/dependency-jars/*:target/16SpringBatchCommandLine-1.0-SNAPSHOT.jar" org.springframework.batch.core.launch.support.CommandLineJobRunner spring/batch/jobs/job-read-files.xml readMultiFileJob

If mvn says: Error: Could not find or load main class org.springframework.batch.core.launch.support.CommandLineJobRunner
	it means you have not set maven environment variables properly
		M2_HOME
		M2
		JAVA_HOME
		
		