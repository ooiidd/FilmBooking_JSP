package project.beans;

import java.sql.Date;

public class MovieReservationBeans {
	private int id_resv;
	private String id_mem;
	private int id_film;
	private String film_name;
	private Date date;
	private Date enddate;
	private Date resv_date;
	private int num;
	private String status;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public int getId_resv() {
		return id_resv;
	}
	public void setId_resv(int id_resv) {
		this.id_resv = id_resv;
	}
	public String getId_mem() {
		return id_mem;
	}
	public void setId_mem(String id_mem) {
		this.id_mem = id_mem;
	}
	public int getId_film() {
		return id_film;
	}
	public void setId_film(int id_film) {
		this.id_film = id_film;
	}
	public String getFilm_name() {
		return film_name;
	}
	public void setFilm_name(String film_name) {
		this.film_name = film_name;
	}
	public Date getResv_date() {
		return resv_date;
	}
	public void setResv_date(Date resv_date) {
		this.resv_date = resv_date;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
