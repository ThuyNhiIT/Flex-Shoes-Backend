package com.flexshose.flexshoesbackend.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDTO {
    private Integer customerId;
    private String customerName;
    private String phoneNumber;
    private String email;
    private LocalDate registerDate;
    private Set<String> address;
}
