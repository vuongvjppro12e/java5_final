package com.example.Assignment_Java5.entitys;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="type")
@Data
public class type {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable = false)
	private Integer id;
	
	@Column(name="name")
	private String name;
}
