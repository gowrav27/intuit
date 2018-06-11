package com.intuit.cg.backendtechassessment.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@Table(name = "project")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Project {

	@Id
	@GeneratedValue
	private long projectId;
	
	@Column(nullable = false)
	private String projectName;
	
	 @Column()
	 private String description;
	 
	 @Column()
	 private long maxBudget;
	 
	 @Column()
	 private Date lastDate;
	 
	 @ManyToOne
	 @JoinColumn(name = "sellerId")
	 private Seller seller;
	 
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getMaxBudget() {
		return maxBudget;
	}
	public void setMaxBudget(long maxBudget) {
		this.maxBudget = maxBudget;
	}
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}	
}
