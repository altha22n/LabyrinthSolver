/**
 * Created by peter on 3/29/17.
 */

public class Labyrinth {
	private LabyrinthNode map[][];
	private LabyrinthNode bigMap[][];

	// Create default test labyrinth
	public Labyrinth() {
		int l = 6;
		int w = 6;
		map = new LabyrinthNode[l][w];

		map[0][0] = LabyrinthNode.ENTRANCE;
		
		map[0][2] = LabyrinthNode.WALL;
		map[1][2] = LabyrinthNode.WALL;
		map[1][4] = LabyrinthNode.WALL;
		map[2][4] = LabyrinthNode.WALL;
		map[3][1] = LabyrinthNode.WALL;
		map[3][2] = LabyrinthNode.WALL;
		map[3][3] = LabyrinthNode.WALL;
		map[3][4] = LabyrinthNode.WALL;
		map[4][1] = LabyrinthNode.WALL;
		map[4][2] = LabyrinthNode.WALL;
		map[4][3] = LabyrinthNode.WALL;
		map[4][4] = LabyrinthNode.WALL;
		
		map[0][1] = LabyrinthNode.PATH;
		map[1][1] = LabyrinthNode.PATH;
		map[2][1] = LabyrinthNode.PATH;
		map[2][2] = LabyrinthNode.PATH;
		map[2][3] = LabyrinthNode.PATH;
		map[1][3] = LabyrinthNode.PATH;
		map[0][3] = LabyrinthNode.PATH;
		map[0][4] = LabyrinthNode.PATH;
		map[0][5] = LabyrinthNode.PATH;
		map[1][5] = LabyrinthNode.PATH;
		map[2][5] = LabyrinthNode.PATH;
		map[3][5] = LabyrinthNode.PATH;
		map[4][5] = LabyrinthNode.PATH;
		map[1][0] = LabyrinthNode.PATH;
		map[2][0] = LabyrinthNode.PATH;
		map[3][0] = LabyrinthNode.PATH;
		map[4][0] = LabyrinthNode.PATH;
		map[5][0] = LabyrinthNode.PATH;
		map[5][1] = LabyrinthNode.PATH;
		map[5][2] = LabyrinthNode.PATH;
		map[5][3] = LabyrinthNode.PATH;
		map[5][4] = LabyrinthNode.PATH;
		
		map[5][5] = LabyrinthNode.EXIT;

	}

	// Create length-by-width labyrinth
	public Labyrinth(int l, int w) {
		map = new LabyrinthNode[l][w];
	}

	public int getWidth() {
		return map[0].length;
	}

	public int getLength() {
		return map.length;
	}

	public LabyrinthNode getNode(int l, int w) {
		if ((l >= 0) && (l < map.length) && (w >= 0) && (w < map[0].length)) {
			return map[l][w];
		}
		return null;
	}

	public String drawMap() {
		String temp = "";

		for (int l = 0; l < getLength(); l++) {
			for (int w = 0; w < getWidth(); w++) {
				temp += getNode(l, w).drawNode();
			}
			temp += "\n";
		}

		return temp;
	}

	public static void main(String[] args) {
		Labyrinth testLab = new Labyrinth();

		System.out.println(testLab.drawMap());
	}
}
