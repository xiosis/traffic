package cn.telecom.traffic.model.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ct_traffic")
public class Traffic {

	private int id;
	private String code;
	private String description;
	private boolean actif;

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "code", unique = true, nullable = false, length = 45)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "description", nullable = true, length = 100)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "actif", columnDefinition = "tinyint(1) default 0", nullable = false)
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	
	public boolean isActif() {
		return actif;
	}

}
