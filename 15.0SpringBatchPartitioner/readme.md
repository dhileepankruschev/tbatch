Use com.ds.data.InsertData class to insert data into table
----------------------------------------------------------

In Spring Batch, “Partitioning” is “multiple threads to process a range of data each”. For example, assume you have 100 records in a table, which has “primary id” assigned from 1 to 100, and you want to process the entire 100 records.

Normally, the process starts from 1 to 100, a single thread example. The process is estimated to take 10 minutes to finish.

	Single Thread - Process from 1 to 100
	
	
In “Partitioning”, we can start 10 threads to process 10 records each (based on the range of ‘id’). Now, the process may take only 1 minute to finish.

	Thread 1 - Process from 1 to 10
	Thread 2 - Process from 11 to 20
	Thread 3 - Process from 21 to 30
	.
	.
	.
	.
	Thread 9 - Process from 81 to 90
	Thread 10 - Process from 91 to 100
	
	
To implement “Partitioning” technique, you must understand the structure of the input data to process, so that you can plan the “range of data” properly.