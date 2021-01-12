package controller;

public class EsecuzioneGioco {

	public static void main(String[] args) {
		
		ControlliUser u1=new ControlliUser();
		
		ControlliComputer c1=new ControlliComputer();
		
		c1.posizionaNaviComp(c1.campoCom);
		
		u1.posizionaNavi(u1.campoUs);
		
		
		do {//ogni turno è un'iterazione del ciclo permette di sparare un colpo a testa
			u1.spara(c1.campoCom);//metodo permette di sparare all'user 
			c1.sparaCom(u1.campoUs);//metdodo permette di sparare al computer

			c1.affNave(u1.campoUs); //controllo le navi affondate nel campo user 
			u1.affondateWinner(c1.campoCom);//controllo navi affondate campo computer ed eventuale vincita user
			
			c1.finePartita(u1.campoUs); //controllo enventuale vincita computer 
			
	
			c1.stampaCampoComp();//stampo la situazione dei due schieramenti ad ogni fine turno
			u1.stampaCampoUs();
			
		}while(c1.countNavi&&u1.parita);
		
	
	

	}

}
