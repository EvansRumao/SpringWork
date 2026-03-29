package com.Ecomerce.Website.model.dto;

import java.util.List;

public record orderRequest(
        String CustomerName,
        String email,
        List<OrderItemRequest> items
) {}
