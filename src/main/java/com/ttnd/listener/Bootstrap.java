package com.ttnd.listener;

import com.ttnd.Utils.enums.Visibility;
import com.ttnd.domain.*;
import com.ttnd.repository.ResourceRepository;
import com.ttnd.repository.TopicRepository;
import com.ttnd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Logger;

@Component
public class Bootstrap {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    ResourceRepository resourceRepository;

    @EventListener(ContextRefreshedEvent.class)
    void init() {
        createDummyuser();
     //   createDummyResources();
    }

    void createDummyuser() {
        User dummyUser = new User("saksham", "saksham", "sharma", "saksham.shrm03@gmail.com", "password", true, true);
        Path path = Paths.get("/home/saksham/advancedSpring/linksharing/blue/app/images/flat-avatar.png");
        dummyUser.setImage(defaultImage());
        Topic topic1 = new Topic("Grails", dummyUser, Visibility.PUBLIC, new Date(), new Date());
        Topic topic2 = new Topic("Spring", dummyUser, Visibility.PUBLIC, new Date(), new Date());
        dummyUser.getTopics().add(topic1);
        dummyUser.getTopics().add(topic2);
        userRepository.saveAndFlush(dummyUser);
    }

    void createDummyResources() {
        User dummyUser = userRepository.getOne(1L);
        Topic topic = topicRepository.getOne(1L);
        Resource resource1 = new DocumentResource("Document Resoource1", dummyUser, topic, new Date(), new Date(), "soomething");
        Resource resource2 = new LinkResource("Document Resoource2", dummyUser, topic, new Date(), new Date(), "soomething");
        topic.getResources().add(resource1);
        topic.getResources().add(resource2);
        dummyUser.getResources().add(resource1);
        dummyUser.getResources().add(resource2);
        userRepository.save(dummyUser);
    }

    byte[] defaultImage() {
        Path path = Paths.get("/home/saksham/advancedSpring/linksharing/blue/app/images/flat-avatar.png");
        byte[] output = new byte[0];
        try {
            output = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }
}
