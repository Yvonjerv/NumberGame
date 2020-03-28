package homework;
/*
 * YVON
 */
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JFrame {
	private JFrame myframe;

	public Game() {
		JPanel panel = new JPanel();
		//
		JMenuBar bar;
		JMenu menuFile, menuHelp;
		JMenuItem startGame, closeGame, aboutGame;

		bar = new JMenuBar();
		menuFile = new JMenu("File");
		menuHelp = new JMenu("Help");

		startGame = new JMenuItem("Start Game");
		closeGame = new JMenuItem("End Game");

		aboutGame = new JMenuItem("About");

		menuFile.add(startGame);
		menuFile.addSeparator();
		menuFile.add(closeGame);

		menuHelp.add(aboutGame);
		bar.add(menuFile);

		bar.add(menuHelp);
		setJMenuBar(bar);

		//
		aboutGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null,
						"Please find the number from 1 to 25 in the shortest time \n"
								+ "and click the corresponding button to observe your attention.",
						"Help", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		closeGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		startGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = new innerFrame();
				f.setTitle("Super Game");// Set the title bar.

				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// End the process by clicking the Close button.
				f.setBounds(400, 200, 500, 400);// Window size.
				f.setVisible(true);

				// panel.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			}
		});

	}

	class innerFrame extends JFrame {

		public innerFrame() {
			JPanel panel = new JPanel();
			//
			JMenuBar bar;
			JMenu menuFile, menuHelp;
			JMenuItem startGame, closeGame, aboutGame;

			bar = new JMenuBar();
			menuFile = new JMenu("File");
			menuHelp = new JMenu("Help");

			startGame = new JMenuItem("Start Game");
			closeGame = new JMenuItem("End Game");

			aboutGame = new JMenuItem("About");

			menuFile.add(startGame);
			menuFile.addSeparator();
			menuFile.add(closeGame);

			menuHelp.add(aboutGame);
			bar.add(menuFile);

			bar.add(menuHelp);
			setJMenuBar(bar);

			String[] name = new String[25];

			for (int i = 0; i < name.length; i++) {
				name[i] = "" + (i + 1);
			}
			Collections.shuffle(Arrays.asList(name));
			//
			panel.setLayout(new GridLayout(5, 5, 2, 2));

			for (int i = 0; i < name.length; i++) {
				JButton button = new JButton(name[i]);
				Font font = button.getFont();
				font = font.deriveFont(font.getSize() * 1.4f);
				button.setFont(font);
				// button.setForeground(new Color(255,255,255));
				// button.setBackground(new Color(27,34,45));
				button.addActionListener(new MyActionListener());
				panel.add(button);
			}

			this.add(panel, BorderLayout.CENTER);

		}

	}

	int[] records = new int[25];
	int counter = 0;
	long getTime;
	long startTime = 0, endTime = 0;

	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			String allRecord = "";
			if (counter == 1) {
				startTime = System.currentTimeMillis();
			}
			if (counter < 26) {
				records[counter] = (int) Double.parseDouble(action);
				counter++;
			}
			if (counter == 25) {
				endTime = System.currentTimeMillis();
				getTime = (endTime - startTime) / 1000;
				for (int i = 0; i < 25; i++) {
					System.out.print(records[i] + "\t");
					counter = 0;
					allRecord += records[i] + " , ";
				}
				System.out.println();
				int accu = compareNumber();
				JOptionPane.showMessageDialog(null,
						"Congratulations on your success!\n" + allRecord.substring(0, allRecord.length() - 2)
								+ "\nYour percentage of accuracy is: " + accu + "%" + "\nDuration: " + getTime
								+ "seconds",
						"Message Box", JOptionPane.PLAIN_MESSAGE);
			}
		}
}

	int compareNumber() {
		double[] correct = new double[25];
		int score = 0;

		for (int i = 0; i < 25; i++) {
			correct[i] = (i + 1);
		}

		for (int i = 0; i < correct.length; i++) {
			if (correct[i] == records[i]) {
				score++;
			}
		}
		return (score * 4);
	}

	public static void main(String[] args) {
		JFrame f = new Game();// Initialization is called to generate the calculator window.
		f.setTitle("Super Game");// Set the title bar.
		// f.setIconImage(new
		// ImageIcon("src/homework/icons8_light_switch_99px_1.png").getImage());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// End the process by clicking the Close button.
		f.setBounds(400, 200, 500, 400);// Window size.
		f.setVisible(true);
	}

}
