package com.flexshose.flexshoesbackend.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InvoiceDto {
	     Integer invoiceId;
	     LocalDate issueDate;
	     String receiverNumber;
	     String receiverName;
	     String receiverAddress;
	     String paymentMethod;
	     String deliveryMethod;
	     String orderStatus;
	     double total;
	     Integer customerId;
	     List<InvoiceDetailDto> invoiceDetails;

}
