import java.util.Random;

public class OneBot extends Robot {

     Random rand = new Random();
    public OneBot()
    {
        this.name = "O" + number;
        this.health = rand.nextDouble(0.5, 1);
        this.attack = rand.nextDouble(4,5);
        this.speed = rand.nextDouble(0.5, 1);
        number++;
    }
    public void attack(Simulation s)
    {
        Robot attacked = s.getLowestHealth(isReadTeam);
        attacked.getHit(this.attack);
        if(attacked.getHitAndDestroyed(attack))
        {
            s.removeRobot(attacked);
        }
          
        
        System.out.println(this.name + " attacks " + attacked.getName());
        System.out.println(attacked.getName() + " receives " + this.attack + " damage -> reamaining health: " + attacked.getHealth());        
    }        
}
