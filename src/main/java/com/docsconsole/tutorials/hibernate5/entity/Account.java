package com.docsconsole.tutorials.hibernate5.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue
	@Column(name = "ACCOUNT_ID")
	private Long id;

	@Column(name = "ACCOUNT_AMOUNT")
	private Double amount;

	@Column(name = "ACCOUNT_TYPE")
	private String type;

	@Column(name = "ACCOUNT_STATUS")
	private String status;


}