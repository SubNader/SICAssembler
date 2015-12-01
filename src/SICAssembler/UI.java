/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SICAssembler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Nader
 */
public class UI extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form NewJFrame
     */
    public Instruction[] instructions;
    String userDir = System.getProperty("user.home") + "/Desktop";
    String objectCode = "";
    int comments;
    String location;
    String start;
    int valid;

    public UI() {
        initComponents();
        addListener();
    }

    void addListener() {
        Assemble.addActionListener(this);
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);

    }

    //Files methods
    void fileSaver() {
        JFileChooser saver = new JFileChooser(userDir);
        int returnVal = saver.showSaveDialog(this);
        File file = saver.getSelectedFile();
        BufferedWriter writer = null;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                writer = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
                codeArea.write(writer);
                writer.close();
                JOptionPane.showMessageDialog(this, "The file was saved successfully!",
                        "Success!", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "The file could not be saved!",
                        "Error!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    void fileCreator() {
        JFileChooser saver = new JFileChooser(userDir);
        int returnVal = saver.showSaveDialog(this);
        File file = saver.getSelectedFile();
        BufferedWriter writer = null;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                writer = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
                writer.write(codeArea.getText());
                writer.close();
                JOptionPane.showMessageDialog(this, "The file was created successfully!",
                        "Success!", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "The file could not be created!",
                        "Error!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    void fileLoader() {
        JFileChooser loader = new JFileChooser(userDir);
        int returnVal = loader.showOpenDialog(this);
        File file = loader.getSelectedFile();
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                FileReader fileReader = new FileReader(file);
                codeArea.read(fileReader, file);

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "The file could not be found!", "Error!", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "The file could not be loaded!", "Error!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        Assemble = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        codeArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        OutputField = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        objectFileArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        openFile = new javax.swing.JMenu();
        newFile = new javax.swing.JMenuItem();
        saveFile = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIC Assembler");
        setResizable(false);

        Assemble.setText("Assemble");

        codeArea.setColumns(20);
        codeArea.setForeground(new java.awt.Color(51, 105, 255));
        codeArea.setRows(5);
        codeArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(codeArea);

        jLabel1.setFont(new java.awt.Font("Qubix", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 179, 255));
        jLabel1.setText("SIC Assembler");

        OutputField.setEditable(false);
        OutputField.setColumns(20);
        OutputField.setForeground(new java.awt.Color(51, 105, 255));
        OutputField.setRows(5);
        OutputField.setAutoscrolls(false);
        jScrollPane2.setViewportView(OutputField);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel2.setText("Input");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel5.setText("Listing file");

        objectFileArea.setEditable(false);
        objectFileArea.setColumns(20);
        objectFileArea.setForeground(new java.awt.Color(51, 105, 255));
        objectFileArea.setRows(5);
        objectFileArea.setAutoscrolls(false);
        jScrollPane3.setViewportView(objectFileArea);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel3.setText("Object program");

        openFile.setText("File");

        newFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newFile.setText("New file");
        newFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileActionPerformed(evt);
            }
        });
        openFile.add(newFile);

        saveFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        saveFile.setText("Open file");
        openFile.add(saveFile);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Save / Save As");
        openFile.add(jMenuItem5);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        openFile.add(jMenuItem1);

        menuBar.add(openFile);

        jMenu3.setText("About");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("About SIC Assembler");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        menuBar.add(jMenu3);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(768, 768, 768))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Assemble, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Assemble)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "SIC Assembler generates a listing file and an object program from SIC instructions.",
                "About", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void newFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newFileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Assemble;
    private javax.swing.JTextArea OutputField;
    private javax.swing.JTextArea codeArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newFile;
    private javax.swing.JTextArea objectFileArea;
    private javax.swing.JMenu openFile;
    private javax.swing.JMenuItem saveFile;
    // End of variables declaration//GEN-END:variables
    //Parses the input into array of strings, and then into array of type Instruction

    void parse() {
        //Parser code goes here
        int numberOfLines = codeArea.getLineCount();
        String[] code = codeArea.getText().split("\\n");
        String label;
        String operation;
        String operand;
        instructions = new Instruction[numberOfLines];
        for (int i = 0; i < numberOfLines; i++) {
            if (code[i].startsWith(".")) {
                continue;
            } else {
                //Split columns into variables
                label = code[i].substring(0, 9);
                operation = code[i].substring(9, 17);
                operand = code[i].substring(17, code[i].length());
                //Remove extra spaces
                label = label.trim();
                operation = operation.trim();
                operand = operand.trim();
                //Set start point
                if (operation.equalsIgnoreCase("start")) {
                    start = operand;
                    location = operand;
                }
                //Create new instruction with split results, along with location
                instructions[valid] = new Instruction(label, operation, operand, location);
                incrementAddress(operation, operand);
                //Increment number of valid instructions
                valid++;
            }
        }
    }

    //Handles and increments the location counter based on previous instruction
    void incrementAddress(String value, String operand) {
        int temp;
        if (value.equalsIgnoreCase("byte")) {
            temp = Integer.parseInt(location, 16);
            temp++;
            location = Integer.toHexString(temp);
        } else if (value.equalsIgnoreCase("resw")) {
            temp = Integer.parseInt(location, 16);
            temp += (3 * Integer.parseInt(operand));
            location = Integer.toHexString(temp);
        } else if (value.equalsIgnoreCase("resb")) {
            temp = Integer.parseInt(location, 16);
            temp += Integer.parseInt(operand);
            location = Integer.toHexString(temp);
        } else if (value.equalsIgnoreCase("start")) {
            location = operand;
        } else {
            temp = Integer.parseInt(location, 16);
            temp += 3;
            location = Integer.toHexString(temp);
        }
        location = location.toUpperCase();
    }

    //Generates object code for every instruction
    void generateObjectCode() {
        String objectCode = "";
        String label;
        String operation;
        String operand;
        String tempOperand;
        int indexed;
        for (int i = 0; i < valid; i++) {
            indexed = 0;
            objectCode = "";
            label = instructions[i].getLabel();
            operation = instructions[i].getOperation();
            operand = instructions[i].getOperand();
            switch (operation.toLowerCase()) {
                case "add":
                    objectCode = "18";
                    break;
                case "and":
                    objectCode = "40";
                    break;
                case "comp":
                    objectCode = "28";
                    break;
                case "div":
                    objectCode = "24";
                    break;
                case "j":
                    objectCode = "3C";
                    break;
                case "jeq":
                    objectCode = "30";
                    break;
                case "jgt":
                    objectCode = "34";
                    break;
                case "jlt":
                    objectCode = "38";
                    break;
                case "jsub":
                    objectCode = "48";
                    break;
                case "lda":
                    objectCode = "00";
                    break;
                case "ldch":
                    objectCode = "50";
                    break;
                case "ldl":
                    objectCode = "08";
                    break;
                case "ldx":
                    objectCode = "04";
                    break;
                case "mul":
                    objectCode = "20";
                    break;
                case "or":
                    objectCode = "44";
                    break;
                case "rd":
                    objectCode = "D8";
                    break;
                case "rsub":
                    objectCode = "4C";
                    break;
                case "sta":
                    objectCode = "0C";
                    break;
                case "stch":
                    objectCode = "54";
                    break;
                case "stl":
                    objectCode = "14";
                    break;
                case "stx":
                    objectCode = "10";
                    break;
                case "sub":
                    objectCode = "1C";
                    break;
                case "td":
                    objectCode = "E0";
                    break;
                case "tix":
                    objectCode = "2C";
                    break;
                case "wd":
                    objectCode = "28";
                    break;
            }
            if (operand.endsWith(",x") || operand.endsWith(",X")) {
                tempOperand = operand.substring(0, operand.length() - 2);
                indexed = 1;
                for (int j = 0; j < valid; j++) {
                    if (instructions[j].getLabel().equalsIgnoreCase(tempOperand)) {
                        objectCode += instructions[j].getAddress();
                    }
                }
            } else if (operation.equalsIgnoreCase("rsub")) {
                //Skipper

            } else {
                indexed = 0;
                for (int j = 0; j < valid; j++) {
                    if (instructions[j].getLabel().equalsIgnoreCase(operand)) {
                        objectCode += instructions[j].getAddress();
                    }
                }
            }
            if (operation.equalsIgnoreCase("resb") || operation.equalsIgnoreCase("resw") || operation.equalsIgnoreCase("start") || operation.equalsIgnoreCase("end")) {
                objectCode = "";
            }
            if (operation.equalsIgnoreCase("word")) {
                objectCode = String.format("%06d", Integer.parseInt(operand));
            }
            if (operation.equalsIgnoreCase("byte")) {
                objectCode = String.format("%06d", Integer.parseInt(operand));
            }

            if (indexed == 1) {
                objectCode = Integer.toHexString(Integer.parseInt(objectCode, 16) | 32768);
            }
            objectCode = objectCode.toUpperCase();
            instructions[i].setObjectCode(objectCode);
        }
    }

    //Generates the listing file from the array of instructions
    void generateListingFile() {
        String temp;
        for (int i = 0; i < valid; i++) {
            temp = String.format("%-8s %-8s %-8s %-8s %10s", instructions[i].getAddress(), instructions[i].getLabel(), instructions[i].getOperation(), instructions[i].getOperand(), instructions[i].getObjectCode());
            OutputField.append(temp + "\n");
        }
    }

    //Generates the final object program, including Header, Text and End entries
    void generateObjectProgram() {
        int startPoint = Integer.parseInt(instructions[0].getAddress(), 16);
        int endPoint = Integer.parseInt(instructions[valid - 1].getAddress(), 16);
        String programLength = String.format("%06x", endPoint - startPoint);
        objectFileArea.append("H^" + instructions[0].getLabel() + "^" + String.format("%06x", Integer.parseInt(start, 16)).toUpperCase() + "^" + programLength.toUpperCase());
        for (int i = 0; i < valid; i++) {
            if (!"".equals(instructions[i].getObjectCode())) {
                objectFileArea.append("^" + instructions[i].getObjectCode());
            }
            if ((((i % 10 == 0) && (i + 1 < valid)) || (instructions[i].getOperation().equalsIgnoreCase("resw") && i + 1 < valid) || (instructions[i].getOperation().equalsIgnoreCase("resb") && i + 1 < valid)) && !instructions[i + 1].getObjectCode().equals("")) {
                objectFileArea.append("\nT^" + String.format("%06x", Integer.parseInt(instructions[i + 1].getAddress(), 16)).toUpperCase() + "^" + String.format("%06x", 0).toUpperCase());
            }
        }
        objectFileArea.append("\nE^" + String.format("%06x", Integer.parseInt(start, 16)));
    }

    @Override
    //Handles the assemble button, with multiple assembles support
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "New file":
                fileCreator();
                codeArea.setText("");
                objectFileArea.setText("");
                OutputField.setText("");
                break;
            case "Open file":
                fileLoader();
                break;
            case "Save / Save As":
                fileSaver();
                break;
            case "Assemble":
                if (codeArea.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "The code area is empty.", "No code found", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    try {
                        OutputField.setText("");
                        objectFileArea.setText("");
                        comments = 0;
                        valid = 0;
                        parse();
                        generateObjectCode();
                        generateListingFile();
                        generateObjectProgram();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "The code you have entered is isvalid.", "Invalid code", JOptionPane.INFORMATION_MESSAGE);

                    }
                }
        }
    }
}
