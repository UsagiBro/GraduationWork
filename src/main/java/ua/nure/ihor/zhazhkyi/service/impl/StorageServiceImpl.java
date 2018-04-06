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
    public String storeFile(MultipartFile file, String name) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = context.getRealPath("");
                File dir = new File(
                        rootPath + File.separator +
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

                return WebConstants.CABINET_PATH;
            } catch (Exception e) {
                throw new FileUploadException("You failed to upload " + name + " => " + e.getMessage());
            }
        } else {
            throw new FileUploadException("You failed to upload " + name
                    + " because the file was empty.");
        }
    }
}
