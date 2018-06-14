package ua.nure.ihor.zhazhkyi.recogniser;

import org.bytedeco.javacpp.opencv_core;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.nure.ihor.zhazhkyi.entity.Glasses;

@Component
public class FacePointEstimator {

    @Autowired
    private GlassesAdvisor glassesAdvisor;

    private int interPupilaryDistance;
    private int browEarDistance;
    private int noseWidth;
    private int headDiameter;

    public void getPintsFromImage(opencv_core.IplImage grayImg) {

    }

    public Glasses selectGlassesToFace() {
        return glassesAdvisor.adviceGlasses(interPupilaryDistance,  browEarDistance, noseWidth, headDiameter);
    }
}
