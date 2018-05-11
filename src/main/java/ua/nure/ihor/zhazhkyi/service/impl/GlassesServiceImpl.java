package ua.nure.ihor.zhazhkyi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import ua.nure.ihor.zhazhkyi.entity.Glasses;
import ua.nure.ihor.zhazhkyi.exception.ServiceException;
import ua.nure.ihor.zhazhkyi.persistence.GlassesRepository;
import ua.nure.ihor.zhazhkyi.service.GlassesService;

import java.util.List;
import java.util.Optional;

@Component
public class GlassesServiceImpl implements GlassesService {

    @Autowired
    private GlassesRepository glassesRepository;

    @Override
    public List<Glasses> getGlasses() {
        PageRequest pageRequest = new PageRequest(0, 6);
        Page<Glasses> receivedGlasses = Optional.ofNullable(glassesRepository.findAll(pageRequest)).
                filter(gotCards -> gotCards.getTotalElements() > 0).orElseThrow(() ->
                new ServiceException("Not found any glasses!"));
        return receivedGlasses.getContent();
    }

    @Override
    public Glasses getGlassesByName(String name) {
        return glassesRepository.findOneByName(name);
    }
}
