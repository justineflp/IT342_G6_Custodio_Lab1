package com.it342.auth.dto;

public class AuthResponse {

    private String token;
    private String type = "Bearer";
    private Long id;
    private String email;
    private String fullName;

    public AuthResponse(String token, Long id, String email, String fullName) {
        this.token = token;
        this.id = id;
        this.email = email;
        this.fullName = fullName;
    }

    public String getToken() { return token; }
    public String getType() { return type; }
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getFullName() { return fullName; }
}
