package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Spielfeld;

import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.GridLayout;

public class Spielfeldzeichnen extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblMinesweeper;
	private JPanel panel_1;
	
	int xwert = Spielfeld.getXmax();
	int ywert = Spielfeld.getYmax();
	JLabel[][] feld = new JLabel[xwert][ywert];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Spielfeldzeichnen frame = new Spielfeldzeichnen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Spielfeldzeichnen() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow]", "[][grow]"));

		lblMinesweeper = new JLabel("Minesweeper");
		lblMinesweeper.setFont(new Font("Century Schoolbook", Font.PLAIN, 16));
		panel.add(lblMinesweeper, "cell 1 0,alignx center");

		panel_1 = new JPanel();
		panel_1.setLayout(new GridLayout(xwert, ywert, 0, 0));
		panel.add(panel_1, "cell 0 1 3 1,grow");

		int[][] spiel = Spielfeld.getSpielfeld();
		Felderfüllen(feld, panel_1, spiel);
		
	}

	public void Felderfüllen(JLabel[][] feld,JPanel panel,int[][] spiel)
	{
		for(int i = 0; i<xwert; i++) {
			for(int j = 0; j<ywert; j++) {
				feld[i][j] = new JLabel();
				feld[i][j].setVisible(true);
				feld[i][j].setBackground(Color.WHITE);
				if(spiel[i][j]==-1)
				{
					feld[i][j].setText("*");
				}
				else{
					feld[i][j].setText(""+spiel[i][j]);
				}
				panel_1.add(feld[i][j]);
			}
		}
	}

}
