package com.App.Yogesh.Controller;

import com.App.Yogesh.Models.User;
import com.App.Yogesh.Repository.UserRepository;
import com.App.Yogesh.Response.AuthResponse;
import com.App.Yogesh.Services.CustomUserDetailService;
import com.App.Yogesh.Services.UserService;
import com.App.Yogesh.config.JwtProvider;
import com.App.Yogesh.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
  private   UserService userService;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * Creates a new user or updates an existing user.
     */
    @PostMapping("/signup")
    public AuthResponse createUser(@RequestBody User user) throws Exception {

       User isExist = userRepository.findByEmail(user.getEmail());
       if(isExist!=null)
        {
            throw new Exception("this email is used with another account");
        }

        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));


        User savedUser = userRepository.save(newUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(),savedUser.getPassword());
        String token = JwtProvider.generateToken(authentication);
         AuthResponse res = new AuthResponse("Register Success",token);
        return res;
    }

    @PostMapping("signin")
    public AuthResponse signin(@RequestBody LoginRequest loginRequest)
    {
        Authentication authentication=
                authenticate(loginRequest.getEmail(),loginRequest.getPassword());
        String token = JwtProvider.generateToken(authentication);
        AuthResponse res = new AuthResponse("Login Success",token);
        return res;
    }

    private Authentication authenticate(String email, String password) {

        UserDetails userDetails = customUserDetailService.loadUserByUsername(email);

        if(userDetails==null)
        {
            throw new BadCredentialsException("Invalid User");

        }
        if(!passwordEncoder.matches(password,userDetails.getPassword()))
        {
            throw new BadCredentialsException("Password not matched");
        }
        return  new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
    }

}
