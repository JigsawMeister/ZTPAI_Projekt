
package com.ztpai.library.controller;

import com.ztpai.library.dto.AuthResponse;
import com.ztpai.library.dto.LoginRequest;
import com.ztpai.library.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody LoginRequest request){

        String token = authService.register(request);

        return new AuthResponse(token);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request){

        String token = authService.login(request);

        return new AuthResponse(token);
    }
}
