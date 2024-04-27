package com.example.springjwt;

import lombok.Data;
//first use of a DTO 
@Data
public class RegisterDTO {
    public String username;
    public String password;
}
