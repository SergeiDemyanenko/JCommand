import fs.Files;
import fs.GetFiles;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;

public class Main {

    private JPanel rootPanel;
    private JTable leftTable;
    private JTable rightTable;
    private JSplitPane tablePanel;

    public static void main(String... args) {
        Main main = new Main();

        JFrame frame = new JFrame("JCommand");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(main.rootPanel);
        frame.pack();
        frame.setVisible(true);

        main.leftTable.setModel(new DefaultTableModel(Files.getFiles(System.getProperty("user.dir")), Files.TABLE_COLUMNS));
        main.rightTable.setModel(new DefaultTableModel(Files.getFiles(System.getProperty("user.dir")), Files.TABLE_COLUMNS));
    }
}
