/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rubikscubesolver;

/**
 *
 * @author 37505
 */
public class RubiksFrame extends javax.swing.JFrame
{

    /**
     * Creates new form RubiksFrame
     */
    public RubiksFrame()
    {
	initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        rubiksCube1 = new rubikscubesolver.RubiksCube();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        numTurns = new javax.swing.JTextField();
        solveBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        orangeFaceBtn = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        blueFaceBtn = new javax.swing.JButton();
        yellowFaceBtn = new javax.swing.JButton();
        greenFaceBtn = new javax.swing.JButton();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        redFaceBtn = new javax.swing.JButton();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        whiteFaceBtn = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        xMidBtn = new javax.swing.JButton();
        yMidBtn = new javax.swing.JButton();
        zMidBtn = new javax.swing.JButton();
        solutionField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        tPermMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Turn:");

        numTurns.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        numTurns.setText("1");
        numTurns.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                numTurnsActionPerformed(evt);
            }
        });

        solveBtn.setText("Solved");
        solveBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                solveBtnActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new java.awt.GridLayout(5, 3));
        jPanel2.add(filler1);

        orangeFaceBtn.setText("Back");
        orangeFaceBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                orangeFaceBtnActionPerformed(evt);
            }
        });
        jPanel2.add(orangeFaceBtn);
        jPanel2.add(filler3);

        blueFaceBtn.setText("Left");
        blueFaceBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                blueFaceBtnActionPerformed(evt);
            }
        });
        jPanel2.add(blueFaceBtn);

        yellowFaceBtn.setText("Up");
        yellowFaceBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                yellowFaceBtnActionPerformed(evt);
            }
        });
        jPanel2.add(yellowFaceBtn);

        greenFaceBtn.setText("Right");
        greenFaceBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                greenFaceBtnActionPerformed(evt);
            }
        });
        jPanel2.add(greenFaceBtn);
        jPanel2.add(filler6);

        redFaceBtn.setText("Front");
        redFaceBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                redFaceBtnActionPerformed(evt);
            }
        });
        jPanel2.add(redFaceBtn);
        jPanel2.add(filler5);
        jPanel2.add(filler4);

        whiteFaceBtn.setText("Down");
        whiteFaceBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                whiteFaceBtnActionPerformed(evt);
            }
        });
        jPanel2.add(whiteFaceBtn);
        jPanel2.add(filler2);

        xMidBtn.setText("X mid");
        xMidBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                xMidBtnActionPerformed(evt);
            }
        });
        jPanel2.add(xMidBtn);

        yMidBtn.setText("Y mid");
        yMidBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                yMidBtnActionPerformed(evt);
            }
        });
        jPanel2.add(yMidBtn);

        zMidBtn.setText("Z mid");
        zMidBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                zMidBtnActionPerformed(evt);
            }
        });
        jPanel2.add(zMidBtn);

        solutionField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                solutionFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Solution:");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(numTurns, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(9, 9, 9)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .add(solveBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 243, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(62, 62, 62))
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(solutionField)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(numTurns, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 160, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(solutionField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(solveBtn)
                .addContainerGap())
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Perms");

        tPermMenu.setText("T Perm");
        tPermMenu.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tPermMenuActionPerformed(evt);
            }
        });
        jMenu3.add(tPermMenu);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(rubiksCube1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 499, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(rubiksCube1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void yellowFaceBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_yellowFaceBtnActionPerformed
    {//GEN-HEADEREND:event_yellowFaceBtnActionPerformed
        rubiksCube1.rotateFace(Layer.UP, Integer.parseInt(numTurns.getText()));
	updateUI();
    }//GEN-LAST:event_yellowFaceBtnActionPerformed

    private void redFaceBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_redFaceBtnActionPerformed
    {//GEN-HEADEREND:event_redFaceBtnActionPerformed
        rubiksCube1.rotateFace(Layer.FRONT, Integer.parseInt(numTurns.getText()));
	updateUI();
    }//GEN-LAST:event_redFaceBtnActionPerformed

    private void orangeFaceBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_orangeFaceBtnActionPerformed
    {//GEN-HEADEREND:event_orangeFaceBtnActionPerformed
        rubiksCube1.rotateFace(Layer.BACK, Integer.parseInt(numTurns.getText()));
	updateUI();
    }//GEN-LAST:event_orangeFaceBtnActionPerformed

    private void blueFaceBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_blueFaceBtnActionPerformed
    {//GEN-HEADEREND:event_blueFaceBtnActionPerformed
        rubiksCube1.rotateFace(Layer.LEFT, Integer.parseInt(numTurns.getText()));
	updateUI();
    }//GEN-LAST:event_blueFaceBtnActionPerformed

    private void greenFaceBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_greenFaceBtnActionPerformed
    {//GEN-HEADEREND:event_greenFaceBtnActionPerformed
        rubiksCube1.rotateFace(Layer.RIGHT, Integer.parseInt(numTurns.getText()));
	updateUI();
    }//GEN-LAST:event_greenFaceBtnActionPerformed

    private void whiteFaceBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_whiteFaceBtnActionPerformed
    {//GEN-HEADEREND:event_whiteFaceBtnActionPerformed
        rubiksCube1.rotateFace(Layer.DOWN, Integer.parseInt(numTurns.getText()));
	updateUI();
    }//GEN-LAST:event_whiteFaceBtnActionPerformed

    private void xMidBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_xMidBtnActionPerformed
    {//GEN-HEADEREND:event_xMidBtnActionPerformed
        rubiksCube1.rotateFace(Layer.X_MIDDLE, Integer.parseInt(numTurns.getText()));
	updateUI();
    }//GEN-LAST:event_xMidBtnActionPerformed

    private void yMidBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_yMidBtnActionPerformed
    {//GEN-HEADEREND:event_yMidBtnActionPerformed
        rubiksCube1.rotateFace(Layer.Y_MIDDLE, Integer.parseInt(numTurns.getText()));
	updateUI();
    }//GEN-LAST:event_yMidBtnActionPerformed

    private void zMidBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_zMidBtnActionPerformed
    {//GEN-HEADEREND:event_zMidBtnActionPerformed
        rubiksCube1.rotateFace(Layer.Z_MIDDLE, Integer.parseInt(numTurns.getText()));
	updateUI();
    }//GEN-LAST:event_zMidBtnActionPerformed

    private void numTurnsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_numTurnsActionPerformed
    {//GEN-HEADEREND:event_numTurnsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numTurnsActionPerformed

    private void solveBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_solveBtnActionPerformed
    {//GEN-HEADEREND:event_solveBtnActionPerformed
        String alg = rubiksCube1.solve();
	
	solutionField.setText(alg);
	updateUI();
    }//GEN-LAST:event_solveBtnActionPerformed

    private void solutionFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_solutionFieldActionPerformed
    {//GEN-HEADEREND:event_solutionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_solutionFieldActionPerformed

    private void tPermMenuActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_tPermMenuActionPerformed
    {//GEN-HEADEREND:event_tPermMenuActionPerformed
        rubiksCube1.rotateFace(Layer.RIGHT, 1);
	rubiksCube1.rotateFace(Layer.UP, 1);
	rubiksCube1.rotateFace(Layer.RIGHT, 3);
	rubiksCube1.rotateFace(Layer.UP, 3);
	rubiksCube1.rotateFace(Layer.RIGHT, 3);
	rubiksCube1.rotateFace(Layer.FRONT, 1);
	rubiksCube1.rotateFace(Layer.RIGHT, 2);
	rubiksCube1.rotateFace(Layer.UP, 3);
	rubiksCube1.rotateFace(Layer.RIGHT, 3);
	rubiksCube1.rotateFace(Layer.UP, 3);
	rubiksCube1.rotateFace(Layer.RIGHT, 1);
	rubiksCube1.rotateFace(Layer.UP, 1);
	rubiksCube1.rotateFace(Layer.RIGHT, 3);
	rubiksCube1.rotateFace(Layer.FRONT, 3);
	updateUI();
    }//GEN-LAST:event_tPermMenuActionPerformed

    private void updateUI()
    {
	if (rubiksCube1.hasWon())
	{
	    solveBtn.setText("Solved");
	    solveBtn.setEnabled(false);
	} else {
	    solveBtn.setText("Solve");
	    solveBtn.setEnabled(true);
	}
	
	repaint();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
	/* Set the Nimbus look and feel */
	//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
	 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	 */
	try {
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (ClassNotFoundException ex) {
	    java.util.logging.Logger.getLogger(RubiksFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(RubiksFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(RubiksFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(RubiksFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable()
	{
	    public void run()
	    {
		new RubiksFrame().setVisible(true);
	    }
	});
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton blueFaceBtn;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.JButton greenFaceBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField numTurns;
    private javax.swing.JButton orangeFaceBtn;
    private javax.swing.JButton redFaceBtn;
    private rubikscubesolver.RubiksCube rubiksCube1;
    private javax.swing.JTextField solutionField;
    private javax.swing.JButton solveBtn;
    private javax.swing.JMenuItem tPermMenu;
    private javax.swing.JButton whiteFaceBtn;
    private javax.swing.JButton xMidBtn;
    private javax.swing.JButton yMidBtn;
    private javax.swing.JButton yellowFaceBtn;
    private javax.swing.JButton zMidBtn;
    // End of variables declaration//GEN-END:variables
}
