package com.connectivity.Controller.Commands;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

public interface ICommand {
    String execute(HttpServletRequest request) throws ServletException, IOException;
}
