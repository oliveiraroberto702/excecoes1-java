package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reserva;

public class Principal {
		 
	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
		  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		  
		  try {
			  System.out.print("Quarto número: ");
			  Integer quartoNumero_sc = sc.nextInt();
			  System.out.print("Data de entrada (dd/mm/yyyy): ");
			  Date checkIn_sc = sdf.parse(sc.next());
			  System.out.print("Data de saída: ");
			  Date checkOut_sc = sdf.parse(sc.next());
							
			  Reserva reserva = new Reserva(quartoNumero_sc, checkIn_sc, checkOut_sc);
			  System.out.println(reserva);
			
			  System.out.println();
			  System.out.println("Digite os dados para atualizar a reserva");
			  System.out.print("Date de entrada (dd/mm/yyyy): ");
			  Date checkInUpdate_sc=sdf.parse(sc.next());
			  System.out.print("Date de saída (dd/mm/yyyy): ");
			  Date checkOutUpdate_sc=sdf.parse(sc.next());
			  
			  reserva.atualizaDatas(checkInUpdate_sc, checkOutUpdate_sc);
			  System.out.println(reserva);
		  }
		  catch (ParseException e) {
			  System.out.println("Data de formato inválido");
		  }	  
		  catch(IllegalArgumentException e) {
			  System.out.println("Erro na reserva: " + e.getMessage());
		  }
				  
		  sc.close();

	}
		  

}
