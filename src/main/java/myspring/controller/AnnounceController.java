package myspring.controller;

import myspring.model.Announce;
import myspring.model.User;
import myspring.service.AnnounceService;
import myspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
class AnnounceController {
    private AnnounceService announceService;

    @Autowired(required = true)
    @Qualifier(value = "announceService")
    public void setAnnounceService(AnnounceService announceService) {
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
    public String listAnnounce(Model model){
        model.addAttribute("announce", new Announce());
        model.addAttribute("listAnnounce", this.announceService.listAnnounce());

        return "announce";
    }

    @RequestMapping(value = "/announce/add", method = RequestMethod.POST)
    public String addAnnounce(@ModelAttribute("announce") Announce announce){
        if(announce.getAnnounceid() == 0){
            this.announceService.addAnnounce(announce);
        }else {
            this.announceService.updateAnnounce(announce);
        }

        return "redirect:/announce";
    }

    @RequestMapping("/announceremove/{id}")
    public String removeAnnounce(@PathVariable("id") int id){
        this.announceService.removeAnnounce(id);

        return "redirect:/announce";
    }

    @RequestMapping("announceedit/{id}")
    public String editAnnounce(@PathVariable("id") int id, Model model){
        model.addAttribute("announce", this.announceService.getAnnounceById(id));
        model.addAttribute("listAnnounce", this.announceService.listAnnounce());

        return "announce";
    }

    @RequestMapping("announcedata/{id}")
    public String announceData(@PathVariable("id") int id, Model model){
        model.addAttribute("announce", this.announceService.getAnnounceById(id));

        return "announcedata";
    }

    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String listUser(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listUser", this.userService.listUser());

        return "user";
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){
        if(user.getUserid() == 0){
            this.userService.addUser(user);
        }else {
            this.userService.updateUser(user);
        }

        return "redirect:/user";
    }

    @RequestMapping("/userremove/{id}")
    public String removeUser(@PathVariable("id") int id){
        this.userService.removeUser(id);

        return "redirect:/user";
    }

    @RequestMapping("useredit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUser", this.userService.listUser());

        return "user";
    }

    @RequestMapping("userdata/{id}")
    public String userData(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));

        return "userdata";
    }
}
