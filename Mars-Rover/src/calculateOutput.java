import java.util.ArrayList;

public class calculateOutput {
	
	protected  ArrayList<Integer> coordinates = new ArrayList<Integer>();
	protected  ArrayList<String> initialPosition = new ArrayList<String>();
	protected  ArrayList<Character> moves = new ArrayList<Character>();	//A LIST OF CHARACTERS REPRESENTING THE MOTION SEQUENCE (E.G. LMLMLMLMM)
	
	//------------------>CLASS CONSTRUCTOR<------------------
	public calculateOutput(ArrayList<Integer> coordinates) {
		this.coordinates = coordinates;
	}
	
	//------------------>CALCULATE OUTPUT FUNCTION<------------------
	public String[] calculateOut(){
		int[] currentPosition = new int[2]; //X,Y COORDINATES OF THE ROVER
		char direction = initialPosition.get(2).charAt(0); //THE INITIAL DIRECTION OF THE ROVER (N,W,S,E)
		currentPosition[0]=Integer.parseInt(initialPosition.get(0));
		currentPosition[1]=Integer.parseInt(initialPosition.get(1));
		for(int i=0; i < moves.size(); i++) {
			//CHECK IF THE NEXT ACTION IS 'MOVE' OR 'ROTATION'
			switch(moves.get(i)){
				case 'M':
					//IF THE NEXT ACTION IS 'M'(MOVE) THEN CALL makeMove() FUNCTION AND CALCULATE THE NEXT POSITION
					currentPosition = makeMove(direction, currentPosition[0], currentPosition[1]);
					break;
				default:
					//IF THE NEXT ACTION IS 'L' OR 'R' (ROTATE) THEN CALL newDirection() FUNCTION AND CALCULATE THE NEW DIRECTION
					direction = newDirection(direction, moves.get(i));
			}
		}	
		//finalPosition IS AN ARRAY WITH THE INFORMATION OF THE FINAL POSITION, THAT IS (X,Y,DIRECTION)
		//THIS VARIABLE CONTAINS STRINGS
		String finalPosition[] = { Integer.toString(currentPosition[0]), Integer.toString(currentPosition[1]) , String.valueOf(direction)};
		System.out.println(finalPosition[0]+" "+finalPosition[1]+" "+finalPosition[2]);
		return finalPosition;
	}
	
	//------------------>makeMove FUNCTION<------------------
	protected int[] makeMove (char direction, int x, int y) {
		//THIS FUNCTION CALCULATES THE NEXT POSITION IF THE ROBOT HAS TO MOVE
		//THE FUNCTION HAS AS AN ENTRY THE ROBOT'S CURRENT POSITION (X,Y) AND DIRECTION (N,W,S,E)
		int[] newCoord = new int[2];
		//DEPENDING ON THE DIRECTION, THE NEW POSITION IS CALCULATED
		switch(direction) {
			case 'N':
				newCoord[0] = x;
				newCoord[1] = ++y;
				break;
			case 'E':
				newCoord[0] = ++x;
				newCoord[1] = y;
				break;
			case 'S':
				newCoord[0] = x;
				newCoord[1] = --y;
				break;
			case 'W':
				newCoord[0] = --x;
				newCoord[1] = y;
				break;
		}
		//CHECK IF THIS PATH GUIDES THE ROBOT OUT OF BOUNDS
		if( (coordinates.get(0)-Math.abs(newCoord[0])<0) || (coordinates.get(1)-Math.abs(newCoord[1])<0) ){
			System.out.println("ÁÔÔÅÍÔÉÏÍ! \nÔhis path is not allowed because the robot will go out of bounds. \nThe system will shut down and please try another path.");
			System.out.println(moves);
			System.exit(0);
		}
		return newCoord;
	}
	
	//------------------>newDirection FUNCTION<------------------
	protected char newDirection(char previousDirection, char rotation) {
		
		char newDirection = 0;
		//THIS FUNCTION CALCULATES THE NEW DIRECTION OF THE ROBOT
		//IT HAS AS AN ENTRY THE PREVIOUS DIRECTION (N,W,S,E) AND THE DIRECTION TO BE TURNED (L,R)
		switch(previousDirection) {
			case 'N':
				if(rotation=='L')
					newDirection = 'W';
				else
					newDirection = 'E';
				break;
			case 'E':
				if(rotation=='L')
					newDirection = 'N';
				else
					newDirection = 'S';
				break;
			case 'S':
				if(rotation=='L')
					newDirection = 'E';
				else
					newDirection = 'W';
				break;
			case 'W':
				if(rotation=='L')
					newDirection = 'S';
				else
					newDirection = 'N';
				break;
		}
		return newDirection;
	}
		
	//------------------>setPosition FUNCTION<------------------
	public void setPosition(ArrayList<String> position) {
		this.initialPosition = position;
	}
	
	//------------------>setMoves FUNCTION<------------------
	public void setMoves(ArrayList<Character> moves) {
		this.moves = moves;
	}	
}
