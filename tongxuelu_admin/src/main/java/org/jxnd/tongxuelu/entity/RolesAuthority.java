package org.jxnd.tongxuelu.entity;

public class RolesAuthority {
    private Integer id;

    private Integer rid;

    private Integer aid;
    


    public RolesAuthority(Integer id, Integer rid, Integer aid) {
		super();
		this.id = id;
		this.rid = rid;
		this.aid = aid;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }
}