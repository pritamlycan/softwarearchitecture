package mvc;

public class CapFilter implements IFilter {

	@Override
	public Boolean Execute(String pass) {
		System.out.println("implementing caps filter");

		boolean hasUppercase = pass.equals(pass.toLowerCase());
		System.out.println("There are not any uppercase letters in my username? :");
		System.out.println(hasUppercase);
		return hasUppercase;
	}

}
