package exceptions;

public class NotEnoughGoldException extends BuildingException{
	
	NotEnoughGoldException(){
		super();
	}
	
	
	NotEnoughGoldException(String s){ 
		super(s);
	}

}
