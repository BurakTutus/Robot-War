import java.util.Random;

public class DefenceBot extends Robot {

     Random rand = new Random();
    public DefenceBot()
    {
        this.name = "D" + number;
        this.health = rand.nextDouble(3, 6);
        this.attack = rand.nextDouble(0.5,1 );
        this.speed = rand.nextDouble(0.5, 1);
        number++;
    }
    public void attack(Simulation s)
    {
        Robot attacked = s.getLowestSpeed(isReadTeam);
        attacked.getHit(this.attack);
        if(attacked.getHitAndDestroyed(attack))
        {
            s.removeRobot(attacked);
        }
    
        System.out.println(this.name + " attacks " + attacked.getName());
        System.out.println(attacked.getName() + " receives " + this.attack + " damage -> reamaining health: " + attacked.getHealth());
    }    
    
}
