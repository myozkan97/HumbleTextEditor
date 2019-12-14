package com.humbletexteditor.Commands;

import com.humbletexteditor.FileManager;

import javax.swing.*;

public class SaveFileCommand implements Command {
    private JTextPane textPane;
    private FileManager fileManager;


    public SaveFileCommand(JTextPane textPane) {
        this.textPane = textPane;

    }

    @Override
    public void execute() {
        fileManager = FileManager.getInstance(textPane);
        fileManager.saveFile();
    }
}
