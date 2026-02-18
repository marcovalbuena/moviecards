package com.lauracercas.moviecards.unittest.model;

import com.lauracercas.moviecards.model.Actor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ActorTest {
    @Test
    public void shouldSetAndGetId() {
        Actor actor = new Actor();
        actor.setId(1);
        assertEquals(1, actor.getId());
    }

    @Test
    public void shouldSetAndGetName() {
        Actor actor = new Actor();
        actor.setName("Test Actor");
        assertEquals("Test Actor", actor.getName());
    }
}