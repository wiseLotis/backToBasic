package task.structure.exception;

public class NotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3253518829564886064L;
	
	public NotFoundException() {
		super(); 
	}
	public NotFoundException(String msg){
		super(msg); 
	}

}
