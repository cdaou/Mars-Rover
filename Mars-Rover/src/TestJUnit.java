import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TestJUnit {
	
	protected ArrayList<Integer> coordinates = new ArrayList<Integer>();
	
	@Test
	public void testCase1() {
		//THE FIRST TEST THAT CHECKS THE OUTPUT FOR ENTRY:
		//1 2 N
		//LMLMLMLMM
		ArrayList<String> position = new ArrayList<String>(); //REPRESENTS THE POSITION AND THE DIRECTION OF THE ROBOT E.G. (1,2,N)
		ArrayList<Character> nextMove = new ArrayList<Character>(); //THIS IS A SEQUENCE OF CHARACTERS, WHICH REPRESENTS THE PATH OF THE ROBOT E.G. [L,M,L,M,L,M,L,M,M]
		HashMap<Integer, ArrayList<String>> moves = new HashMap<Integer, ArrayList<String>>();
		moves = readNextMove();
		//PASS THE POSITION AND DIRECTION INFORMATION FROM THE HASHMAP TO THE ARRAYLIST "POSITION"
		position.add(moves.get(0).get(0));
		position.add(moves.get(0).get(1));
		position.add(moves.get(0).get(2));
		//PASS THE PATH INFORMATION FROM THE HASHMAP (STRING) TO THE ARRAYLIST "NEXTMOVE" (LIST OF CHARS)
		for(int i=0; i < moves.get(0).get(3).length(); i++) {
			nextMove.add(moves.get(0).get(3).charAt(i));
		};
		//CREATE AN OBJECT OF THE CLASS "CALCULATEOUTPUT"
		calculateOutput finalPosition = new calculateOutput(coordinates);
		//PASS THE INFORMATION NEEDED
		finalPosition.setPosition(position);
		finalPosition.setMoves(nextMove);
		String result[] = new String[3];
		//SAVE THE RESULT OF THE CALCULATION
		result=finalPosition.calculateOut();
		//TEST IF THE RESULT IS THE DESIRED
		assertTrue(result[0].equals("1"));
		assertTrue(result[1].equals("3"));
		assertTrue(result[2].equals("N"));
	}
	
	@Test
	public void testCase2() {
		//THE SECOND TEST THAT CHECKS THE OUTPUT FOR ENTRY:
		//3 3 E
		//MMRMMRMRRM
		ArrayList<String> position = new ArrayList<String>(); 
		ArrayList<Character> nextMove = new ArrayList<Character>(); 
		HashMap<Integer, ArrayList<String>> moves = new HashMap<Integer, ArrayList<String>>();
		moves = readNextMove();
		position.add(moves.get(1).get(0));
		position.add(moves.get(1).get(1));
		position.add(moves.get(1).get(2));
		for(int i=0; i < moves.get(1).get(3).length(); i++) {
			nextMove.add(moves.get(1).get(3).charAt(i));
		};
		calculateOutput finalPosition = new calculateOutput(coordinates);
		finalPosition.setPosition(position);
		finalPosition.setMoves(nextMove);
		String result[] = new String[3];
		result=finalPosition.calculateOut();
		assertTrue(result[0].equals("5"));
		assertTrue(result[1].equals("1"));
		assertTrue(result[2].equals("E"));
	}
	
	//------------------>readNextMove() FUNCTION<------------------
	private HashMap<Integer, ArrayList<String>> readNextMove(){
		//THIS FUNCTION READS THE inputFile.txt AND PUTS THE INITIAL POSITIONS AND THE MOVES IN A HASHMAP
		//EVERY COMBINATION (POSITION, MOTION SEQUENCE) HAS A SERIAL NUMBER (INTEGER)
		//INITIALIZE VARIABLES
		BufferedReader inputFile;
		String line;
		int lineIndex = 1, moveIndex = 0; //THE INDEX OF EVERY LINE OF THE FILE AND THE INDEX OF EVERY MOVE (SERIAL NUMBER)
		ArrayList<String> tempList = new ArrayList<>();
		HashMap<Integer, ArrayList<String>> moves = new HashMap<Integer, ArrayList<String>>(); //THE HASHMAP WHERE THE INFORMATION OF THE FILE IS STORED
		//READ THE INPUT FILE
		try {	
			inputFile = new BufferedReader(new FileReader("./src/inputFile.txt"));
			//READ EACH LINE OF THE FILE AND SPLIT THE STRING BASED ON THE SPACE CHARACTER
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
						//IF THE LINE NUMBER IS ODD (EXCEPT "1"), MEANS THAT THE INFORMATION OF THIS SPECIFIC MOVE ENDED AND THE RESULT MUST BE STORED
						//LINE ID 1: 5 5
						//LINE ID 2: 1 2 N
						//lINE ID 3: LMLMLMLMM
						//THE FIRST MOVE ENDS IN LINE 3, THE NEXT ON IN LINE 5 AND SO ON...
						moves.put(moveIndex++, tempList);
						tempList = new ArrayList<>();
					}
				}
				line = inputFile.readLine();
				lineIndex++;	
			}
			//CLOSE THE FILE
			if(inputFile!=null)
				inputFile.close();
			//CHECK IF THE FILE NOT FOUND
		} catch (FileNotFoundException e) {
			System.out.println("Input file(s) not found. Try again!");
			e.printStackTrace();
			System.exit(0);
			//CHECK IF THERE IS ANY OTHER PROBLEM ON READING THE FILE
		} catch (IOException e) {
			System.out.println("Something went wrong, reading the file(s). Try again!");
			e.printStackTrace();
			System.exit(0);
		}
		return moves;
	}
}
