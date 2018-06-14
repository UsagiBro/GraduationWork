package ua.nure.ihor.zhazhkyi.recogniser;

import java.io.File;
import java.util.List;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.MatVector;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.nure.ihor.zhazhkyi.entity.Glasses;

import static org.bytedeco.javacpp.opencv_core.IPL_DEPTH_8U;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;
import static org.bytedeco.javacpp.opencv_imgproc.CV_BGR2GRAY;
import static org.bytedeco.javacpp.opencv_imgproc.cvCvtColor;

@Component
public class FaceRecognizer {

    private ImageResolver imageResolver;
    private FacePointEstimator facePointEstimator;
    private GlassesAdviser glassesAdviser;

    @Autowired
    public FaceRecognizer(ImageResolver imageResolver,
                          FacePointEstimator  facePointEstimator,
                          GlassesAdviser glassesAdviser) {
        this.imageResolver = imageResolver;
        this.facePointEstimator = facePointEstimator;
        this.glassesAdviser = glassesAdviser;
    }

    public void recogniseByImages(IplImage image, File rootDirectory) {
        File[] pngImagesFromDirectory = imageResolver.getPngImagesFromDirectory(rootDirectory);

        MatVector vectorOfImages = new opencv_core.MatVector(pngImagesFromDirectory.length);

        int[] labels = new int[pngImagesFromDirectory.length];

        int counter = 0;
        int label;

        IplImage img;
        IplImage grayImg;

        for (File testImage : pngImagesFromDirectory) {
            img = cvLoadImage(testImage.getAbsolutePath());
            label = Integer.parseInt(testImage.getName().split("\\-")[0]);
            grayImg = IplImage.create(img.width(), img.height(), IPL_DEPTH_8U, 1);
            cvCvtColor(img, grayImg, CV_BGR2GRAY);
//            vectorOfImages.put(counter, grayImg);
            labels[counter] = label;

            counter++;
        }

        IplImage greyTestImage = IplImage.create(image.width(), image.height(), IPL_DEPTH_8U, 1);
//        FaceRecognizer faceRecognizer = createFisherFaceRecognizer();
//        faceRecognizer.train(vectorOfImages, labels);
        cvCvtColor(image, greyTestImage, CV_BGR2GRAY);
//        int predictedLabel = faceRecognizer.predict(greyTestImage);

//        setUpGlasses(retreiveFace(predictedLabel));
    }

    private Glasses setUpGlasses(IplImage image) {
        List<Integer> facePoints = facePointEstimator.getPintsFromImage(image);
        return glassesAdviser.adviceGlasses(facePoints);
    }

    private IplImage retreiveFace(int label) {
        return IplImage.create(0, 0, 0, 1);
    }

}
