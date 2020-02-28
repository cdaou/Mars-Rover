import java.util.ArrayList;

public class calculateOutput {
	
	protected  ArrayList<Integer> coordinates = new ArrayList<Integer>();
	protected  ArrayList<String> currentPosition = new ArrayList<String>();
	protected  ArrayList<String> moves = new ArrayList<String>();	
	
	public calculateOutput(ArrayList<Integer> coordinates) {
		this.coordinates = coordinates;
	}
	
	//------------------>CALCULATE OUTPUT FUNCTION<------------------
	public String[] calculateOut(){
		int[] nextPosition = new int[2];
		String direction = currentPosition.get(2);
		System.out.println(moves.get(0).charAt(2));
		for(int i=0; i < moves.get(0).length(); i++) {
			switch(moves.get(0).charAt(i)){
			case 'M':
				nextPosition = makeMove(direction, Integer.parseInt(currentPosition.get(0)), Integer.parseInt(currentPosition.get(1)));
				break;
			default:
				direction = newDirection(direction, moves.get(0).charAt(i));
			}
		}	
		System.out.println(nextPosition[0]);
		System.out.println(direction);
		
		String finalPosition[] = {String.valueOf(nextPosition[0]), String.valueOf(nextPosition[1]), direction};
		System.out.println(finalPosition[0]+finalPosition[1]+finalPosition[2]);
		return finalPosition;
	}
	
	protected int[] makeMove (String direction, int x, int y) {
		
		int[] newCoord = new int[2];
		
		switch(direction) {
		case "N":
			newCoord[0] = x;
			newCoord[1] = ++y;
			break;
		case "E":
			newCoord[0] = ++x;
			newCoord[1] = y;
			break;
		case "S":
			newCoord[0] = x;
			newCoord[1] = --y;
			break;
		case "W":
			newCoord[0] = --x;
			newCoord[1] = y;
			break;
		}
		return newCoord;
	}

	protected String newDirection(String previousDirection, String rotation) {
		
		String newDirection = "";
		
		switch(previousDirection) {
		case "N":
			if(rotation.equals("L"))
				newDirection = "W";
			else
				newDirection = "E";
			break;
		case "E":
			if(rotation.equals("L"))
				newDirection = "N";
			else
				newDirection = "S";
			break;
		case "S":
			if(rotation.equals("L"))
				newDirection = "E";
			else
				newDirection = "W";
			break;
		case "W":
			if(rotation.equals("L"))
				newDirection = "S";
			else
				newDirection = "N";
			break;
		}
		return newDirection;
	}
		
	public void setPosition(ArrayList<String> position) {
		this.currentPosition = position;
	}
	
	public void setMoves(ArrayList<String> moves) {
		this.moves = moves;
	}	
}
