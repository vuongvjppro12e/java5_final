package com.example.Assignment_Java5.entitys;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Skin")
@Data
@Component
public class Skin {
	@Id
	@Column(name="id",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="image")
	private String image;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="buff")
	private int buff;

	@Column(name="rare")
	private String rare;

	@ManyToOne
	@JoinColumn(name="type")
	private type type;
}
