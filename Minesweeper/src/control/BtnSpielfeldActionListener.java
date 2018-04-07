package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Spielfeld;
import view.Spiel;
import view.Spielfeldzeichnen;

public class BtnSpielfeldActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		int xwert = Spielfeld.getXmax();
		int ywert = Spielfeld.getYmax();

		String bomben = Spiel.getTextField_Bombenanzahl().getText();
		
		try{
			int bombenanzahl = Integer.parseInt(bomben);
			int bombenprozent = 0;
			
			bombenprozent=100*bombenanzahl/(xwert*ywert);
			
			if(bombenprozent<70)
			{
				Spielfeld.setAnzahlbomben(bombenanzahl);
				int[][] spielfeld = new int[xwert][ywert];
				Spielfeld.setSpielfeld(spielfeld);
				Spielfeld.Spielfeldmachen();
				Spielfeldzeichnen.main(null);
			}else{
				JOptionPane.showMessageDialog(null, "Die Anzahl an Bomben ist zu hoch");
			}
			
			
		}
		catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(null, "Ungültige Eingabe, es müssen Zahlen eingegeben werden!");
		}
	}

}
