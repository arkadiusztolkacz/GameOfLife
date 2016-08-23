package pl.arek.lifegame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.stereotype.Service;

@Service
public class MenuController {
	
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
        }
    }
	
	private class PauseListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Pause working");
        }
    }
	
	private class ExitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
