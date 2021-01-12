package controller;

import java.util.Scanner;

public class ControlliUser {

	 boolean parita=true;

     Scanner sc=new Scanner(System.in);
	
	 String[][] campoUs=new String[12][12];	


	public ControlliUser() {//valori fissi inseriti dal costruttore
		for(int i=0;i<campoUs.length;i++) {
			//ciclo annidato per creare margini della matrice faccio una cornice di uno per far riconoscere i margini al computer 
			//e non andare in errore durante l'esecuzione del programma 
			for(int j=0;j<campoUs[i].length;j++) {

				campoUs[i][j]="0";
				campoUs[0][j]="1";
				campoUs[i][0]="1";
				campoUs[i][11]="1";
				campoUs[11][j]="1";

			}
		}
		
	}

	public  void spara(String[][] a) {

		int x=0;
		int y=0;
		System.out.println("E' il tuo turno colpisici le navi dell' avversario!!");
		int[] coor=inserisciCoordinateUs();
	
		
		x=coor[0];
		y=coor[1];

		if((a[x][y].equals("i")||a[x][y].equals("s")||a[x][y].equals("a")||a[x][y].equals("z")||a[x][y].equals("p"))) {
			a[x][y]="c";
			

			System.out.println("Colpita! nave computer! "+x+y);
		}
		else if(a[x][y].equals("0")) {
			a[x][y]="f";

			System.out.println("Colpo Mancato!");

		}

		else if(a[x][y].equals("f")||a[x][y].equals("c")) {

			System.out.println("Già colpito!");

		}

		else {

			System.out.println("valore non valido!");
		}

	}
	
