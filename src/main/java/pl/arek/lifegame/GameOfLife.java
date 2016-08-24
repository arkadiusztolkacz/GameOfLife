package pl.arek.lifegame;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.arek.lifegame.view.View;

public class GameOfLife {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
		View view = context.getBean(View.class);
		view.setVisible(true);
	}
}
