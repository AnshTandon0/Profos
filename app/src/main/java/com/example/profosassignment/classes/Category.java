package com.example.profosassignment.classes;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {

    private String Id = "" ;
    private String name = "";
    private List<String> itemsId;
    private String imageUrl = "";

    public Category ()
    {

    }

    public Category(String id, String name, List<String> itemsId, String imageUrl) {
        Id = id;
        this.name = name;
        this.itemsId = itemsId;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getItemsId() {
        return itemsId;
    }

    public void setItemsId(List<String> itemsId) {
        this.itemsId = itemsId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
