package org.jxnd.tongxuelu.entity;

import java.util.Date;

public class History {
    private Integer id;

    private Integer aid;

    private String aname;

    private String operation;

    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname == null ? null : aname.trim();
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

	public History(Integer aid, String aname, String operation, Date date) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.operation = operation;
		this.date = date;
	}
	
	public History() {
	
	}
    
    
    
    
    
    
}