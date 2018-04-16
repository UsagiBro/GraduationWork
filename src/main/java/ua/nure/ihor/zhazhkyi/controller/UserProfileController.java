package ua.nure.ihor.zhazhkyi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.nure.ihor.zhazhkyi.constants.WebConstants;

@Controller
public class UserProfileController {

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String cabinetGet() {
        return WebConstants.PROFILE_PATH;
    }
}
