package com.humbletexteditor;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileManager {
    private static FileManager fileManagerIns;

    private File file;
    private JFileChooser fileChooser;
    private JTextPane textPane;

    public FileManager(JTextPane textPane) {
        this.textPane = textPane;
        fileChooser = new JFileChooser();

        fileChooser.addChoosableFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                String fileName = f.getName();
                String extension;
                if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
                    extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                else
                    extension = "";

                return extension.equals("java") || extension.equals("txt") || extension.equals("c") ||
                        extension.equals("cs") || extension.equals("js") || extension.equals("html");
            }

            @Override
            public String getDescription() {
                return "Text file";
            }
        });
    }

    public void saveFile() {
        if (file == null) {
            fileChooser.showSaveDialog(null);
            file = fileChooser.getSelectedFile();

        }

        try (
                PrintWriter printWriter = new PrintWriter(file);
        ) {
            printWriter.write(textPane.getText());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(textPane, e, "An error occured", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void openFile() {
        fileChooser.showOpenDialog(null);
        file = fileChooser.getSelectedFile();

        if (fileChooser.accept(file)) {
            try {
                String content = new Scanner(file).useDelimiter("\\Z").next();
                textPane.setText(content);
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(textPane, e, "An error occured", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void newFile() {
        file = null;
        textPane.setText("");
    }

    public File getFile() {
        return file;
    }


    public static FileManager getInstance(JTextPane textPane) {
        if (fileManagerIns == null) {
            synchronized (FileManager.class) {
                if (fileManagerIns == null)
                    fileManagerIns = new FileManager(textPane);
            }
        }
        return fileManagerIns;
    }
}
