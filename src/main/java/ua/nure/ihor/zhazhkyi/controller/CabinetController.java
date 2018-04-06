package ua.nure.ihor.zhazhkyi.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import ua.nure.ihor.zhazhkyi.service.StorageService;

import javax.servlet.ServletContext;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Controller
public class CabinetController {

    private static final Logger LOG = Logger.getLogger(CabinetController.class);

    @Autowired
    private ServletContext context;

    @Autowired
    private StorageService storageService;

    @GetMapping("/cabinet")
    public String cabinetGet() {
        return "cabinet";
    }

    @PostMapping("/uploadPhoto")
    public @ResponseBody
    String uploadImage(@RequestParam("name") String name,
                       @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
//                String rootPath = context.getRealPath("");
                File dir = new File(
//                        rootPath + File.separator +
                        "upload");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                LOG.info("Server File Location="
                        + serverFile.getAbsolutePath());

                return "You successfully uploaded file=" + name;
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name
                    + " because the file was empty.";
        }
    }
}
