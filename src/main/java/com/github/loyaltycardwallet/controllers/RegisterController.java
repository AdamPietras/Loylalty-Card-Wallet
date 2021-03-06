package com.github.loyaltycardwallet.controllers;

import com.github.loyaltycardwallet.dto.ManagerRegisterAndEditDTO;
import com.github.loyaltycardwallet.dto.NormalUserRegisterAndEditDTO;
import com.github.loyaltycardwallet.models.User;
import com.github.loyaltycardwallet.services.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@AllArgsConstructor
@RestController
@RequestMapping("/api/register")
public class RegisterController {

    private RegisterService registerService;

    @PostMapping(
            value = "/user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> userRegister(@RequestBody @Valid NormalUserRegisterAndEditDTO normalUserRegisterAndEditDTO) {
        User createdUser = registerService.normalUserRegister(normalUserRegisterAndEditDTO);
        return ResponseEntity.created(URI.create("/" + createdUser.getId())).body(createdUser);
    }

    @PostMapping(
            value = "/manager",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> managerRegister(@RequestBody @Valid ManagerRegisterAndEditDTO managerRegisterAndEditDTO) {
        User createdUser = registerService.managerRegister(managerRegisterAndEditDTO);
        return ResponseEntity.created(URI.create("/" + createdUser.getId())).body(createdUser);
    }

}
