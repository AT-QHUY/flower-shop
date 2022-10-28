package com.example.flowershop.api;

import com.example.flowershop.dto.OrderDTO;
import com.example.flowershop.dto.OrderDetailDTO;
import com.example.flowershop.service.IOrderDetailService;
import com.example.flowershop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "cart")
public class CartAPI {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private IOrderDetailService orderDetailService;

    @GetMapping(value = "/{id}")
    public ResponseEntity getCart(@PathVariable(name = "id") int id){
        List<OrderDTO> dtoList = orderService.getByStatusAndUserId(1, id);
        if(dtoList == null) return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        return new ResponseEntity(dtoList, HttpStatus.OK);
    }

    @PutMapping(value = "/add")
    public ResponseEntity addToCart(@RequestBody OrderDetailDTO dto){
        int result = orderService.addToCart(dto.getUser_id(), dto.getFlower_id(), dto.getQuantity());
//        int result = orderDetailService.addToCart(dto.getUser_id(), dto.getFlower_id(), dto.getQuantity());
        if(result == 0) return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity updateCart(@RequestBody OrderDetailDTO dto){
        int result = orderDetailService.updateCart(dto.getId(), dto.getQuantity());
        if(result == 0) return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(value = "/confirm/{id}")
    public ResponseEntity confirmOrder(@PathVariable(name = "id") int id){
        int result = orderService.confirmOrder(id);
        if(result == 0) return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteCartItem(@PathVariable(name = "id") int itemId){
         orderDetailService.deleteCartItem(itemId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
