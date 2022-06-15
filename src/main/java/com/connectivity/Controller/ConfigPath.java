package com.connectivity.Controller;

import com.connectivity.Controller.Commands.ICommand;

public enum ConfigPath {
    home("/home.jsp"),
    login("/login.jsp"),
    register("/register.jsp"),
    users("/users.jsp"),
    books("/books.jsp"),
    genres("/genres.jsp");

    private final String jspAddress;

    ConfigPath(String jspAddress) {
        this.jspAddress = jspAddress;
    }
    public String getJspAddress() {
        return jspAddress;
    }
    }
