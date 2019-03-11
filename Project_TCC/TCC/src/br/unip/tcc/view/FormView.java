package br.unip.tcc.view;

// <editor-fold defaultstate="collapsed" desc="Imports">  
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import br.unip.tcc.controller.Controller;
import br.unip.tcc.model.Information;
import br.unip.tcc.model.Statistics;
import br.unip.tcc.util.Util;
import br.unip.tcc.util.OpenPanel;
import java.awt.Dimension;
import java.text.DecimalFormat;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
//</editor-fold>

/**
 * Class with the main visualization frame.
 */
public class FormView extends javax.swing.JFrame {

    public FormView() {
        initComponents();
        formConfig();
    }

    public enum Code {
        RED, YELLOW, GREEN;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pnDrag = new javax.swing.JPanel();
        pnMenu = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblRustFinder = new javax.swing.JLabel();
        lblLoad = new javax.swing.JLabel();
        lblResults = new javax.swing.JLabel();
        lblStatistics = new javax.swing.JLabel();
        lblCredits = new javax.swing.JLabel();
        lblHelp = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        pnlMain = new javax.swing.JPanel();
        pnLoad = new javax.swing.JPanel();
        lblUploadIcon = new javax.swing.JLabel();
        lblSelectImage = new javax.swing.JLabel();
        pnResults = new javax.swing.JPanel();
        cbxFilter = new javax.swing.JComboBox<>();
        lblResultsTitle = new javax.swing.JLabel();
        pnResultsContainer = new javax.swing.JScrollPane();
        pnResultsContent = new javax.swing.JPanel();
        pnStatistics = new javax.swing.JPanel();
        lblStatisticsTitle = new javax.swing.JLabel();
        pnStatsLayout = new javax.swing.JPanel();
        pnInfectedContainer = new javax.swing.JPanel();
        pnInfected = new javax.swing.JPanel();
        lblInfectedText = new javax.swing.JLabel();
        lblInfectedValue = new javax.swing.JLabel();
        pnUncertainContainer = new javax.swing.JPanel();
        pnUncertain = new javax.swing.JPanel();
        lblUncertainText = new javax.swing.JLabel();
        lblUncertainValue = new javax.swing.JLabel();
        pnTotalImagesContainer = new javax.swing.JPanel();
        pnHealthyLeaves = new javax.swing.JPanel();
        lblHealthyText = new javax.swing.JLabel();
        lblHealthyValue = new javax.swing.JLabel();
        pnHealthyContainer = new javax.swing.JPanel();
        pnTotalImages = new javax.swing.JPanel();
        lblTotalText = new javax.swing.JLabel();
        lblTotalValue = new javax.swing.JLabel();
        pnCredits = new javax.swing.JPanel();
        lblHelpTitle1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnNoResults = new javax.swing.JPanel();
        lblEmptyText = new javax.swing.JLabel();
        lblEmptyBoxIcon = new javax.swing.JLabel();
        pnHelp = new javax.swing.JPanel();
        lblHelpTitle = new javax.swing.JLabel();
        lblHelpText = new javax.swing.JLabel();
        pnProgressBar = new javax.swing.JPanel();
        pgbProgressBar = new javax.swing.JProgressBar();
        lblProcessing = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnDrag.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        pnDrag.setOpaque(false);

        javax.swing.GroupLayout pnDragLayout = new javax.swing.GroupLayout(pnDrag);
        pnDrag.setLayout(pnDragLayout);
        pnDragLayout.setHorizontalGroup(
            pnDragLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        pnDragLayout.setVerticalGroup(
            pnDragLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        getContentPane().add(pnDrag, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 20));

        pnMenu.setBackground(new java.awt.Color(0, 128, 43));
        pnMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unip/tcc/images/imageLogo.png"))); // NOI18N
        pnMenu.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 120));

