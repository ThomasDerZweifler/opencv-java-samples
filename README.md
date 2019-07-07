# opencv-java-samples

## how to install opencv for MAC using macport

    sudo port selfupdate
    sudo port install opencv +java

Check the installation
    
    port contents opencv | grep java
    
It should show 
    
    /opt/local/share/OpenCV/java/libopencv_java343.dylib
    /opt/local/share/OpenCV/java/opencv-343.jar
    
## how to add opencv support for java application
    
- alternative 1: add libopencv_java343.dylib as Java extension in MAC
 
        cp /opt/local/share/OpenCV/java/libopencv_java343.dylib /Library/Java/Extensions
    
- alternative 2: run application with java.library.path
    
        java -Djava.library.path=/opt/local/share/OpenCV/java