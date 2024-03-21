public abstract class Robot implements Comparable<Robot>{

    protected double health;
    protected double attack;
    protected double speed;
    protected String name;
    public static boolean isReadTeam = true;
    public static int number = 0;

    abstract void attack (Simulation s);

    public void getHit(double damage)
    {
        double last_health = 0;
        last_health = this.health - damage;
        this.health = last_health;
    }

    public boolean getHitAndDestroyed(double damage)
    {        
        boolean found = false;
        if(this.health<= 0)
        {
            found = true;
        }
        return found; 
    }

    public double getHealth()
    {
        return this.health;
    }
    public double getAttack()
    {
        return this.attack;
    }
    public double getSpeed()
    {
        return this.speed;
    }
    public String getName()
    {
        return this.name;
    }   
    public String toString()
    {
        String result = "";
        result += this.name + " Health: " + this.health + " Attack: " +this.attack + " Speed: " + this.speed;
        return result; 
    }
    public int compareTo(Robot r)
    {
        if(this.speed > r.speed)
        {
            return -1;
        }
        if(this.speed < r.speed)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

}