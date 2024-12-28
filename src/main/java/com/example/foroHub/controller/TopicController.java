package com.example.foroHub.controller;

import com.example.foroHub.model.topic.Topic;
import com.example.foroHub.model.topic.dto.DtoShowTopic;
import com.example.foroHub.model.topic.dto.DtoUpdateTopic;
import com.example.foroHub.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<DtoShowTopic>> showAllTopics(@PageableDefault(value = 10) Pageable pageable){
        return ResponseEntity.ok(topicService.showAllTopics(pageable).map(DtoShowTopic::new));
    }

    @GetMapping
    public ResponseEntity<Page<DtoShowTopic>> showOpenTopics(@PageableDefault(value = 10) Pageable pageable){
        return ResponseEntity.ok(topicService.showOpenTopics(pageable).map(DtoShowTopic::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoShowTopic> showTopicById(@PathVariable Long id){
        var optionalTopic = topicService.showTopicById(id);
        if(optionalTopic.isPresent()){
            var topic = optionalTopic.get();
            return ResponseEntity.ok(new DtoShowTopic(topic));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DtoShowTopic> createTopic(@RequestBody @Valid Topic topic){
        topicService.saveTopic(topic);
        return ResponseEntity.ok(new DtoShowTopic(topic));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DtoShowTopic> updateTopic(@PathVariable Long id, @RequestBody @Valid DtoUpdateTopic data){
        var optionalTopic = topicService.showTopicById(id);
        if(optionalTopic.isPresent()){
            var topic = optionalTopic.get();

            if(data.title() != null) topic.setTitle(data.title());

            if(data.message() != null) topic.setMessage(data.message());

            if(data.course() != null) topic.setCourse(data.course());

            topicService.saveTopic(topic);
            return ResponseEntity.ok(new DtoShowTopic(topic));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/close")
    public ResponseEntity<Void> closeTopic(@PathVariable Long id){
        var optionalTopic = topicService.showTopicById(id);
        if(optionalTopic.isPresent()){
            var topic = optionalTopic.get();
            topicService.closeTopic(topic.getId());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id){
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }

}
