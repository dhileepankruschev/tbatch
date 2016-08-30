package com.ds.listeners;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;

public class ProductChunkListener implements ChunkListener {

	@Override
	public void beforeChunk(ChunkContext cc) {
		// TODO Auto-generated method stub
		System.out.println("Before chunk execution.");
	}
	
	@Override
	public void afterChunk(ChunkContext cc) {
		// TODO Auto-generated method stub
		System.out.println("After chunk execution.");
	}

	@Override
	public void afterChunkError(ChunkContext cc) {
		// TODO Auto-generated method stub
		System.out.println("After chunk execution error.");
	}

}
