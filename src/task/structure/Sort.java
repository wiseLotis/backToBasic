package task.structure;


public class Sort {
	
	int[] array = new int[20]; 
	
	
 	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public Sort() {
		
	}
	 
	public static void main(String[] args) {
		int[] dataarr= {5,1,6,4,2,3}; 
		Sort sort = new Sort(); 
		sort.setArray(dataarr);
		System.out.println(printArray(sort.getArray()));
		//System.out.println(printArray( sort.bubbleSort()));
		//System.out.println(printArray( sort.insertionSort()));
		System.out.println(printArray( sort.quickSort()));
	}
	
	public static String printArray(int[] arr){
		String result = "[" ; 
		for(int i = 0; i <arr.length ; i++){
			result += arr[i]; 
		}
		result += "]"; 
		return result; 
	}
	
	private int[] bubbleSort(){
		int[] arr = getArray(); 
		int cnt = 0; 
		int len = arr.length; 
		boolean flag= true; 
		for(int i = 0; i <len ; i++){
			if(flag){
				flag = false; 
				for(int j=0; j < len - (i+1); j++){
					cnt +=1; 
					if(arr[j] > arr[j+1]){
						flag = true; 
						int temp = arr[j+1]; 
						arr[j+1] = arr[j]; 
						arr[j]= temp; 
						System.out.println("change" + arr[j+1] + "<->" +temp);
					}
					
					System.out.println( arr[j] + " / "+ arr[j+1] + "-->"+ printArray(arr));

				}
			} 
			
		}
		System.out.println(cnt);
		return arr;
	}
	
	private int[] insertionSort(){
		System.out.println("start InsertionSort! ");
		int[] arr = getArray(); 
		int cnt = 0; 
		int len = arr.length; 
		for(int i = 1; i < len ; i++){
			if(arr[i-1] > arr[i]){//오른쪽이 더 작으면 
				int num = arr[i]; 
				int j = 0; 
				while(num > arr[j]){
					j++; //1
				}
				//System.out.println( num + "have to insert to" + j );
				arr = change(i, j, arr); 
			}
				  
		}
		
		return arr;
	}

	private int[] change(int oldi, int newi, int[] arr){
		int temp = arr[oldi];  
		for(int i = oldi; i > newi; i--){
			arr[i] = arr[i-1]; 
		}
		arr[newi] = temp; 
		return arr;
	}
	
	private int[] quickSort(){
		int[] arr = getArray(); 
		System.out.println(arr.length);
		quickSort( 0, arr.length-1);
		return getArray();
	}
	
	private void swap(int ai, int bi){
		int[] arr = getArray(); 
		int temp = arr[bi]; 
		arr[bi] = arr[ai]; 
		arr[ai] = temp; 
	}
	
	private int partition(int left, int right){
		System.out.println("partition::: " + left +"/" + right);
		int[] arr = getArray(); 
		int first = left; 
		int pivot = arr[first]; 
		
		while(left <= right){
			while(arr[right] > pivot && left < right){
				--right; 
			}
			while(arr[left] <= pivot && left < right){
				++left; 
			}
			
			
			System.out.println("left:" + left + " right:" +  right);
			if(left < right ){
				swap(left, right);
				System.out.println(printArray(arr));
			}else{
				break; 
			}
		}
		
		swap(first, right); 
		System.out.println(printArray(arr));

		System.out.println("retrun::" + right);
		return right;
	}
	
	private void quickSort(int left, int right){
		
		if(left < right ){
			int index = partition( left, right); 
			
			quickSort( left, index-1); 
			quickSort( index+1, right);
		}
	}

}

