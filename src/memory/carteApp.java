package memory;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Deque;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RootPaneContainer;
import javax.swing.SwingUtilities;

import memory.FrameForDemoMaker;
import memory.ResourceUtility;
import memory.Jeu;

public class carteApp extends FrameForDemoMaker {

	private ImageIcon dosCarte = ResourceUtility.loadImage("images/dos.png");
	private Jeu jeu = new Jeu();

	public carteApp() throws IOException{
		super("Mémoire");
		setDefaultBounds(100,100,900,600);
	}  
	private static final int ROW_COUNT = 4;
	private static final int COLUMN_COUNT = 6;

	@Override
	public void init(JFrame frame) {
		Container cp = frame.getContentPane();
		cp.setLayout(new GridLayout(ROW_COUNT, COLUMN_COUNT));

		Deque<ImageIcon> pioche = jeu.creerPioche();
		while(!pioche.isEmpty()) {
			cp.add(createButtonShuffle(pioche));
		}        
	}

	private Component createButtonShuffle(Deque<ImageIcon> pioche) {
		JButton buttoon = new JButton(pioche.pop());
		return buttoon;
	}



	public JComponent createButton(int row, int column) {
		JButton button = new JButton(dosCarte);
		return button;
	}

	public static void main(String[] args) throws IOException {
		carteApp example = new carteApp();
		SwingUtilities.invokeLater(example);
	}
}