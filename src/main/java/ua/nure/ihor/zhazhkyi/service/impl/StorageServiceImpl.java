package ua.nure.ihor.zhazhkyi.service.impl;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.nure.ihor.zhazhkyi.service.StorageService;

@Service
public class StorageServiceImpl implements StorageService {

    @Override
    public Resource storeFile(String filename) {
        return null;
    }

    @Override
    public boolean store(MultipartFile file) {
        return false;
    }
}
