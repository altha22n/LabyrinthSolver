/**
 * Created by peter on 3/28/17. Edited by Nada Al-Thawr 4/10/17.
 */
public class GraphMatrix implements Graph {
	// declare a boolean 2D array
	protected boolean[][] vertexMatrix;

	public GraphMatrix(int i) {
		// create the 2D array and pass in i
		// because it has the same width and length
		vertexMatrix = new boolean[i][i];
	}

	@Override
	/**
	 * addEdge adds an edge between two vertices
	 * by changing it to true
	 * @param from
	 * @param to
	 */
	public void addEdge(int from, int to) {
		// if from is the same as to
		// then we have only one vertex
		if (from == to) {
			// so we just return
			return;
		} else {
			// else set it to be true
			// bidrectionally
			vertexMatrix[from][to] = true;
			vertexMatrix[to][from] = true;
		}

	}

	@Override
	/**
	 * deleteEdge deletes an edge between two vertices 
	 * by setting it to false 
	 * @param from
	 * @param to
	 */
	public void deleteEdge(int from, int to) {
		// if from is the same as to
		// then we have only one vertex
		if (from == to) {
			// so we just retur
			return;
		} else {
			// else set the edge or connection to be false
			// bidrectionally
			vertexMatrix[from][to] = false;
			vertexMatrix[to][from] = false;
		}
	}

	@Override
	/** 
	 * getEdge is a boolean that returns true if there's an edge between two vertices
	 * and false if there's no edge
	 * @param from
	 * @param to
	 */
	public boolean getEdge(int from, int to) {
		// if there's an edge between from and to OR between to and from
		if (vertexMatrix[from][to] == true || vertexMatrix[to][from] == true) {
			// return true
			return true;
		} else {
			// else return false
			return false;
		}
	}

	@Override
	/**
	 * @param from
	 * @return adjacent
	 */
	public int[] getAdjacent(int from) {
		// create an int count and initialize it to 0
		int count = 0;
		// loop through the array while passing only one parameter: from
		for (int i = 0; i < vertexMatrix[from].length; i++) {
			// if there's an edge between from and i
			if (getEdge(from, i) == true) {
				// then increment count
				count++;
			}
		}
		// create an int array and pass in count for the indices
		int[] adjacent = new int[count];
		// loop through the array while passing one parameter: from
		for (int j = 0; j < vertexMatrix[from].length; j++) {
			// create an int num and initialzie it to 0
			int num = 0;
			// if there's an edge between from and j
			if (getEdge(from, j) == true) {
				// pass in num as index of adjacent and set it to j
				adjacent[num] = j;
				// increment num
				num += 1;
			}

		}
		// return adjacent array
		return adjacent;
	}

	@Override
	/**
	 * @return int
	 */
	public int getVertexCount() {
		// return the length of the 2D array vertexMatrix
		return vertexMatrix.length;
	}

}
