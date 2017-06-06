package ru.babin.web.model;

import java.util.Date;

import lombok.Data;


public @Data class Job {

	private long id;

	private long jobId;

	private String user;

	private String device;

	private int amount;

	private Date created;

}
