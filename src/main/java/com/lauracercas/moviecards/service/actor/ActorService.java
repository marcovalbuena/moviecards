package com.lauracercas.moviecards.service.actor;

import com.lauracercas.moviecards.model.Actor;
import java.util.List;

public interface ActorService {
    List<Actor> getAllActors();
    Actor save(Actor actor);
    Actor getActorById(int actorId);
    void deleteActor(int actorId);
}