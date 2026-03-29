package com.Ecomerce.Website.model.dto;

public record OrderItemRequest (
        int productId,
        int quantity
) {}
