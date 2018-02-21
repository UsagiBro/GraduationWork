package ua.nure.ihor.zhazhkyi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StoreController {

    @RequestMapping(value = "/store", method = RequestMethod.GET)
    public String storeGet() {
        return "store";
    }
}
