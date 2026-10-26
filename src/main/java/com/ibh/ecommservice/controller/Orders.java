package com.ibh.ecommservice.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/orders")
public class Orders {

    @GetMapping(value = "{orderId:[0-9]*}"
    ,produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Long> getOrders(@PathVariable long orderId){
        return ResponseEntity.ok(orderId);
    }

    @GetMapping(value = {
            "/customer/{customerId:[0-9]+}"
            ,"/customer/{customerId:[0-9]+}/{customerName:[0-9a-zA-Z]+}/order/{orderId:[0-9]+}"}
    ,produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Map<String,Object>>> getCustomerAllOrders(@PathVariable long customerId, @PathVariable(required = false) Long orderId
            , @PathVariable(required = false) String customerName
    ){
        System.out.println("customerId ::  " +  customerId + " OrderId " + orderId + " customerName : " + customerName);
        int i = 0;
        List<Map<String,Object>> res = new ArrayList<>();
        for(i = 0;i<10;i++){
            Map<String,Object> data = new HashMap<>();
            //if(i == 0) data.put(null,"irfan");
            data.put("cName" , "Irfan" + i);
            data.put("cProduct" , "Laptop" + i);
            res.add(data);
        }
        return ResponseEntity.ok(res);
    }
}
