
public class Activity4 {
	
	public void ascendingsort(int array[]) {
		for(int i=1;i<array.length;i++) {
			int key=array[i];
			int j=i-1;
			while(j>=0 && key<array[j]) {
				array[j+1]=array[j];
				j--;
			}
			array[j+1]=key;
		}
		System.out.println("After Sort");
		for(int num:array) {
			System.out.print(num+" ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int arr[]= {5,1,4,2,3};
       System.out.println("Before sort");
       for(int i=0;i<arr.length;i++) {
       System.out.print(arr[i]+" ");
	}
       System.out.println();
       Activity4 act=new Activity4();
       act.ascendingsort(arr); 
       
	}
}
