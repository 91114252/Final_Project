public class Flower extends Plant
{
    private int waterRqrd;

    public Flower(String type, boolean watered, int rndsWtrd)
    {
        super(type, watered, rndsWtrd);
        this.waterRqrd = 3;
    }

    //getter

    public int getWaterRqrd()
    {
        return waterRqrd;
    }

    //methods

    public String toString()
    {
        return super.toString() +
                "Water Required: " + waterRqrd;
    }

    public boolean waterMet()
    {
        if (rndsWtrd == waterRqrd)
        {
            return true;
        }
        return false;
    }

    public int harvest(int n)
    {
        if (waterMet() == true)
        {
            System.out.println("Harvested!");
            rndsWtrd = 0;
            return n++;
        }
        return n;
    }
}
