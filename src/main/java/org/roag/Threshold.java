package org.roag;

import org.opencv.core.Mat;

import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.Date;

/**
 * Created by eurohlam on 11.11.17.
 */

public class Threshold
{

    public static void main(String[] args)
    {

        try
        {
            long starttime=new Date().getTime();
            System.out.println("Start time "+0);
            System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
            Mat source = Imgcodecs.imread("salmon_spot.jpg", Imgcodecs.CV_LOAD_IMAGE_COLOR);
            Mat destination = new Mat(source.rows(), source.cols(), source.type());

            destination = source;
            Imgproc.threshold(source, destination, 100, 255, Imgproc.THRESH_TRUNC);
            Imgcodecs.imwrite("salmon_threshold.jpg", destination);

            long end_time=new Date().getTime();
            System.out.println("End time "+(end_time-starttime));

        }
        catch (Exception e)
        {
            System.out.println("error: " + e.getMessage());
        }
    }
}

