package br.unip.tcc.model;

// <editor-fold defaultstate="collapsed" desc="imports">  
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import static org.opencv.imgproc.Imgproc.MORPH_RECT;
import static org.opencv.imgproc.Imgproc.THRESH_BINARY;
//</editor-fold>

/** Class that does all the images operations in the program.*/
public class ImageOperations {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    private final double HEALTHY_LIMIT = 0.03;
    private final double MIN_DISEASED = 0.07;

    //Yellow color range
    final Scalar LOW_YELLOW = new Scalar(17, 75, 75);//20,100,100
    final Scalar HIGH_YELLOW = new Scalar(27, 255, 255);//30,255,255

    //Green color range
    final Scalar LOW_GREEN = new Scalar(30, 50, 50);
    final Scalar HIGH_GREEN = new Scalar(60, 200, 200);
    //</editor-fold>

    /**
     * Getter of the HEALTHY_LIMIT constant
     *
     * @return Double - the limit in which a plant leaf is considered healthy
     */
    public double getHEALTHY_LIMIT() {
        return HEALTHY_LIMIT;
    }

    /**
     * Getter of the MIN_DISEASED constant
     *
     * @return Double - the minimum amount of infection in which a plant leaf
     * can be considered to be infected
     */
    public double getMIN_DISEASED() {
        return MIN_DISEASED;
    }

    /**
     * Method that returns the equivalent Mat from a file
     *
     * @param file File - the image source file
     * @return Mat - the generated Mat from the file
     */
    public Mat matFromFile(File file) {
        return Imgcodecs.imread(file.getPath());
    }

    /**
     * Method that extracts the saturation channel (HSV colorspace) from a RGB
     * Mat
     *
     * @param mat Mat- the source image in RBG colorspace
     * @return Mat - the saturation channel of the source
     */
    public Mat hsvSaturationChannel(Mat mat) {
        Mat hsv = new Mat();
        ArrayList channels = new ArrayList<>();
        //Change to HSV colorspace and split it
        //Order of the values - [0: hue, 1: saturation, 2: value]
        Imgproc.cvtColor(mat, hsv, Imgproc.COLOR_BGR2HSV);
        Core.split(hsv, channels);
        return (Mat) channels.get(1);
    }

    /**
     * Method that creates a mask according to the darkest shapes of the image.
     * In the case of a plant leaf, it takes the shape of the leaf.
     *
     * @param mat Mat - the source image
     * @return Mat - the generated mask from the source image
     */
    public Mat leafMask(Mat mat) {
        Mat leafMask = new Mat();
        // Make the mask out of its saturation channel for a better contrast
        Imgproc.threshold(hsvSaturationChannel(mat), leafMask, 60, 255, THRESH_BINARY);
        return leafMask;
    }

    /**
     * Method that receives an image and returns the edges of the objects found
     * in the image.
     *
     * @param mat Mat - the source image. For better results its recommended to
     * use the mask made from the source image, which can be obtained through
     * the leafMask method of this class.
     * @return Mat - a binaty Mat with the source image edges, where the
     * background is black and the edges are white.
     */
    public Mat getEdges(Mat mat) {
        Mat edge = new Mat(mat.size(), CvType.CV_8UC1, new Scalar(0, 0, 0));
        //Get the edges out of the mask
        Imgproc.adaptiveThreshold(mat, edge, 255, Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C, THRESH_BINARY, 31, -2);
        //Dilate and Erode for closing contour
        Mat element = Imgproc.getStructuringElement(MORPH_RECT, new Size(5, 5));
        Mat element2 = Imgproc.getStructuringElement(MORPH_RECT, new Size(4, 4));
        Imgproc.dilate(edge, edge, element);
        Imgproc.erode(edge, edge, element2);
        return edge;
    }

    /**
     * Method that returns the contours of the image, in the case of a plant
     * leaf, the countour of the leaf.
     *
     * @param edge Mat - source Mat with the edges of the original image, which
     * can be obtained through the getEdges method of this class.
     * @return MatOfPoint List - a list with the contours of the source image
     */
    public List<MatOfPoint> leafContours(Mat edge) {
        List<MatOfPoint> contour = new ArrayList<>();
        Imgproc.findContours(edge, contour, new Mat(), Imgproc.RETR_EXTERNAL,
                Imgproc.CHAIN_APPROX_NONE);
        return contour;
    }

    /**
     * Method to remove shades in the background of the image. Do not remove a
     * complex background.
     *
     * @param mat Mat - the source image
     * @param edge Mat - the edges of the source image
     * @param leafMask Mat - the mask of the source image
     * @return Mat - the source image in a black background.
     */
    public Mat removeBackground(Mat mat, Mat edge, Mat leafMask) {
        Mat noBackground = new Mat();
        Mat draw = mat.clone();
        List<MatOfPoint> contour = leafContours(edge);
        // Draw contour                    
        Imgproc.drawContours(draw, contour, 0, new Scalar(0, 0, 0), 1);
        // Draw again to cover the line of the contour
        Mat aux = mat.clone();
        Imgproc.drawContours(aux, contour, 0, new Scalar(255, 0, 0), 5);
        Imgproc.drawContours(leafMask, contour, -1, new Scalar(255, 255, 255), -1);

        draw.copyTo(noBackground, leafMask);
        return noBackground;
    }

    /**
     * Method that returns the bounding rectangle of an image through its
     * contour
     *
     * @param contour MatOfPoint List - the source image's contour
     * @return Rect - the bouding rectangle of the source image
     */
    public Rect boundingBox(List<MatOfPoint> contour) {
        Rect box = Imgproc.boundingRect(contour.get(0));
        return box;
    }

