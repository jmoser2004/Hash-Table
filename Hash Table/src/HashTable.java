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

        while(index < hashTable.length)
        {
            if(hashTable[index].equals(""))
            {
                hashTable[index] = insertMe;
                return true;
            }
            index++;
        }

        return false;
    }

    public String popItem(String popMe)
    {
        if(inTable(popMe) != -1)
        {
            String returnMe = hashTable[inTable(popMe)];
            hashTable[inTable(popMe)] = "";
            return returnMe;
        }

        return "";
    }

    public boolean deleteItem(String deleteMe)
    {
        if(inTable(deleteMe) != -1)
        {
            hashTable[inTable(deleteMe)] = "";

            if(inTable(deleteMe) == -1) return true;
        }
        return false;
    }

    public int inTable(String checkMe)
    {
        if(checkMe.equals("")) return -1;

        int checkIndex = hashAlgorithm(checkMe);

        while(checkIndex < hashTable.length)
        {
            if(hashTable[checkIndex].equals(checkMe)) return checkIndex;

            checkIndex++;
        }

        return -1;
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