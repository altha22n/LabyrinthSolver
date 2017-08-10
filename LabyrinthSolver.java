import java.awt.Color;
import java.util.*;

/**
 * Created by peter on 3/28/17. Edited by Nada Al-Thawr on 4/11/17.
 */
public class LabyrinthSolver {
	protected boolean isVisited;

	// labyrinthToNodeNumber
	public static int labyrinthToNodeNumber(int l, int w, int labwidth) {
		// the lab width is 0
		if (labwidth == 0) {
			// return -1
			return -1;
		}
		// return the product of the length and the labwidth added to the width
		return ((l * labwidth) + w);

	}

	/**
	 * labyrinthToGraph add appropriate edges to mazeGraph this converts our
	 * labyrinth to a graph
	 * 
	 * @param lab
	 * @param mazeGraph
	 * @return mazeGraph
	 */
	public static Graph labyrinthToGraph(Labyrinth lab, Graph mazeGraph) {
		// we loop through the lab length
		for (int i = 0; i < lab.getLength(); i++) {
			// then we loop through the width so we loop through the whole
			// labyrinth
			for (int j = 0; j < lab.getWidth(); j++) {
				// if the node we get at a certain length and width is passable
				if (lab.getNode(i, j).isPassable()) {
					// we create two arrays for the possible neighbors
					// assuming it's an x and y axes
					int[] x = { i - 1, i, i, i + 1, i };
					int[] y = { j, j - 1, j + 1, j, j };
					// then we loop through the x length
					for (int a = 0; a < x.length; a++) {
						// and we create two new ints and go through the indices
						// of the x length
						int xnum = x[a];
						int ynum = y[a];
						// then we create a new node by passing the xnum and
						// ynum
						LabyrinthNode node = lab.getNode(xnum, ynum);
						// if node isn't null and is passable
						if (node != null && node.isPassable()) {
							// we create two ints: from and to by calling
							// labyrinthToNodeNumber method
							// for from we pass the i and j - lab width and
							// length, and the labwidth
							int from = labyrinthToNodeNumber(i, j,
									lab.getWidth());
							// for to we pass xnum and ynum which are for the
							// neighbors and the labwidth
							int to = labyrinthToNodeNumber(xnum, ynum,
									lab.getWidth());
							// then we add an edge to the mazeGraph by passing
							// in from and to
							mazeGraph.addEdge(from, to);
						}
					}
				}
			}
		}

		// then we return the mazeGrapth
		return mazeGraph;

	}

	/**
	 * finds the shortest path between the start and the end
	 * 
	 * @param mazeGraph
	 * @return
	 */
	public static int[] breadFirstSearch(Graph mazeGraph) {
		// create a colors array and pass in the vertex count
		Color[] graphColors = new Color[mazeGraph.getVertexCount()];
		// create an array for the distance and pass in the vertex count
		int[] distance = new int[mazeGraph.getVertexCount()];
		// create an array for the path and pass in the vertex count
		int[] pi = new int[mazeGraph.getVertexCount()];

		// starting from 1, we loop through all the vertices in the graph
		for (int i = 1; i < mazeGraph.getVertexCount(); i++) {
			// at each increment of i , set the color to white
			graphColors[i] = Color.WHITE;
			// set the distance to -1
			distance[i] = -1;
			// set pi to -1
			pi[i] = -1;
		}
		// then change the first element to gray
		graphColors[0] = Color.GRAY;
		// change the distance of the first element to -1
		distance[0] = -1;
		// and change the pi of the first element to -1
		pi[0] = -1;
		// create a generic queue
		Queue<Integer> myQueue = new LinkedList<>();
		// add the 0 element to it
		myQueue.add(0);
		// you peek at the queue and as long as it's not null
		while (myQueue.peek() != null) {
			// create an int u which saves what is removed from the queue
			int u = myQueue.remove();
			// create an int array and get the adjacents of u from the graph
			int[] adjacentArray = mazeGraph.getAdjacent(u);
			// loop through the adjacent array
			for (int i = 0; i < adjacentArray.length; i++) {
				// if the graph color of the element i in the adjacent array is
				// white
				if (graphColors[adjacentArray[i]] == Color.WHITE) {
					// change the color to gray
					graphColors[adjacentArray[i]] = Color.GRAY;
					// change the distance if element is in adjacent array to
					// distance of u +1
					distance[adjacentArray[i]] = distance[u] + 1;
					// set pi at element i in adjacent array to u
					pi[adjacentArray[i]] = u;
					// add element i at adjacent array to the queue
					myQueue.add(adjacentArray[i]);
				}
			}
			// set the color of u to black
			graphColors[u] = Color.BLACK;

		}
		// create an int last element and set it to pi with params vertices of
		// the graph -1
		int lastElement = pi[mazeGraph.getVertexCount() - 1];
		// create an int count and initialize it to 1
		int count = 1;
		// while the last element is not equal to -1
		while (lastElement != -1) {
			// increment count
			count = count + 1;
			// set last element to be pi of last element
			lastElement = pi[lastElement];
		}
		// create an int array called patha rray and set it to the indices as
		// count
		int[] pathArray = new int[count];
		// set last element to pi with params vertices of the graph -1
		lastElement = pi[mazeGraph.getVertexCount() - 1];
		// set the path array at index count -1 to the vertex count of the graph
		// -1
		pathArray[count - 1] = mazeGraph.getVertexCount() - 1;
		// while last element is still not equal to -1
		while (lastElement != -1) {
			// set path array at count -1 as last element
			pathArray[count - 2] = lastElement;
			// decrement count by 1
			count = count - 1;
			// set last element to pi at last element
			lastElement = pi[lastElement];
		}
		// return the path array
		return pathArray;
	}

	public static void main(String[] args) {
		// Design the Labyrinth
		Labyrinth testLab = new Labyrinth();
		System.out.println("The Starting Labyrinth");
		System.out.println(testLab.drawMap());

		// Convert the Labyrinth to a graph
		Graph mazeGraph = new GraphMatrix(testLab.getLength()
				* testLab.getWidth());
		labyrinthToGraph(testLab, mazeGraph);
		System.out.println(mazeGraph);

		// Draw the final path
		int[] path = breadFirstSearch(mazeGraph);
		if (path == null)
			System.out.println("There is no solution path");
		else
			System.out.println(Arrays.toString(path));
	}
}
