package com.Project.SpringSecurity.Controller;

import com.Project.SpringSecurity.Dto.UserRegisterDto;
import com.Project.SpringSecurity.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegisterUserController {

    private UserService userService;

    public RegisterUserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("usuario")
    public UserRegisterDto returnNewUserRegisterDTO(){
        return new UserRegisterDto();
    }

    @GetMapping
    public String showFormRegister(){
        return "registro";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("usuario") UserRegisterDto registerDto){
        userService.save(registerDto);
        return "redirect:/registro?exito";
    }
}
