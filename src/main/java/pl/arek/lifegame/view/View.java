package pl.arek.lifegame.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class View extends JFrame {
	
//	@Autowired
//	private BoardPanel boardPanel;
//	@Autowired
//	private ButtonPanel buttonPanel;
	
	 final static Color EMPTY_COLOR = Color.CYAN;
	 final static Color FILLED_COLOR = Color.RED;
	
	public View(BoardPanel boardPanel, ButtonPanel buttonPanel){
		super("Game of Life");
		this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(boardPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.pack();
	}
}
