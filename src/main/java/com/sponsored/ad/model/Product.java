package com.sponsored.ad.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCT")
@Data
@NoArgsConstructor
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "category", nullable = false)
	private String category;

	@Column(name = "price", nullable = false)
	@NumberFormat(style = NumberFormat.Style.CURRENCY)
	private BigDecimal price;

	@Column(name = "price", nullable = false, unique = true)
	private String serialNumber;
}
