package ua.nure.ihor.zhazhkyi.recogniser;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FilenameFilter;

@Component
public class ImageResolver {

    public File[] getPngImagesFromDirectory(File rootDirectory) {
        FilenameFilter pngFilter = (dir, name) -> name.toLowerCase().endsWith(".png");
        return rootDirectory.listFiles(pngFilter);
    }
}
