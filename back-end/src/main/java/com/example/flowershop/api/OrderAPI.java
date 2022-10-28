package com.example.flowershop.api;

import com.example.flowershop.dto.OrderDTO;
import com.example.flowershop.dto.UserDTO;
import com.example.flowershop.service.IOrderService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "order")
public class OrderAPI {

    @Autowired
    private IOrderService orderService;

    @GetMapping
    public ResponseEntity getAll(@RequestParam(name = "user-id") int id) {
        List<OrderDTO> dtoList = orderService.getAllByUserId(id);
        if (dtoList == null) return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        return new ResponseEntity(dtoList, HttpStatus.OK);
    }

    @GetMapping(value = "/getOrder/{user_id}")
    public ResponseEntity getAllOrder(@PathVariable(name = "user_id") int id){
        List<OrderDTO> dtoList = orderService.getAllOrderByUserIdAndNotStatus(id ,1);
        if(dtoList == null ) return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        return new ResponseEntity(dtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createNewOrder(@RequestBody OrderDTO dto){
        return new ResponseEntity(HttpStatus.OK);
    }
}
