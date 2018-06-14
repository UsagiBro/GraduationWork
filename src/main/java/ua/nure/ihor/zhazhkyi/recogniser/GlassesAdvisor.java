package ua.nure.ihor.zhazhkyi.recogniser;

import org.springframework.stereotype.Component;
import ua.nure.ihor.zhazhkyi.entity.Glasses;

@Component
public class GlassesAdvisor {


    public Glasses adviceGlasses(int interPupilaryDistance, int browEarDistance, int noseWidth, int headDiameter) {
        return new Glasses();
    }
}
