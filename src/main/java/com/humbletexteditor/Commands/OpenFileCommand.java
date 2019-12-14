package com.humbletexteditor.Commands;

import com.humbletexteditor.FileManager;

import javax.swing.*;
import java.util.Scanner;

public class OpenFileCommand implements Command {
    private JTextPane textPane;
    private FileManager fileManager;

    public OpenFileCommand(JTextPane textPane) {
        this.textPane = textPane;
    }

    @Override
    public void execute() {
        fileManager = FileManager.getInstance(textPane);
        fileManager.saveFile();
        fileManager.openFile();

    }
}
