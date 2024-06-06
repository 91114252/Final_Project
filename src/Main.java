import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Herb herb = new Herb("Herb", false, 0);
        Flower flower = new Flower("Flower", false, 0);
        Fruiter fruiter = new Fruiter("Fruiter", false, 0);
        Garden garden = new Garden(herb, flower, fruiter);
        String str = "";
        int row = 0;
        int col = 0;
        int n = 0;

        commands(garden);

        while (str.equalsIgnoreCase("stop") == false)
        {
            str = scan.nextLine();

            if (str.equals("plantSeed"))
            {
                System.out.println("What type?: ");
                str = scan.next();
                if(str.equalsIgnoreCase("Herb"))
                {
                    System.out.println("X?: ");
                    row = scan.nextInt();
                    System.out.println("Y?: ");
                    col = scan.nextInt();
                    garden.plantSeed(row, col, herb);
                    commands(garden);
                }
                else if (str.equalsIgnoreCase("Flower"))
                {
                    System.out.println("X?: ");
                    row = scan.nextInt();
                    System.out.println("Y?: ");
                    col = scan.nextInt();
                    garden.plantSeed(row, col, flower);
                    commands(garden);
                }
                else if(str.equalsIgnoreCase("Fruiter"))
                {
                    System.out.println("X?: ");
                    row = scan.nextInt();
                    System.out.println("Y?: ");
                    col = scan.nextInt();
                    garden.plantSeed(row, col, fruiter);
                    commands(garden);
                }
            }
            if (str.equalsIgnoreCase("pollinate"))
            {
                System.out.println("X?: ");
                row = scan.nextInt();
                System.out.println("Y?: ");
                col = scan.nextInt();
                System.out.println("How much?: ");
                n = scan.nextInt();
                garden.getFRGarden(row, col).pollinate(n);
                commands(garden);
            }
            if (str.equalsIgnoreCase("Harvest"))
            {
                System.out.println("X?: ");
                row = scan.nextInt();
                System.out.println("Y?: ");
                col = scan.nextInt();
                if (garden.getGarden(row, col).equals("FL"))
                {
                    garden.setPollen(garden.getFLGarden(row, col).harvest(garden.getPollen()));
                    commands(garden);
                }
                else
                {
                    garden.setSeeds(garden.getFRGarden(row, col).harvest(garden.getSeeds()));
                    commands(garden);
                }


            }
            if (str.equalsIgnoreCase("Water"))
            {
                System.out.println("What type?: ");
                str = scan.next();
                System.out.println("X?: ");
                row = scan.nextInt();
                System.out.println("Y?: ");
                col = scan.nextInt();
                if (str.equalsIgnoreCase("herb"))
                {
                    garden.getHGarden(row, col).water();
                    commands(garden);
                }
                else
                {
                    garden.getFLGarden(row, col).water();
                    commands(garden);
                }
            }
            if (str.equalsIgnoreCase("newRound"))
            {
                garden.newRound();
                commands(garden);
            }
            if (str.equalsIgnoreCase("showGarden"))
            {
                for (int r = 0; r < garden.getFullGarden().length; r++)
                {
                    for (int c = 0; c < garden.getFullGarden()[row].length; c++)
                    {
                        System.out.print(garden.getGarden(r, c) + "  ");
                    }
                    System.out.print("\n");
                }
                commands(garden);
            }
            if (str.equalsIgnoreCase("shovel"))
            {
                System.out.println("X?: ");
                row = scan.nextInt();
                System.out.println("Y?: ");
                col = scan.nextInt();
                garden.getFLGarden(row, col).harvest(garden.getPollen());
                garden.getFRGarden(row, col).harvest(garden.getPollen());
                commands(garden);
            }
        }
    }

    public static void commands(Garden garden)
    {
        System.out.println("Commands: " +
                "\nplantSeed\tpollinate\tharvest" +
                "\nwater\t\tnewRound\tshowGarden\n" +
                "Pollen: " + garden.getPollen() +
                "\tSeeds: " + garden.getSeeds() +
                "\tShovel\ntype stop to end");
    }
}