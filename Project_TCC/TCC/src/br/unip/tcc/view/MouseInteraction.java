package br.unip.tcc.view;

// <editor-fold defaultstate="collapsed" desc="Imports">  
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//</editor-fold>

public class MouseInteraction extends MouseAdapter {

    FormView form;
    Color mouseIn = new Color(0, 153, 51);
    Color mouseOut = new Color(0, 128, 43);
    JLabel currClick = null;

    public MouseInteraction(FormView frame) {
        this.form = frame;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        if ((form.carregou)
                || ((!form.carregou) && (label != form.lblResults) && (label != form.lblStatistics))) {
            mouseIn((JLabel) e.getSource());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        if (label != currClick) {
            mouseOut(label);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        if (label == form.lblExit) {
            int response = JOptionPane.showConfirmDialog(null, "Deseja encerrar a aplicação?", "Sair", JOptionPane.OK_CANCEL_OPTION);
            System.out.println(response);   
            if(response == 0){
                System.exit(0);
            }            
        } else {
            setCurrClick(label);
            if (label == form.lblLoad) {
                form.menuLoadClicked();
            } else if (label == form.lblResults) {
                form.menuResultsClicked();
            } else if (label == form.lblStatistics) {
                form.menuStatisticsClicked();
            } else if (label == form.lblCredits) {
                form.menuCreditsClicked();
            } else if (label == form.lblHelp) {
                form.menuHelpClicked();
            }
        }
    }

    private void mouseIn(JLabel label) {
        if (form.currPanel != form.pnProgressBar) {
        label.setBackground(mouseIn);
        }
    }

    private void mouseOut(JLabel label) {
        label.setBackground(mouseOut);
    }

    public void setCurrClick(JLabel label) {
        if (currClick != null) {
            if (form.currPanel != form.pnProgressBar) {
                if ((form.carregou)
                        || ((!form.carregou) && (label != form.lblResults) && (label != form.lblStatistics))) {
                    mouseOut(currClick);
                    currClick = label;
                    mouseIn(currClick);
                }
            }

        } else {
            currClick = label;
        }
    }

}
