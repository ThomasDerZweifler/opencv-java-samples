package org.roag;

import org.opencv.core.Mat;

import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.util.logging.Logger;

/**
 * Created by eurohlam on 11.11.17.
 */

public class ProcessedImageBuilder {

    private final Logger LOG = Logger.getLogger(ProcessedImageBuilder.class.getName());

    private static final String OUTPUT_FOLDER = "output/";
    private String srcFile;
    private Mat srcMat;
    private String dstFile;
    private Mat currentMat;

    public ProcessedImageBuilder withSource(String file) {
        srcFile = file;
        srcMat = Imgcodecs.imread(file, Imgcodecs.CV_LOAD_IMAGE_COLOR);
        currentMat = srcMat;
        return this;
    }

    public ProcessedImageBuilder withDestination(String file) {
        dstFile = OUTPUT_FOLDER + file;
        return this;
    }

    public ProcessedImageBuilder blur(int size) {
        LOG.info("===> Blur processing started");
        Mat dstMat = new Mat(currentMat.rows(), currentMat.cols(), currentMat.type());
        Imgproc.medianBlur(currentMat, dstMat, size);
        currentMat = dstMat;
        LOG.info("<=== Blur processing finished");
        return this;
    }

    public ProcessedImageBuilder threshold(int threshold) {
        LOG.info("===> Threshold processing started");
        Mat dstMat = new Mat(currentMat.rows(), currentMat.cols(), currentMat.type());
        Imgproc.threshold(currentMat, dstMat, threshold, 255, Imgproc.THRESH_TRUNC);
        currentMat = dstMat;
        LOG.info("<=== Threshold processing finished");
        return this;
    }

    public ProcessedImageBuilder erode() {
        LOG.info("===> Erode processing started");
        Mat dstMat = new Mat(currentMat.rows(), currentMat.cols(), currentMat.type());
        Imgproc.erode(currentMat, dstMat, Imgproc.getStructuringElement(Imgproc.MORPH_CROSS, new Size(3, 3)));
        currentMat = dstMat;
        LOG.info("<=== Erode processing finished");
        return this;
    }

    public void build() {
        File outputFolder = new File(OUTPUT_FOLDER);
        if (!(outputFolder.exists() && outputFolder.isDirectory())) {
            outputFolder.mkdir();
        }
        Imgcodecs.imwrite(dstFile, currentMat);
    }

    public static void main(String[] args) {
        System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);

        new ProcessedImageBuilder()
                .withSource("src/main/resources/salmon_spot.jpg")
                .withDestination("salmon_threshold.jpg")
                .threshold(134)
                .build();

        new ProcessedImageBuilder()
                .withSource("src/main/resources/salmon_spot.jpg")
                .withDestination("salmon_blur.jpg")
                .blur(25)
                .threshold(90)
                .build();

        new ProcessedImageBuilder()
                .withSource("src/main/resources/salmon_spot.jpg")
                .withDestination("salmon_erode.jpg")
                .erode()
                .build();
    }
}