	public  void posizionaNavi(String[][] oc ) {

		//coordinate nave incrociatore 3 caselle
		//inserimento o per orientamento orizzontale o altro per orizz
		int x=0;

		int y=0;
		int[] coor=new int[2];

		do {
			
			deleteX(oc);
			stampaCampoUs();
			System.out.println("posizona le tue navi sul campo di battaglia!");
			System.out.println("posiziona le nave incrociatore ");
			try {


		if(Orientamento()) {
			do {
				System.out.println("posiziona le nave incrociatore orizzontale ");

					coor=inserisciCoordinateUs();
					x=coor[0];
					y=coor[1];
		
			}
			while(oc[x][y]!="0"||oc[x][y+1]!="0"||oc[x][y+2]!="0");
			oc[x][y]="x";
			oc[x][y+1]="x";
			oc[x][y+2]="x";	


		}
		else {
			do {
				
				System.out.println("posiziona le nave incrociatore verticale ");
			
					coor=inserisciCoordinateUs();
					x=coor[0];
					y=coor[1];

		
			}

			while(oc[x][y]!="0"||oc[x+1][y]!="0"||oc[x+2][y]!="0"); 
			
			oc[x][y]="x";
			oc[x+1][y]="x";
			oc[x+2][y]="x";

			
		}
		
		stampaCampoUs();

		// coordinata nave sottomarino
		//orientamneto

		System.out.println("coordinate nave sottomarino");


		if(Orientamento()) {

				do {
					System.out.println("posiziona le nave sottomarino orizzontale ");
					coor=inserisciCoordinateUs();
					x=coor[0];
					y=coor[1];

				}
				while(oc[x][y]!="0"||oc[x][y+1]!="0"||oc[x][y+2]!="0"); 
				oc[x][y]="x";
				oc[x][y+1]="x";
				oc[x][y+2]="x";

		}
		

			

		else {
		
				do {
					
					System.out.println("posiziona le nave sootomarino verticale");
					coor=inserisciCoordinateUs();
					x=coor[0];
					y=coor[1];
				}

				while(oc[x][y]!="0"||oc[x+1][y]!="0"||oc[x+2][y]!="0"); 

		
			oc[x][y]="x";
			oc[x+1][y]="x";
			oc[x+2][y]="x";

		}

		stampaCampoUs();
		//coordinate nave da'assalto 
		//orientamento

		System.out.println("Inserire  nave d'assalto ");

		if(Orientamento()) {

	
				do {
					System.out.println("posiziona le nave d'assalto orizzontale ");
					coor=inserisciCoordinateUs();
					x=coor[0];
					y=coor[1];

				}
				while(oc[x][y]!="0"||oc[x][y+1]!="0"); 
	

			oc[x][y]="x";
			oc[x][y+1]="x";



		}else {
			//coordinate

				do {
					
					System.out.println("posiziona le nave d'assalto verticale ");
					coor=inserisciCoordinateUs();
					x=coor[0];
					y=coor[1];
				}

				while(oc[x][y]!="0"||oc[x+1][y]!="0"); 



			oc[x][y]="x";
			oc[x+1][y]="x";

		}

		stampaCampoUs();
		//coordinate nave corazzata 4 caselle
		//genero oriantamento nave vertical o orizzontale
		System.out.println("Inserire  nave corazzata ");

		if(Orientamento()) {

				do {
					System.out.println("posiziona le nave corazzata orizzontale ");
					
					coor=inserisciCoordinateUs();
					x=coor[0];
					y=coor[1];

				}
				while(oc[x][y]!="0"||oc[x][y+1]!="0"||oc[x][y+2]!="0"||oc[x][y+3]!="0"); 
			
		

			oc[x][y]="x";
			oc[x][y+1]="x";
			oc[x][y+2]="x";
			oc[x][y+3]="x";


		}else {

		
				do {
					System.out.println("posiziona le nave corazzata verticale ");
					coor=inserisciCoordinateUs();
					x=coor[0];
					y=coor[1];
				}

				while(oc[x][y]!="0"||oc[x+1][y]!="0"||oc[x+2][y]!="0"||oc[x+3][y]!="0"); 

			oc[x][y]="x";
			oc[x+1][y]="x";
			oc[x+2][y]="x";
			oc[x+3][y]="x";
		}

		//coordinate nave portaerei
		//orientamento
		stampaCampoUs();
		System.out.println("nave portaererei");
		//coordinate
		if(Orientamento()) {

				do {
					System.out.println("posiziona le nave portaerei verticale ");
					coor=inserisciCoordinateUs();
					x=coor[0];
					y=coor[1];

				}
				while(oc[x][y]!="0"||oc[x][y+1]!="0"||oc[x][y+2]!="0"||oc[x][y+3]!="0"||oc[x][y+4]!="0"); 
			
		
			oc[x][y]="x";
			oc[x][y+1]="x";
			oc[x][y+2]="x";
			oc[x][y+3]="x";
			oc[x][y+4]="x";

		}else {

			
				do {
					System.out.println("posiziona le nave portaaerei vericale ");
					
					coor=inserisciCoordinateUs();
					x=coor[0];
					y=coor[1];
				}

				while(oc[x][y]!="0"||oc[x+1][y]!="0"||oc[x+2][y]!="0"||oc[x+3][y]!="0"||oc[x+4][y]!="0"); 

			

			

			oc[x][y]="x";
			oc[x+1][y]="x";
			oc[x+2][y]="x";
			oc[x+3][y]="x";
			oc[x+4][y]="x";
			
		}
			}
			catch(Exception ex) {
				System.out.println("assicurarsi che le navi rientrino all'interno del campo di battaglia  ");

			}		
			stampaCampoUs();
			
		}while(count(oc)!=17); 
	
	

}

