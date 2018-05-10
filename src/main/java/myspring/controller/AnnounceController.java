package myspring.controller;

import myspring.dao.Announcable;
import myspring.dao.Userable;
import myspring.model.Announce;
import myspring.model.User;
import myspring.service.AnnounceServiceImpl;
import myspring.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@Controller

@RestController
@RequestMapping("/announce")

class AnnounceController {
    private AnnounceServiceImpl announceService;

    @Autowired(required = true)
    @Qualifier(value = "announceService")
    public void setAnnounceService(AnnounceServiceImpl announceService) {
        this.announceService = announceService;
    }

    @RequestMapping(value = "join", method = RequestMethod.GET)
    public String join() {
        return "join";
    }

    @RequestMapping(value = "signin", method = RequestMethod.GET)
    public String signin() {
        return "signin";
    }

    @RequestMapping(value = "announce", method = RequestMethod.GET)
    public String listAnnounce(Model model) {
        model.addAttribute("announce", new Announce());
        model.addAttribute("listAnnounce", this.announceService.listAnnounce());

        return "announce";
    }

    @RequestMapping(value = "/announce/add", method = RequestMethod.POST)
    public String addAnnounce(@ModelAttribute("announce") Announce announce) {
        if (announce.getAnnounceid() == 0) {
            this.announceService.addAnnounce(announce);
        } else {
            this.announceService.updateAnnounce(announce);
        }

        return "redirect:/announce";
    }

    @RequestMapping(value = "/announce/{id}", method = RequestMethod.DELETE)
    public String removeAnnounce(@PathVariable("id") int id) {
        this.announceService.removeAnnounce(id);

        return "redirect:/announce";
    }

    @RequestMapping(value = "announce/{id}", method = RequestMethod.PUT)
    public String editAnnounce(@PathVariable("id") int id, Model model) {
        model.addAttribute("announce", this.announceService.getAnnounceById(id));
        model.addAttribute("listAnnounce", this.announceService.listAnnounce());

        return "announce";
    }

    @RequestMapping(value = "announce/{id}", method = RequestMethod.GET)
    public String announceData(@PathVariable("id") int id, Model model) {
        model.addAttribute("announce", this.announceService.getAnnounceById(id));

        return "announcedata";
    }

    private UserServiceImpl userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String listUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUser", this.userService.listUser());

        return "user";
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        if (user.getUserid() == 0) {
            this.userService.addUser(user);
        } else {
            this.userService.updateUser(user);
        }

        return "redirect:/user";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String removeUser(@PathVariable("id") int id) {
        this.userService.removeUser(id);

        return "redirect:/user";
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUser", this.userService.listUser());

        return "user";
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public String userData(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.getUserById(id));

        return "userdata";
    }
}
