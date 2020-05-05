package com.xinjingjie.restudy.bean;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", name=" + name + ", age="
				+ age + ", grinder=" + grinder + ", tel=" + tel + ", email=" + email + ", create_time=" + create_time
				+ "]";
	}


private int uid;
  private String username;
  private String password;
  private String name;
  private int age;
  private String grinder;
  private String tel;
  private String email;
  private Date create_time;
  
  public Date getCreate_time() { return this.create_time; }

  
  public void setCreate_time(Date create_time) { this.create_time = create_time; }

  
  public int getuid() { return this.uid; }

  
  public void setuid(int uid) { this.uid = uid; }

  
  public String getUsername() { return this.username; }

  
  public void setUsername(String username) { this.username = username; }

  
  public String getPassword() { return this.password; }

  
  public void setPassword(String password) { this.password = password; }

  
  public String getName() { return this.name; }

  
  public void setName(String name) { this.name = name; }

  
  public int getAge() { return this.age; }

  
  public void setAge(int age) { this.age = age; }

  
  public String getGrinder() { return this.grinder; }

  
  public void setGrinder(String grinder) { this.grinder = grinder; }

  
  public String getTel() { return this.tel; }

  
  public void setTel(String tel) { this.tel = tel; }

  
  public String getEmail() { return this.email; }

  
  public void setEmail(String email) { this.email = email; }

  
  public User(String username, String password, String email, Date create_time) {
    this.username = username;
    this.password = password;
    this.email = email;
    this.create_time = create_time;
  }


  
  public User() {}

  
  public User(int uid, String username, String password, String name, int age, String grinder, String tel, String email, Date create_time) {
    this.uid = uid;
    this.username = username;
    this.password = password;
    this.name = name;
    this.age = age;
    this.grinder = grinder;
    this.tel = tel;
    this.email = email;
    this.create_time = create_time;
  }
}
