public class Garden
{
    private int pollen;
    private int seeds;
    private Herb[][] hgarden;
    private String[][] garden;
    private Flower[][] flgarden;
    private Fruiter[][] frgarden;

    public Garden(Herb herb, Flower flower, Fruiter fruiter)
    {
        this.pollen = 0;
        this.seeds = 1;
        this.hgarden = new Herb[][]{
                {herb, herb, herb, herb, herb},
                {herb, herb, herb, herb, herb},
                {herb, herb, herb, herb, herb},
                {herb, herb, herb, herb, herb},
                {herb, herb, herb, herb, herb},
        };
        this.garden = new String[][]{
                {"E", "E", "E", "E", "E"},
                {"E", "E", "E", "E", "E"},
                {"E", "E", "E", "E", "E"},
                {"E", "E", "E", "E", "E"},
                {"E", "E", "E", "E", "E"},
        };
        this.flgarden = new Flower[][]{
                {flower, flower, flower, flower, flower},
                {flower, flower, flower, flower, flower},
                {flower, flower, flower, flower, flower},
                {flower, flower, flower, flower, flower},
                {flower, flower, flower, flower, flower}
        };
        this.frgarden = new Fruiter[][]{
                {fruiter, fruiter, fruiter, fruiter, fruiter},
                {fruiter, fruiter, fruiter, fruiter, fruiter},
                {fruiter, fruiter, fruiter, fruiter, fruiter},
                {fruiter, fruiter, fruiter, fruiter, fruiter},
                {fruiter, fruiter, fruiter, fruiter, fruiter}
        };
    }

    //getters
    public int getPollen()
    {
        return pollen;
    }
    public int getSeeds()
    {
        return seeds;
    }
    public Herb getHGarden(int row, int col)
    {
        return hgarden[row][col];
    }
    public String getGarden(int row, int col)
    {
        return garden[row][col];
    }
    public String[][] getFullGarden()
    {
        return garden;
    }
    public Flower getFLGarden(int row, int col)
    {
        return flgarden[row][col];
    }
    public Fruiter getFRGarden(int row, int col)
    {
        return frgarden[row][col];
    }

    //setters
    public void setPollen(int n)
    {
        pollen = n;
    }
    public void setSeeds(int n)
    {
        seeds = n;
    }
    public void setHGarden(int row, int col,  Herb n)
    {
        hgarden[row][col] = n;
    }
    public void setGarden(int row, int col, String str)
    {
        garden[row][col] = str;
    }
    public void setFlGarden(int row, int col,  Flower n)
    {
        flgarden[row][col] = n;
    }
    public void setFrGarden(int row, int col, Fruiter n)
    {
        frgarden[row][col] = n;
    }

    //methods
    public String toString()
    {
        return "\nPollen: " + pollen +
                "\nSeeds: " + seeds;
    }

    public void plantSeed(int row, int col, Herb seed)
    {
        boolean temp = true;
        if (seeds > 0)
        {
            if (garden[row][col].equals("E"))
            {
                hgarden[row][col] = seed;
                garden[row][col] = "HB";
                hgarden[row][col].setRounds(0);
            }
            temp = false;
            seeds--;
        }
        System.out.println("Not enough seeds!");
    }
    public void plantSeed(int row, int col, Flower seed)
    {
        boolean temp = true;
        if (seeds > 0)
        {
            if (garden[row][col].equals("E"))
            {
                flgarden[row][col] = seed;
                garden[row][col] = "Fl";
            }
            temp = false;
            seeds--;
        }
        System.out.println("Not enough seeds!");
    }
    public void plantSeed(int row, int col, Fruiter seed)
    {
        boolean temp = true;
        if (seeds > 0)
        {
            if (garden[row][col].equals("E")) {
                frgarden[row][col] = seed;
                garden[row][col] = "FR";
            }
            temp = false;
            seeds--;
            System.out.println(seeds);
        }
        System.out.println("Not enough seeds!");
    }

    public void newRound()//traverses the garden and checks each plant in garden
    {
        for (int row = 0; row < garden.length; row++)
        {
            for (int col = 0; col < garden[row].length; col++)
            {
                if (hgarden[row][col].getType().equalsIgnoreCase("herb"))
                {
                    if (hgarden[row][col].getAlive() == false)
                    {
                        garden[row][col] = "DP";
                    }
                    else
                    {
                        if (hgarden[row][col].getWatered() == false)
                        {
                            garden[row][col] = "DP";
                            hgarden[row][col].setAlive(false);
                            hgarden[row][col].setRounds(hgarden[row][col].getRounds() + 1);
                        }
                        hgarden[row][col].setRounds(hgarden[row][col].getRounds() + 1);
                    }
                    hgarden[row][col].lives();
                }
            }
        }
        System.out.println("New round");
    }

    public void shovel(int row, int col)
    {
        setGarden(row, col, "E");
    }

}
