package ale.haritos.projeto1_Springboot.services.exceptions;

public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NotFoundException(Object id) {
		super("Not found Id: " + id);
	}
}
