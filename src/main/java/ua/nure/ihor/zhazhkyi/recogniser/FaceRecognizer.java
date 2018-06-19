package ua.nure.ihor.zhazhkyi.recogniser;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacpp.opencv_core.MatVector;
import org.springframework.stereotype.Component;

import static org.bytedeco.javacpp.opencv_core.IPL_DEPTH_8U;
import static org.bytedeco.javacpp.opencv_imgproc.CV_BGR2GRAY;
import static org.bytedeco.javacpp.opencv_imgproc.cvCvtColor;

@Component
public class FaceRecognizer {

    public IplImage recogniseByImages(IplImage image) {

        MatVector vectorOfImages = new opencv_core.MatVector(image);
        IplImage resultImage;
        resultImage = IplImage.create(image.width(), image.height(), IPL_DEPTH_8U, 1);
        vectorOfImages.put(resultImage);

        IplImage greyTestImage = IplImage.create(image.width(), image.height(), IPL_DEPTH_8U, 1);
        cvCvtColor(image, greyTestImage, CV_BGR2GRAY);

//        GlassesFisherFaceRecogniser faceRecognizer = new GlassesFisherFaceRecogniser(resultImage);
//        resultImage =  faceRecognizer.retreiveFaceParameters();
        return resultImage;
    }

}
