package pl.arek.lifegame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.arek.lifegame.view.ButtonPanel;

@Service
public class MenuController {
	
	@Autowired
	private ButtonPanel buttonPanel;
	
	public ActionListener newStartListener(){
		return new StartListener();
	}
	
	public ActionListener newPauseListener(){
		return new PauseListener();
	}
	
	public ActionListener newExitListener(){
		return new ExitListener();
	}
	
	private class StartListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Start working");
            buttonPanel.enableOrDisablePause(true);
            buttonPanel.enableOrDisableStart(false);
        }
    }
	
	private class PauseListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	buttonPanel.enableOrDisablePause(false);
            buttonPanel.enableOrDisableStart(true);
        }
    }
	
	private class ExitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
