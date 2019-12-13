package com.humbletexteditor.Commands;

import com.humbletexteditor.Aligner;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class AlignRightCommand implements Command {
    private JTextPane textPane;
    private Aligner aligner;
    private SimpleAttributeSet right;



    public AlignRightCommand(JTextPane textPane) {
        aligner = Aligner.getInstance();
        this.textPane = textPane;
        right = new SimpleAttributeSet();
        StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
    }

    @Override
    public void execute() {
        aligner.alignPane(textPane, right);

    }



}
