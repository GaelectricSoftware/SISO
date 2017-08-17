package com.vogella.jersey.todo.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement (name = "clickmo")
public class Message 
{
	private String api_id;
	private String moMsgId;
	private String from;
	private String to;
	private String timestamp;
	private String text;
	private String charset;
	private String udh;
	
	public Message()
	{
		this.api_id = " ";
		this.moMsgId = " ";
		this.from = " ";
		this.to = " ";
		this.timestamp = " ";
		this.text = " ";
		this.charset = " ";
		this.udh = " ";
	
	}
	
	@XmlElement (name = "api_id")
	public String getApiId() 
	{
		return api_id;
	}

	public void setApiId(String api_id) 
	{
		this.api_id = api_id;
	}
	
	@XmlElement (name = "moMsgId")
	public String getMoMessageid() 
	{
		return moMsgId;
	}
	
	public void setMoMessageid(String moMessageid) 
	{
		this.moMsgId = moMessageid;
	}
	
	@XmlElement (name = "from")
	public String getFrom() 
	{
		return from;
	}

	public void setFrom(String from) 
	{
		this.from = from;
	}

	@XmlElement (name = "to")
	public String getTo() 
	{
		return to;
	}

	public void setTo(String to) 
	{
		this.to = to;
	}

	@XmlElement (name = "timestamp")
	public String getTimestamp() 
	{
		return timestamp;
	}

	public void setTimestamp(String timestamp) 
	{
		this.timestamp = timestamp;
	}

	@XmlElement (name = "text")
	public String getText() 
	{
		return text;
	}

	public void setText(String text) 
	{
		this.text = text;
	}

	@XmlElement (name = "charset")
	public String getCharset() 
	{
		return charset;
	}

	public void setCharset(String charset) 
	{
		this.charset = charset;
	}

	@XmlElement (name = "udh")
	public String getUdh() 
	{
		return udh;
	}

	public void setUdh(String udh) 
	{
		this.udh = udh;
	}
	
	public void toPrint()
	{
		System.out.print(this.api_id + " " + this.moMsgId + " " + this.to + " " + this.from + " " + this.timestamp + " " + this.charset + " " + this.udh + " " + this.text);
	}
}
