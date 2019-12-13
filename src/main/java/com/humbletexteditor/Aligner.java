package com.humbletexteditor;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;

public class Aligner {
    private static volatile Aligner aligner;

    private Aligner() {
    }

    public void alignPane(JTextPane textPane, SimpleAttributeSet sAttrSet) {
        StyledDocument doc = textPane.getStyledDocument();
        doc.setParagraphAttributes(textPane.getSelectionStart(),
                textPane.getSelectionEnd(), sAttrSet, false);
    }


    public static Aligner getInstance() {
        if (aligner == null) {
            synchronized (Aligner.class) {
                if (aligner == null)
                    aligner = new Aligner();
            }
        }
        return aligner;
    }

}
