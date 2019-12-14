package com.humbletexteditor;

import javax.swing.*;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;

public class UndoAction extends AbstractAction {
    private UndoManager undoManager;


    public UndoAction(JTextPane textPane) {
        undoManager = new UndoManager();
        textPane.getDocument().addUndoableEditListener(undoManager);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            undoManager.undo();
        } catch (CannotUndoException exc) {
            System.out.println(exc.getMessage());
        }

    }
}
