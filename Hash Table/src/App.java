import java.util.Scanner;

public class App {
    public static void main(String[] args)
    {
        HashTable myTable = new HashTable(10, "My Table");

        myTable.insertItem("a \n a");

        System.out.println(myTable.popItem("a \n b"));

        System.out.println(myTable.popItem("a \n a"));
    }
}