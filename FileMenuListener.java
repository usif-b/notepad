import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class FileMenuListener implements ActionListener {
    private JFileChooser fileChooser = new JFileChooser();
    private JFrame frame;
    private JTextArea textArea;
    private String path = " ";

    public FileMenuListener(JFrame frame, JTextArea textArea){
        this.frame = frame;
        this.textArea = textArea;
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JMenuItem){
            JMenuItem choice = (JMenuItem) source;
            switch(choice.getText()){
                case "New":
                    int newFileOption = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                    if(newFileOption == JOptionPane.YES_OPTION) {
                        path = " ";
                        textArea.setText("");
                    }
                    break;
                case "Open":
                    int openVal = fileChooser.showOpenDialog(frame);
                    if (openVal == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                        path = file.getAbsolutePath();
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader(file));
                            textArea.read(reader, null);
                            reader.close();
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(frame, "Error opening file", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case "Save":
                    if(path == " ") {
                        int saveVal = fileChooser.showSaveDialog(frame);
                        if(saveVal == JFileChooser.APPROVE_OPTION){
                            File file = fileChooser.getSelectedFile();
                            path = file.getAbsolutePath();
                            try {
                                FileWriter writer = new FileWriter(file);
                                textArea.write(writer);
                                writer.close();
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(frame, "Error Saving file", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    else {
                        try {
                            FileWriter writer = new FileWriter(path);
                            textArea.write(writer);
                            writer.close();
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(frame, "Error saving file", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case "Exit":
                    int exitOption = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                    if(exitOption == JOptionPane.YES_OPTION) {
                        frame.dispose();
                    }
                    break;
            }
        }
    }
}
