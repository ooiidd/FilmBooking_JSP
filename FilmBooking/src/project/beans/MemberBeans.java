package project.beans;

import java.sql.Date;

public class MemberBeans {
	private String id_mem;
	private String password;
	private String name_mem;
	private int age_mem;
	private Date register_date;
	public String getId_mem() {
		return id_mem;
	}
	public void setId_mem(String id_mem) {
		this.id_mem = id_mem;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName_mem() {
		return name_mem;
	}
	public void setName_mem(String name_mem) {
		this.name_mem = name_mem;
	}
	public int getAge_mem() {
		return age_mem;
	}
	public void setAge_mem(int age_mem) {
		this.age_mem = age_mem;
	}
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}
	
	
}
