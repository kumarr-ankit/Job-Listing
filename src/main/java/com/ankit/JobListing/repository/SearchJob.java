package com.ankit.JobListing.repository;

import com.ankit.JobListing.model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.internal.MongoClientImpl;
import jakarta.annotation.PostConstruct;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchJob implements SearchRepo {



    @Autowired
    MongoConverter converter;

    @Autowired
    MongoClient mongoClient;

    private MongoCollection<Document> collection;


    @PostConstruct
    public void init() {
        // Declare these fields but do not initialize them yet
        MongoDatabase database = mongoClient.getDatabase("jobsDB");
        this.collection = database.getCollection("jobPost");
    }

    @Override
    public List<Post> findByText(String search) {
        ArrayList<Post> posts = new ArrayList<>();

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("index", "ankit-search")
                                .append("text",
                                        new Document("query", search)
                                                .append("path", Arrays.asList("techs", "desc", "profile")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 4L)));
        result.forEach(doc -> {
            posts.add(converter.read(Post.class, doc));
        });

        return posts;
    }
}
