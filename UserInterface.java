import javax.swing.*;
import java.awt.*;

public class UserInterface {
    private JFrame frame;
    private JTextArea textArea;
    private JMenuBar menu;
    private JMenu file, edit;
    private JMenuItem newFile, open, save, exit;

    public UserInterface() {
        frame = new JFrame("Notepad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,640);
        frame.setResizable(true);
        textArea = new JTextArea();
        textArea.setPreferredSize(frame.getSize());
        Font font = textArea.getFont();
        textArea.setFont(font.deriveFont(14f));
        textArea.setTabSize(4);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);

        menu = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        
        FileMenuListener fileMenu = new FileMenuListener(frame, textArea);
        newFile = new JMenuItem("New");
        newFile.addActionListener(fileMenu);
        open = new JMenuItem("Open");
        open.addActionListener(fileMenu);
        save = new JMenuItem("Save");
        save.addActionListener(fileMenu);
        exit = new JMenuItem("Exit");
        exit.addActionListener(fileMenu);

        file.add(newFile);
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