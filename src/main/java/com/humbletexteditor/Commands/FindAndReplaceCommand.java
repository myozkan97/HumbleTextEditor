package com.humbletexteditor.Commands;

import com.humbletexteditor.FindAndReplaceDialog;

import javax.swing.*;

public class FindAndReplaceCommand implements Command {

    private JTextPane textPane;
    private FindAndReplaceDialog findAndReplaceDialog;

    public FindAndReplaceCommand(JTextPane textPane) {
        this.textPane = textPane;
    }

    @Override
    public void execute() {
        if(findAndReplaceDialog == null)
            findAndReplaceDialog = new FindAndReplaceDialog(textPane);
        else
            findAndReplaceDialog.setVisible(true);
    }


}
