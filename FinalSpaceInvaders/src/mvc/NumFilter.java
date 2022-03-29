package mvc;


public class NumFilter implements IFilter{

	@Override
	public Boolean Execute(String pass) {
		System.out.println("implementing num filter");
		if(pass.matches(".*\\d+.*")){
			System.out.println("false");
			return false;
		}
		
		
		return true;
		
	}
}
