
import java.util.Scanner;

import loja.Loja;
import loja.LojaApp;

public class LojaConsoleUI {
	
	private LojaApp loja;
	private Scanner sc;
	
	
	public LojaConsoleUI() {
		this.loja = new Loja();
		this.sc = new Scanner(System.in);
		
	}
	
	private void solicitarPigmento() {
		
		String codigoHexadecimal;
		double qtdDesejada;
		
		System.out.println("SOLICITAR PIGMENTO");
		System.out.println("Informe o pigmento desejado:");
		codigoHexadecimal = sc.nextLine();
		System.out.println("Informa a quantidade desejada:");
		qtdDesejada = sc.nextDouble();
		
		this.loja.consultarPigmento(qtdDesejada);
		//PODE DAR EXCEPTION QUANDO NÃO TEM NENHUM PIGMENTO COM A QUANTIDADE DESEJADA
		//CASO TENHA, AI ELE FAZ A SELEÇÃO CORRETAMENTE, ENTÃO TEM QUE FAZER UM IF-ELSE AQUI OU TRY-CATCH 
		/*Matheus:
		Aí tem que lançar o throws lá na hora da consulta e
		tratar aqui, quando eu conseguir entender o código posso fazer KK
		*/
		this.loja.selecionarPigmento(codigoHexadecimal);
		
	}
	
	public static void main(String[] args) {
		(new LojaConsoleUI()).solicitarPigmento();
	}
}
