package mvc;

//if this filter is selected it checks if there are any duplicate 
//characters in the username does not take into account numbers or special char

public class LengthFilter implements IFilter {

	@Override
	public Boolean Execute(String pass) {
		System.out.println("implementing length filter");
		//return false if longer than 5 characters
		if (pass.length() > 5) { 
	        return false;
	    }
	    
	    return true;
	}

}
