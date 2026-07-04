package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import modelos.excecoes.DominioExcecoes;

public class Reserva {
	
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		
	}

	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) { // throws DominioExcecoes {
		if(!checkOut.after(checkIn)) {
			throw new DominioExcecoes("data de entrada deve ser posterior a de saída");
		}
		
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	

	public Date getCheckOut() {
		return checkOut;
	}

	
	
	public long duracao() {
		
		long diff =checkOut.getTime()-checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
		
	}
	
	public void atualizaDatas(Date checkIn, Date checkOut) { // throws DominioExcecoes {
		Date now = new Date();
		if  (checkIn.before(now) || checkOut.before(checkOut)) {
		      throw new DominioExcecoes("as Datas das atualizações informadas devem ser futuras as reservadas");
		}
		if (!checkOut.after(checkIn)) {
		      throw new DominioExcecoes("data da saída deve ser posterior a data de entrada");
		} 
		this.checkIn=checkIn;
		this.checkOut=checkOut;
	}
	@Override
	public String toString() {
		
		
		return "Reserva: Quarto "
				+ numeroQuarto
				+ ", check-in: "
		    	+ sdf.format(checkIn)
		    	+ ", check-out: "
		    	+ sdf.format(checkOut)
		    	+ ", " 
		    	+ duracao()
		    	+ " noites";
		
		
	}

}
