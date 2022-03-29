package mvc;



//in this application we are using the interceptor patteren
 //this is the "target" of the application which means we will
 //apply all of the users selected filters and then send it to the "target"
 //this will check and validate that all the username requirements are met
 
public class Model {

	
		//holds the string value of the username at first
		//no filters set so it must pass no matter what
		private static String username = "username passed";
		
		//gets the boolean results from all the filters and checks if the username is valid
		public void usernamePassedFilter(Boolean[] check){
			for(int i = 0; i < check.length && check[i] != null; i++)
			{
				if(check[i] == false)
				{
					username = "username failed";
					System.out.println(username);
					return;
				}
				else{
					username = "username passed";
					System.out.println(username);
				}
			}
			
		}
		
		//returns the username whether it be set or not
		public String getUsername(){

			return username;
		}

}
