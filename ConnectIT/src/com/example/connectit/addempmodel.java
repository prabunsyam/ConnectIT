package com.example.connectit;

public class addempmodel {
	int id ;
	String name,age,addr,dob ,phone ,mail ,dsig ,joindate ,salarry ,exper ,qlif ,depart ,gender;
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public addempmodel(String s1, String s2, String s3, String s4, String s5,
			String s6, String s7, String s8, String s9, String s10, String s11,
			String s12, String s13) {
		// TODO Auto-generated constructor stub
		this.name=s1;
		this.age=s2;
		this.addr=s3;
		this.dob=s4;
		this.phone=s5;
		
		this.mail=s6;
		this.dsig=s7;	
		this.joindate=s8;
		this.salarry=s9;
		this.exper=s10;
		
		this.qlif=s11;
		this.depart=s12;
		this.gender=s13;
				
	}
	
	public addempmodel() {
		// TODO Auto-generated constructor stub
	}
public addempmodel(int parseInt, String string1, String string2,
			String string3, String string4, String string5, String string6,
			String string7, String string8, String string9, String string10,
			String string11, String string12, String string13) {
		// TODO Auto-generated constructor stub
		this.id=parseInt;
		this.name=string1;
		this.age=string2;
		this.addr=string3;
		this.dob=string4;
		this.phone=string5;
		
		this.mail=string6;
		this.dsig=string7;	
		this.joindate=string8;
		this.salarry=string9;
		this.exper=string10;
		
		this.qlif=string11;
		this.depart=string12;
		this.gender=string13
				;
		
		
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getDsig() {
		return dsig;
	}
	public void setDsig(String dsig) {
		this.dsig = dsig;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getSalarry() {
		return salarry;
	}
	public void setSalarry(String salarry) {
		this.salarry = salarry;
	}
	public String getExper() {
		return exper;
	}
	public void setExper(String exper) {
		this.exper = exper;
	}
	public String getQlif() {
		return qlif;
	}
	public void setQlif(String qlif) {
		this.qlif = qlif;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
