package com.humbletexteditor.Commands;

import com.humbletexteditor.Aligner;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class AlignLeftCommand implements Command {
    private JTextPane textPane;
    private Aligner aligner;
    private SimpleAttributeSet left;



    public AlignLeftCommand(JTextPane textPane) {
        aligner = Aligner.getInstance();
        this.textPane = textPane;
        left = new SimpleAttributeSet();
        StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);
    }

    @Override
    public void execute() {
        aligner.alignPane(textPane, left);

    }



}
