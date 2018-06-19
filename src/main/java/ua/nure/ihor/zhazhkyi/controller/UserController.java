package ua.nure.ihor.zhazhkyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.ihor.zhazhkyi.constants.WebConstants;
import ua.nure.ihor.zhazhkyi.entity.User;
import ua.nure.ihor.zhazhkyi.exception.ServiceException;
import ua.nure.ihor.zhazhkyi.service.StorageService;

import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private HttpSession session;

    @GetMapping(value = "/cabinet")
    public ModelAndView cabinetGet() {
        ModelAndView cabinetMav = new ModelAndView(WebConstants.CABINET_PATH);
        Optional.ofNullable(session.getAttribute(WebConstants.USER))
                .orElseThrow(() -> new ServiceException("Please authorize first!"));
        return cabinetMav;
    }

    @PostMapping(value = "/uploadPhoto")
    public String uploadPhoto(@RequestParam("file") MultipartFile file) {
        User user = (User) session.getAttribute(WebConstants.USER);
        storageService.storePhoto(file, user.getEmail());
        return WebConstants.CABINET_PATH;
    }

    @GetMapping(value = "/loadPhoto", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] loadPhoto() {
        User user = (User) Optional.ofNullable(session.getAttribute(WebConstants.USER))
                .orElseThrow(() -> new ServiceException("Please authorize first!"));
        return storageService.loadPhoto(user.getEmail());
    }

    @GetMapping(value = "/profile")
    public String profileGet() {
        return WebConstants.PROFILE_PATH;
    }


}
