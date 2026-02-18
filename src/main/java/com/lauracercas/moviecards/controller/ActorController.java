package com.lauracercas.moviecards.controller;

import com.lauracercas.moviecards.model.Actor;
import com.lauracercas.moviecards.service.actor.ActorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("actors")
    public String index(Model model) {
        List<Actor> actors = actorService.getAllActors();
        model.addAttribute("actors", actors);
        return "actors/list";
    }

    @GetMapping("actors/new")
    public String create(Model model) {
        model.addAttribute("actor", new Actor());
        return "actors/form";
    }

    @PostMapping("actors/save")
    public String save(@ModelAttribute("actor") Actor actor, Model model) {
        actorService.save(actor);
        return "redirect:/actors";
    }

    @GetMapping("actors/edit/{id}")
    public String edit(@PathVariable("id") int actorId, Model model) {
        Actor actor = actorService.getActorById(actorId);
        model.addAttribute("actor", actor);
        return "actors/form";
    }
}