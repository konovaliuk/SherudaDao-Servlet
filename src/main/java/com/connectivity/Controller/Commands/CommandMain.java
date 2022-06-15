package com.connectivity.Controller.Commands;

import com.connectivity.Controller.Config;
import com.connectivity.Controller.ConfigPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CommandMain implements ICommand {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        return ConfigPath.home.getJspAddress();
    }
}
