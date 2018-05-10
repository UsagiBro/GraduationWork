package ua.nure.ihor.zhazhkyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import ua.nure.ihor.zhazhkyi.constants.WebConstants;
import ua.nure.ihor.zhazhkyi.dto.user.UserDto;
import ua.nure.ihor.zhazhkyi.entity.User;
import ua.nure.ihor.zhazhkyi.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Objects;


@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return WebConstants.AUTHORIZATION_PATH;
    }

    @RequestMapping(value = "/authorization", method = RequestMethod.GET)
    public String getAuthorization() {
        return WebConstants.AUTHORIZATION_PATH;
    }

    @RequestMapping(value = "/authorization", method = RequestMethod.POST)
    public String authorizeUser(@RequestParam String email, @RequestParam String password, HttpSession session) {
        User receivedUser = userService.getUserByEmailAndPassword(email, password);
        if (Objects.nonNull(receivedUser)) {
            session.setAttribute("user", receivedUser);
            return "redirect:" + WebConstants.CABINET_PATH;
        }
        return WebConstants.AUTHORIZATION_PATH;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationGet() {
        return WebConstants.REGISTRATION_PATH;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrationPost(UserDto userDto) {
        userService.registerUser(userDto);
        return "redirect:" + WebConstants.AUTHORIZATION_PATH;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:" + WebConstants.AUTHORIZATION_PATH;
    }
}
