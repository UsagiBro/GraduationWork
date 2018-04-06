package ua.nure.ihor.zhazhkyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import ua.nure.ihor.zhazhkyi.constants.WebConstants;
import ua.nure.ihor.zhazhkyi.service.StorageService;

@Controller
public class CabinetController {

    @Autowired
    private StorageService storageService;

    @GetMapping("/cabinet")
    public String cabinetGet() {
        return WebConstants.CABINET_PATH;
    }

    @PostMapping("/uploadPhoto")
    public @ResponseBody
    String uploadImage(@RequestParam("name") String name,
                       @RequestParam("file") MultipartFile file) {
        return storageService.storeFile(file, name);
    }
}
