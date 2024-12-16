package org.personalprojects.springsecurity.controller;

import jakarta.validation.Valid;
import org.personalprojects.springsecurity.controller.dto.SignupRequest;
import org.personalprojects.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("locker/auth")
public class LockerController {

  @Autowired
  UserService userService;

  @PostMapping("signup")
  public ResponseEntity<Void> signup(@Valid @RequestBody SignupRequest requestDto){
    userService.signup(requestDto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

}
