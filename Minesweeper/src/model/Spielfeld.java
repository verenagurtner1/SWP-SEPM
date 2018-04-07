package model;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Spielfeld {

	static int anzahlbomben=10;
	static int xmax=5;
	static int ymax=5;
	static int anzahlbombenpronzent;

	//Spielfeld
	private static int[][] spielfeld = new int[xmax][ymax];

	public static void main(String[] args) {
		System.out.println("Lass uns ein Spiel spielen:");
		//Spielfeldmachen();
	}

	public static int getAnzahlbomben() {
		return anzahlbomben;
	}



	public static void setAnzahlbomben(int anzahlbomben) {
		Spielfeld.anzahlbomben = anzahlbomben;
	}



	public static int getXmax() {
		return xmax;
	}

	public static void setXmax(int xmax) {
		if(xmax>4 && xmax<21)
		{
			Spielfeld.xmax = xmax;
		}else{
			System.out.println("Der eingegebene Wert ist zu hoch bzw zu niedrig");
		}

	}

	public static int getYmax() {
		return ymax;
	}

	public static void setYmax(int ymax) {
		if(ymax>4 && ymax<21)
		{
			Spielfeld.ymax = ymax;
		}else{
			System.out.println("Der eingegebene Wert ist zu hoch bzw zu niedrig");
		}

	}

	public static int[][] Spielfeldmachen()
	{
		Spielfeldauslesen();
		//alle Werte des 2-D-Array 0 setzen
		for(int i = 0; i<xmax;i++)
		{
			for(int j = 0; j<ymax;j++)
			{
				getSpielfeld()[i][j] = 0;
			}
		}

		//Bomben setzen
		int gesetztebombenanzahl = 0;
		while(gesetztebombenanzahl<anzahlbomben)
		{
			Random random = new Random();
			int zahlx = random.nextInt(xmax);
			int zahly = random.nextInt(ymax);

			if(getSpielfeld()[zahlx][zahly] != -1)
			{

				getSpielfeld()[zahlx][zahly] = -1;
				gesetztebombenanzahl++;
				//System.out.println("der vogel ist gelandet");
			}
		};

		int kontrolle=0;

		Spielfeldauslesen();

		//Zahlen setzen
		for(int i = 0; i<xmax;i++)
		{
			for(int j = 0; j<ymax;j++)
			{
				if(getSpielfeld()[i][j] == -1)
				{
					for(int x = i-1;x<i+2;x++)
					{
						for(int y = j-1;y<j+2;y++)
						{
							if(x>-1&&x<xmax && y>-1&&y<ymax && getSpielfeld()[x][y] !=-1){
								getSpielfeld()[x][y]= getSpielfeld()[x][y] +1;

							}

						}
					}
				}
			}
		}

		Spielfeldauslesen();
		return getSpielfeld();
	}

	public static void Spielfeldauslesen()
	{
		//Spielfeld ausgeben
		System.out.println("Spielfeld ausgeben: ");
		for(int i = 0; i<xmax;i++)
		{
			for(int j = 0; j<ymax;j++)
			{
				System.out.print("\t"+ getSpielfeld()[i][j]);
			}
			System.out.println("");
		}

	}


	public static int[][] getSpielfeld() {
		return spielfeld;
	}


	public static void setSpielfeld(int[][] spielfeld) {
		Spielfeld.spielfeld = spielfeld;
	}
	
	public static boolean Bedingungen(int l,int b) throws IllegalArgumentException{
		if(l <5 || l>20) throw new IllegalArgumentException();
		if(b <5 || b>20) throw new IllegalArgumentException();
		
		return true;
	}
}
