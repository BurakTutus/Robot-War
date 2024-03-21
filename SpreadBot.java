import java.util.Random;

public class SpreadBot extends Robot {
     Random rand = new Random();
    public SpreadBot()
    {
        this.name = "K" + number;
        this.health = rand.nextDouble(2, 3);
        this.attack = rand.nextDouble(0.5,1);
        this.speed = rand.nextDouble(0.5, 1.5);
        number++;
    }
    public void attack(Simulation s)
    {
        if(isReadTeam)
        {
           
           for(int i = 0; i < s.getLowestSpeed31(isReadTeam).length; i++)
           {
            s.RedTeam.get(i).getHit(this.attack);
            System.out.println(this.name + " attacks " + s.RedTeam.get(i).getName());
            System.out.println(s.RedTeam.get(i).getName() + " receives " + this.attack + " damage -> reamaining health: " + s.RedTeam.get(i).getHealth());
            if(s.RedTeam.get(i).getHitAndDestroyed(this.attack))
            {
                s.removeRobot(s.RedTeam.get(i));
            }                    

           }
        }
        else
        {
            for(int i = 0; i < s.getLowestSpeed31(isReadTeam).length; i++)
           {
            s.BlueTeam.get(i).getHit(this.attack);
            System.out.println(this.name + " attacks " + s.BlueTeam.get(i).getName());
            System.out.println(s.BlueTeam.get(i).getName() + " receives " + this.attack + " damage -> reamaining health: " + s.BlueTeam.get(i).getHealth());
            if(s.BlueTeam.get(i).getHitAndDestroyed(this.attack))
            {
                s.removeRobot(s.BlueTeam.get(i));
            }                    

           }
           
                
        }
    
    }    
    
}
