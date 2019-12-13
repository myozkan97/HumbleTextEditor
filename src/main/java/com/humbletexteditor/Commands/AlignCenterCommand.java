package com.humbletexteditor.Commands;

import com.humbletexteditor.Aligner;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class AlignCenterCommand implements Command {
    private JTextPane textPane;
    private Aligner aligner;
    private SimpleAttributeSet center;

    public AlignCenterCommand(JTextPane textPane) {
        aligner = Aligner.getInstance();
        this.textPane = textPane;
        center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
    }

    @Override
    public void execute() {
        aligner.alignPane(textPane, center);

    }


}
