import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class calculateOutput {
	
	public static ArrayList<Integer> coordinates = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		HashMap<Integer, ArrayList<String>> moves = new HashMap<>();
		
		moves = readMoves();
		System.out.println(moves);

	}
	
	protected static  HashMap<Integer, ArrayList<String>> readMoves(){
		//INITIALIZE VARIABLES
		BufferedReader inputFile;
		String line;
		int lineIndex = 1, moveIndex = 0;
		ArrayList<String> tempList = new ArrayList<>();
		HashMap<Integer, ArrayList<String>> moves = new HashMap<>();
		//READ THE INPUT FILE
		try {	
			inputFile = new BufferedReader(new FileReader("./src/inputFile.txt"));
			line = inputFile.readLine();
			while (line != null) {
				String[] splitStrings = line.split(" ");
				if(lineIndex == 1) {
					for (String s : splitStrings) 
						coordinates.add(Integer.parseInt(s));
				}else{
					for (String s : splitStrings) 
						tempList.add(s);
					if(lineIndex%2==1) {
						moves.put(moveIndex++, tempList);
						tempList = new ArrayList<>();
					}
				}
				line = inputFile.readLine();
				lineIndex++;	
			}
			if(inputFile!=null)
				inputFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("Input file(s) not found. Try again!");
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Something went wrong, reading the file(s). Try again!");
			e.printStackTrace();
			System.exit(0);
		}	
		return moves;
	}
	
}
