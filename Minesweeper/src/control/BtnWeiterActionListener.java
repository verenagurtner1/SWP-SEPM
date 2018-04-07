package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Spielfeld;
import view.Spiel;

public class BtnWeiterActionListener implements ActionListener {
	
	static int reihen = 0;
	static int spalten = 0;

	@Override
	public void actionPerformed(ActionEvent e) {
		//int w = slider.getValue();
		String r = Spiel.getTextField_Spalte().getText();
		String s = Spiel.getTextField_Reihe().getText();
		try{
			reihen = Integer.parseInt(r);
			spalten = Integer.parseInt(s);
			
			if(Spielfeld.Bedingungen(spalten, reihen) ==true)
			{
				Spielfeld.setXmax(spalten);
				Spielfeld.setYmax(reihen);
				
				Spiel.getTextField_Reihe().setVisible(false);
				Spiel.getLblAnzahlReihen().setVisible(false);
				Spiel.getLblAnzahlSpalten().setVisible(false);
				Spiel.getTextField_Spalte().setVisible(false);
				Spiel.getBtnWeiter().setVisible(false);
				Spiel.getLblBombenanzahl().setVisible(true);
				Spiel.getTextField_Bombenanzahl().setVisible(true);
				Spiel.getBtnSpielfeld().setVisible(true);
			}
			
		}
		catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(null, "Ungültige Eingabe, es müssen Zahlen eingegeben werden!");
		}
		catch(IllegalArgumentException ix){
			JOptionPane.showMessageDialog(null, "Die Reihen bzw. Spaltenanzahl liegt außerhalb des erlaubten Bereiches von 5-20.");
		}
		
	
	}

}


