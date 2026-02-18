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
        String url = serviceUrl + "/actors";
        Actor[] actors = restTemplate.getForObject(url, Actor[].class);
        return Arrays.asList(actors != null ? actors : new Actor[0]);
    }

    @Override
    public Actor save(Actor actor) {
        String url = serviceUrl + "/actors";
        return restTemplate.postForObject(url, actor, Actor.class);
    }

    @Override
    public Actor getActorById(int actorId) {
        String url = serviceUrl + "/actors/" + actorId;
        return restTemplate.getForObject(url, Actor.class);
    }

    @Override
    public void deleteActor(int actorId) {
        String url = serviceUrl + "/actors/" + actorId;
        restTemplate.delete(url);
    }
}