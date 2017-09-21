package org.jxnd.tongxuelu.entity;

public class Administrator {
    private Integer id;

    private String name;

    private String pwd;

    private String tele;

    private String email;

    private Integer rolesid;
    
    private Roles rinfo;

    public Roles getRinfo() {
		return rinfo;
	}

	public void setRinfo(Roles rinfo) {
		this.rinfo = rinfo;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele == null ? null : tele.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getRolesid() {
        return rolesid;
    }

    public void setRolesid(Integer rolesid) {
        this.rolesid = rolesid;
    }

	
	@Override
	public String toString() {
		return "Administrator [id=" + id + ", name=" + name + ", pwd=" + pwd
				+ ", tele=" + tele + ", email=" + email + ", rolesid="
				+ rolesid + ", rinfo=" + rinfo + "]";
	}
    
    
}