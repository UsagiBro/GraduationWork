package ua.nure.ihor.zhazhkyi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface StorageService {

    String storeFile(MultipartFile file, String name);
}
