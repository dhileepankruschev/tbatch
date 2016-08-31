package com.ds;

import java.util.List;

import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.item.support.ListItemWriter;

public class MemoryItemReader extends ListItemReader<Product> {

	   public MemoryItemReader(ListItemWriter<Product> writer) {
	      super((List<Product>) writer.getWrittenItems());
	      
	      System.out.println("Waiting....");
	      try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	   }

	}
