package com.springboot.hibernate;
// Generated 21 May, 2020 12:44:37 PM by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Country generated by hbm2java
 */
@Entity
@Table(name = "country", catalog = "springbootdemo")
public class Country implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cid;
	private String countryname;
	private Set<Employee> employees = new HashSet<>();

	public Country() {
	}

	public Country(String countryname) {
		this.countryname = countryname;
	}

	public Country(String countryname, Set<Employee> employees) {
		this.countryname = countryname;
		this.employees = employees;
	}

	public Country(int cid2, String countryname2) 
	{
		this.countryname = countryname2;
		this.cid=cid2;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cid", unique = true, nullable = false)
	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Column(name = "countryname", nullable = false, length = 45)
	public String getCountryname() {
		return this.countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Country [cid=" + cid + ", countryname=" + countryname +"]";
	}

}
