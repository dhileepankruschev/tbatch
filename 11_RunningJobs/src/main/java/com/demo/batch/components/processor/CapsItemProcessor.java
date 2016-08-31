package com.demo.batch.components.processor;

import com.demo.batch.entity.Person;

import javax.batch.api.chunk.ItemProcessor;

public class CapsItemProcessor implements ItemProcessor {

    @Override
    public Object processItem(Object item) throws Exception {
        return new PersonItemProcessor().process((Person) item);
    }
}
