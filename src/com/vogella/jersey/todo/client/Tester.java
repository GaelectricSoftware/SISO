package com.vogella.jersey.todo.client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.apache.el.util.MessageFactory;
import org.glassfish.jersey.client.ClientConfig;

import com.vogella.jersey.todo.JSON.XML;
import com.vogella.jersey.todo.model.Message;
import com.vogella.jersey.todo.processing.MessagesDatabase;

import com.vogella.jersey.todo.dao.MessageDao;
import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.runtime.JSONFunctions;

public class Tester {
  public static void main(String[] args) {


          ClientConfig config = new ClientConfig();
          Client client = ClientBuilder.newClient(config);
          WebTarget service = client.target(getBaseURI());
          

          // create one Message
          Message Message = new Message();
          Message.setMoMessageid("3");
          Message.toPrint();
          Response response = service.path("rest").path("Messages").path(Message.getMoMessageid()).request(MediaType.APPLICATION_XML).put(Entity.entity(Message,MediaType.APPLICATION_XML),Response.class);
          
          Message MessageTest = new Message();
          MessageTest = MessageDao.instance.getModel().get("1");
          Message Message2 = new Message();
          Message2.setMoMessageid("6");
          service.path("rest").path("Messages").path(Message2.getMoMessageid()).request(MediaType.APPLICATION_XML).put(Entity.entity(Message2,MediaType.APPLICATION_XML),Response.class);
          // Return code should be 201 == created resource
          System.out.println(response.getStatus());

          // Get the Messages
          System.out.println(service.path("rest").path("Messages").request().accept(MediaType.TEXT_XML).get(String.class));
          System.out.println(XML.toJSONObject(service.path("rest").path("Messages").request().accept(MediaType.TEXT_XML).get(String.class)));

//          // Get JSON for application
          

          // Get XML for application
          System.out.println(service.path("rest").path("Messages").request().accept(MediaType.APPLICATION_XML).get(String.class));

          //Get Message with id 1
          Response checkDelete = service.path("rest").path("Messages/2").request().accept(MediaType.APPLICATION_XML).get();

          //Delete Message with id 1
          service.path("rest").path("Messages/1").request().delete();

          //Get get all Messages id 1 should be deleted
          System.out.println(service.path("rest").path("Messages").request().accept(MediaType.APPLICATION_XML).get(String.class));

          //Create a Message
          Form form =new Form();
          form.param("apiId", "4");
          form.param("to", "Clickatell's number");
          form.param("charset", "UTH-8");
          form.param("udh", "udh");
          form.param("from", "02877764212");
          form.param("moMessageID", "4");
          form.param("timestamp", "12:00");
          form.param("text", "Sample message");
          
          response = service.path("rest").path("Messages").request().post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED),Response.class);
          System.out.println("Form response " + response.getStatus());

          //Get all the Messages, id 4 should have been created
          System.out.println(service.path("rest").path("Messages").request().accept(MediaType.APPLICATION_XML).get(String.class));
          
        
          
        

  }

  private static URI getBaseURI() {
    return UriBuilder.fromUri("http://54.229.40.23:8080/com.vogella.jersey.Message/").build();
  }
}
