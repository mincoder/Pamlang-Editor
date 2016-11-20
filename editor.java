package pamlang;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;
/**
 * Created by Victor Nordlinder on 20/11/2016.
 */
public class editor {
    class TextEditor extends JFrame {
        private JTextArea area = new JTextArea(20,120);
        private JFileChooser dialog = new JFileChooser(System.getProperty("user.dir"));
        private String currentFile = "Untitled";
        private boolean changed = false;
        public TextEditor() {
            area.setFont(new Font("Monospaced", Font.PLAIN, 12));
            JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            add(scroll, BorderLayout.CENTER);

            JMenuBar JMB = new JMenuBar();
            setJMenuBar(JMB);
            JMenu file = new JMenu("File");
            JMenu edit = new JMenu("Edit");
            JMB.add(file);
            JMB.add(edit);
            file.add(New);file.add(Open);file.add(Save);
            file.add(Quit);file.add(SaveAs);
            file.addSeparator();

            for(int i=0; i<4; i++)
                file.getItem(i).setIcon(null);

            edit.add(Cut);edit.add(Copy);edit.add(Paste);

            edit.getItem(0).setText("Cut out");
            edit.getItem(1).setText("Copy");
            edit.getItem(2).setText("Paste");

            JToolBar tool = new JToolBar();
            add(tool,BorderLayout.NORTH);
            tool.add(New);tool.add(Open);tool.add(Save);
            tool.addSeparator();

            JButton cut = tool.add(Cut), cop = tool.add(Copy),pas = tool.add(Paste);

            cut.setText(null); cut.setIcon(new ImageIcon("cut.gif"));
            cop.setText(null); cop.setIcon(new ImageIcon("copy.gif"));
            pas.setText(null); pas.setIcon(new ImageIcon("paste.gif"));

            Save.setEnabled(false);
            SaveAs.setEnabled(false);

            setDefaultCloseOperation(EXIT_ON_CLOSE);
            pack();
            area.addKeyListener(k1);
            setTitle(currentFile);
            setVisible(true);
        }
    }
}
