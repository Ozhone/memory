package memory;

import java.io.IOException;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

import memory.ResourceUtility;

public class Jeu {
	private ImageIcon[][] figures = loadImages();

	public Jeu() throws IOException {}
	
	public ImageIcon[][] loadImages() throws IOException {
		int rows = 4;
		int cols = 3;
		ImageIcon[][] images = ResourceUtility.splitImageIcon(
				ResourceUtility.loadBufferedImage("images/butterfly2.png")
				, rows, cols);
		int index = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				images[i][j].setDescription("c"+index++);
			}
		}
		return images;
	}

	public Deque<ImageIcon> creerPioche(){
		LinkedList<ImageIcon> pioche = new LinkedList<>();
		int row = 4;
		int col = 3;
		int x = 0;
		int z = 0;
		int k = 0;
		for (k = 0; k <2; k++) {
		for (x = 0; x < row; x++) {
			for (z = 0; z < col; z++) {
			pioche.add(figures[x][z]);
			Collections.shuffle(pioche);
		}
		}
		}
System.out.println(pioche);
		return pioche;
	}

}

