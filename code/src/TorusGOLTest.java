import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TorusGOLTest {

    @Test
    public void testNeighbors(){

        int[][]a  = {{0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};

        TorusGameOfLife life = new TorusGameOfLife(a);
        assertEquals(4,life.neighbors(2,1));
    }

    @Test
    public void testNeighbors2(){
        int[][]a  = {{0, 0, 0},
                {0, 0, 0},
                {0, 1, 1}};
        TorusGameOfLife life = new TorusGameOfLife(a);
        assertEquals(2,life.neighbors(1,1));
    }

    @Test
    public void testNeighbors3(){
        int[][]a  = {{0, 0, 0},
                {1, 1, 1},
                {1, 1, 1}};

        TorusGameOfLife life = new TorusGameOfLife(a);
        assertEquals(3, life.neighbors(2,1));

    }

    @Test
    public void testNeighbors4(){
        int[][]a  = {{0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};

        TorusGameOfLife life = new TorusGameOfLife(a);
        assertEquals(0,life.neighbors(1,1));
    }

    @Test
    public void testNeighbors5(){
        int[][]a  = {{1, 0},
                {0, 0}};
        TorusGameOfLife life = new TorusGameOfLife(a);
        assertEquals(0,life.neighbors(1,0));

    }

    @Test
    public void testOneStep(){

        int[][]a  = {{0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};

        int[][] expected = {{0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}};

        TorusGameOfLife life = new TorusGameOfLife(a);
        life.oneStep();
        assertArrayEquals(expected, life.getBoard());
    }

    @Test
    public void testOneStep2(){
        int[][]a  = {{0, 0, 0},
                {0, 0, 0},
                {0, 1, 1}};

        int[][] expected = {{0, 0, 0},
                {0, 0, 1},
                {0, 0, 1}};

        TorusGameOfLife life = new TorusGameOfLife(a);
        life.oneStep();
        assertArrayEquals(expected,life.getBoard());
    }

    @Test
    public void testOneStep3(){
        int[][]a  = {{0, 0, 0},
                {1, 1, 1},
                {1, 1, 1}};

        int[][] expected = {{0,0, 0},
                {1, 0, 1},
                {0, 1, 0}};

        TorusGameOfLife life = new TorusGameOfLife(a);
        life.oneStep();
        assertArrayEquals(expected, life.getBoard());
    }

    @Test
    public void testOneStep4(){
        int[][]a  = {{0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};

        int[][] expected = {{0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};

        TorusGameOfLife life = new TorusGameOfLife(a);
        life.oneStep();
        assertArrayEquals(expected, life.getBoard());
    }

    @Test
    public void testOneStep5(){
        int[][]a  = {{1, 0},
                {0, 0}};

        int[][] expected = {{1, 1},
                {0, 0}};

        TorusGameOfLife life = new TorusGameOfLife(a);
        life.oneStep();
        assertArrayEquals(expected, life.getBoard());
    }

    @Test
    public void testEvolution(){

       int[][]a  = {{0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};

        int[][] expected = {{0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}};

        TorusGameOfLife life = new TorusGameOfLife(a);

        life.evolution(1);
        assertArrayEquals(expected,life.getBoard());
    }

    @Test
    public void testEvolution2(){
        int[][]a  = {{0, 0, 0},
                {0, 0, 0},
                {0, 1, 1}};

        int[][] expected = {{0, 0, 0},
                {0, 0, 1},
                {0, 0, 1}};

        TorusGameOfLife life = new TorusGameOfLife(a);
        life.evolution(3);
        assertArrayEquals(expected,life.getBoard());
    }

    @Test
    public void testEvolution3(){
        int[][]a  = {{0, 0, 0},
                {1, 1, 1},
                {1, 1, 1}};

        int[][] expected = {{0,0, 0},
                {1, 0, 1},
                {0, 1, 0}};

        TorusGameOfLife life = new TorusGameOfLife(a);
        life.evolution(20);
        assertArrayEquals(expected, life.getBoard());

    }

    @Test
    public void testEvolution4(){
        int[][]a  = {{0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};

        int[][] expected = {{0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};

        TorusGameOfLife life = new TorusGameOfLife(a);
        life.evolution(2);
        assertArrayEquals(expected, life.getBoard());
    }

    @Test
    public void testEvolution5(){
        int[][]a  = {{1, 0},
                {0, 0}};

        int[][] expected = {{1, 1},
                {0, 0}};

        TorusGameOfLife life = new TorusGameOfLife(a);
        life.evolution(5);
        assertArrayEquals(expected, life.getBoard());
    }
}
