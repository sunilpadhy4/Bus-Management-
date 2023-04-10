package com.buscrud.security;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "User")
@Entity
public class User {

    @Id
    private Long id;
    private String username;
    private String password;
    private String role;
	
	
}
