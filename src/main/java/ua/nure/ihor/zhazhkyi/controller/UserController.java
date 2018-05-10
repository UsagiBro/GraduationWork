package ua.nure.ihor.zhazhkyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.ihor.zhazhkyi.constants.WebConstants;
import ua.nure.ihor.zhazhkyi.entity.User;
import ua.nure.ihor.zhazhkyi.exception.ServiceException;
import ua.nure.ihor.zhazhkyi.service.StorageService;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private HttpSession session;

    @RequestMapping(value = "/cabinet", method = RequestMethod.GET)
    public ModelAndView cabinetGet() {
        ModelAndView cabinetMav = new ModelAndView(WebConstants.CABINET_PATH);
        User user = (User) Optional.ofNullable(session.getAttribute(WebConstants.USER))
                .orElseThrow(() -> new ServiceException("Please authorize first!"));
        String userPhoto = storageService.getUserPhoto(user);
        cabinetMav.addObject("userPhoto", userPhoto);
        return cabinetMav;
    }

    @RequestMapping(value = "/uploadPhoto", method = RequestMethod.POST)
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        storageService.storeFile(file);
        return WebConstants.CABINET_PATH;
    }
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profileGet() {
        return WebConstants.PROFILE_PATH;
    }
}
