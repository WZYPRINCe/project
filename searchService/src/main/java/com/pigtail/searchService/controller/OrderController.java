package com.pigtail.searchService.controller;

import com.pigtail.searchService.dto.OrderRequest;
import com.pigtail.searchService.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tomato/search/order")

@RequiredArgsConstructor
public class OrderController {
    public OrderResponse placeOrder(OrderRequest orderRequest){

    }
}
