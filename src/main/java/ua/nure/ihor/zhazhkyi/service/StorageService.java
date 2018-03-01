package ua.nure.ihor.zhazhkyi.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface StorageService {

    Resource storeFile(String filename);

    boolean store(MultipartFile file);
}
