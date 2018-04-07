package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.BtnSpielfeldActionListener;
import control.BtnWeiterActionListener;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Spiel extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JPanel panel;
	private static JLabel lblAnzahlSpalten;
	private static JTextField textField_Spalte;
	private static JLabel lblAnzahlReihen;
	private static JTextField textField_Reihe;
	private static JPanel panel_1;
	private static JLabel lblMinesweeper;
	private static JButton btnWeiter;
	private static JLabel lblBombenanzahl;
	private static JTextField textField_Bombenanzahl;
	private static JButton btnSpielfeld;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Spiel frame = new Spiel();
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
	public Spiel() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(new MigLayout("", "[][][right][grow]", "[grow][][][][][][grow]"));
		
		setLblAnzahlSpalten(new JLabel("Anzahl Spalten:"));
		panel.add(getLblAnzahlSpalten(), "cell 1 1");
		getLblAnzahlSpalten().setVisible(true);
		
		setTextField_Spalte(new JTextField());
		panel.add(getTextField_Spalte(), "cell 1 2,growx");
		getTextField_Spalte().setColumns(10);
		textField_Spalte.setVisible(true);
		
		setLblAnzahlReihen(new JLabel("Anzahl Reihen:"));
		panel.add(getLblAnzahlReihen(), "cell 1 3");
		getLblAnzahlReihen().setVisible(true);
		
		setTextField_Reihe(new JTextField());
		panel.add(getTextField_Reihe(), "cell 1 4,growx");
		getTextField_Reihe().setColumns(10);
		textField_Reihe.setVisible(true);
		
		setLblBombenanzahl(new JLabel("Bombenanzahl:"));
		panel.add(getLblBombenanzahl(), "cell 2 3");
		getLblBombenanzahl().setVisible(false);
		
		textField_Bombenanzahl = new JTextField();
		panel.add(textField_Bombenanzahl, "cell 2 4,growx");
		textField_Bombenanzahl.setColumns(10);
		textField_Bombenanzahl.setVisible(false);
		
		setBtnWeiter(new JButton("weiter"));
		panel.add(getBtnWeiter(), "cell 1 5,growx");
		getBtnWeiter().addActionListener(new BtnWeiterActionListener());
		getBtnWeiter().setVisible(true);
		
		setBtnSpielfeld(new JButton("Spielfeld"));
		panel.add(getBtnSpielfeld(), "cell 2 5");
		getBtnSpielfeld().addActionListener(new BtnSpielfeldActionListener());
		getBtnSpielfeld().setVisible(false);
		
		panel_1 = new JPanel();
		splitPane.setLeftComponent(panel_1);
		panel_1.setLayout(new MigLayout("", "[]", "[grow,fill][][grow,fill]"));
		
		lblMinesweeper = new JLabel("Minesweeper");
		panel_1.add(lblMinesweeper, "cell 0 1");
		
	}

	public static JTextField getTextField_Spalte() {
		return textField_Spalte;
	}

	public static void setTextField_Spalte(JTextField textField_Spalte) {
		Spiel.textField_Spalte = textField_Spalte;
	}

	public static JTextField getTextField_Reihe() {
		return textField_Reihe;
	}

	public static void setTextField_Reihe(JTextField textField_Reihe) {
		Spiel.textField_Reihe = textField_Reihe;
	}

	public static JTextField getTextField_Bombenanzahl() {
		return textField_Bombenanzahl;
	}

	public static void setTextField_Bombenanzahl(JTextField textField_Bombenanzahl) {
		Spiel.textField_Bombenanzahl = textField_Bombenanzahl;
	}

	public static JLabel getLblAnzahlReihen() {
		return lblAnzahlReihen;
	}

	public void setLblAnzahlReihen(JLabel lblAnzahlReihen) {
		this.lblAnzahlReihen = lblAnzahlReihen;
	}

	public static JLabel getLblAnzahlSpalten() {
		return lblAnzahlSpalten;
	}

	public static void setLblAnzahlSpalten(JLabel lblAnzahlSpalten) {
		Spiel.lblAnzahlSpalten = lblAnzahlSpalten;
	}

	public static JButton getBtnWeiter() {
		return btnWeiter;
	}

	public void setBtnWeiter(JButton btnWeiter) {
		this.btnWeiter = btnWeiter;
	}

	public static JLabel getLblBombenanzahl() {
		return lblBombenanzahl;
	}

	public void setLblBombenanzahl(JLabel lblBombenanzahl) {
		Spiel.lblBombenanzahl = lblBombenanzahl;
	}

	public static JButton getBtnSpielfeld() {
		return btnSpielfeld;
	}

	public void setBtnSpielfeld(JButton btnSpielfeld) {
		Spiel.btnSpielfeld = btnSpielfeld;
	}
	

}
