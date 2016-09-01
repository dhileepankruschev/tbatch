package com.ds;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.Resource;

public class DecompressTasklet implements Tasklet {
	private Resource inputResource;
	private String targetDirectory;
	private String targetFile;

	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		ZipInputStream zis = new ZipInputStream(new BufferedInputStream(inputResource.getInputStream()));
		System.out.println("File set to be decompressed "+inputResource.getFile().getAbsolutePath());
		Thread.sleep(2000);
		
		File targetDirectoryAsFile = new File(inputResource.getFile().getParentFile().getParentFile(), targetDirectory);
		if (!targetDirectoryAsFile.exists()) {
			FileUtils.forceMkdir(targetDirectoryAsFile);
		}
		
		File target = new File(targetDirectoryAsFile, targetFile);
		if (!target.exists()) {
			target.createNewFile();
		} 
		
		
		BufferedOutputStream dest = null;
		while (zis.getNextEntry() != null) {
			FileOutputStream fos = new FileOutputStream(target);
			dest = new BufferedOutputStream(fos);
			IOUtils.copy(zis, dest);
			dest.flush();
			dest.close();
		}
		zis.close();
		
		System.out.println("Wrtten decompressed data in : " + target.getAbsolutePath());
		Thread.sleep(2000);

		return RepeatStatus.FINISHED;
	}

	public Resource getInputResource() {
		return inputResource;
	}

	public void setInputResource(Resource inputResource) {
		this.inputResource = inputResource;
	}

	public String getTargetDirectory() {
		return targetDirectory;
	}

	public void setTargetDirectory(String targetDirectory) {
		this.targetDirectory = targetDirectory;
	}

	public String getTargetFile() {
		return targetFile;
	}

	public void setTargetFile(String targetFile) {
		this.targetFile = targetFile;
	}

}