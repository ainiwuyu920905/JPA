package cn.edu.bean;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity @Table(name="person")
public class Person {
	private Integer id;
	private String name;
	private Date brithday = new Date();
	private Gerder gerder = Gerder.MAN;
	private String info;
	private String imagepath;
	private byte[] file;
	@Column(name="personName",nullable=false,length=10)
	public String getName() {
		return name;
	}
	@Lob      //大文本数据
	public String getInfo() {
		return info;
	}
	@Transient   //不在数据库中映射
	public String getImagepath() {
		return imagepath;
	}
	@Id @GeneratedValue(strategy=GenerationType.AUTO)  //根据persistence.xml中配置的数据库方言来决定(默认)
	public Integer getId() {
		return id;
	}
	@Lob @Basic(fetch=FetchType.LAZY)   //实现延时加载
	public byte[] getFile() {
		return file;
	}
	@Temporal(TemporalType.DATE) @Column(nullable=false)		//日期的 类型  data  time  timestamp
	public Date getBrithday() {
		return brithday;
	}
	@Enumerated(EnumType.STRING)		//Enume 在数据库中的表现显示
	@Column(length=5,nullable=false)
	public Gerder getGerder() {
		return gerder;
	}
	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public void setGerder(Gerder gerder) {
		this.gerder = gerder;
	}
	public Person() {}
	public Person(String name) {
		this.name = name;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
