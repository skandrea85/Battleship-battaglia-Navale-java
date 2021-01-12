package controller;

import java.util.Random;
import java.util.Scanner;

public class ControllerComp {

	static Random ra =new Random();

	public static void main(String[] args) {
		String[][] campoUs=new String[12][12];

		String[][] campoCom=new String[10][10];


		for(int i=0;i<campoUs.length;i++) {
			//ciclo annidato per i margini della matrice faccio una cornice di uno per far riconoscere i margini al computer 
			//e non andare in errore durante l'esecuzione del programma 
			for(int j=0;j<campoUs[i].length;j++) {

				campoUs[i][j]="0";
				campoUs[0][j]="1";
				campoUs[i][0]="1";
				campoUs[i][11]="1";
				campoUs[11][j]="1";

			}
		}

		for(int i=0;i<campoUs.length-1;i++) {
			//ciclo utile solo per la stampa non itero tutto l'array ma salto l'ultima riga e colonna 
			//mentre alle prime  colonne e righe stampo alfabeto e numerazione(senza modificare i valori) fino a dieci utili per individuare le caselle 
			for(int j=0;j<campoUs[i].length-1;j++) {

				int add=i;
				char d=(char) (96+j);

				if(j==0&&i>=1&&i<10) {
					System.out.print(""+add);
				}

				else if(i==0&&j>=1) {
					System.out.print(""+d);						
				}
				else if(i==0&&j==0) {
					System.out.print(campoUs[i][j]);
				}
				else  if(i==10&&j==0){							
					System.out.print(campoUs[i][j]);
				}
				else {
					System.out.print(campoUs[i][j]);
				}
			}
			System.out.println();		
		}
		for(String[] m: campoUs) {
			for(String s:m) {

				System.out.print(s);

			}
			System.out.println();

		}

		//control(campoCom);
	//	for(int i=0;i<10;i++) {
		//		for(int j=0;j<10;j++) {
		//			if(campoCom[i][j]==null) {
		//				
		//				campoCom[i][j]="0";
		//				
		//			}
		//			System.out.print(campoCom[i][j]);
		//			
		//		}
		//		System.out.println();
		//		
		//		
		//
		//	}




	}

