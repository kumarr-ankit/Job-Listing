package com.ankit.JobListing.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "jobPost")
public class Post {
    private String profile;
    private String desc;
    private int exp;
    private String[] techs;

}
