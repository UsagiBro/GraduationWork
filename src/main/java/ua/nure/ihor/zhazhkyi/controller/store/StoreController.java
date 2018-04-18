package ua.nure.ihor.zhazhkyi.controller.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.nure.ihor.zhazhkyi.constants.WebConstants;

@Controller
public class StoreController {

    @RequestMapping(value = "/store", method = RequestMethod.GET)
    public String storeGet() {
        return WebConstants.STORE_PATH;
    }
}
