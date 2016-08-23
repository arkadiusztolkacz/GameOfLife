package pl.arek.lifegame.model.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BoardSize {
	@Value("${board.columns}")
	private int columns;
	@Value("${board.rows}")
	private int rows;

	public int getColumns() {
		return columns;
	}

	public int getRows() {
		return rows;
	}

}
