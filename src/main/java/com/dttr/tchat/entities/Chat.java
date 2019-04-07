package com.dttr.tchat.entities;
// Generated Jan 28, 2019 12:43:14 PM by Hibernate Tools 5.2.11.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Chat generated by hbm2java
 */

@Entity
@Table(name = "chat")
public class Chat implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer chatid;
	private Boolean isgroup;
	private String name;
	private Date createday;
	private Date lasttime;
	@JsonIgnore
	private Set<Message> messages = new HashSet<Message>(0);
	@JsonIgnore
	private Set<UserHasChat> userHasChats = new HashSet<UserHasChat>(0);

	public Chat() {
		this.createday=new Date();
		this.isgroup=false;
	}
	public Chat(Boolean isgroup, String name, Date createday, Set<Message> messages, Set<UserHasChat> userHasChats) {
		this.isgroup = isgroup;
		this.name = name;
		this.createday = createday;
		this.messages = messages;
		this.userHasChats = userHasChats;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "chatid", unique = true, nullable = false)
	public Integer getChatid() {
		return this.chatid;
	}

	public void setChatid(Integer chatid) {
		this.chatid = chatid;
	}

	@Column(name = "isgroup")
	public Boolean getIsgroup() {
		return this.isgroup;
	}

	public void setIsgroup(Boolean isgroup) {
		this.isgroup = isgroup;
	}

	@Column(name = "name", length = 150)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createday", length = 19)
	public Date getCreateday() {
		return this.createday;
	}

	public void setCreateday(Date createday) {
		this.createday = createday;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lasttime", length = 19)
	public Date getLasttime() {
		return this.lasttime;
	}

	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "chat",orphanRemoval=true)
	public Set<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "chat")
	public Set<UserHasChat> getUserHasChats() {
		return this.userHasChats;
	}

	public void setUserHasChats(Set<UserHasChat> userHasChats) {
		this.userHasChats = userHasChats;
	}

}