package ua.nure.ihor.zhazhkyi.service.impl;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.nure.ihor.zhazhkyi.constants.WebConstants;
import ua.nure.ihor.zhazhkyi.exception.FileUploadException;
import ua.nure.ihor.zhazhkyi.exception.ServiceException;
import ua.nure.ihor.zhazhkyi.persistence.UserRepository;
import ua.nure.ihor.zhazhkyi.service.StorageService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

@Service
public class StorageServiceImpl implements StorageService {

    @Value("${user.dir}")
    private String homeDir;

    @Override
    public void storePhoto(MultipartFile file, String fileName) {
        if (!file.isEmpty()) {
            try {
                String uploadPath = homeDir + File.separator + WebConstants.UPLOAD_IMAGES_PATH;
                // Creating the directory to store file
                File dir = new File(uploadPath);
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath() + File.separator
                        + fileName + "."
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

    @Override
    public byte[] loadPhoto(String fileName) {
        BufferedImage image = null;
        String loadPath = homeDir + File.separator + WebConstants.UPLOAD_IMAGES_PATH;
        try {
            for (File file : Objects.requireNonNull(new File(loadPath).listFiles())) {
                if (fileName.equals(FilenameUtils.removeExtension(file.getName()))) {
                    image = ImageIO.read(file);
                    return convertImageToBytes(image, FilenameUtils.getExtension(file.getName()));
                }
            }
            image = ImageIO.read(new File(homeDir + File.separator + WebConstants.DEFAULT_IMAGE_PATH));
            return convertImageToBytes(image, "png");
        } catch (IOException e) {
            throw new ServiceException("Failed to upload avatar");
        }
    }

    private byte[] convertImageToBytes(BufferedImage image, String extension) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, extension, baos );
        baos.flush();
        byte[] imageInBytes = baos.toByteArray();
        baos.close();
        return imageInBytes;
    }
}
