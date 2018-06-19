package ua.nure.ihor.zhazhkyi.recogniser;

import org.bytedeco.javacpp.opencv_core.IplImage;

public class GlassesFisherFaceRecogniser
//        extends FisherFaceRecognizer
{

    private int interPupilaryDistance, browEarDistance, noseWidth, headDiameter;

    private IplImage targetImage;

//    public GlassesFisherFaceRecogniser(IplImage targetImage) {
//        this.targetImage = targetImage;
//    }

    public IplImage retreiveFaceParameters() {
        interPupilaryDistance = calculateInterPupilaryDistance(targetImage);
        browEarDistance = calculateBrowEarDistance(targetImage);
        noseWidth = calculateNoseWidth(targetImage);
        headDiameter = calculateHeadDiameter(targetImage);
        return recogniseFaceByPattern(targetImage, interPupilaryDistance, browEarDistance, noseWidth, headDiameter);
    }

    private int calculateInterPupilaryDistance(IplImage targetImage) {
        return 1;
    }

    private int calculateBrowEarDistance(IplImage targetImage) {
        return 1;
    }

    private int calculateNoseWidth(IplImage targetImage) {
        return 1;
    }

    private int calculateHeadDiameter(IplImage targetImage) {
        return 1;
    }

    private IplImage recogniseFaceByPattern(IplImage targetImage,
                                            int pupilaryDistance,
                                            int interPupilaryDistance,
                                            int noseWidth,
                                            int headDiameter) {
        return null;
    }

}
