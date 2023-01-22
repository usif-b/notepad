import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class FileMenuListener implements ActionListener {
    private JFileChooser fileChooser = new JFileChooser();
    private JFrame frame;
    private JTextArea textArea;

    public FileMenuListener(JFrame frame, JTextArea textArea){
        this.frame = frame;
        this.textArea = textArea;
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JMenuItem){
            JMenuItem choice = (JMenuItem) source;
            switch(choice.getText()){
                case "Open":
                    int returnVal = fileChooser.showOpenDialog(frame);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
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
                    break;
                case "Exit":
                    break;
            }
        }
    }
}
