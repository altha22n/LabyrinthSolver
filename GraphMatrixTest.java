import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by peter on 3/28/17.
 */
public class GraphMatrixTest {
	GraphMatrix twoVertexEmptyGraph;
	GraphMatrix twoVertexFullGraph;

	@Before
	public void setUp() {
		twoVertexEmptyGraph = new GraphMatrix(2);
		twoVertexFullGraph = new GraphMatrix(2);
		twoVertexFullGraph.vertexMatrix[0][1] = true;
		twoVertexFullGraph.vertexMatrix[1][0] = true;
	}

	@Test
	public void constructor() {
		assertNotNull(twoVertexEmptyGraph);
		assertNotNull(twoVertexFullGraph);
	}

	@Test
	public void addEdge() {
		twoVertexEmptyGraph.addEdge(0, 1);
		assertTrue(twoVertexEmptyGraph.vertexMatrix[0][1]);
		assertTrue(twoVertexEmptyGraph.vertexMatrix[1][0]);
	}

	@Test
	public void deleteEdge() {
		twoVertexEmptyGraph.vertexMatrix[0][1] = true;
		assertTrue(twoVertexEmptyGraph.vertexMatrix[0][1]);
		twoVertexEmptyGraph.deleteEdge(0, 1);
		assertFalse(twoVertexEmptyGraph.vertexMatrix[0][1]);
		assertFalse(twoVertexEmptyGraph.vertexMatrix[1][0]);

		twoVertexFullGraph.deleteEdge(1, 0);
		assertFalse(twoVertexFullGraph.vertexMatrix[1][0]);
	}

	@Test
	public void getEdge() {
		twoVertexFullGraph.vertexMatrix[0][1] = true;
		assertTrue(twoVertexFullGraph.getEdge(0, 1));

		assertTrue(twoVertexFullGraph.getEdge(0, 1));
		assertTrue(twoVertexFullGraph.getEdge(1, 0));
	}
	

}