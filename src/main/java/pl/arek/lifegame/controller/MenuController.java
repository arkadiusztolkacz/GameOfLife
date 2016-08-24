package pl.arek.lifegame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.arek.lifegame.model.Board;
import pl.arek.lifegame.view.BoardPanel;
import pl.arek.lifegame.view.ButtonPanel;

@Service
public class MenuController {
	@Autowired
	private Board board;
	@Autowired
	private ButtonPanel buttonPanel;
	@Autowired
	private BoardPanel boardPanel;
	private boolean suspend = false;

	public ActionListener newStartListener() {
		return new StartListener();
	}

	public ActionListener newPauseListener() {
		return new PauseListener();
	}

	public ActionListener newExitListener() {
		return new ExitListener();
	}

	private class StartListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			suspend = false;
			buttonPanel.enableOrDisableButtons();

			LifeRunnable life = new LifeRunnable();
			Thread thread = new Thread(life);
			thread.start();
		}
	}

	private class PauseListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			suspend = true;
			buttonPanel.enableOrDisableButtons();
		}
	}

	private class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	private class LifeRunnable implements Runnable {
		public void run() {
			try {
				for (int i = 0; i < 1000; i++) {
					if (!suspend) {
						board.nextCycle();
						boardPanel.nextCycle();
						Thread.sleep(1000);
					}
				}
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}
}
