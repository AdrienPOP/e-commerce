package com.ap_commerce.engine.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int user_id;
}