    /**
     * Method that returns the bounding rectangle of an image through its
     * contour
     *
     * @param edge Mat - the source image's edge
     * @return Rect- the bouding rectangle of the source image
     */
    public Rect boundingBox(Mat edge) {
        Rect box = Imgproc.boundingRect((MatOfPoint) edge);
        return box;
    }

    /**
     * Method that returns the yellow pixels of an image.
     *
     * @param mat Mat - the source image
     * @return Mat - a binary image in which the white points represents the
     * yellow points of the source image.
     */
    public Mat recognizeYellow(Mat mat) {
        Mat yellowDots = new Mat();
        Imgproc.cvtColor(mat, yellowDots, Imgproc.COLOR_BGR2HSV);
        Core.inRange(yellowDots, LOW_YELLOW, HIGH_YELLOW, yellowDots);
        return yellowDots;
    }

    /**
     * Method that returns the green pixels of an image.
     *
     * @param mat Mat - the source image
     * @return Mat - a binary image in which the white points represents the
     * yellow points of the source image.
     */
    public Mat recognizeGreen(Mat mat) {
        Mat greenDots = new Mat();
        Imgproc.cvtColor(mat, greenDots, Imgproc.COLOR_BGR2HSV);
        Core.inRange(greenDots, LOW_GREEN, HIGH_GREEN, greenDots);
        return greenDots;
    }

    /**
     * Method that counts non zeros pixels of a binary Mat. The sum of those
     * pixels can represent especifics areas of interests.
     *
     * @param mat Mat - a binary Mat
     * @return int - the sum of non black pixels of the image
     */
    public int getArea(Mat mat) {
        return Core.countNonZero(mat);
    }

    /**
     * Method that calculcates the relationship in percentage of an infected
     * leaf area out of the total leaf area.
     *
     * @param leafArea Double - the total area of the leaf image
     * @param infected Double - the pixels classified as infection
     * @return Double - the percentage representing the infection
     */
    public double getAffectedArea(double leafArea, double infected) {
        return ((100 * infected) / leafArea);
    }

    /**
     * Method that resizes an image according to a predefined rect.
     *
     * @param image Mat - the image to be resized.
     * @param box Rect - the area to be resized.
     * @return
     */
    public Mat resize(Mat image, Rect box) {
        return image.submat(box);
    }

    /**
     * Method that rezised an image in a way that the biggest side of it (width
     * or height) is 310 px. It was found to be a good size to not use a lot of
     * memory nor be to small to be processed.
     *
     * @param image Mat - the source image to be resized
     * @return Mat - the resized image
     */
    public Mat resize(Mat image) {
        Mat resizedImage = new Mat();
        int newSize = 310;

        double newWidth, newHeight, originalWidth, originalHeight;
        originalWidth = image.width();
        originalHeight = image.height();

        //Checking for landscape or portrait position
        if (originalWidth > originalHeight) {
            newWidth = newSize;
            newHeight = (originalHeight * newSize) / originalWidth;
        } else {
            newHeight = newSize;
            newWidth = (originalWidth * newSize) / originalHeight;
        }

        Imgproc.resize(image, resizedImage, new Size(newWidth, newHeight));
        return resizedImage;
    }

    /**
     * Method that makes a black background white for a better visualization.
     *
     * @param mat Mat - the source image with the black background
     * @return Mat - the image with the white background
     */
    public Mat makeBgWhite(Mat mat) {
        for (int i = 0; i < mat.rows(); i++) {
            for (int j = 0; j < mat.cols(); j++) {
                double[] temp = mat.get(i, j);
                if ((temp[0] == 0) && (temp[1] == 0) && (temp[2] == 0)) {
                    temp[0] = 240;
                    temp[1] = 240;
                    temp[2] = 240;
                    mat.put(i, j, temp);
                }
            }
        }
        return mat;
    }

    /**
     * Method used to put the yellow pixels in evidence by changing their color
     * to red, for better visualization purposes.
     *
     * @param mat Mat - the source image
     * @param yellow Mat - the binary image with the yellow pixels
     * @return Mat - the source image with the yellow pixels colored red.
     */
    public Mat makeYellowRed(Mat mat, Mat yellow) {
        Mat aux = mat.clone();
        //Imgproc.cvtColor(mat, aux, Imgproc.COLOR_BGR2BGRA);
        double temp2[] = new double[3];
        for (int i = 0; i < mat.rows(); i++) {
            for (int j = 0; j < mat.cols(); j++) {
                double[] temp = yellow.get(i, j);
                if ((temp[0] == 255)) {
                    temp2[0] = 0; //bh
                    temp2[1] = 0; //gs
                    temp2[2] = 255; //rv
                    aux.put(i, j, temp2);
                }
            }
        }
        return aux;
    }
    
    /** Method to make the result of the yellow segmentation be shaped like the 
     * original image.
     * 
     * @param yellow Mat - the result of the yellow segmentation.
     * @param resizedMask Mat - the mask in the shape of the leaf.
     * @return Mat - a binary image, shaped like a leaf, where the white pixels
     * represents the yellow ones.
     */
    public Mat makeYellowView(Mat yellow, Mat resizedMask){
        Mat aux = new Mat(yellow.size(), CvType.CV_8UC1, new Scalar(240, 240, 240));
        yellow.copyTo(aux, resizedMask);
        return aux;
    }
    
}
