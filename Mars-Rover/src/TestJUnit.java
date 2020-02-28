import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TestJUnit {
	
	protected ArrayList<Integer> coordinates = new ArrayList<Integer>();
	protected HashMap<Integer, ArrayList<String>> data = new HashMap<Integer, ArrayList<String>>();
	
	@Test
	public void testCase1() {
		ArrayList<String> position = new ArrayList<String>();
		ArrayList<String> moves = new ArrayList<String>();
		data = readMoves();
		position.add(data.get(0).get(0));
		position.add(data.get(0).get(1));
		position.add(data.get(0).get(2));
		moves.add(data.get(0).get(3));
		calculateOutput finalPosition = new calculateOutput(coordinates);
		finalPosition.setPosition(position);
		finalPosition.setMoves(moves);
		assertEquals("1", finalPosition.calculateOut()[0], "The x co-ordinate must be equal to 1");
		assertEquals("3", finalPosition.calculateOut()[1], "The y co-ordinate must be equal to 3");
		assertEquals("N", finalPosition.calculateOut()[2], "The direction must be equal to N");
	}
	
	//------------------>READ MOVES FUNCTION<------------------
	private HashMap<Integer, ArrayList<String>> readMoves(){
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
