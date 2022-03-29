package mvc;

public class CapFilter implements IFilter {

	@Override
	public Boolean Execute(String pass) {
		System.out.println("implementing caps filter");

		boolean isUppercase = pass.equals(pass.toUpperCase());
		if (isUppercase == false){
			System.out.println("There are lower case letters in this username...");
		}
		
		return isUppercase;
	}

}
