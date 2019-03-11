package br.unip.tcc.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import org.opencv.core.Mat;

public class OpenPanel extends JPanel{

    private BufferedImage buf;
    private OpenPanel panel;

    public OpenPanel() {
        super();
        initPanel();
    }        
    
    private void initPanel(){
        this.setDoubleBuffered(true);
        this.setOpaque(false);
        super.setOpaque(false);
        this.setBackground(Color.DARK_GRAY);
    }

    public void setImage(Mat mat) {
        this.buf = Util.toBufferedImage(mat);
        this.repaint();
    }
    
    public OpenPanel getPanel(){
        return panel;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.DARK_GRAY);
        
        //g.setColor(Color.WHITE);
        g.clearRect(0, 0, getWidth(), getHeight());
        if (buf != null) {
            g.drawImage(buf, 0, 0, null);
        }
    }

}
