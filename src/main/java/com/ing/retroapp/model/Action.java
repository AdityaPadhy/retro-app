package com.ing.retroapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by D-RB15LP on 13/09/2018.
 */
@Document(collection = "action")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Action {

    @Id
    private String id;

    private String postcardId;

    private String what;

    private String when;

    private String who;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostcardId() {
        return postcardId;
    }

    public void setPostcardId(String postcardId) {
        this.postcardId = postcardId;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }
}
