package ua.nure.ihor.zhazhkyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.nure.ihor.zhazhkyi.service.UserService;

@Controller
public class CabinetController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/cabinet", method = RequestMethod.GET)
    public String cabinetGet() {
        return "cabinet";
    }

    @RequestMapping(value = "/uploadPhoto", method = RequestMethod.POST)
    public String uploadPhoto() {

        return "cabinet";
    }
}
