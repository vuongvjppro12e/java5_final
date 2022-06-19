package com.example.giaodien.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @CreationTimestamp
    @Column
    private Date CreateDate;

    @Column
    private Type type;

    @Column
    private BigDecimal price;

    @Column
    private Integer sale;

    @Column
    private String rare;
}
