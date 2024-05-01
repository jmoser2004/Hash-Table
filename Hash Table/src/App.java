import java.util.Scanner;

public class App {
    public static void main(String[] args)
    {
        HashTable myTable = new HashTable(10, "My Table");

        for(int i = 0; i < 10; i++)
        {
            myTable.insertItem(i + "");
        }

        System.out.println(myTable.popItem(5 + ""));
    }
}