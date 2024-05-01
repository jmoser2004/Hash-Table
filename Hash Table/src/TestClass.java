public class TestClass {
    private int testInt;
    private static int totalNum = 0;

    public TestClass(int tI)
    {
        testInt = tI;
        totalNum++;
    }

    public void setTestInt(int tI){testInt = tI;}
    
    public int getTestInt(){return testInt;}
    public static int getTotalNum(){return totalNum;}
}