package com.example.demo;

public enum UserRole {
    CLIENT("Client"),
    HOTEL_MANAGER("Hotel Manager");

    private String displayName;

    UserRole(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
