package com.usersystem.project.resources.exceptions;

import java.io.Serializable;
import java.util.Date;

public class StandardError implements Serializable{

    private static final long serialVersionUID = 1l;
    private Date timestamp;
	private int status;
	private String error;
	private String message;
    private String path;

    public StandardError() {}

    public StandardError(Date timestamp, int status, String error, String message, String path) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Date getTimestamp() {
		return timestamp;
	}

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

	public int getStatus() {
		return this.status;
	}

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
		return this.error;
	}

    public void setError(String error) {
		this.error = error;
	}

    public String getMessage() {
		return message;
	}

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

