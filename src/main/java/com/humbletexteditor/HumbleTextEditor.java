
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
    private JMenuBar menuBar;
    private JMenu fileMenu, aboutMenu;



    private AlignLeftCommand alignLeftCommand;
    private AlignRightCommand alignRightCommand;
    private AlignCenterCommand alignCenterCommand;
    private FindCommand findCommand;
    private FindAndReplaceCommand findAndReplaceCommand;
    private UndoCommand undoCommand;
    private OpenFileCommand openFileCommand;
    private SaveFileCommand saveFileCommand;
    private NewFileCommand newFileCommand;



    public HumbleTextEditor() {

        findCommand = new FindCommand(textPane);
        alignLeftCommand = new AlignLeftCommand(textPane);
        alignRightCommand = new AlignRightCommand(textPane);
        alignCenterCommand = new AlignCenterCommand(textPane);
        findAndReplaceCommand = new FindAndReplaceCommand(textPane);
        undoCommand = new UndoCommand(textPane);

        saveFileCommand = new SaveFileCommand(textPane);
        newFileCommand = new NewFileCommand(textPane);
        openFileCommand = new OpenFileCommand(textPane);

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        aboutMenu = new JMenu("About");
        menuBar.add(fileMenu);
        menuBar.add(aboutMenu);

        fileMenu.add(new JMenuItem("New")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newFileCommand.execute();
            }
        });


        fileMenu.add(new JMenuItem("Save")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFileCommand.execute();
            }
        });


        fileMenu.add(new JMenuItem("Open")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFileCommand.execute();
            }
        });




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
        HumbleTextEditor humbleTextEditor = new HumbleTextEditor();
        frame.setContentPane(humbleTextEditor.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        frame.setJMenuBar(humbleTextEditor.menuBar);


        frame.pack();
        frame.setVisible(true);
    }
}
