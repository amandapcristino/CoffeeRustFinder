package br.unip.tcc.view;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser extends javax.swing.JDialog {

    FormView frame;
    public FileChooser(java.awt.Frame parent, boolean modal, FormView frame) {
        super(parent, modal);
        this.frame = frame;
        initComponents();
        formConfigurations();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        fileChooser.setDialogTitle("Select the images");
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fileChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserActionPerformed
        if (evt.getActionCommand().equals("ApproveSelection")) {

            files = new ArrayList<>();
            File[] selectedFiles = fileChooser.getSelectedFiles();

            for (File f : selectedFiles) {
                if (f.isDirectory()) {
                    File[] new_files = f.listFiles();
                    files.addAll(Arrays.asList(new_files));
                } else {
                    files.add(f);
                }
            }
        }
        else{
            frame.setCanceledOperation();
        }
        this.dispose();
    }//GEN-LAST:event_fileChooserActionPerformed

    private void formConfigurations() {
        //<editor-fold defaultstate="collapsed" desc="Look and feel setting code">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        this.setLocationRelativeTo(null);
        this.setTitle("Select the image");
        fileChooser.setCurrentDirectory(
                new File("C:\\Users\\Amanda\\Desktop\\TCC\\IMAGES"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png");
        fileChooser.setFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
    }

    //<editor-fold defaultstate="collapsed" desc="Variables declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fileChooser;
    // End of variables declaration//GEN-END:variables
    ArrayList<File> files;
    //</editor-fold>
}
