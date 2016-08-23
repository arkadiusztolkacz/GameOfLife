package pl.arek.lifegame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.stereotype.Service;

@Service
public class BoardController {
	
	public ActionListener newMakeLifeListener(){
		return new MakeLifeListener();
	}

	private class MakeLifeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("I'm working");
		}
	}
}
