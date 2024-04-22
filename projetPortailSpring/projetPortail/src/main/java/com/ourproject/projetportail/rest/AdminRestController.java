package com.ourproject.projetportail.rest;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminRestController {
    @PostMapping("/admin/checkemail")
    public String verifierDoublonEmail(@Param("email") String email){
        String answer = "doublon";
        if (email.equals("root@control.com")){
            answer="OK";
        }
        return answer;

    }


}
