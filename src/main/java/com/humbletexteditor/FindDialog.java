package com.humbletexteditor;

import com.humbletexteditor.Commands.NextItemCommand;

import javax.swing.*;
import java.awt.event.*;

public class FindDialog extends JDialog {
    private JPanel contentPane;
    private JButton nextButton;
    private JButton buttonCancel;
    private JTextField textField1;




    private NextItemCommand nextItemCommand;


    public FindDialog(JTextPane textPane) {
        nextItemCommand = new NextItemCommand(textPane, textField1);

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(nextButton);



        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nextItemCommand.execute();
            }
        });



        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);



        this.setModalityType(ModalityType.MODELESS);
        this.pack();
        this.setVisible(true);

    }



}
