
/*

=====================================================================================================
=====================================================================================================
=====================================================================================================
====     _   _                 _     _        _____         _     _____    _ _ _                  ===
====    | | | |               | |   | |      |_   _|       | |   |  ___|  | (_) |                 ===
====    | |_| |_   _ _ __ ___ | |__ | | ___    | | _____  _| |_  | |__  __| |_| |_ ___  _ __      ===
====    |  _  | | | | '_ ` _ \| '_ \| |/ _ \   | |/ _ \ \/ / __| |  __|/ _` | | __/ _ \| '__|     ===
====    | | | | |_| | | | | | | |_) | |  __/   | |  __/>  <| |_  | |__| (_| | | || (_) | |        ===
====    \_| |_/\__,_|_| |_| |_|_.__/|_|\___|   \_/\___/_/\_\\__| \____/\__,_|_|\__\___/|_|        ===
=====================================================================================================
=====================================================================================================
=====================================================================================================

* */


package com.humbletexteditor;


import com.humbletexteditor.Commands.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HumbleTextEditor {
    private JPanel panel1;
    private JTextPane textPane;
    private JButton leftButton;
    private JButton centerButton;
    private JButton rightButton;
    private JButton findButton;
    private JButton findAndReplaceButton;
    private JButton undoButton;


    private AlignLeftCommand alignLeftCommand;
    private AlignRightCommand alignRightCommand;
    private AlignCenterCommand alignCenterCommand;
    private FindCommand findCommand;
    private FindAndReplaceCommand findAndReplaceCommand;
    private UndoCommand undoCommand;


    public HumbleTextEditor() {

        findCommand = new FindCommand(textPane);
        alignLeftCommand = new AlignLeftCommand(textPane);
        alignRightCommand = new AlignRightCommand(textPane);
        alignCenterCommand = new AlignCenterCommand(textPane);
        findAndReplaceCommand = new FindAndReplaceCommand(textPane);
        undoCommand = new UndoCommand(textPane);

        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                undoCommand.execute();
            }
        });


        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alignLeftCommand.execute();
            }
        });


        centerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alignCenterCommand.execute();
            }
        });


        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alignRightCommand.execute();
            }
        });


        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { findCommand.execute(); }
        });

        findAndReplaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { findAndReplaceCommand.execute(); }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Humble Text Editor");
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setContentPane(new HumbleTextEditor().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
