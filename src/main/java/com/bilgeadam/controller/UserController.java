package com.bilgeadam.controller;

import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.repository.entity.User;
import com.bilgeadam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

//   @Autowired
    private final UserService userService;


    /*
        create user metodu dısardan name surname email password phone
        alsın daha sonra bunlarla bir user olusturup database e kayıt yapalım
        bu işlem için bir end point ve service sınıfında gerkli metotları yazalım
     */


    //http://localhost:8090/user/save?name=Mustafa&surname=%C3%96zt%C3%BCrk&email=musty@gmail.com&phone=123456&password=123
    @GetMapping("/save")
    public ResponseEntity<?> createUser(String name, String surname, String email, String password, String phone ){
    User user= User.builder().name(name).surName(surname).phone(phone).password(password).email(email).build();
    try {
        userService.createUser(user);
        return ResponseEntity.ok(user);
    }catch (Exception e){
        return ResponseEntity.badRequest().body("Kullanıcı olusturulamadı");
    }
    }

    @GetMapping("/register")
    public ResponseEntity<User> register(RegisterRequestDto dto){
        return ResponseEntity.ok(userService.register(dto));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register2(@RequestBody RegisterRequestDto dto){
        return ResponseEntity.ok(userService.register(dto));
    }



}
