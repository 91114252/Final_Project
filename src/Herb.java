public class Herb extends Plant
{
    private int rounds;
    private boolean alive;

    public Herb(String type, boolean watered, int rndsWtrd)
    {
        super(type, watered, rndsWtrd);
        this.rounds = 0;
        this.alive = true;
    }

    //getters

    public int getRounds()
    {
        return rounds;
    }
    public boolean getAlive()
    {
        return alive;
    }

    //setters

    public void setRounds(int n)
    {
        rounds = n;
    }
    public void setAlive(boolean n)
    {
        alive = n;
    }

    //methods

    public String toString()
    {
        return super.toString() +
                "Rounds: " +
                "Alive: " + alive;
    }

    public void lives()
    {
        if (rounds <= 5 && watered == true)
        {
            alive = true;
        }
        alive = false;
    }
}
