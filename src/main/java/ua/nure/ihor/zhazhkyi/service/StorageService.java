package ua.nure.ihor.zhazhkyi.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public interface StorageService {

    Resource storeFile(String filename);
}
