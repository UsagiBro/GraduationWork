package ua.nure.ihor.zhazhkyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.nure.ihor.zhazhkyi.constants.WebConstants;
import ua.nure.ihor.zhazhkyi.service.StorageService;

@Controller
public class UserController {

    @Autowired
    private StorageService storageService;

    @RequestMapping(value = "/cabinet", method = RequestMethod.GET)
    public String cabinetGet() {
        return WebConstants.CABINET_PATH;
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