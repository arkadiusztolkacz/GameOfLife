package pl.arek.lifegame.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

@Component
public class ButtonPanel extends JPanel{
	 private final JButton startButton = new JButton("Start");
	    private final JButton endButton = new JButton("Close");
	    private final JButton pauseButton = new JButton("Pause");

	    ButtonPanel() {
	        pauseButton.setEnabled(false);

	        this.add(startButton);
	        this.add(pauseButton);
	        this.add(endButton);
	    }
}
