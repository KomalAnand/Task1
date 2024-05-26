
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {
    public Main() {
        initComponents();
        jLabel3.setVisible(false);
        jButton2.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Guess The Number!");

        jLabel2.setText("Enter Your Number");

        jButton1.setText("Check");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("New Game");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(22, 22, 22))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(112, 112, 112)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(72, 72, 72)
                                                .addComponent(jLabel2)
                                                .addGap(30, 30, 30)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(116, 116, 116)
                                                .addComponent(jLabel3)))
                                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addGap(31, 31, 31))
        );

        pack();
    }
    int Generate=(int)(Math.random()*100);
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        jButton2.setEnabled(false);
        jButton1.setEnabled(true);
        Generate=(int)(Math.random()*100);
        jTextField1.setText("");
        count=0;
        jLabel3.setVisible(false);
    }
    int count=0;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        count++;jButton2.setEnabled(true);
        if(Integer.parseInt(jTextField1.getText())>Generate)
        {
            jLabel3.setVisible(true);
            jLabel3.setText("Try Again with a lower number");
        }
        if(Integer.parseInt(jTextField1.getText())<Generate)
        {
            jLabel3.setVisible(true);
            jLabel3.setText("Try Again with a higher number");
        }
        if(count==7)
        {
            JOptionPane.showMessageDialog(this, "Try Again! You have reached maximum attempts");
            jButton1.setEnabled(false);
            jLabel3.setVisible(false);
        }
        if(Integer.parseInt(jTextField1.getText())==Generate)
        {
            JOptionPane.showMessageDialog(this, "Congratulations. You guessed the correct number in "+count+" number of tries");
            count=0;
            jButton1.setEnabled(false);
            jLabel3.setVisible(false);
        }
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
}
