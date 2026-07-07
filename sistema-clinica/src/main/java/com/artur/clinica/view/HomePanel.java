package com.artur.clinica.view;

public class HomePanel extends javax.swing.JPanel {
    
    public HomePanel() {
        initComponents();
        String nomeUsuario = System.getProperty("user.name");
        nomeUsuario = com.artur.clinica.model.Consulta.transformarTitulo(nomeUsuario);
        lblWelcome.setText("Welcome, "+ nomeUsuario + "!");

        javax.swing.Timer timer = new javax.swing.Timer(50, new java.awt.event.ActionListener() {
        int alpha = 0;
        
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            alpha += 5; 
            if (alpha >= 255) {
                alpha = 255;
                ((javax.swing.Timer)e.getSource()).stop(); 
            }
            lblWelcome.setForeground(new java.awt.Color(0, 0, 0, alpha)); 
            SubtTitle.setForeground(new java.awt.Color(0, 0, 0, alpha));
            }   
        });
        timer.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        HomePnaelInner = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        SubtTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(248, 250, 252));
        setLayout(new java.awt.GridBagLayout());

        HomePnaelInner.setOpaque(false);

        lblWelcome.setBackground(new java.awt.Color(0, 204, 255));
        lblWelcome.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N

        SubtTitle.setBackground(new java.awt.Color(0, 204, 255));
        SubtTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SubtTitle.setText("Sistema Integrado de Gestão Clínica — Clinicativa v1.0");
        SubtTitle.setForeground(java.awt.Color.GRAY);

        javax.swing.GroupLayout HomePnaelInnerLayout = new javax.swing.GroupLayout(HomePnaelInner);
        HomePnaelInner.setLayout(HomePnaelInnerLayout);
        HomePnaelInnerLayout.setHorizontalGroup(
            HomePnaelInnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePnaelInnerLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(HomePnaelInnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SubtTitle)
                    .addComponent(lblWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(99, 99, 99))
        );
        HomePnaelInnerLayout.setVerticalGroup(
            HomePnaelInnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePnaelInnerLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SubtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 34;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(165, 180, 223, 219);
        add(HomePnaelInner, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HomePnaelInner;
    private javax.swing.JLabel SubtTitle;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables
}
