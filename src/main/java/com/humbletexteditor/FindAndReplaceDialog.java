package com.humbletexteditor;

import com.humbletexteditor.Commands.NextItemCommand;
import com.humbletexteditor.Commands.ReplaceAllCommand;
import com.humbletexteditor.Commands.ReplaceCommand;

import javax.swing.*;
import java.awt.event.*;

public class FindAndReplaceDialog extends JDialog {
    private JPanel contentPane;
    private JButton findButton;
    private JButton cancelButton;
    private JButton replaceAllButton;
    private JButton replaceButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextPane textPane;



    private NextItemCommand nextItemCommand;
    private ReplaceCommand replaceCommand;
    private ReplaceAllCommand replaceAllCommand;

    public FindAndReplaceDialog(JTextPane textPane) {
        this.textPane = textPane;
        replaceCommand = new ReplaceCommand(textPane, textField2);
        nextItemCommand = new NextItemCommand(textPane, textField1);
        replaceAllCommand = new ReplaceAllCommand(textPane, textField1, textField2);


        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(findButton);

        replaceAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                replaceAllCommand.execute();
            }
        });

        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nextItemCommand.execute();
            }
        });

        replaceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                replaceCommand.execute();
            }
        });



        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);



        this.pack();
        this.setModalityType(ModalityType.MODELESS);
        this.setVisible(true);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


}
