package task.structure;

public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) {
		String personalNo = "54251255325"; 
		if(personalNo.matches("^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-?[1-6][0-9]{6}$")){
			System.out.println("yes~!!!!!1");
		}else{
			System.out.println("no~! ");
		}
	}
}
