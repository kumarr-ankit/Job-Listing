package com.ankit.JobListing.controller;

import com.ankit.JobListing.model.Post;
import com.ankit.JobListing.repository.PostRepo;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepo repo;
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {

        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping(value = "/posts")
    public List<Post> getAllPost(){
     return repo.findAll();
    }
}
