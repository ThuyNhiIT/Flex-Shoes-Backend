package com.flexshose.flexshoesbackend.dto;

import java.time.LocalDate;
import java.util.Set;

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
public class CustomerDTO {

    Integer customerId;

    String customerName;

    String phoneNumber;

    String email;

    String gender;

    LocalDate registerDate;

    Set<String> address;

}