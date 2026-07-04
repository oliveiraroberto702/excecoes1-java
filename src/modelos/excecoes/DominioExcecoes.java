package modelos.excecoes;

public class DominioExcecoes extends RuntimeException {   // extends Exception
	private static final long serialVersionUID = 1L;
	
	public DominioExcecoes(String msg) {
		super(msg);
	}
	

}
