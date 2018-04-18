package ua.nure.ihor.zhazhkyi.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import ua.nure.ihor.zhazhkyi.constants.WebConstants;
import ua.nure.ihor.zhazhkyi.service.StorageService;

@Controller
@SessionAttributes("user")
public class CabinetController {

    @Autowired
    private StorageService storageService;

    @RequestMapping(value = "/cabinet", method = RequestMethod.GET)
    public String cabinetGet() {
        return WebConstants.CABINET_PATH;
    }

    @RequestMapping(value = "/uploadPhoto", method = RequestMethod.POST)
    public @ResponseBody
    String uploadImage(@RequestParam("name") String name,
                       @RequestParam("file") MultipartFile file) {
        return storageService.storeFile(file, name);
    }
}
