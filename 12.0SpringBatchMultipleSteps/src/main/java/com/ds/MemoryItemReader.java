package com.ds;

import java.util.List;

import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.item.support.ListItemWriter;

public class MemoryItemReader extends ListItemReader<Product> {

	   public MemoryItemReader(ListItemWriter<Product> writers) {
	      super((List<Product>) writers.getWrittenItems());
	      
	      System.out.println("Waiting....");
	      try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	   }

	}
