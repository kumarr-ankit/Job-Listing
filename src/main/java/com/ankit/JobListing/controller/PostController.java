package com.ankit.JobListing.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.http.HttpRequest;

@RestController
public class PostController {
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {

        response.sendRedirect("/swagger-ui.html");
    }
}
