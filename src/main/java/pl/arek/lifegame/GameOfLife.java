package pl.arek.lifegame;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.arek.lifegame.model.Board;

public class GameOfLife {
    public static void main(String[] args) {
    	ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
		Board board = context.getBean(Board.class);
		System.out.println(board.getState());
		
    }
}
