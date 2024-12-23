package com.example.foroHub.service;

import com.example.foroHub.model.topic.StatusEnum;
import com.example.foroHub.model.topic.Topic;
import com.example.foroHub.repository.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Page<Topic> showAllTopics(Pageable pageable){
        return topicRepository.findAll(pageable);
    }

    public Page<Topic> showOpenTopics(Pageable pageable){
        return topicRepository.findOpenTopics(pageable);
    }

    public Optional<Topic> showTopicById(Long id){
        return topicRepository.findById(id);
    }

    public void saveTopic(Topic topic){
        topicRepository.save(topic);
    }

    public void deleteTopic(Long id){
        topicRepository.deleteById(id);
    }

    public Topic closeTopic(Long id){
        var topic = topicRepository.getReferenceById(id);
        topic.setStatus(StatusEnum.CLOSE);
        return topicRepository.save(topic);
    }
}
