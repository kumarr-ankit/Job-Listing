package com.ankit.JobListing.controller;

import com.ankit.JobListing.model.Post;
import com.ankit.JobListing.repository.PostRepo;
import com.ankit.JobListing.repository.SearchJob;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepo repo;
    @Autowired
    SearchJob searchJob = new SearchJob();
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {

        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping(value = "/posts")
    public List<Post> getAllPost(){
     return repo.findAll();
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post body){
      return  repo.save(body);
    }

    @GetMapping(value = "/search/{text}")
    public List<Post> getAllFilter(@PathVariable("text") String search){
        return searchJob.findByText(search);
    }

}
