package mvc;


public class SpaceFilter implements IFilter {

	@Override
	public Boolean Execute(String pass) {
		System.out.println("implements space filter");
		if(pass.contains(" ")){
		System.out.println("false");
			return false;
		}
		System.out.println("True");
		return true;
	}

}
