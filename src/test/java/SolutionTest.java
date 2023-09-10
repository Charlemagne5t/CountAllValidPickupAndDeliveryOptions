import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void countOrdersTest1() {
        int n = 1;
        int expected = 1;
        int actual = new Solution().countOrders(n);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void countOrdersTest2() {
        int n = 2;
        int expected = 6;
        int actual = new Solution().countOrders(n);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void countOrdersTest3() {
        int n = 3;
        int expected = 90;
        int actual = new Solution().countOrders(n);

        Assert.assertEquals(expected, actual);
    }
}
