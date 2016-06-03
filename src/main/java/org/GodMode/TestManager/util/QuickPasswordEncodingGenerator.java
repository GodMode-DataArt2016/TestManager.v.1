package org.GodMode.TestManager.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class QuickPasswordEncodingGenerator {


    public static void main(String[] args) {
        String password = "1111";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode(password));
    }

}
