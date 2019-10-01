package com.websecure.zzzRefer;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author DELL
 *
 */
//@Entity
public class RedBus_seat_layout {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String code;
	
	private String desc;
	
	private List<RedBus_seat_Item> item;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<RedBus_seat_Item> getItem() {
		return item;
	}

	public void setItem(List<RedBus_seat_Item> item) {
		this.item = item;
	}	
	
}