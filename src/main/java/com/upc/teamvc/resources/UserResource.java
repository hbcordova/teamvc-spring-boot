package com.upc.teamvc.resources;

import lombok.Data;

@Data
public class UserResource {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Long dni;
}
