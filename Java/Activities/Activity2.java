
public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int arr[]= {10, 77, 10, 54, -11, 10};
        int sum=0;
        int search_num=10;
        int final_sum=30;
        for(int num : arr) {
        	if(num==search_num) {
        		sum=sum+num;
        	}
        }
        if(sum==final_sum) {
        	System.out.println("True");
        }
        else {
        	System.out.println("False");
        }
	}
	

}