	public  int[] inserisciCoordinateUs() {
		//con questo metodo faccio inserire  all'utente delle coordinate valide per il gioco 
		//istanzio un array che mi servira per inviare le coordinate ad un metodo che le utilizzerà

		int[] coo=new int[2];

		int x=0;
		String y="";
		
		int y1=1;
		//con un ciclo ed blocco try catch mi assucuro che l'utente inserisca valori validi 
//ed il programma non vada in errore

		
			//				x=0;
			//				y=0;
			//				
		do {
			try {
			
				System.out.println("inserire coordinata x numero da 1 a 10");
				x=Integer.parseInt(sc.nextLine());
				
				//sc.nextLine();
				
				System.out.println("inserire coordinata y lettera  da a ad j");

				
				y=sc.nextLine();

			}
			
			
			catch(Exception ex) {
				System.out.println("Inserire valori validi");
				
				
			}
		}
			while(x>10||x<1);
		

	//	[a-j]
		

	//	sc.close();
		
		//con u ciclo switch trasformo i valori inseriti come stringhe in numeri 
		
		switch(y) {
		
		case "a":
			y1=1;
			break;
			
		case "b":
			y1=2;
			break;	
		case "c":
			y1=3;
			break;		
		case "d":
			y1=4;
			break;		
		case "e":
			y1=5;
			break;	
		case "f":
			y1=6;
			break;
		case "g":
			y1=7;
			break;	
		case "h":
			y1=8;
			break;	
		case "i":
			y1=9;
			break;	
		case "j":
			y1=10;
			break;	
		default:
		
		y1=1;
		break;
		}
		//inserisco valori validi all'interno dell'array 
		coo[0]=x;
		coo[1]=y1;
		
		System.out.println(x+" "+y1);
		//come tipo di dato di ritorno  invio l'array
		return coo;
	}
	
	public  boolean Orientamento() {
		
		String orient="";
		do {
		
		try {
			
			System.out.println("Inserisci valore o per orientamento orizz oppure v per verticale ");
			orient=sc.nextLine();
		}
		catch(Exception ex) {
			
			System.out.println("Inserire valori corretti ");
		}
		}while(!orient.equals("v")&&!orient.equals("o"));
		//System.out.println(orient);
	//	sc.close();
		
		if(orient.equals("o")) {
			
			return true;
		}
			
		return false;
	}
	
	public static int count(String oc[][]) {
		int c=0;
		for(int i=0;i<oc.length;i++) {
			
		for(int j=0;j<oc[i].length;j++) {
			
		
				if(oc[i][j]=="x") {
					
					c++;
				}
				
				
			
		
		}
		}
		return c;
		
	}
	
//	public static void stampa(String[][] oc){
//		for(int i=0;i<oc.length;i++) {
//
//			for(int j=0;j<oc[i].length;j++) {
//
//				System.out.print(oc[i][j]);
//
//			}
//			System.out.println();
//		}
//
//	}	

	public  void deleteX(String[][] oc) {

		for(int i=0;i<oc.length;i++) {

			for(int j=0;j<oc[i].length;j++) {

				if(oc[i][j]=="x") {

					oc[i][j]="0";
				}
			}
		}

	}
	public  void affondateWinner(String[][] oc) {
		int in=0;
		int s=0;
		int z=0;
		int a=0;
		int p=0;
		for(int i=0;i<oc.length;i++) {
			
			for(int j=0;j<oc[i].length;j++) {

				if(oc[i][j]=="i") {

					in++;
				}
				if(oc[i][j]=="s") {

					s++;
				}
				if(oc[i][j]=="a") {

					a++;
				}
				if(oc[i][j]=="z") {

					z++;
				}
				if(oc[i][j]=="p") {

					p++;
				}
			}
		}
	
		if(in==0) {
			
			System.out.println("Incrociatre comp affondato");
		}
		 if(s==0) {
			 System.out.println("Sottomarino comp affondato");
		 }
		 if(z==0) {
			 System.out.println("Corazzata comp affondato");
		 }
		 if(a==0) {
			 
			 System.out.println("Nave assaalto comp affondato");
		 }
		 if(p==0) {
			 
			 System.out.println("Portaerei comp affondato");
		 }
		  if(in==0&&s==0&&z==0&&a==0&&p==0) {
			 
			  System.out.println("hai affonadato tutte le navi!! complimenti Hai vinto!!");
			  
			  parita=false;
		 }
		
	}
	
	public void stampaCampoUs() {
		System.out.println("Posizione navi user");
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
					System.out.print(" ");
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
		
		
		
	}
	
	public void vittoria(boolean a,boolean b){
		if(!a&&!b) {
			
			System.out.println("pareggio!");
			
		}
		else if(a&&!b) {
			
			System.out.println("Vittoria del  computer!!");
		}
		else if(!a&&b) {
			
			System.out.println("Vittoria User!!");
		}
		
		
	}

}
