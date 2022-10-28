package com.example.flowershop.api;

import com.example.flowershop.dto.FlowerDTO;
import com.example.flowershop.dto.UserDTO;
import com.example.flowershop.service.IFlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("flower")
public class FlowerAPI {

    @Autowired
    private IFlowerService flowerService;

    @GetMapping
    public ResponseEntity getAll(@RequestParam(name = "page") int page, @RequestParam(name = "limit") int limit){
        List<FlowerDTO> dtoList = flowerService.getAll(page, limit);
        if(dtoList == null || dtoList.isEmpty()) return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        return new ResponseEntity(dtoList, HttpStatus.OK);
    }

    @GetMapping(value = "getAll")
    public ResponseEntity getAll(){
        List<FlowerDTO> dtoList = flowerService.getAll();
        if(dtoList == null || dtoList.isEmpty()) return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        return new ResponseEntity(dtoList, HttpStatus.OK);
    }

    @GetMapping(value = "/count")
    public Long getCount(){
        return flowerService.getCount();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getOneById(@PathVariable int id){
        FlowerDTO dto = flowerService.getOneById(id);
        if(dto == null) return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        else return new ResponseEntity(dto, HttpStatus.OK);
    }

    @GetMapping(value = "/by-name")
    public ResponseEntity getByName(@RequestParam(name = "name") String name){
        List<FlowerDTO> dtoList = flowerService.getByName(name);
        if(dtoList == null || dtoList.isEmpty()) return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        return new ResponseEntity(dtoList, HttpStatus.OK);
    }
}
