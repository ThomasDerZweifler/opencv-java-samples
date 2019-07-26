package org.roag;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class Main {

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
/*
        new ImageAnalyzer();
        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
        System.out.println("mat = " + mat.dump());
*/

        new ProcessedImageBuilder()
                .withSource("src/main/resources/salmon_spot.jpg")
                .withDestination("salmon_threshold.jpg")
                .threshold(87)
                .build();

        new ProcessedImageBuilder()
                .withSource("src/main/resources/salmon_spot.jpg")
                .withDestination("salmon_blur.jpg")
                .blur(7)
                .build();

        new ProcessedImageBuilder()
                .withSource("src/main/resources/salmon_spot.jpg")
                .withDestination("salmon_dilate.jpg")
                .blur(7)
                .threshold(90)
                .erode(12)
                .dilate(25)
                .build();

        new ProcessedImageBuilder()
                .withSource("src/main/resources/salmon_spot.jpg")
                .withDestination("salmon_erode.jpg")
                .erode(12)
                .build();


        new SpotDetector().spot();
    }
}
