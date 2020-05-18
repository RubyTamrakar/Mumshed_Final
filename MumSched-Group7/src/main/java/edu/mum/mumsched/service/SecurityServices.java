package edu.mum.mumsched.service;


public interface SecurityServices {
    String findLoggedInUsername();
    void autologin(String username, String password);
}
