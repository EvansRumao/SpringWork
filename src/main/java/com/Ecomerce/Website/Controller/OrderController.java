package com.Ecomerce.Website.Controller;

import com.Ecomerce.Website.Service.OrderService;
import com.Ecomerce.Website.model.dto.OrderItemRequest;
import com.Ecomerce.Website.model.dto.OrderResponse;
import com.Ecomerce.Website.model.dto.orderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class OrderController {

    @Autowired
   private OrderService service;
    @PostMapping("/orders/place")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody orderRequest request){
        OrderResponse response=service.placeOrder(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponse>> getAllOrders(){
        List<OrderResponse> responses=service.getAllOrdersResponses();
        return new ResponseEntity<>(responses,HttpStatus.OK);
    }
}
