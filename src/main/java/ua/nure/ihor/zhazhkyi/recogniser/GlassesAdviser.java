package ua.nure.ihor.zhazhkyi.recogniser;

import org.springframework.stereotype.Component;
import ua.nure.ihor.zhazhkyi.entity.Glasses;

import java.util.List;

@Component
public class GlassesAdviser {

    private int interPupilaryDistance, browEarDistance, noseWidth, headDiameter;

    public Glasses adviceGlasses(List<Integer> facePoints) {
        return new Glasses();
    }
}
