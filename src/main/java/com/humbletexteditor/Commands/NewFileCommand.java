package com.humbletexteditor.Commands;

import com.humbletexteditor.FileManager;

import javax.swing.*;
import java.io.File;

public class NewFileCommand implements Command {
    private JTextPane textPane;
    private FileManager fileManager;

    public NewFileCommand(JTextPane textPane) {
        this.textPane = textPane;
    }

    @Override
    public void execute() {
        fileManager = FileManager.getInstance(textPane);
        fileManager.saveFile();
        fileManager.newFile();
    }
}
