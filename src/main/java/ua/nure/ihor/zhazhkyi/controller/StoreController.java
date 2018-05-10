package ua.nure.ihor.zhazhkyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.nure.ihor.zhazhkyi.constants.WebConstants;
import ua.nure.ihor.zhazhkyi.entity.Glasses;
import ua.nure.ihor.zhazhkyi.service.GlassesService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StoreController {

    @Autowired
    private GlassesService glassesService;

    @RequestMapping(value = "/store", method = RequestMethod.GET)
    public String storeGet(HttpSession session) {
        List<Glasses> glassesList = glassesService.getGlasses();
        session.setAttribute("glassesList", glassesList);
        return WebConstants.STORE_PATH;
    }
}
