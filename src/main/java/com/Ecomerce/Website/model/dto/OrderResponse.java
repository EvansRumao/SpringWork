package com.Ecomerce.Website.model.dto;

import java.time.LocalDate;
import java.util.List;

public record OrderResponse(
       String oderId,
       String customerName,
       String email,
       String status,
       LocalDate orderDate,
       List<OrderItemResponse> items
) {
}
