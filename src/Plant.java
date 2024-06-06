public class Plant
{
    public String type;
    public boolean watered;
    public int rndsWtrd;

    public Plant(String type, boolean watered, int rndsWtrd)
    {
        this.type = type;
        this.watered = watered;
        this.rndsWtrd = rndsWtrd;
    }

    // getters
    public String getType()
    {
        return type;
    }
    public boolean getWatered()
    {
        return watered;
    }
    public int getRndsWtrd()
    {
        return rndsWtrd;
    }

    // setters
    public void setWatered(boolean b)
    {
        watered = b;
    }

    // methods

    public String toString() {
        return "\ntype: " + type +
                "\nwatered: " + watered +
                "\nrndsWtrd: " + rndsWtrd;
    }

    public void water()
    {
        watered = true;
        rndsWtrd++;
        System.out.println("Watered!");
    }
}

