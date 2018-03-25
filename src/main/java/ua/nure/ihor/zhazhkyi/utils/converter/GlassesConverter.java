package ua.nure.ihor.zhazhkyi.utils.converter;

import org.springframework.stereotype.Component;
import ua.nure.ihor.zhazhkyi.dto.GlassesDto;
import ua.nure.ihor.zhazhkyi.entity.Glasses;

@Component
public class GlassesConverter extends AbstractConverter {

    public Glasses glassesDtoToGlasses(GlassesDto glassesDto) {
        Glasses glasses = new Glasses();
        convert(glassesDto, glasses);
        return glasses;
    }

    public GlassesDto glassesToGlassesDto(Glasses glasses) {
        GlassesDto glassesDto = new GlassesDto();
        convert(glasses, glassesDto);
        return glassesDto;
    }
}
