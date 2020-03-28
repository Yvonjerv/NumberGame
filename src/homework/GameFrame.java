package homework;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
 

public class GameFrame extends JFrame {

	public JMenuBar bar = new JMenuBar();
	public JPanel panel = new JPanel();
	public JMenu menuFile = new JMenu("File");
	public JMenu menuHelp = new JMenu("Help");

	public JMenuItem startGame = new JMenuItem("Start Game");
	public JMenuItem closeGame = new JMenuItem("Close Game");
	public JMenuItem aboutGame = new JMenuItem("About");

	int[] records = new int[25];
	int counter = 0;
	long getTime;
	long startTime = 0, endTime = 0;

	public GameFrame() {

		this.setTitle("Super Game");
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		this.add(panel);
		this.setLayout(new FlowLayout());

		
		menuFile.add(startGame);
		menuFile.addSeparator();
		menuFile.add(closeGame);

		menuHelp.add(aboutGame);
		bar.add(menuFile);

		bar.add(menuHelp);
		setJMenuBar(bar);

		// aboutGame
		aboutGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null,
						"Please find the number from 1 to 25 in the shortest time \n"
								+ "and click the corresponding button to observe your attention.",
						"Help", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		// startGame
		startGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				init();
			}
		});

	}

	void init() {
		JPanel panel1 = new JPanel();
		panel1.setVisible(true);
		panel1.setSize(500, 400);
				
		String[] name = new String[25];

		for (int i = 0; i < name.length; i++) {
			name[i] = "" + (i + 1);
		}
		Collections.shuffle(Arrays.asList(name));
		

		panel1.setLayout(new GridLayout(5, 5, 1, 1));

		for (int i = 0; i < name.length; i++) {
			JButton button = new JButton(name[i]);
			Font font = button.getFont();
			font = font.deriveFont(font.getSize() * 1.4f);
			button.setFont(font);
			button.addActionListener(new MyActionListener());
			panel1.add(button);
		}
		
		//this.add(panel1, BorderLayout.CENTER);
		panel.add(panel1);
	}

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
	}
}
