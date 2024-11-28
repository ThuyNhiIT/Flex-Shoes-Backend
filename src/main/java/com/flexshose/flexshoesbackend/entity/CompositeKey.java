package com.flexshose.flexshoesbackend.entity;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompositeKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Invoice invoice;
	Product product;
}
