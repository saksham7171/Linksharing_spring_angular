package com.ttnd.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue(value = "Document")
public class DocumentResource extends Resource {

    @Column(nullable = true)
    String filepath;

    public DocumentResource(){}

    public DocumentResource(String description, User createdBy, Topic topic, Date dateCreated, Date lastUpdated, String filepath) {
        super(description, createdBy, topic, dateCreated, lastUpdated);
        this.filepath = filepath;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}
