package com.Ecomerce.Website.Service;

import com.Ecomerce.Website.model.Order;
import com.Ecomerce.Website.model.OrderItem;
import com.Ecomerce.Website.model.Product;
import com.Ecomerce.Website.model.dto.OrderItemRequest;
import com.Ecomerce.Website.model.dto.OrderItemResponse;
import com.Ecomerce.Website.model.dto.OrderResponse;
import com.Ecomerce.Website.model.dto.orderRequest;
import com.Ecomerce.Website.repo.OrderRepo;
import com.Ecomerce.Website.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private ProductRepo repo;
    @Autowired
    private OrderRepo orderRepo;
    public OrderResponse placeOrder(orderRequest request) {
        Order order;
        order = new Order();
        String orderId="ORD"+UUID.randomUUID().toString().substring(0,13).toUpperCase();
        order.setOrderId(orderId);
        order.setCustomerName(request.CustomerName());
        order.setEmail(request.email());
        order.setStatus("PLACED");
        order.setOrderDate(LocalDate.now());
        List<OrderItem> orderItems=new ArrayList<>();
        //iterating all the items in request.items and doing work on them in this for loop
        for(OrderItemRequest itemRequest:request.items()){
            Product product=repo.findById(itemRequest.productId()).orElseThrow(()->new RuntimeException("Product Not Found"));
            product.setQuantity(product.getQuantity()-itemRequest.quantity());
            repo.save(product);
            BigDecimal totalprice=product.getPrice().multiply(BigDecimal.valueOf(itemRequest.quantity()));
            OrderItem orderItem = new OrderItem(
                    product,
                    itemRequest.quantity(),
                    totalprice,
                    order
                    );
            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);
        Order savesorder=orderRepo.save(order);

        List<OrderItemResponse> itemResponses=new ArrayList<>();
        for(OrderItem item:order.getOrderItems()){
            OrderItemResponse orderItemResponse= new OrderItemResponse(
                    item.getProduct().getName(),
                    item.getQuantity(),
                    item.getTotalPrice()
            );

            itemResponses.add(orderItemResponse);
        }


        OrderResponse response= new OrderResponse(savesorder.getOrderId(), savesorder.getCustomerName(), savesorder.getEmail(),savesorder.getStatus(),savesorder.getOrderDate(),itemResponses);

//        order.setOrderItems(request.items());


        return response;
    }

    public List<OrderResponse> getAllOrdersResponses() {
        List<OrderResponse> responses=new ArrayList<>();
        List<Order> orders=orderRepo.findAll();

        for(Order order:orders){
            List<OrderItemResponse> itemResponses=new ArrayList<>();
            for(OrderItem item:order.getOrderItems()){
                OrderItemResponse orderItemResponse= new OrderItemResponse(
                        item.getProduct().getName(),
                        item.getQuantity(),
                        item.getTotalPrice()
                );

                itemResponses.add(orderItemResponse);
            }

            OrderResponse orderResponse=new OrderResponse(
                    order.getOrderId(),
                    order.getCustomerName(),
                    order.getEmail(),
                    order.getStatus(),
                    order.getOrderDate(),
                    itemResponses

            );

            responses.add(orderResponse);
        }

        return responses;

    }
}
