package com.Deed.joblisting.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "JobPosts")
public class Schema {
    
    @Id
    private ObjectId id;
    private String title;
    private String desc;

    public Schema(){}

    public Schema(String desc, ObjectId id, String title) {
        this.desc = desc;
        this.id = id;
        this.title = title;
    }

    // Getters and Setters

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}