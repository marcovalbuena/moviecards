package com.lauracercas.moviecards.service.actor;

import com.lauracercas.moviecards.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${application.service.url}")
    private String serviceUrl;

    @Override
    public List<Actor> getAllActors() {
        Actor[] actors = restTemplate.getForObject(serviceUrl + "/actors", Actor[].class);
        return Arrays.asList(actors != null ? actors : new Actor[0]);
    }

    @Override
    public Actor save(Actor actor) {
        try {restTemplate.postForEntity(serviceUrl + "/actors", actor, Void.class);
            return actor;
        } catch (Exception e) {
            return actor;
        }
    }

    @Override
    public Actor getActorById(Integer id) {
        return restTemplate.getForObject(serviceUrl + "/actors/" + id, Actor.class);
    }

}