        lblRustFinder.setBackground(new java.awt.Color(0, 128, 43));
        lblRustFinder.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblRustFinder.setForeground(new java.awt.Color(255, 255, 255));
        lblRustFinder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRustFinder.setText("RustFinder");
        lblRustFinder.setOpaque(true);
        pnMenu.add(lblRustFinder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 180, 39));

        lblLoad.setBackground(new java.awt.Color(0, 128, 43));
        lblLoad.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblLoad.setForeground(new java.awt.Color(255, 255, 255));
        lblLoad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unip/tcc/images/iconLoadMenu.png"))); // NOI18N
        lblLoad.setText("  Carregar");
        lblLoad.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 35, 1, 1));
        lblLoad.setOpaque(true);
        pnMenu.add(lblLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 180, 39));

        lblResults.setBackground(new java.awt.Color(0, 128, 43));
        lblResults.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblResults.setForeground(new java.awt.Color(186, 186, 186));
        lblResults.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblResults.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unip/tcc/images/iconResultsMenu.png"))); // NOI18N
        lblResults.setText("  Resultados");
        lblResults.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 35, 1, 1));
        lblResults.setOpaque(true);
        pnMenu.add(lblResults, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 180, 39));

        lblStatistics.setBackground(new java.awt.Color(0, 128, 43));
        lblStatistics.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblStatistics.setForeground(new java.awt.Color(186, 186, 186));
        lblStatistics.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblStatistics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unip/tcc/images/iconStatisticsMenu.png"))); // NOI18N
        lblStatistics.setText("  Estatísticas");
        lblStatistics.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 35, 1, 1));
        lblStatistics.setOpaque(true);
        pnMenu.add(lblStatistics, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 180, 39));

        lblCredits.setBackground(new java.awt.Color(0, 128, 43));
        lblCredits.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblCredits.setForeground(new java.awt.Color(255, 255, 255));
        lblCredits.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCredits.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unip/tcc/images/iconCreditsMenu.png"))); // NOI18N
        lblCredits.setText("  Créditos");
        lblCredits.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 35, 1, 1));
        lblCredits.setOpaque(true);
        pnMenu.add(lblCredits, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 180, 39));

        lblHelp.setBackground(new java.awt.Color(0, 128, 43));
        lblHelp.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblHelp.setForeground(new java.awt.Color(255, 255, 255));
        lblHelp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unip/tcc/images/iconHelpMenu.png"))); // NOI18N
        lblHelp.setText("  Ajuda");
        lblHelp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 35, 1, 1));
        lblHelp.setOpaque(true);
        pnMenu.add(lblHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 180, 39));

        lblExit.setBackground(new java.awt.Color(0, 128, 43));
        lblExit.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblExit.setForeground(new java.awt.Color(255, 255, 255));
        lblExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unip/tcc/images/iconExitMenu.png"))); // NOI18N
        lblExit.setText(" Sair");
        lblExit.setOpaque(true);
        pnMenu.add(lblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 180, 40));

        getContentPane().add(pnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, -1));

        pnlMain.setLayout(new java.awt.CardLayout());

        pnLoad.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblUploadIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUploadIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unip/tcc/images/iconLoadPanel.png"))); // NOI18N

        lblSelectImage.setBackground(new java.awt.Color(51, 51, 51));
        lblSelectImage.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblSelectImage.setForeground(new java.awt.Color(51, 51, 51));
        lblSelectImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSelectImage.setText("Carregue uma imagem para começar");

        javax.swing.GroupLayout pnLoadLayout = new javax.swing.GroupLayout(pnLoad);
        pnLoad.setLayout(pnLoadLayout);
        pnLoadLayout.setHorizontalGroup(
            pnLoadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLoadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnLoadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUploadIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSelectImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnLoadLayout.setVerticalGroup(
            pnLoadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLoadLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(lblUploadIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSelectImage, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(253, Short.MAX_VALUE))
        );

        pnlMain.add(pnLoad, "card2");

        pnResults.setLayout(null);

        cbxFilter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbxFilter.setMaximumRowCount(4);
        cbxFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Saudáveis", "Incertezas", "Infectadas", "Todas" }));
        cbxFilter.setSelectedIndex(3);
        cbxFilter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxFilterItemStateChanged(evt);
            }
        });
        pnResults.add(cbxFilter);
        cbxFilter.setBounds(490, 40, 100, 30);

        lblResultsTitle.setFont(new java.awt.Font("Gisha", 0, 30)); // NOI18N
        lblResultsTitle.setForeground(new java.awt.Color(51, 51, 51));
        lblResultsTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultsTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unip/tcc/images/iconResultsTitle.png"))); // NOI18N
        lblResultsTitle.setText(" Resultados");
        pnResults.add(lblResultsTitle);
        lblResultsTitle.setBounds(0, 30, 640, 60);

        pnResultsContainer.setBorder(null);

        pnResultsContent.setOpaque(false);

        javax.swing.GroupLayout pnResultsContentLayout = new javax.swing.GroupLayout(pnResultsContent);
        pnResultsContent.setLayout(pnResultsContentLayout);
        pnResultsContentLayout.setHorizontalGroup(
            pnResultsContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1168, Short.MAX_VALUE)
        );
        pnResultsContentLayout.setVerticalGroup(
            pnResultsContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 867, Short.MAX_VALUE)
        );

        pnResultsContainer.setViewportView(pnResultsContent);

        pnResults.add(pnResultsContainer);
        pnResultsContainer.setBounds(20, 101, 610, 370);

        pnlMain.add(pnResults, "card3");

        pnStatistics.setBackground(new java.awt.Color(237, 237, 237));

        lblStatisticsTitle.setFont(new java.awt.Font("Gisha", 0, 30)); // NOI18N
        lblStatisticsTitle.setForeground(new java.awt.Color(51, 51, 51));
        lblStatisticsTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatisticsTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unip/tcc/images/iconStatisticsTitle.png"))); // NOI18N
        lblStatisticsTitle.setText("  Análise Geral");

        pnStatsLayout.setBackground(new java.awt.Color(237, 237, 237));
        pnStatsLayout.setMaximumSize(new java.awt.Dimension(564, 283));
        pnStatsLayout.setMinimumSize(new java.awt.Dimension(564, 283));

        pnInfectedContainer.setBackground(new java.awt.Color(237, 237, 237));
        pnInfectedContainer.setMaximumSize(new java.awt.Dimension(564, 52));
        pnInfectedContainer.setMinimumSize(new java.awt.Dimension(564, 52));
        pnInfectedContainer.setPreferredSize(new java.awt.Dimension(564, 52));
        pnInfectedContainer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        pnInfected.setBackground(new java.awt.Color(239, 203, 203));
        pnInfected.setMaximumSize(new java.awt.Dimension(564, 52));
        pnInfected.setMinimumSize(new java.awt.Dimension(264, 52));
        pnInfected.setPreferredSize(new java.awt.Dimension(564, 52));

        lblInfectedText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblInfectedText.setForeground(new java.awt.Color(51, 51, 51));
        lblInfectedText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblInfectedText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unip/tcc/images/iconStatisticsInfected.png"))); // NOI18N
        lblInfectedText.setText(" Folhas Infectadas");
        lblInfectedText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));

        lblInfectedValue.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblInfectedValue.setForeground(new java.awt.Color(51, 51, 51));
        lblInfectedValue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblInfectedValue.setText("0");
        lblInfectedValue.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));

        javax.swing.GroupLayout pnInfectedLayout = new javax.swing.GroupLayout(pnInfected);
        pnInfected.setLayout(pnInfectedLayout);
        pnInfectedLayout.setHorizontalGroup(
            pnInfectedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfectedLayout.createSequentialGroup()
                .addComponent(lblInfectedText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 347, Short.MAX_VALUE)
                .addComponent(lblInfectedValue)
                .addContainerGap())
        );
        pnInfectedLayout.setVerticalGroup(
            pnInfectedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfectedLayout.createSequentialGroup()
                .addGroup(pnInfectedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInfectedValue, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInfectedText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pnInfectedContainer.add(pnInfected);

        pnUncertainContainer.setBackground(new java.awt.Color(237, 237, 237));
        pnUncertainContainer.setMaximumSize(new java.awt.Dimension(564, 52));
        pnUncertainContainer.setMinimumSize(new java.awt.Dimension(564, 52));
        pnUncertainContainer.setPreferredSize(new java.awt.Dimension(564, 52));
        pnUncertainContainer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        pnUncertain.setBackground(new java.awt.Color(235, 233, 162));
        pnUncertain.setMaximumSize(new java.awt.Dimension(564, 52));
        pnUncertain.setMinimumSize(new java.awt.Dimension(264, 52));
        pnUncertain.setPreferredSize(new java.awt.Dimension(564, 52));

        lblUncertainText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblUncertainText.setForeground(new java.awt.Color(51, 51, 51));
        lblUncertainText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUncertainText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unip/tcc/images/iconStatisticsUncertain.png"))); // NOI18N
        lblUncertainText.setText(" Incertezas");
        lblUncertainText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));

        lblUncertainValue.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblUncertainValue.setForeground(new java.awt.Color(51, 51, 51));
        lblUncertainValue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUncertainValue.setText("0");
        lblUncertainValue.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));

        javax.swing.GroupLayout pnUncertainLayout = new javax.swing.GroupLayout(pnUncertain);
        pnUncertain.setLayout(pnUncertainLayout);
        pnUncertainLayout.setHorizontalGroup(
            pnUncertainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUncertainLayout.createSequentialGroup()
                .addComponent(lblUncertainText, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
                .addComponent(lblUncertainValue)
                .addContainerGap())
        );
        pnUncertainLayout.setVerticalGroup(
            pnUncertainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUncertainLayout.createSequentialGroup()
                .addGroup(pnUncertainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUncertainText, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUncertainValue, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );

        pnUncertainContainer.add(pnUncertain);

        pnTotalImagesContainer.setBackground(new java.awt.Color(237, 237, 237));
        pnTotalImagesContainer.setMaximumSize(new java.awt.Dimension(564, 52));
        pnTotalImagesContainer.setMinimumSize(new java.awt.Dimension(564, 52));
        pnTotalImagesContainer.setPreferredSize(new java.awt.Dimension(564, 52));
        pnTotalImagesContainer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        pnHealthyLeaves.setBackground(new java.awt.Color(183, 233, 179));
        pnHealthyLeaves.setMaximumSize(new java.awt.Dimension(564, 52));
        pnHealthyLeaves.setMinimumSize(new java.awt.Dimension(264, 52));
        pnHealthyLeaves.setPreferredSize(new java.awt.Dimension(564, 52));

        lblHealthyText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblHealthyText.setForeground(new java.awt.Color(51, 51, 51));
        lblHealthyText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblHealthyText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unip/tcc/images/iconStatisticsHealthy.png"))); // NOI18N
        lblHealthyText.setText(" Folhas Saudáveis");
        lblHealthyText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));

        lblHealthyValue.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblHealthyValue.setForeground(new java.awt.Color(51, 51, 51));
        lblHealthyValue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHealthyValue.setText("0");
        lblHealthyValue.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));

        javax.swing.GroupLayout pnHealthyLeavesLayout = new javax.swing.GroupLayout(pnHealthyLeaves);
        pnHealthyLeaves.setLayout(pnHealthyLeavesLayout);
        pnHealthyLeavesLayout.setHorizontalGroup(
            pnHealthyLeavesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHealthyLeavesLayout.createSequentialGroup()
                .addComponent(lblHealthyText, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
                .addComponent(lblHealthyValue)
                .addContainerGap())
        );
        pnHealthyLeavesLayout.setVerticalGroup(
            pnHealthyLeavesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHealthyLeavesLayout.createSequentialGroup()
                .addGroup(pnHealthyLeavesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHealthyText, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHealthyValue, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        pnTotalImagesContainer.add(pnHealthyLeaves);

        pnHealthyContainer.setBackground(new java.awt.Color(237, 237, 237));
        pnHealthyContainer.setMaximumSize(new java.awt.Dimension(564, 52));
        pnHealthyContainer.setMinimumSize(new java.awt.Dimension(564, 52));
        pnHealthyContainer.setPreferredSize(new java.awt.Dimension(564, 52));
        pnHealthyContainer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        pnTotalImages.setBackground(new java.awt.Color(191, 198, 205));
        pnTotalImages.setMaximumSize(new java.awt.Dimension(564, 52));
        pnTotalImages.setMinimumSize(new java.awt.Dimension(264, 52));
        pnTotalImages.setPreferredSize(new java.awt.Dimension(564, 52));

        lblTotalText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblTotalText.setForeground(new java.awt.Color(51, 51, 51));
        lblTotalText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTotalText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unip/tcc/images/iconStatisticsAnalysed.png"))); // NOI18N
        lblTotalText.setText(" Imagens Analisadas");
        lblTotalText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 5));

        lblTotalValue.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblTotalValue.setForeground(new java.awt.Color(51, 51, 51));
        lblTotalValue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalValue.setText("0");
        lblTotalValue.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));

        javax.swing.GroupLayout pnTotalImagesLayout = new javax.swing.GroupLayout(pnTotalImages);
        pnTotalImages.setLayout(pnTotalImagesLayout);
        pnTotalImagesLayout.setHorizontalGroup(
            pnTotalImagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTotalImagesLayout.createSequentialGroup()
                .addComponent(lblTotalText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 334, Short.MAX_VALUE)
                .addComponent(lblTotalValue)
                .addContainerGap())
        );
        pnTotalImagesLayout.setVerticalGroup(
            pnTotalImagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTotalImagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblTotalText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblTotalValue, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnHealthyContainer.add(pnTotalImages);

        javax.swing.GroupLayout pnStatsLayoutLayout = new javax.swing.GroupLayout(pnStatsLayout);
        pnStatsLayout.setLayout(pnStatsLayoutLayout);
        pnStatsLayoutLayout.setHorizontalGroup(
            pnStatsLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnStatsLayoutLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnStatsLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnInfectedContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnUncertainContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnTotalImagesContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnHealthyContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        pnStatsLayoutLayout.setVerticalGroup(
            pnStatsLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnStatsLayoutLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(pnInfectedContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pnUncertainContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pnTotalImagesContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pnHealthyContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnStatisticsLayout = new javax.swing.GroupLayout(pnStatistics);
        pnStatistics.setLayout(pnStatisticsLayout);
        pnStatisticsLayout.setHorizontalGroup(
            pnStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnStatisticsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStatisticsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnStatisticsLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(pnStatsLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        pnStatisticsLayout.setVerticalGroup(
            pnStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnStatisticsLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblStatisticsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(pnStatsLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pnlMain.add(pnStatistics, "card4");

        pnCredits.setBackground(new java.awt.Color(237, 237, 237));
        pnCredits.setLayout(null);

        lblHelpTitle1.setFont(new java.awt.Font("Gisha", 0, 30)); // NOI18N
        lblHelpTitle1.setForeground(new java.awt.Color(51, 51, 51));
        lblHelpTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHelpTitle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unip/tcc/images/iconCreditsTitle.png"))); // NOI18N
        lblHelpTitle1.setText(" Créditos");
        pnCredits.add(lblHelpTitle1);
        lblHelpTitle1.setBounds(10, 36, 620, 50);

        jLabel1.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(90, 90, 90));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html>Os ícones utilizados nesta aplicação foram cedidos por www.flaticon.com, pelos seguintes colaboradores:</html>");
        pnCredits.add(jLabel1);
        jLabel1.setBounds(70, 110, 510, 40);

        jLabel2.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(90, 90, 90));
        jLabel2.setText("<html>\n\n<b>Ocha </b><br>\n•  Ícone do logo <br><br>\n\n<b>Smashicons</b><br>\n•  Ícone das imagens analisadas<br><br>\n\n<b>Vignesh Oviyan</b><br>\n•  Ícone do menu resultados<br><br>\n\n<b>Zlatko Najdenovski</b><br>\n•  Ícone do menu sair<br><br>\n\n\n</html>");
        pnCredits.add(jLabel2);
        jLabel2.setBounds(350, 170, 200, 220);

        jLabel3.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(90, 90, 90));
        jLabel3.setText("<html>\n<b>Baianat</b>  <br>\n•  Ícones do menu créditos<br><br>\n\n<b>Chris Veigt</b> <br>\n•  Ícones do menu ajuda<br><br>\n\n<b>Freepik</b><br>\n•  Ícone do menu carregar <br>\n•  Ícones do menu estatísticas<br>\n•  Imagens infectadas<br>\n•  Incertezas<br>\n•  Imagens saudáveis<br>\n\n</html>");
        pnCredits.add(jLabel3);
        jLabel3.setBounds(90, 170, 200, 220);

        pnlMain.add(pnCredits, "card5");

        lblEmptyText.setBackground(new java.awt.Color(51, 51, 51));
        lblEmptyText.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblEmptyText.setForeground(new java.awt.Color(51, 51, 51));
        lblEmptyText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmptyText.setText("Carregue uma imagem para começar...");

        lblEmptyBoxIcon.setForeground(new java.awt.Color(240, 240, 240));
        lblEmptyBoxIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmptyBoxIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unip/tcc/images/iconResultsEmpty.png"))); // NOI18N

        javax.swing.GroupLayout pnNoResultsLayout = new javax.swing.GroupLayout(pnNoResults);
        pnNoResults.setLayout(pnNoResultsLayout);
        pnNoResultsLayout.setHorizontalGroup(
            pnNoResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNoResultsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnNoResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmptyText, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addComponent(lblEmptyBoxIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnNoResultsLayout.setVerticalGroup(
            pnNoResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNoResultsLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(lblEmptyBoxIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmptyText, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(258, Short.MAX_VALUE))
        );

        pnlMain.add(pnNoResults, "card7");

        lblHelpTitle.setFont(new java.awt.Font("Gisha", 0, 30)); // NOI18N
        lblHelpTitle.setForeground(new java.awt.Color(51, 51, 51));
        lblHelpTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHelpTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unip/tcc/images/iconHelpTitle.png"))); // NOI18N
        lblHelpTitle.setText("  Ajuda");

        lblHelpText.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        lblHelpText.setForeground(new java.awt.Color(90, 90, 90));
        lblHelpText.setText("<html><head></head><body>\nEsta aplicação tem como objetivo auxiliar na identificação do fungo Hemileia vastatrix (causador da ferrugem) em imagens de folhas de café.<br><br>\n  •  Para começar, adicione uma foto de uma folha de café que possa ter a doença no menu carregar. A foto da folha deverá ser tirada contra um fundo branco ou neutro. Pode-se adicionar mais de uma imagem por vez.<br><br>\n  •  Depois que a imagem for carregada, os resultados individuais parecerão no menu resultados.<br><br>\n  •  Os resultados gerais aparecerão no menu estatísticas. <br><br>\n</body><html>");
        lblHelpText.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));

        javax.swing.GroupLayout pnHelpLayout = new javax.swing.GroupLayout(pnHelp);
        pnHelp.setLayout(pnHelpLayout);
        pnHelpLayout.setHorizontalGroup(
            pnHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHelpLayout.createSequentialGroup()
                .addGroup(pnHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHelpLayout.createSequentialGroup()
                        .addComponent(lblHelpTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHelpLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblHelpText, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnHelpLayout.setVerticalGroup(
            pnHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHelpLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblHelpTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHelpText, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        pnlMain.add(pnHelp, "card2");

        pgbProgressBar.setForeground(new java.awt.Color(153, 0, 0));

        lblProcessing.setBackground(new java.awt.Color(51, 51, 51));
        lblProcessing.setFont(new java.awt.Font("Gisha", 0, 18)); // NOI18N
        lblProcessing.setForeground(new java.awt.Color(51, 51, 51));
        lblProcessing.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProcessing.setText("Processando...");

        javax.swing.GroupLayout pnProgressBarLayout = new javax.swing.GroupLayout(pnProgressBar);
        pnProgressBar.setLayout(pnProgressBarLayout);
        pnProgressBarLayout.setHorizontalGroup(
            pnProgressBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProgressBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnProgressBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnProgressBarLayout.createSequentialGroup()
                        .addComponent(lblProcessing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnProgressBarLayout.createSequentialGroup()
                        .addGap(0, 65, Short.MAX_VALUE)
                        .addComponent(pgbProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))))
        );
        pnProgressBarLayout.setVerticalGroup(
            pnProgressBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProgressBarLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(lblProcessing, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pgbProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );

        pnlMain.add(pnProgressBar, "card8");

        getContentPane().add(pnlMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 640, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFilterItemStateChanged
        int item = cbxFilter.getSelectedIndex();

        List<Information> list;

        switch (item) {
            case 0:
                list = results.getHealthyList();
                break;
            case 1:
                list = results.getUncertainList();
                break;
            case 2:
                list = results.getDiseasedList();
                break;
            default:
                list = results.getAllList();
                break;
        }

        createPanels(list.size());
        //setContentSize();

        int i = 0;
        for (Information info : list) {
            showImages(info, panelList.get(i));
            setImageInformation(info, panelList.get(i++));
        }

    }//GEN-LAST:event_cbxFilterItemStateChanged

    // <editor-fold defaultstate="collapsed" desc="Menu Click Actions">  
    /**
     * Method for load button click.
     */
    public void menuLoadClicked() {
        if (currPanel != pnProgressBar) {
            canceled = false;

            //<editor-fold defaultstate="collapsed" desc="File Chooser Call">  
            FileChooser dialog = new FileChooser(new javax.swing.JFrame(), true, this);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    canceled = true;
                    dialog.dispose();
                }
            });
            dialog.setVisible(true);
            //</editor-fold>

            if (!canceled) {

                cbxFilter.setSelectedIndex(3);
                ArrayList<File> files = dialog.files;
                if (files.size() > 0) {
                    createPanels(files.size());

                    results.process(files);

                    if (!carregou) {
                        lblResults.setForeground(new Color(255, 255, 255));
                        lblStatistics.setForeground(new Color(255, 255, 255));
                        carregou = true;
                    }

                    mouseEvents.setCurrClick(lblResults);

                }
            }
        }
    }

    /**
     * Method fot results button click.
     */
    public void menuResultsClicked() {
        if (currPanel != pnProgressBar) {
            if (carregou) {
                setCurrPanel(pnResults);
            }
        }
    }

    /**
     * Methods for statistics click.
     */
    public void menuStatisticsClicked() {
        if (currPanel != pnProgressBar) {
            if (carregou) {
                setCurrPanel(pnStatistics);
            }
        }
    }

    /**
     * Method for credits click.
     */
    public void menuCreditsClicked() {
        if (currPanel != pnProgressBar) {
            setCurrPanel(pnCredits);
        }
    }

    /**
     * Method for help click.
     */
    public void menuHelpClicked() {
        if (currPanel != pnProgressBar) {
            setCurrPanel(pnHelp);
        }
    }

    /**
     * Method to set canceled flag.
     */
    public void setCanceledOperation() {
        this.canceled = true;
    }

    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="ProgressBar Settings">  
    /**
     * Method that initialize the progress bar with the number of loaded files.
     *
     * @param max int - number of loaded files.
     */
    public void initProgressBar(int max) {
        pgbProgressBar.setMinimum(0);
        pgbProgressBar.setMaximum(max);
        pgbProgressBar.setValue(0);
        setCurrPanel(pnProgressBar);
    }

    /**
     * Method for updating the progress bar.
     *
     * @param newValue
     */
    public void updateBar(int newValue) {
        pgbProgressBar.setValue(newValue);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Changing Panel Settings">  
    /**
     * Set the inicial configurations of the panels.
     */
    public void initPanels() {
        pnLoad.setVisible(true);
        pnProgressBar.setVisible(false);
        pnStatistics.setVisible(false);
        pnCredits.setVisible(false);
        pnResults.setVisible(false);
        pnNoResults.setVisible(false);
        pnHelp.setVisible(false);
    }

    /**
     * Selects the menuResultsClicked panel to be displayed.
     */
    public void setCurrPanelResults() {
        setCurrPanel(pnResults);
    }

    /**
     * Sets the current selected panel.
     *
     * @param panel
     */
    public void setCurrPanel(JPanel panel) {
        if (currPanel != null) {
            if (panel == this.pnResults) {
            }
            currPanel.setVisible(false);
            currPanel = panel;
            currPanel.setVisible(true);
        } else {
            currPanel = panel;
            currPanel.setVisible(true);
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Results Setters and Display">  
    /**
     * Setter for the general menuStatisticsClicked.
     *
     * @param stats Statistics
     */
    public void setGeneralStatistics(Statistics stats) {
        int total = stats.getTotal();
        int infected = stats.getInfected();
        int uncertain = stats.getUncertain();
        int healthy = stats.getHealthy();

        lblTotalValue.setText(String.valueOf(total));
        lblInfectedValue.setText(String.valueOf(infected));
        lblUncertainValue.setText(String.valueOf(uncertain));
        lblHealthyValue.setText(String.valueOf(healthy));
        setStatisticsBar(total, infected, uncertain, healthy);
    }

    /**
     * Setter for the menuStatisticsClicked bars values.
     *
     * @param total int - sum of loaded images.
     * @param diseased int - sum of diseased images .
     * @param doubt int - sum of uncertain resulted images.
     * @param healthy int - sum of healthy images.
     */
    public void setStatisticsBar(int total, int diseased, int doubt, int healthy) {
        int diseasedVal = (diseased == 0) ? 0 : ((diseased * 100) / total);
        int doubtVal = (doubt == 0) ? 0 : ((doubt * 100) / total);
        int healthyVal = (healthy == 0) ? 0 : ((healthy * 100) / total);

        doubtVal = (264 + (3 * doubtVal));
        diseasedVal = (264 + (3 * diseasedVal));
        healthyVal = (264 + (3 * healthyVal));

        pnUncertain.setSize(new Dimension(doubtVal, 52));
        pnUncertain.setPreferredSize(new Dimension(doubtVal, 52));
        pnUncertain.setMaximumSize(new Dimension(doubtVal, 52));

        pnInfected.setSize(new Dimension(diseasedVal, 52));
        pnInfected.setPreferredSize(new Dimension(diseasedVal, 52));
        pnInfected.setMaximumSize(new Dimension(diseasedVal, 52));

        pnHealthyLeaves.setSize(new Dimension(healthyVal, 52));
        pnHealthyLeaves.setPreferredSize(new Dimension(healthyVal, 52));
        pnHealthyLeaves.setMaximumSize(new Dimension(healthyVal, 52));
    }

    /**
     * Method that sets the specifics image's information.
     *
     * @param info Information - images info.
     * @param panels PanelList - panels in which the information will be
     * displayed.
     */
    public void setImageInformation(Information info, OpenPanel[] panels) {
        DecimalFormat df = new DecimalFormat("0.00#");
        FormView.addInfo(panels[2], info.getResult(), info.getColor(), info.getFile().getName(),
                String.valueOf(info.getLeafArea()) + " px", String.valueOf(info.getYellowPoints())
                + " px", df.format(info.getInfectedArea()) + " %");
    }

    /**
     * Method that display the received images in the menuResultsClicked panel.
     *
     * @param info Information - images info.
     * @param panels Panel - panel in which the images will be displayed.
     */
    public void showImages(Information info, OpenPanel[] panels) {
        Util.exibirImagem(panels[0], resize4Pannel(info.getProcessedWhite(), panels[0].getPreferredSize()));
        Util.exibirImagem(panels[1], resize4Pannel(info.getYellowRed(), panels[1].getPreferredSize()));
    }

    /**
     * Method that resizes the images to be displayed in a specific panel.
     *
     * @param image Mat - image to be displayed.
     * @param panelSize Dimension - the size of the panel.
     * @return Mat - the resized image.
     */
    public Mat resize4Pannel(Mat image, Dimension panelSize) {
        Mat aux = new Mat(new Size(panelSize.width, panelSize.height), image.type(), new Scalar(240, 240, 240));
        Mat resizedImage = new Mat();
        double imageWidth = image.width();
        double imageHeight = image.height();
        double var = imageHeight / imageWidth;
        double newWidth, newHeight;

        if (var >= 2) {
            newHeight = panelSize.height - 10;
            newWidth = ((imageWidth * newHeight) / imageHeight);
        } else {
            newWidth = panelSize.width - 10;
            newHeight = ((imageHeight * newWidth) / imageWidth);
        }
        Imgproc.resize(image, resizedImage, new Size(newWidth, newHeight));
        double paddingWidth = (panelSize.width - resizedImage.width()) / 2;

        Rect rect = new Rect((int) paddingWidth, 5, resizedImage.width(), resizedImage.height());
        resizedImage.copyTo(aux.submat(rect));

        return aux;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Results Panel: Creation and Settings">  
    /**
     * Method that dynamically creates the panels for the menuResultsClicked
     * visualization.
     *
     * @param num int - number of panels to be created.
     */
    private void createPanels(int num) {
        panelList = new ArrayList();
        pnResultsContent.removeAll();
        pnResultsContent.revalidate();
        pnResultsContent.repaint();

        int vGap = 30; // vertical distance between panels
        int hGap = 10; // horizontal distance of each panel

        // For each result, create 3 panels: original image, result image and information
        for (int i = 0; i < num; i++) {
            int elements = panelList.size();
            int pos_height = 10 + (elements * (260 + vGap));
            int width = 130; // panel width
            int height = 260; // panel height
            int info_width = 280; // information panel width
            OpenPanel[] panelRow = new OpenPanel[3];

            // Painel 1 : for original image
            panelRow[0] = new OpenPanel();
            pnResultsContent.add(panelRow[0]);
            panelRow[0].setSize(width, height);
            panelRow[0].setPreferredSize(new Dimension(width, height));
            panelRow[0].setLocation(hGap, pos_height);
            panelRow[0].setVisible(true);

            // Painel 2 : for result image
            panelRow[1] = new OpenPanel();
            pnResultsContent.add(panelRow[1]);
            panelRow[1].setSize(width, height);
            panelRow[1].setPreferredSize(new Dimension(width, height));
            panelRow[1].setLocation(2 * hGap + width, pos_height);
            panelRow[1].setVisible(true);

            // Painel 3 : for image information
            panelRow[2] = new OpenPanel();
            pnResultsContent.add(panelRow[2]);
            panelRow[2].setSize(info_width, height + 5);
            panelRow[2].setPreferredSize(new Dimension(info_width, height + 5));
            panelRow[2].setLocation((3 * hGap + 2 * width), pos_height - 5);
            panelRow[2].setVisible(true);

            panelList.add(panelRow);
        }
        setContentSize(vGap);
    }

    /**
     * Method that sets the right size for the menuResultsClicked content panel
     * according to the quantity of images loaded.
     *
     * @param vGap int - vertical space between the panels to be added to the
     * sum of the panel height.
     */
    public void setContentSize(int vGap) {
        int size = panelList.size();
        int panelHeight = 260 + vGap;
        pnResultsContent.setSize(560, size * panelHeight);
        pnResultsContent.setPreferredSize(new Dimension(560, size * panelHeight));
        pnResultsContent.setMinimumSize(new Dimension(560, size * panelHeight));
        pnResultsContent.setMaximumSize(new Dimension(560, size * panelHeight));
        pnResultsContent.setBackground(new Color(255, 255, 255));
    }

    /**
     * Method that sets the informations of each image in the menuResultsClicked
     * panel.
     *
     * @param container Panel - the panel where the information is to be written.
     * @param resultValue String - the diagnosis of the detection.
     * @param color Color - the color correspondent to resultValue.
     * @param fileName String - the name of the loaded image.
     * @param leafArea String - the area of the leaf.
     * @param infectedPoints String - the amout of yellow pixels found.
     * @param infectedArea String - the relation of yellow pixels and total
     * area.
     */
    public static void addInfo(OpenPanel container, String resultValue, Color color,
            String fileName, String leafArea, String infectedPoints, String infectedArea) {

        FlowLayout customFlow = new FlowLayout();
        customFlow.setVgap(0);
        container.setLayout(customFlow);
        container.setVisible(true);
        
        JPanel info = new JPanel();
        info.setVisible(true);
        info.setLocation(0,0);
        info.setOpaque(true);
        info.setBackground(new Color(240,240,240));
        info.setPreferredSize(container.getPreferredSize());
        container.add(info);
        
        FlowLayout flow = new FlowLayout(FlowLayout.LEFT);
        flow.setHgap(0);
        flow.setVgap(5);
        info.setLayout(flow);

        JLabel result = new JLabel(resultValue);
        result.setSize(new Dimension(280, 60));
        result.setPreferredSize(new Dimension(280, 60));
        result.setOpaque(true);
        result.setBackground(color);
        result.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        result.setLocation(0, 0);
        result.setFont(new java.awt.Font("Candara", 0, 18));

        info.add(result);
        info.add(setInfoPanel("Nome do Arquivo", fileName));
        info.add(setInfoPanel("Área Foliar", leafArea));
        info.add(setInfoPanel("Pontos de Doença", infectedPoints));
        info.add(setInfoPanel("Área Afetada", infectedArea));
    }

    /**
     * Method that creates the subpanels of informations.
     *
     * @param description String - the reference of what the panel indicates.
     * @param value String - the result value to be put in the panel.
     * @return JPanel - the formatted subpanel of information.
     */
    static JPanel setInfoPanel(String description, String value) {
        int panelWidth = 280;
        int panelHeight = 45;
        int labelHeight = 15;

        JPanel pnPanel = new JPanel();
        pnPanel.setPreferredSize(new Dimension(panelWidth, panelHeight));
        pnPanel.setLocation(70, 0);
        pnPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        pnPanel.setBackground(new Color(220, 220, 220));

        JLabel lblDescription = new JLabel(description);
        lblDescription.setLocation(0, 0);
        lblDescription.setSize(panelWidth - 10, labelHeight);
        lblDescription.setPreferredSize(new Dimension(panelWidth - 10, labelHeight));
        lblDescription.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDescription.setFont(new java.awt.Font("Tahoma", 0, 13));

        JLabel lblValue = new JLabel(value);
        lblValue.setSize(panelWidth - 10, labelHeight);
        lblValue.setPreferredSize(new Dimension(panelWidth - 10, labelHeight));
        lblValue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblValue.setFont(new java.awt.Font("Tahoma", 0, 13));

        pnPanel.add(lblDescription);
        pnPanel.add(lblValue);
        return pnPanel;
    }

    /**
     * Getter for the created panel list.
     *
     * @return PanelList
     */
    public List<OpenPanel[]> getPanelList() {
        return panelList;
    }
    //</editor-fold>

    /**
     * Frame settings
     */
    
    private void formConfig() {
        initPanels();
        setCurrPanel(pnLoad);
        setLocationRelativeTo(null);

        FrameDragListener frameDragListener = new FrameDragListener(this);
        pnDrag.addMouseListener(frameDragListener);
        pnDrag.addMouseMotionListener(frameDragListener);

        mouseEvents = new MouseInteraction(this);
        lblLoad.addMouseListener(mouseEvents);
        lblResults.addMouseListener(mouseEvents);
        lblStatistics.addMouseListener(mouseEvents);
        lblCredits.addMouseListener(mouseEvents);
        lblHelp.addMouseListener(mouseEvents);
        lblExit.addMouseListener(mouseEvents);
    }

    public static void main(String args[]) {
        /* Set the  look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            //System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            System.loadLibrary("opencv_java343");
            
            new FormView().setVisible(true);
        });

    }

    // <editor-fold defaultstate="collapsed" desc="Variables">     
    JPanel currPanel;

    boolean carregou = false;
    boolean canceled = false;

    MouseInteraction mouseEvents;
    Controller results = new Controller(this);
    List<Information> diseasedList = new ArrayList();
    List<Information> uncertainList = new ArrayList();
    List<Information> healthyList = new ArrayList();
    List<OpenPanel[]> panelList = new ArrayList();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblCredits;
    private javax.swing.JLabel lblEmptyBoxIcon;
    private javax.swing.JLabel lblEmptyText;
    public javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblHealthyText;
    public javax.swing.JLabel lblHealthyValue;
    public javax.swing.JLabel lblHelp;
    private javax.swing.JLabel lblHelpText;
    private javax.swing.JLabel lblHelpTitle;
    private javax.swing.JLabel lblHelpTitle1;
    private javax.swing.JLabel lblInfectedText;
    public javax.swing.JLabel lblInfectedValue;
    public javax.swing.JLabel lblLoad;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblProcessing;
    public javax.swing.JLabel lblResults;
    private javax.swing.JLabel lblResultsTitle;
    private javax.swing.JLabel lblRustFinder;
    private javax.swing.JLabel lblSelectImage;
    public javax.swing.JLabel lblStatistics;
    private javax.swing.JLabel lblStatisticsTitle;
    private javax.swing.JLabel lblTotalText;
    public javax.swing.JLabel lblTotalValue;
    private javax.swing.JLabel lblUncertainText;
    public javax.swing.JLabel lblUncertainValue;
    private javax.swing.JLabel lblUploadIcon;
    public javax.swing.JProgressBar pgbProgressBar;
    private javax.swing.JPanel pnCredits;
    private javax.swing.JPanel pnDrag;
    private javax.swing.JPanel pnHealthyContainer;
    public static javax.swing.JPanel pnHealthyLeaves;
    private javax.swing.JPanel pnHelp;
    public static javax.swing.JPanel pnInfected;
    private javax.swing.JPanel pnInfectedContainer;
    private javax.swing.JPanel pnLoad;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnNoResults;
    public javax.swing.JPanel pnProgressBar;
    public javax.swing.JPanel pnResults;
    private javax.swing.JScrollPane pnResultsContainer;
    private javax.swing.JPanel pnResultsContent;
    private javax.swing.JPanel pnStatistics;
    private javax.swing.JPanel pnStatsLayout;
    private javax.swing.JPanel pnTotalImages;
    private javax.swing.JPanel pnTotalImagesContainer;
    public static javax.swing.JPanel pnUncertain;
    private javax.swing.JPanel pnUncertainContainer;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>

}
