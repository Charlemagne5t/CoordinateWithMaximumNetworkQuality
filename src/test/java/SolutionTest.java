import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        int[][] towers = {
                {1, 2, 5},
                {2, 1, 7},
                {3, 1, 9}
        };
        int radius = 2;
        int[] expected = {2, 1};
        int[] actual = new Solution().bestCoordinate(towers, radius);
        Assert.assertArrayEquals(expected, actual);
    }
    @Test
    public void test5() {
        int[][] towers = {
                {32, 36, 27},
                {17, 22, 43},
                {8, 11, 41},
                {46, 28, 7},
                {22, 4, 35},
                {41, 8, 33},
                {32, 29, 4},
                {44, 32, 16},
                {33, 20, 16},
                {3, 38, 35},
                {17, 47, 23},
                {33, 0, 29},
                {29, 19, 6},
                {4, 50, 46},
                {19, 47, 6},
                {48, 6, 41},
                {20, 26, 35}
        };
        int radius = 4;
        int[] expected = {4, 50};
        int[] actual = new Solution().bestCoordinate(towers, radius);
        Assert.assertArrayEquals(expected, actual);
    }

}
