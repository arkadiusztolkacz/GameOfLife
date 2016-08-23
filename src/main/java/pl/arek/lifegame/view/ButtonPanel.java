package pl.arek.lifegame.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.arek.lifegame.controller.MenuController;

@Component
public class ButtonPanel extends JPanel{
	 private final JButton startButton = new JButton("Start");
	    private final JButton endButton = new JButton("Close");
	    private final JButton pauseButton = new JButton("Pause");
	    
	    @Autowired
	    ButtonPanel(MenuController menuController) {
	        //pauseButton.setEnabled(false);
	    	
	    	startButton.addActionListener(menuController.newStartListener());
	    	pauseButton.addActionListener(menuController.newPauseListener());
	    	endButton.addActionListener(menuController.newExitListener());
	    	
	        this.add(startButton);
	        this.add(pauseButton);
	        this.add(endButton);
	    }
}
