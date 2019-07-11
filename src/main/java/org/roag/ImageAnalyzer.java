package org.roag;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;

import javax.imageio.ImageIO;

/**
 * Created by eurohlam on 11.11.17.
 */
public class ImageAnalyzer {

    BufferedImage image;
    int width;
    int height;

    public ImageAnalyzer() {
        try {
            File input = new File("src/main/resources/salmon_spot.jpg");
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();

            System.out.println("width=" + width + "   height" + height);

            int count = 0;

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {

                    count++;
                    Color c = new Color(image.getRGB(j, i));
                    System.out.println("S.No: " + count + " Red: " + c.getRed() + "  Green: " + c.getGreen() + " Blue: " + c.getBlue());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
