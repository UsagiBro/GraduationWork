package ua.nure.ihor.zhazhkyi.service;

import ua.nure.ihor.zhazhkyi.entity.Glasses;

import java.util.List;

public interface GlassesService {

    List<Glasses> getGlasses();

    Glasses getGlassesByName(String itemId);
}
