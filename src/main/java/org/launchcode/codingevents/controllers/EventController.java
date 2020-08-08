package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value="events")
public class EventController {

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("events", EventData.getAllEvents());
        model.addAttribute("title", "All Events");
        return "events/allEvents";
}

    //lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@ModelAttribute Event newEvent) {
        EventData.addEvent(new Event(newEvent.getName(), newEvent.getDescription()));
        return "redirect:";
    }

    @GetMapping("delete")
    public String deleteEventForm(Model model) {
        model.addAttribute("events", EventData.getAllEvents());
        model.addAttribute("title", "Delete Events");
        return "events/delete";
    }

    @PostMapping("delete")
    public String deleteEvents(@RequestParam(required = false) List<Integer> eventIds) {
        if (null != eventIds) {
            for (Integer id : eventIds) {
                EventData.deleteEvent(id);
            }
        }
            return "redirect:";
    }


}
