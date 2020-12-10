package gui;

import model.domain.chooser.ApplicationChooser;
import yaml_converter.YamlLoader;

import javax.swing.*;

public class StartWindow implements Gui {
    @Override
    public void show() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JPanel upperPanel = new JPanel();
        JPanel downPanel = new JPanel();

        JLabel label = new JLabel("what kind of application do you want to use: ");
        JButton buttonGui = new JButton("Gui application");
        buttonGui.addActionListener(actionEvent -> {
            frame.dispose();
            String className = YamlLoader.loadYamlFile("firstAppClassName");
            String methodName = YamlLoader.loadYamlFile("firstAppMethodName");
            ApplicationChooser.chooseApplication(className, methodName);
        });
        JButton buttonConsole = new JButton(" Console application");
        buttonConsole.addActionListener(actionEvent -> {
            frame.dispose();
            String className = YamlLoader.loadYamlFile("secondAppClassName");
            String methodName = YamlLoader.loadYamlFile("secondAppMethodName");
            ApplicationChooser.chooseApplication(className, methodName);
        });
        frame.getContentPane().add(panel);
        panel.add(upperPanel);
        panel.add(downPanel);
        upperPanel.add(label);
        downPanel.add(buttonGui);
        downPanel.add(buttonConsole);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