	public static void  colpisci(String[][] a,int x, int y) {
		
		if(a[x][y].equals("x")) {
			
			System.out.println("Colpita!");
			a[x][y]="c";
		}
		
		else if(a[x][y].equals("0")) {
			a[x][y]="f";
			
			System.out.println("Mancato!");
			
		}
		
		else if(a[x][y].equals("f")) {
			
			
			System.out.println("Già colpito!");
			
		}
		
		else {
			
			System.out.println("valore non valido!");
		}
		

	}	
	public static String[][] PO11(String[][] oc ) {

		//coordinate nave incrociatore 3 caselle
		//inserimento o per orientamento orizzontale o altro per orizz

		String orient="";
		int p=ra.nextInt(2);

		if(p==1) {

			orient="o";
		}else {

			orient="v";
		}


		int x=0;

		int y=0;

			if(orient.equals("o")) {
			x=	ra.nextInt(10);
			y=	ra.nextInt(8);
			
				while(oc[x][y]!=null||oc[x][y+1]!=null||oc[x][y+2]!=null) {

					x=ra.nextInt(10);

					y=ra.nextInt(8);

				}


				oc[x][y]="x";
				oc[x][y+1]="x";
				oc[x][y+2]="x";
			}else {
				x=ra.nextInt(8);
				y=ra.nextInt(10);

				while(oc[x][y]!=null||oc[x+1][y]!=null||oc[x+2][y]!=null) {
					x=ra.nextInt(8);

					y=ra.nextInt(10);

				}

				oc[x][y]="x";
				oc[x+1][y]="x";
				oc[x+2][y]="x";

			}
		
		// coordinata nave sottomarino
		//orientamneto
		p=ra.nextInt(2);

		if(p==1) {

			orient="o";
		}else {

			orient="v";
		}

			if(orient.equals("o")) {
				
				x=ra.nextInt(10);

				y=ra.nextInt(8);
				while(oc[x][y]!=null||oc[x][y+1]!=null||oc[x][y+2]!=null) {

					x=ra.nextInt(10);

					y=ra.nextInt(8);

				}


				oc[x][y]="x";
				oc[x][y+1]="x";
				oc[x][y+2]="x";
			}else {
				x=ra.nextInt(8);

				y=ra.nextInt(10);

				while(oc[x][y]!=null||oc[x+1][y]!=null||oc[x+2][y]!=null) {
					x=ra.nextInt(8);

					y=ra.nextInt(10);

				}

				oc[x][y]="x";
				oc[x+1][y]="x";
				oc[x+2][y]="x";

			}

		//coordinate nave da'assalto 
		//orientamento

		p=ra.nextInt(2);

		if(p==1) {

			orient="o";
		}else {

			orient="v";
		}



		
			if(orient.equals("o")) {
				
				//genero coordinate random

				x=ra.nextInt(10);

				y=ra.nextInt(9);
				while(oc[x][y]!=null||oc[x][y+1]!=null) {

					x=ra.nextInt(10);

					y=ra.nextInt(9);

				}


				oc[x][y]="x";
				oc[x][y+1]="x";

			}else {
				//coordinate

				x=ra.nextInt(9);

				y=ra.nextInt(10);

				while(oc[x+0][y]!=null||oc[x+1][y]!=null) {
					x=ra.nextInt(9);

					y=ra.nextInt(10);

				}

				oc[x][y]="x";
				oc[x+1][y]="x";

			}
		

		//coordinate nave corazzata 4 caselle
		//genero oriantamento nave vertical o orizzontale

		p=ra.nextInt(2);

		if(p==1) {

			orient="o";
		}else {

			orient="v";
		}
	
			if(orient.equals("o")) {
				//genero coordinate random
				x=ra.nextInt(10);

				y=ra.nextInt(7);
				//controllo se sono presnti navi altrimento genero altre coordinate random
				while(oc[x][y]!=null||oc[x][y+1]!=null||oc[x][y+2]!=null||oc[x][y+3]!=null) {

					x=ra.nextInt(10);

					y=ra.nextInt(7);

				}


				oc[x][y]="x";
				oc[x][y+1]="x";
				oc[x][y+2]="x";
				oc[x][y+3]="x";
			}else {
				
				//genero coordinate random
				x=ra.nextInt(7);

				y=ra.nextInt(10);

				while(oc[x+0][y]!=null||oc[x+1][y]!=null||oc[x+2][y]!=null||oc[x+3][y]!=null) {
					x=ra.nextInt(7);

					y=ra.nextInt(10);

				}

				oc[x][y]="x";
				oc[x+1][y]="x";
				oc[x+2][y]="x";
				oc[x+3][y]="x";

			}

		//coordinate nave portaerei
		//orientamento

		p=ra.nextInt(2);

		if(p==1) {

			orient="o";
		}else {

			orient="v";
		}

		//coordinate
			if(orient.equals("o")) {
				
				x=ra.nextInt(10);

				y=ra.nextInt(6);
				while(oc[x][y]!=null||oc[x][y+1]!=null||oc[x][y+2]!=null||oc[x][y+3]!=null||oc[x][y+4]!=null) {

					x=ra.nextInt(10);

					y=ra.nextInt(6);

				}

				oc[x][y]="x";
				oc[x][y+1]="x";
				oc[x][y+2]="x";
				oc[x][y+3]="x";
				oc[x][y+4]="x";
			}else {
				
				x=ra.nextInt(6);

				y=ra.nextInt(10);

				while(oc[x+0][y]!=null||oc[x+1][y]!=null||oc[x+2][y]!=null||oc[x+3][y]!=null||oc[x+4][y]!=null) {
					x=ra.nextInt(6);

					y=ra.nextInt(10);

				}

				oc[x][y]="x";
				oc[x+1][y]="x";
				oc[x+2][y]="x";
				oc[x+3][y]="x";
				oc[x+4][y]="x";

			}
						
		return oc;

	}


	



	
}
