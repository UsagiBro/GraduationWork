package ua.nure.ihor.zhazhkyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.nure.ihor.zhazhkyi.entity.User;
import ua.nure.ihor.zhazhkyi.service.UserService;

import java.util.Objects;


@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "authorization";
    }

    @RequestMapping(value = "/authorization", method = RequestMethod.POST)
    public String authorizeUser(@RequestParam String email, @RequestParam String password) {
        User receivedUser = userService.getUserByEmailAndPassword(email, password);
        if (Objects.nonNull(receivedUser)) {
            return "cabinet";
        }
        return "authorization";
    }
}
