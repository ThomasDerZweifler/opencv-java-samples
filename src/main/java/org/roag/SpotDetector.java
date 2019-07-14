package org.roag;

/**
 * Created by eurohlam on 12.11.17.
 */
public class SpotDetector {

    public void spot() {
        new ProcessedImageBuilder()
                .withSource("src/main/resources/salmon_spot.jpg")
                .withDestination("salmon_contour.jpg")
                .contour()
                .build();
    }
}
