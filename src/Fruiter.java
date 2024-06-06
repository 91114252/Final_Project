public class Fruiter extends Plant
{
    private boolean pollinated;
    private int plnRqrd;

    public Fruiter(String type, boolean watered, int rndsWtrd)
    {
        super(type, watered, rndsWtrd);
        this.pollinated = false;
        this.plnRqrd = 3;
    }

    //getter and setter
    public boolean getPollinated()
    {
        return pollinated;
    }
    public int getPlnRqrd()
    {
        return plnRqrd;
    }

    public void setPollinated(boolean n)
    {
        pollinated = n;
    }

    //methods

    public String toString()
    {
        return super.toString() +
                "Pollnated: " + pollinated;
    }

    public void pollinate (int n)
    {
        if (n != plnRqrd)
        {
            System.out.println("Not enough pollen");
        }
        else
        {
            System.out.println("Pollinated!");
            pollinated = true;
        }
    }

    public int harvest(int n)
    {
        if (pollinated == true)
        {
            System.out.println("Harvested!");
            pollinated = false;
            return n++;
        }
        return n;
    }

}
