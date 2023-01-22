import javax.swing.*;
import java.awt.*;

public class UserInterface {
    private JFrame frame;
    private JTextArea textArea;
    private JMenuBar menu;
    private JMenu file, edit;
    private JMenuItem open, save, exit;

    public UserInterface() {
        frame = new JFrame("Notepad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,640);
        frame.setResizable(true);
        textArea = new JTextArea();
        textArea.setPreferredSize(frame.getSize());
        Font font = textArea.getFont();
        textArea.setFont(font.deriveFont(14f));
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);

        menu = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        
        open = new JMenuItem("Open");
        open.addActionListener(new FileMenuListener(frame, textArea));
        save = new JMenuItem("Save");
        exit = new JMenuItem("Exit");

        file.add(open);
        file.add(save);
        file.add(exit);

        menu.add(file);
        menu.add(edit);
        frame.setJMenuBar(menu);
        frame.pack();
        frame.setVisible(true);
    }
}