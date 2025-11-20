package com.ankit.JobListing.repository;

import com.ankit.JobListing.model.Post;

import java.util.List;

public interface SearchRepo {
    List<Post> findByText(String search);
}
