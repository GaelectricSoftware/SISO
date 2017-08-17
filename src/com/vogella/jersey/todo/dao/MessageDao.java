package com.vogella.jersey.todo.dao;

import java.util.HashMap;
import java.util.Map;

import com.vogella.jersey.todo.model.Message;

public enum MessageDao 
{
	instance;
	
	private Map<String, Message> contentProvider =new HashMap<>();
	
	private MessageDao()
	{
		Message Message = new Message();
        Message.setApiId("12345");
        Message.setMoMessageid("1");
        contentProvider.put("1", Message);
        Message Message2 = new Message();
        Message2.setApiId("12345");
        Message2.setMoMessageid("2");
        contentProvider.put("2", Message2);
	}
	public Map<String, Message> getModel()
	{
		return contentProvider;
	}
}
