package com.ing.retroapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by D-RB15LP on 20/04/2018.
 */
@Document(collection = "postcard")
public class PostCard {

    @Id
    private String id;

    private String header;

    private String description;

    private String type;

    private String sprintVersion;

    private Boolean isSubmitted;

    private Boolean isSelected;

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSprintVersion() {
        return sprintVersion;
    }

    public void setSprintVersion(String sprintVersion) {
        this.sprintVersion = sprintVersion;
    }

    public Boolean getIsSubmitted() {
        return isSubmitted;
    }

    public void setIsSubmitted(Boolean isSubmitted) {
        this.isSubmitted = isSubmitted;
    }

    public Boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }
}
