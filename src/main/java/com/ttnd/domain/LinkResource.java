package com.ttnd.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue(value = "Link")
public class LinkResource extends Resource{

    @Column(nullable = true)
    String url;

    public LinkResource(){}

    public LinkResource(String description, User createdBy, Topic topic, Date dateCreated, Date lastUpdated, String url) {
        super(description, createdBy, topic, dateCreated, lastUpdated);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
