import ada.wm2.helper.SalaryHelper;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class SalaryHelperTest {
    @Test
    public void testGrossToNet2017() {
        double value;
        double expectedValue;

        value = SalaryHelper.GrossToNet2017(0,7396.0,2);
        expectedValue = 5452.2;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2017(0,17326.0,7);
        expectedValue = 11536.9;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2017(0,902.0,10);
        expectedValue = 680.16;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2017(400,1000.0,5);
        expectedValue = 857.7;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2017(200, 1000.0,5);
        expectedValue = 829.7;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2017(100,1000.0,5);
        expectedValue = 815.7;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2017(50,1000.0,5);
        expectedValue = 808.7;
        assertTrue(expectedValue == value);

    }

    @Test
    public void testGrossToNet2018() {
        double value;
        double expectedValue;

        value = SalaryHelper.GrossToNet2018(0,7396.0,2);
        expectedValue = 5415.22;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2018(0,17326.0,7);
        expectedValue = 11450.27;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2018(0,902.0,10);
        expectedValue = 678.17;
        assertTrue(expectedValue == value);



        value = SalaryHelper.GrossToNet2018(400,1000.0,5);
        expectedValue = 855.22;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2018(200, 1000.0,5);
        expectedValue = 827.22;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2018(100,1000.0,5);
        expectedValue = 813.22;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2018(50,1000.0,5);
        expectedValue = 806.22;
        assertTrue(expectedValue == value);

    }

    @Test
    public void testGrossToNet2019() {
        double value;
        double expectedValue;

        value = SalaryHelper.GrossToNet2019(0,true,7396.0,2);
        expectedValue = 6485.5;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2019(0,true, 17326.0,7);
        expectedValue = 13002.31;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2019(0,false, 902.0,10);
        expectedValue = 681.95;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2019(0,true, 902.0,10);
        expectedValue = 731.09;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2019( 0,true,500.0, 5);
        expectedValue = 436.5;
        assertTrue(expectedValue == value);



        value = SalaryHelper.GrossToNet2019(400,true,1000.0,5);
        expectedValue = 859.0;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2019(200, true,1000.0,5);
        expectedValue = 859.0;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2019(100,true,1000.0,5);
        expectedValue = 859.0;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2019(50,true,1000.0,5);
        expectedValue = 859.0;
        assertTrue(expectedValue == value);

    }

    @Test
    public void testGrossToNet2020() {
        double value;
        double expectedValue;

        value = SalaryHelper.GrossToNet2020(0,true, 7396.0,2);
        expectedValue = 6411.54;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2020(0,true, 17326.0,7);
        expectedValue = 12875.68;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2020(0,false, 902.0,10);
        expectedValue = 663.91;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2020(0,true, 902.0,10);
        expectedValue = 722.07;
        assertTrue(expectedValue == value);


        value = SalaryHelper.GrossToNet2020(400,true,1000.0,5);
        expectedValue = 849.0;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2020(200, true,1000.0,5);
        expectedValue = 849.0;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2020(100,true,1000.0,5);
        expectedValue = 849.0;
        assertTrue(expectedValue == value);

        value = SalaryHelper.GrossToNet2020(50,true,1000.0,5);
        expectedValue = 849.0;
        assertTrue(expectedValue == value);

    }

    @Test
    public void testNetToGross2018() {
        double value;
        double expectedValue;

        value = SalaryHelper.NetToGross2018(560.0);
        expectedValue = 649.43;
        assertTrue(expectedValue == value);

        value = SalaryHelper.NetToGross2018(12580.0);
        expectedValue = 17209.79;
        assertTrue(expectedValue == value);

        value = SalaryHelper.NetToGross2018(870.0);
        expectedValue = 1025.19;
        assertTrue(expectedValue == value);

    }

    @Test
    public void testNetToGross2019() {
        double value;
        double expectedValue;

        value = SalaryHelper.NetToGross2019(560.0);
        expectedValue = 649.43;
        assertTrue(expectedValue == value);

        value = SalaryHelper.NetToGross2019(12580.0);
        expectedValue = 17209.79;
        assertTrue(expectedValue == value);

        value = SalaryHelper.NetToGross2019(870.0);
        expectedValue = 1025.19;
        assertTrue(expectedValue == value);

    }

}