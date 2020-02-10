/**
 * 
 */
package com.iStudy.springboot.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@Table(name="m_user")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    /**
     * 姓名
     */
    @Column(name = "name")
	private String name;
    
    /**
     * 密码
     */
    @Column(name = "pwd")
	private String pwd;
    
    /**
     * 性别
     */
    @Column(name = "sex")
    private String sex;
    
    /**
     * 年龄
     */
    @Column(name = "age")
    private Integer age;

	@Transient
    private Set<Role> roles;  

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}  
    
}
