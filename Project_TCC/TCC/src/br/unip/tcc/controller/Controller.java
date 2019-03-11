package br.unip.tcc.controller;

// <editor-fold defaultstate="collapsed" desc="Imports">   
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingWorker;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import br.unip.tcc.view.FormView;
import br.unip.tcc.model.ImageOperations;
import br.unip.tcc.model.Information;
import br.unip.tcc.model.Statistics;
import static br.unip.tcc.view.FormView.Code.GREEN;
import static br.unip.tcc.view.FormView.Code.RED;
import static br.unip.tcc.view.FormView.Code.YELLOW;
//</editor-fold>

/**
 * Class responsible for connecting the view with the processing image menuResultsClicked.
 */
public class Controller {

    // <editor-fold defaultstate="collapsed" desc="Variables">   
    ImageOperations image;
    FormView form;
    Statistics stats;
    Information info;
    List<Information> infoList = new ArrayList<>();
    List<Information> healthyList = new ArrayList<>();
    List<Information> uncertainList = new ArrayList<>();
    List<Information> diseasedList = new ArrayList<>();
    List<br.unip.tcc.util.OpenPanel[]> panelList;
    //</editor-fold>

    public Controller(FormView form) {
        image = new ImageOperations();
        this.form = form;
    }

    /**
     * Method that makes all the necessary calls to ImageOperations class for
 the wanted menuResultsClicked, and send these menuResultsClicked to the view. The method uses
     * SwingWorker to process and update the view progress bar.
     *
     * @param files FileList - the uploaded images.
     */
    public void process(List<File> files) {

        SwingWorker worker = new SwingWorker() {

            @Override
            protected Object doInBackground() throws Exception {

                // <editor-fold defaultstate="collapsed" desc="Init Local Variables">      
                Mat aux;
                stats = new Statistics();
                panelList = form.getPanelList();
                infoList = new ArrayList<>();
                healthyList = new ArrayList<>();
                uncertainList = new ArrayList<>();
                diseasedList = new ArrayList<>();
                int infected = 0, uncertain = 0, healthy = 0, i = 0, total = files.size();
                //</editor-fold>

                form.initProgressBar(total);

                for (File file : files) {
                    info = new Information();
                    info.setFile(file);
                    aux = new Mat();
                    Imgproc.GaussianBlur(image.matFromFile(file), aux, new Size(15, 15), 0);
                    info.setOriginal(aux);
                    info.setMask(image.leafMask(info.getOriginal()));
                    info.setEdges(info.getMask());
                    info.setContours(image.leafContours(info.getEdges()));
                    info.setNoBackgroung(image.removeBackground(info.getOriginal(), info.getEdges(), info.getMask()));
                    info.setBoundingBox(image.boundingBox(info.getContours()));
                    info.setProcessed(image.resize(info.getNoBackgroung(), info.getBoundingBox()));
                    info.setResizedMask(image.resize(info.getMask(), info.getBoundingBox()));
                    info.setLeafArea(image.getArea(info.getResizedMask()));
                    info.setYellowMat(image.recognizeYellow(info.getProcessed()));
                    info.setYellowPoints(image.getArea(info.getYellowMat()));
                    info.setInfectedArea(image.getAffectedArea(info.getLeafArea(), info.getYellowPoints()));
                    info.setGreenMat(image.recognizeGreen(info.getProcessed()));
                    info.setProcessedWhite(image.makeBgWhite(info.getProcessed()));
                    //info.setYellowRed(image.makeYellowRed(info.getProcessedWhite(), info.getYellowMat()));
                    info.setYellowRed(image.makeYellowView(info.getYellowMat(), info.getResizedMask()));

                    switch (info.getCode()) {
                        case GREEN:
                            healthyList.add(info);
                            healthy++;
                            break;
                        case YELLOW:
                            uncertainList.add(info);
                            uncertain++;
                            break;
                        case RED:
                            diseasedList.add(info);
                            infected++;
                            break;
                    }
                    infoList.add(info);
                    form.showImages(info, panelList.get(i));
                    form.setImageInformation(info, panelList.get(i));

                    i = i + 1;
                    form.updateBar(i);
                }

                stats.setTotal(total);
                stats.setInfected(infected);
                stats.setUncertain(uncertain);
                stats.setHealthy(healthy);

                form.setGeneralStatistics(stats);
                form.setCurrPanelResults();

                return null;
            }
        };
        worker.execute();
    }

    /**
     * Getter for the information about diseased leaves.
     *
     * @return InformationList
     */
    public List<Information> getDiseasedList() {
        return this.diseasedList;
    }

    /**
     * Getter for the information about uncertain leaves.
     *
     * @return InformationList
     */
    public List<Information> getUncertainList() {
        return this.uncertainList;
    }

    /**
     * Getter for the information about healthy leaves.
     *
     * @return InformationList
     */
    public List<Information> getHealthyList() {
        return this.healthyList;
    }

    /**
     * Getter for the information about all leaves.
     *
     * @return InformationList
     */
    public List<Information> getAllList() {
        return this.infoList;
    }
}
