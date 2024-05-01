public class HashTable
{
    public String name;
    public String[] hashTable;

    public HashTable(int s, String n)
    {
        name = n;

        hashTable = new String[s];
        for(int i = 0; i < s; i++)
        {
            hashTable[i] = "";
        }
    }

    public boolean insertItem(String insertMe)
    {
        if(insertMe == "") return true;

        int index = hashAlgorithm(insertMe);

        if(hashTable[index].equals(""))
        {
            hashTable[index] = insertMe;
            return true;
        }

        return false;
    }

    public String popItem(String popMe)
    {
        if(inTable(popMe))
        {
            String returnMe = hashTable[hashAlgorithm(popMe)];
            hashTable[hashAlgorithm(popMe)] = "";
            return returnMe;
        }

        return "";
    }

    public boolean deleteItem(String deleteMe)
    {
        if(inTable(deleteMe))
        {
            hashTable[hashAlgorithm(deleteMe)] = "";

            if(!inTable(deleteMe)) return true;
        }
        return false;
    }

    public boolean inTable(String checkMe)
    {
        if(checkMe.equals("")) return false;

        int checkIndex = hashAlgorithm(checkMe);

        if(hashTable[checkIndex].equals(checkMe)) return true;

        return false;
    }

    public int hashAlgorithm(String hashMe)
    {
        int result = 0;

        for(int i = 0; i < hashMe.length(); i++)
        {
            result += (int)hashMe.charAt(i);
            result *= result;
            result -= i;
            result %= (hashTable.length - 1);
        }

        return result;
    }

    public void printTable()
    {
        System.out.println("\nTable " + name + ":");

        for(int i = 0; i < hashTable.length; i++)
            System.out.println("| " + i + ": " + hashTable[i]);
    }
}