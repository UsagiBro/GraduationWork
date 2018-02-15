package ua.nure.ihor.zhazhkyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.nure.ihor.zhazhkyi.entity.User;
import ua.nure.ihor.zhazhkyi.service.UserService;


@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "authorization";
    }

    @RequestMapping(value = "/authorize", method = RequestMethod.GET)
    public String authorizeUser(@RequestBody String email, @RequestBody String password) {
        User receivedUser = userService.getUserByEmail(email, password);
        return "authorization";
    }
}
