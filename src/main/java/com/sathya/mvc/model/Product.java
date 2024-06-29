package com.sathya.mvc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	@NotBlank(message = "Product Name is required")
	String name;

	@NotBlank(message = "Product Brand is required")
	String brand;

	@NotBlank(message = "Product MadeIn is required")
	String madeIn;

	@NotNull(message = "Product price is required")
	@Min(value = 0, message = "Product price must be greater than or equal to 0")
	Double price;
}
