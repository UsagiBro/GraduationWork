package ua.nure.ihor.zhazhkyi.recogniser;

import org.bytedeco.javacpp.opencv_core;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.nure.ihor.zhazhkyi.entity.Glasses;

import java.util.ArrayList;
import java.util.List;

@Component
public class FacePointEstimator {

    @Autowired
    private GlassesAdviser glassesAdviser;

    private int interPupilaryDistance;
    private int browEarDistance;
    private int noseWidth;
    private int headDiameter;

    public List<Integer> getPintsFromImage(opencv_core.IplImage grayImg) {
        return new ArrayList<>();
    }

    public void selectGlassesToFace() {
//        return glassesAdviser.adviceGlasses(interPupilaryDistance,  browEarDistance, noseWidth, headDiameter);
    }
}
