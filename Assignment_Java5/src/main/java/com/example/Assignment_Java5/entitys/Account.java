package com.example.Assignment_Java5.entitys;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="accounts")
//@NamedQueries(
//	@NamedQuery(name="Account.findByUsernameLike",
//		query="SELECT acc FROM Account acc WHERE acc.username LIKE :keyword")
//)
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable = false)
	private Integer id;

	@Column(name="username")
	private String username;

	@Column(name="password")
	private String password;

	@Column(name="fullname")
	private String fullname;

	@Column(name="email")
	private String email;

	@Column(name="activated")
	private int activated;

	@Column(name="admin")
	private int admin;
}
