package com.ttnd.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="resource_type")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = true)
    String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User createdBy;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    Topic topic;

    @Column(nullable = false)
    Date dateCreated;

    @Column(nullable = false)
    Date lastUpdated;

    public Resource(){}

    public Resource(String description, User createdBy, Topic topic, Date dateCreated, Date lastUpdated) {
        this.description = description;
        this.createdBy = createdBy;
        this.topic = topic;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
