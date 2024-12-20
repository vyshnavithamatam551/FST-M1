
public class Activity8 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
try {
		exceptionTest("This will execute correctly");
		exceptionTest(null); //Throws exception
		exceptionTest("If exception has thrown it'll not get executed");
	}
catch(CustomException ce) {
	
	System.out.println("The exception has been caught for string "+ce.getMessage());
	
}
	}
	static void exceptionTest(String s) throws CustomException {
		if(s == null) {
            throw new CustomException("String value is null");
        } else {
            System.out.println(s);
        }
}
}



