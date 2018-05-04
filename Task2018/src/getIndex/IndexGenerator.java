package getIndex;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class IndexGenerator {

	private String filepath = ""; 
	private Boolean option_path = false; 
	
	public IndexGenerator(){
		
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	public static void main(String[] args) {
	
		IndexGenerator generator= new IndexGenerator(); 
		System.out.println("경로를 입력해주세요 ");
		Scanner sc = new Scanner(System.in); 
		String path = sc.next(); 
		generator.setFilepath(path);
		generator.recodeTxt("index.txt");
		System.out.println(generator.getFilepath()+"의 index.txt 를 생성합니다."); 
		generator.getFilePath(); 
 	}

	 
	private void getFilePath() {
		
		listFilesForFolder(new File(this.filepath), "", ""); //jsp 파일탐색
 	}
	
	private void listFilesForFolder(File folder, String fileExtension, String depth){	
		 
		for(final File fileEntry : folder.listFiles()){
			if(fileEntry.isDirectory()){
				System.out.println(depth + "├─" + fileEntry.getName() + "(path:" + fileEntry.getPath()+" )" );
				listFilesForFolder(fileEntry, fileExtension, depth+" |   ");
			}else{
				if(fileEntry.isFile()&&fileEntry.getName().contains(fileExtension)){
					System.out.println(depth + fileEntry.getName() );
				}
			}
		}
 	} 

	private void recodeTxt(String filename){
		try{
			File file = new File(filepath, filename); 
			FileOutputStream fos = new FileOutputStream(file); 
			PrintStream ps = new PrintStream(fos); 		
			System.setOut(ps);	
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	
}
