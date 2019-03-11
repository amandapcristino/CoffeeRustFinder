package br.unip.tcc.model;

import br.unip.tcc.view.FormView.Code;
import static br.unip.tcc.view.FormView.Code.GREEN;
import static br.unip.tcc.view.FormView.Code.RED;
import static br.unip.tcc.view.FormView.Code.YELLOW;
import java.io.File;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import java.awt.Color;

/** Class that contains all the information about the processing menuResultsClicked of each image. */
public class Information {

    // <editor-fold defaultstate="collapsed" desc="Variables"> 
    private File file;
    private Mat original;
    private Mat mask;
    private Mat edges;
    private List<MatOfPoint> contours;
    private Mat noBackgroung;
    private Rect boundingBox;
    private Mat processed;
    private Mat resizedMask;
    private int leafArea;
    private Mat yellowMat;
    private int yellowPoints;
    private double infectedArea;
    private Mat greenMat;
    private Code code;
    private Mat processedWhite;
    private Mat yellowRed;
    private String result;
    private Color color;
    private final double HEALTHY_LIMIT = 0.03;
    private final double MIN_DISEASED = 0.07;
    private final  Color red = new Color(243,210,210);
    private final Color yellow = new Color(238,236,174);
    private final Color green = new Color(201,239,198);
    //</editor-fold>

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Mat getOriginal() {
        return original;
    }

    public void setOriginal(Mat original) {
        this.original = original;
    }

    public Mat getMask() {
        return mask;
    }

    public void setMask(Mat mask) {
        this.mask = mask;
    }

    public Mat getEdges() {
        return edges;
    }

    public void setEdges(Mat edges) {
        this.edges = edges;
    }

    public List<MatOfPoint> getContours() {
        return contours;
    }

    public void setContours(List<MatOfPoint> contours) {
        this.contours = contours;
    }

    public Mat getNoBackgroung() {
        return noBackgroung;
    }

    public void setNoBackgroung(Mat noBackgroung) {
        this.noBackgroung = noBackgroung;
    }

    public Rect getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(Rect boundingBox) {
        this.boundingBox = boundingBox;
    }

    public Mat getProcessed() {
        return processed;
    }

    public void setProcessed(Mat processed) {
        this.processed = processed;
    }

    public Mat getResizedMask() {
        return resizedMask;
    }

    public void setResizedMask(Mat resizedMask) {
        this.resizedMask = resizedMask;
    }

    public int getLeafArea() {
        return leafArea;
    }

    public void setLeafArea(int leafArea) {
        this.leafArea = leafArea;
    }

    public Mat getYellowMat() {
        return yellowMat;
    }

    public void setYellowMat(Mat yellowMat) {
        this.yellowMat = yellowMat;
    }

    public int getYellowPoints() {
        return yellowPoints;
    }

    public void setYellowPoints(int yellowPoints) {
        this.yellowPoints = yellowPoints;
    }

    public double getInfectedArea() {
        return infectedArea;
    }

    public void setInfectedArea(double infectedArea) {
        this.infectedArea = infectedArea;
        if (infectedArea < HEALTHY_LIMIT) {
            code = GREEN;
            result = "SAUDÁVEL";
            color = green;
        } else if (infectedArea >= MIN_DISEASED) {
            code = RED;
            result = "INFECTADA";
            color = red;
        } else {
            code = YELLOW;
            result = "INCERTO";
            color = yellow;
        }
    }

    public Mat getGreenMat() {
        return greenMat;
    }

    public void setGreenMat(Mat greenMat) {
        this.greenMat = greenMat;
    }

    public Code getCode() {
        return code;
    }

    public Mat getProcessedWhite() {
        return processedWhite;
    }

    public void setProcessedWhite(Mat processedWhite) {
        this.processedWhite = processedWhite;
    }

    public Mat getYellowRed() {
        return yellowRed;
    }

    public void setYellowRed(Mat yellowRed) {
        this.yellowRed = yellowRed;
    }

    public String getResult() {
        return result;
    }    

    public Color getColor() {
        return color;
    }    
    
}
