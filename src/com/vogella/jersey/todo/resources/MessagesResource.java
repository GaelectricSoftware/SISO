package com.vogella.jersey.todo.resources;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.xml.crypto.dsig.XMLObject;

import com.vogella.jersey.todo.dao.MessageDao;

import com.vogella.jersey.todo.JSON.XML;
import com.vogella.jersey.todo.model.Message;

// Will map the resource to the URL Messages
@Path("/Messages")
public class MessagesResource {

        
        @Context
        UriInfo uriInfo;
        @Context
        Request request;
       
        

       /**
        * Creates a list of all Messages (Messages) as Text XML that can be displayed in a browser
        * 
        * @return Messages (messages)
        */
        @GET
        @Produces(MediaType.TEXT_XML)
        public List<Message> getMessagesBrowser() {
                List<Message> Messages = new ArrayList<Message>();
                Messages.addAll(MessageDao.instance.getModel().values());
                return Messages;
        }
        
        /**
         * Creates a list of all Messages (Messages) as JSON
         *  
         * @return
         */
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public List<Message> getMessagess() {
                List<Message> Messages = new ArrayList<Message>();
                Messages.addAll(MessageDao.instance.getModel().values());
                return Messages;
        }

        /**
         * Creates a list of all Messages (Messages) as Application XML
         *  
         * @return
         */
        @GET
        @Produces(MediaType.APPLICATION_XML)
        public List<Message> getMessages() {
                List<Message> Messages = new ArrayList<Message>();
                Messages.addAll(MessageDao.instance.getModel().values());
                return Messages;
        }

        /**
         * Returns a count of all Messages (Messages) that are in the Hashmap
         *  
         * @return
         */
        @GET
        @Path("count")
        @Produces(MediaType.TEXT_PLAIN)
        public String getCount() {
                int count = MessageDao.instance.getModel().size();
                return String.valueOf(count);
        }

        /**
         * Used to create a new instance of a Message (message) using parameters passed through the URL. 
         * Creates a new Message (message) object using XML. 
         * returns text message
         * 
         * 
         * @throws IOException
         * @throws ClassNotFoundException 
         * @throws SQLException 
         */
        @POST
        @Consumes(MediaType.TEXT_XML + ";charset=ISO-8859-1")
        @Produces(MediaType.TEXT_XML + ";charset=ISO-8859-1")
        public Response newMessage(Message Message) throws IOException, ClassNotFoundException, SQLException 
        {
        	MessageDao.instance.getModel().put("3", Message);
        	System.out.println(Message.getText());
        	String result = "Message saved : " + Message;
        	return Response.status(201).entity(Message).build();
        }


        /**
         * Will display only the Message (message) with the set message id
         * @param moMessageid
         * @return
         */
        @Path("{Message}")
        public MessageResource getMessage(@PathParam("Message") String moMessageid) {
                return new MessageResource(uriInfo, request, moMessageid);
        }

}