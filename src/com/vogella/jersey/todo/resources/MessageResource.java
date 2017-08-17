package com.vogella.jersey.todo.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import com.vogella.jersey.todo.JSON.*;

import com.vogella.jersey.todo.model.Message;

import com.vogella.jersey.todo.dao.MessageDao;

public class MessageResource 
{
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String id;
	public MessageResource(UriInfo uriInfo, Request request, String id)
	{
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
	}
	
	
	/**
	 * Used to get a single Message as Application XML
	 * Searches the messages (MessageDao) Hashmap to obtain the message with the requested id. 
	 * if it cannot find the hashmap member then it throws a Runtime Exception and a message saying that the requested message does not exist.
	 * 
	 * 
	 * @return message (Message)
	 */
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage()
	{
		Message Message = MessageDao.instance.getModel().get(id);
		if(Message==null)
			throw new RuntimeException("Get: Message with " + id + " not found");
		
		return Message;
	}
	
	/**
	 * Used to get a single Message as Application JSON
	 * Searches the messages (MessageDao) Hashmap to obtain the message with the requested id. 
	 * if it cannot find the message then it throws a Runtime Exception and a message saying that the requested message does not exist.
	 * 
	 * 
	 * @return message (Message)
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessageo()
	{
		Message Message = MessageDao.instance.getModel().get(id);
		if(Message==null)
			throw new RuntimeException("Get: Message with " + id + " not found");
		
		return Message;
	}
	
	/**
	 * Used to get a single Message as Text XML
	 * Searches the messages (MessageDao) Hashmap to obtain the message with the requested id and display it in a format that is readable by the user 
	 * if it cannot find the message then it throws a Runtime Exception and a message saying that the requested message does not exist.
	 * 
	 * 
	 * @return message (Message)
	 */
	@GET
	@Produces(MediaType.TEXT_XML)
	public Message getMessageHTML()
	{
		Message Message = MessageDao.instance.getModel().get(id);
		if(Message==null)
			throw new RuntimeException("Get: Message with " + id + " not found");
		
		return Message;
	}
	/**
	 * Used to update an already existing message. 
	 * Consumes an XML object that replaces an existing message
	 * Uses the putAndGetResponse method to check if the resource has been updated or not. 
	 * @param Message
	 * @return Response
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putMessage(JAXBElement<Message> Message)
	{
		Message c = Message.getValue();
		return putAndGetResponse(c);
	}
	
	/**
	 * Deletes the message with the stated id 
	 * if it does not exist, it throws a runTime exception.
	 */
	@DELETE
	public void deleteMessage()
	{
		Message c = MessageDao.instance.getModel().remove(id);
		if(c==null)
			throw new RuntimeException("Delete: Message with " + id + " not found");
	}
	
	/** 
	 * This method is used to check that a resource has been created and then returns a response. 
	 * Used to send a response when the put method is used
	 * @param Message (Message)
	 * @return Response
	 */
	private Response putAndGetResponse(Message Message)
	{
		Response res;
		if(MessageDao.instance.getModel().containsKey(Message.getMoMessageid()))
		{
			res = Response.noContent().build();
		}
		else
		{
			res = Response.created(uriInfo.getAbsolutePath()).build();
		}
		MessageDao.instance.getModel().put(Message.getMoMessageid(), Message);
		return res;
	}
	
	
	
}
