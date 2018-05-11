package ua.nure.ihor.zhazhkyi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.nure.ihor.zhazhkyi.entity.User;

import java.awt.image.BufferedImage;
import java.io.IOException;

@Service
public interface StorageService {

    void storePhoto(MultipartFile file, String fileName);

    byte[] loadPhoto(String fileName);

}
