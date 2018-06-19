package ua.nure.ihor.zhazhkyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.ihor.zhazhkyi.constants.WebConstants;
import ua.nure.ihor.zhazhkyi.entity.Glasses;
import ua.nure.ihor.zhazhkyi.service.GlassesService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StoreController {

    @Autowired
    private GlassesService glassesService;

    @GetMapping(value = "/store")
    public ModelAndView storeGet() {
        ModelAndView storeMav = new ModelAndView(WebConstants.STORE_PATH);
        List<Glasses> glassesList = glassesService.getGlasses();
        storeMav.addObject("glassesList", glassesList);
        return storeMav;
    }


    @GetMapping(value = "/item/{id}")
    public ModelAndView itemGet(@PathVariable("id") Long id) {
        ModelAndView itemMav = new ModelAndView(WebConstants.ITEM_PATH);
        Glasses glasses = glassesService.getGlassesById(id);
        itemMav.addObject("glasses", glasses);
        return itemMav;
    }

    @GetMapping(value = "/recognition")
    public ModelAndView recognitionGet() {
        ModelAndView itemMav = new ModelAndView(WebConstants.RECOGNITION_PATH);
        Glasses glasses = glassesService.getGlassesById(1L);
        itemMav.addObject("glasses", glasses);
        return itemMav;
    }
}
