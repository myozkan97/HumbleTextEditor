package com.humbletexteditor.Commands;

import com.humbletexteditor.UndoAction;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;

public class UndoCommand implements Command{
    private UndoAction undoAction;
    private JTextPane textPane;
    private JButton button;

    public UndoCommand(JTextPane textPane) {
        this.textPane = textPane;
        undoAction = new UndoAction(textPane);

    }

    @Override
    public void execute() {
        undoAction.actionPerformed(new ActionEvent(textPane, ActionEvent.ACTION_PERFORMED, "execute"));
    }
}
