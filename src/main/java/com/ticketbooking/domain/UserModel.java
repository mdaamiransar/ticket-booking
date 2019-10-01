package com.ticketbooking.domain;

import java.io.Serializable;

public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String fullName;

	private String role;

	private Cart cart;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", fullName=" + fullName + ", role=" + role + ", cart=" + cart + "]";
	}

}