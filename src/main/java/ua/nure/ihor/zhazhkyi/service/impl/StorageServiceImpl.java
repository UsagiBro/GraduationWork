package ua.nure.ihor.zhazhkyi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.nure.ihor.zhazhkyi.constants.WebConstants;
import ua.nure.ihor.zhazhkyi.exception.file.FileUploadException;
import ua.nure.ihor.zhazhkyi.service.StorageService;

import javax.servlet.ServletContext;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private ServletContext context;

    @Override
    public void storeFile(MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // Creating the directory to store file
                File dir = new File(
                        context.getRealPath("") + File.separator +
                                "upload");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                String fileName = "default";
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + fileName + "."
                        + file.getContentType().split("/")[1]);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(file.getBytes());
                stream.close();
            } catch (Exception e) {
                throw new FileUploadException("You failed to upload photo => " + e.getMessage());
            }
        } else {
            throw new FileUploadException("You failed to upload photo" +
                    " because the file was empty.");
        }
    }
}
