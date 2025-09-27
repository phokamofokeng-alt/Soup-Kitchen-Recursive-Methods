// Creating a Soup Kitchen through different recursive method types.
// Each person receives 2 slices of bread and 1 cup of soup
// Bread input as loafs -> one loaf == 24 slices
// Soup input as 3-l pots -> one litre == 5 cups (200ml a cup)
// A method should return the amount of people fed.
// A method should aslo return the amount of slices and cups of soup left

//"Base Case"
// If a 2:1 serving cannot be met, if a person cannot have 2 slices + 1 cup of soup

public class SoupKitchen
{
    // Slices should be inputed after being converted from loaves from another method
    // Same with cups from pots of litres
    public static int charityTree (int slices, int cups)
    {
        // Base case: no people fed / no meals available
        if (slices <2 || cups <1)
        {
            return 0;
        }
        else 
        {
            // Create two branches
            // 1. Focusing on bread served. Count people fed a whole meal in that branch
            int breadBranch = 1 + charityTree(slices -2, cups); 

            // 2. Focusing on soup served. Count people fed whole meal in that branch
            int soupBranch = 1 + charityTree(slices, cups -1);

            return Math.max(breadBranch, soupBranch);

        }

    }

    // method to convert loaves to slices
    public static int slices( int loaves)
    {
        // base case: no slices
        if (loaves == 0)
        {
            return 0;
        }

        else
        {
            return 24 + slices(loaves -1);

        }


    }

    // method to convert pots of soups into cups
    // One 3l pot makes 5 x 3 = 15 cups 
    public static int cups (int pots)
    {

        // base case: no soup available
        if (pots ==0)
        {
            return 0;
        }

        else
        {
            return 15 + cups(pots -1);
        }
    }

    // Main method
    public static void main (String [] args)
    {
        int loaves = 5; // 5 loaves = 5 x 24 slices = 120 slices
        int pots = 3; // 3 pots = 3 x 15 cups = 45 cups

        int totalSlices, totalCups, fed, slicesLeft, cupsLeft;
        totalSlices = slices(loaves);
        totalCups = cups(pots);
        fed = charityTree(totalSlices, totalCups);
        slicesLeft = totalSlices - (fed *2);
        cupsLeft = totalCups - (fed *1);


        System.out.println("People fed: " +fed);
        System.out.println("Leftover slices: " +slicesLeft);
        System.out.println("Leftover cups: " +cupsLeft);

    }

}
