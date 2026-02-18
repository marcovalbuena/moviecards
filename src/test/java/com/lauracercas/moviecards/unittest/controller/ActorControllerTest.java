package com.lauracercas.moviecards.unittest.controller;

import com.lauracercas.moviecards.controller.ActorController;
import com.lauracercas.moviecards.model.Actor;
import com.lauracercas.moviecards.service.actor.ActorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActorControllerTest {

    @Mock
    private ActorService actorService;
    @Mock
    private Model model;

    @InjectMocks
    private ActorController actorController;

    @Test
    public void shouldReturnIndexViewWithActors() {
        List<Actor> actors = new ArrayList<>();
        when(actorService.getAllActors()).thenReturn(actors);

        String viewName = actorController.index(model);

        assertEquals("actors/list", viewName);
        verify(model).addAttribute("actors", actors);
    }

    @Test
    public void shouldReturnNewActorView() {
        String viewName = actorController.create(model);
        assertEquals("actors/form", viewName);
        verify(model).addAttribute(any(String.class), any(Actor.class));
    }

    @Test
    public void shouldSaveActorAndRedirect() {
        Actor actor = new Actor();
        String viewName = actorController.save(actor, model);
        assertEquals("redirect:/actors", viewName);
        verify(actorService).save(actor);
    }
}