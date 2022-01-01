package com.example.easyrent.Model;

import org.springframework.stereotype.Service;

@Service
public class TemporaryHold {
    public static String email="default";
    public static String service="default";

    public static String getService() {
        return service;
    }

    public static void setService(String service) {
        TemporaryHold.service = service;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        TemporaryHold.email = email;
    }
}
