package com.homework2.lakshitha.zoodirectory;

import java.io.Serializable;

public class Animal implements Serializable{
    private String name;
    private String scientificName;
    private String imageFileName;
    private String fullSizeImageFileName;
    private String description;

    public Animal(String name, String scientificName, String imageFileName) {
        this.name = name;
        this.scientificName = scientificName;
        this.imageFileName = imageFileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getFullSizeImageFileName() {
        return fullSizeImageFileName;
    }

    public void setFullSizeImageFileName(String fullSizeImageFileName) {
        this.fullSizeImageFileName = fullSizeImageFileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
