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
public class RedBus_seat_layoutRoot {

	public RedBus_seat_layout root;

	public RedBus_seat_layout getRoot() {
		return root;
	}

	public void setRoot(RedBus_seat_layout root) {
		this.root = root;
	}
	
}