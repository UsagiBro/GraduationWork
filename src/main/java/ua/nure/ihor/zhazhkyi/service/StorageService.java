package ua.nure.ihor.zhazhkyi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.nure.ihor.zhazhkyi.entity.User;

@Service
public interface StorageService {

    void storeFile(MultipartFile file);

    String getUserPhoto(User user);
}
