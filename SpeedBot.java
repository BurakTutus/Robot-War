import java.util.Random;

public class SpeedBot extends Robot {
     Random rand = new Random();
    public SpeedBot()
    {
        this.name = "X" + number;
        this.health = rand.nextDouble(1, 2);
        this.attack = rand.nextDouble(1,2);
        this.speed = rand.nextDouble(3, 4);
        number++;
    }
    public void attack(Simulation s)
    {
        Robot attacked = s.getLowestAttack(isReadTeam);
        attacked.getHit(this.attack);
        if(attacked.getHitAndDestroyed(attack))
        {
            s.removeRobot(attacked);
        }
            
        System.out.println(this.name + " attacks " + attacked.getName());
        System.out.println(attacked.getName() + " receives " + this.attack + " damage -> reamaining health: " + attacked.getHealth());        
    }    
    
}
