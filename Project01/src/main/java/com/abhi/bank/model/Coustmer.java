package com.abhi.bank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="coustmer")
public class Coustmer {

	 @Id
	 @GeneratedValue(generator = "native")
	 @GenericGenerator(name = "native", strategy = "native")
	private int coustid;
	private String name;
	private String mobno;
	private String email;
	private String adhar;
	private String pan;
	private String pass;
	private int bal;
	
	public int getCoustid() {
		return coustid;
	}
	public void setCoustid(int coustid) {
		this.coustid = coustid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdhar() {
		return adhar;
	}
	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getBal() {
		return bal;
	}
	public void setBal(int bal) {
		this.bal = bal;
	}
	@Override
	public String toString() {
		return "Coustmer [coustid=" + coustid + ", name=" + name + ", mobno=" + mobno + ", email=" + email + ", adhar="
				+ adhar + ", pan=" + pan + ", pass=" + pass + ", bal=" + bal + "]";
	}
	
	
	
}
