import java.util.Random;

public class PredatorBot extends Robot{

    Random rand = new Random();
    public PredatorBot()
    {
        this.name = "P" + number;
        this.health = rand.nextDouble(2, 3);
        this.attack = rand.nextDouble(2,3);
        this.speed = rand.nextDouble(0.5, 1);
        number++;
    }
    public void attack(Simulation s)
    {
        Robot attacked = s.getHighestHealth(isReadTeam);
        attacked.getHit(this.attack);
        if(attacked.getHitAndDestroyed(attack))
        {
            s.removeRobot(attacked);
        }
        
        
        System.out.println(this.name + " attacks " + attacked.getName());
        System.out.println(attacked.getName() + " receives " + this.attack + " damage -> reamaining health: " + attacked.getHealth());
    }    
}
