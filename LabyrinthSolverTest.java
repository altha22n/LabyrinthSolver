import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by peter on 4/2/17.
 */
public class LabyrinthSolverTest {

    Labyrinth testLab;
    Graph g;

    @Before
    public void setup() {
        testLab = new Labyrinth();
        g       = new GraphMatrix(testLab.getLength()*testLab.getWidth());
        g       = LabyrinthSolver.labyrinthToGraph(testLab,g);
    }

    @Test
    public void labyrinthToNodeNumber() {
        int node = LabyrinthSolver.labyrinthToNodeNumber(6,7,10);

        assertEquals(67, node);
        
        int testNode = LabyrinthSolver.labyrinthToNodeNumber(3, 6, 10);
        assertEquals(36, testNode);
    }

    @Test
    public void labyrinthToGraph() {
        int trueCount = 0;

        for(int i = 0; i < g.getVertexCount(); i++) {
            for( int j = 0; j < g.getVertexCount(); j++ ) {
                if( g.getEdge(i, j) )
                    trueCount++;
            }
        }

        assertEquals( 52, trueCount);
    }

    @Test
    public void breadFirstSearch() {
        assertArrayEquals(new int[]{0,6,12,18,24,30,31,32,33,34,35}, LabyrinthSolver.breadFirstSearch(g));
    }

}