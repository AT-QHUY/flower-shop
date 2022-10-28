package com.example.flowershop.api;

import com.example.flowershop.dto.UserDTO;
import com.example.flowershop.service.IUserService;
import com.example.flowershop.service.impl.MyUserDetailsService;
import com.example.flowershop.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserAPI {

    @Autowired
    private IUserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JWTUtil jwtUtil;
    @GetMapping
    public ResponseEntity getAll(){
        List<UserDTO> dtoList = userService.getAll();
        return new ResponseEntity(dtoList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getOneById(@PathVariable int id){
        UserDTO dto = userService.getOneById(id);
        if(dto == null) return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO dto) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(),dto.getPassword()));
        }catch (BadCredentialsException ex){
            throw new Exception("Incorrect username or password", ex);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        UserDTO tmpDTO = userService.findOneByName(dto.getUsername());
        return ResponseEntity.ok(new UserDTO(jwt, tmpDTO.getId()));
    }

    @PutMapping(value = "/insert")
    public ResponseEntity<UserDTO> createNew(@RequestBody UserDTO dto){
        dto = userService.save(dto);
        if(dto == null) return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        return new ResponseEntity<UserDTO>(dto, HttpStatus.OK);

    }



}
