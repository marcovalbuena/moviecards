package com.lauracercas.moviecards.unittest.service;

import com.lauracercas.moviecards.model.Actor;
import com.lauracercas.moviecards.service.actor.ActorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ActorServiceImplTest {

    @Mock
    private RestTemplate template;

    @InjectMocks
    private ActorServiceImpl sut;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldGetAllActors() {
        Actor[] actorsArray = new Actor[2];
        actorsArray[0] = new Actor();
        actorsArray[1] = new Actor();

        when(template.getForObject(anyString(), eq(Actor[].class))).thenReturn(actorsArray);

        List<Actor> result = sut.getAllActors();

        assertEquals(2, result.size());
    }

    @Test
    public void shouldGetActorById() {
        Actor actor = new Actor();
        actor.setId(1);
        actor.setName("Test Actor");

        when(template.getForObject(anyString(), eq(Actor.class))).thenReturn(actor);

        Actor result = sut.getActorById(1);

        assertEquals("Test Actor", result.getName());
    }

    @Test
    public void shouldSaveActor() {
        Actor actor = new Actor();
        actor.setName("New Actor");

        when(template.postForObject(anyString(), any(Actor.class), eq(Actor.class))).thenReturn(actor);

        Actor result = sut.save(actor);

        assertEquals("New Actor", result.getName());
    }
}