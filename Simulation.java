import java.util.ArrayList;
import java.util.Random;

public class Simulation {

    ArrayList<Robot> RedTeam = new ArrayList<>();
    ArrayList<Robot> BlueTeam = new ArrayList<>();
    Random random = new Random();
    
    public void initialize(int teamSize)
    {
        for(int i = 0; i < teamSize; i++)
        {
            int chooser = random.nextInt(6);
            if(chooser == 0)
            {
                RedTeam.add(new SimpleBot());
            }
            else if(chooser == 1)
            {
                RedTeam.add(new PredatorBot());
            }
            else if(chooser == 2)
            {
                RedTeam.add(new DefenceBot());
            }
            else if(chooser == 3)
            {
                RedTeam.add(new OneBot());
            }
            else if(chooser == 4)
            {
                RedTeam.add(new SpeedBot());
            }
            else if(chooser == 5)
            {
                RedTeam.add(new SpreadBot());
            }
        }
        for(int i = 0; i < teamSize; i++)
        {
            int chooser = random.nextInt(6);
            if(chooser == 0)
            {
                BlueTeam.add(new SimpleBot());
            }
            else if(chooser == 1)
            {
                BlueTeam.add(new PredatorBot());
            }
            else if(chooser == 2)
            {
                BlueTeam.add(new DefenceBot());
            }
            else if(chooser == 3)
            {
                BlueTeam.add(new OneBot());
            }
            else if(chooser == 4)
            {
                BlueTeam.add(new SpeedBot());
            }
            else if(chooser == 5)
            {
                BlueTeam.add(new SpreadBot());
            }
        }
        //RedTeam = SortMethod(RedTeam);
        //BlueTeam = SortMethod(BlueTeam);
        RedTeam.sort(null);
        BlueTeam.sort(null);

    }
    private ArrayList<Robot> SortMethod(ArrayList<Robot> team)
    {
        ArrayList<Robot> result = new ArrayList<>();
        int index = 0;
        while(team.size() > 0)
        {
            for(int i = 0; i < team.size(); i++)
            {
                if(team.get(index).getSpeed() < team.get(i).getSpeed())
                {
                    index = i;
                }
            }
            result.add(team.get(index));
            team.remove(index);
            index = 0;            
        }
        return result;
    }    
    public void simulate()
    {
        double speed_of_red = 0;
        double speed_of_blue = 0;        
        for(int i = 0; i < RedTeam.size(); i++)
        {
            speed_of_red += RedTeam.get(i).getSpeed();
            speed_of_blue += BlueTeam.get(i).getSpeed();
        }
        System.out.println("Speed sum of Red" + speed_of_red); 
        System.out.println("Speed sum of Blue" + speed_of_blue); 
        if(speed_of_blue > speed_of_red)
        {
            Robot.isReadTeam = true;
            System.out.println("Blue starts first");
        }
        else
        {
            System.out.println("Red starts first"); 
            Robot.isReadTeam = false;
        }
        int redindex = 0;
        int blueindex = 0;
        Robot nextblue = BlueTeam.get(blueindex);
        Robot nextred = RedTeam.get(redindex);
        
        while(RedTeam.size() != 0 && BlueTeam.size() != 0)
        {           
            if(Robot.isReadTeam)
            {
                if(blueindex < BlueTeam.size())
                {
                    nextblue = BlueTeam.get(blueindex);
                    nextblue.attack(this);
                    blueindex++;
                }
                else
                {
                    blueindex = 0;
                }               

            }
            else
            {
                if(redindex < RedTeam.size())
                {
                    nextred = RedTeam.get(redindex);
                    nextred.attack(this);
                    redindex++;
                }
                else
                {
                    redindex = 0;
                }               
            }
            Robot.isReadTeam = !Robot.isReadTeam;
        }    

        
                      
    }
    public Robot getRandomRobot(boolean isReadTeam)
    {
        int x = random.nextInt(RedTeam.size());
        int y = random.nextInt(BlueTeam.size());
        if(isReadTeam)
        {
            return RedTeam.get(x);
        }
        else
        {
            return BlueTeam.get(y);
        }
        
    }
    public Robot getHighestHealth(boolean isReadTeam)
    {
        int index = 0;
        if(isReadTeam)
        {
            for(int i = 0; i < RedTeam.size(); i++)
            {
                if(RedTeam.get(index).getHealth() < RedTeam.get(i).getHealth())
                {
                    index = i;
                }
            }
            return RedTeam.get(index);
        }
        else
        {
            for(int i = 0; i < BlueTeam.size(); i++)
            {
                if(BlueTeam.get(index).getHealth() < BlueTeam.get(i).getHealth())
                {
                    index = i;
                }
            }
            return BlueTeam.get(index);
        }
    }
    public Robot getLowestHealth(boolean isReadTeam)
    {
        int index = 0;
        if(isReadTeam)
        {
            for(int i = 0; i < RedTeam.size(); i++)
            {
                if(RedTeam.get(index).getHealth() > RedTeam.get(i).getHealth())
                {
                    index = i;
                }
            }
            return RedTeam.get(index);
        }
        else
        {
            for(int i = 0; i < BlueTeam.size(); i++)
            {
                if(BlueTeam.get(index).getHealth() > BlueTeam.get(i).getHealth())
                {
                    index = i;
                }
            }
            return BlueTeam.get(index);
        }
    }
    public Robot getLowestSpeed(boolean isReadTeam)
    {
        int index = 0;
        if(isReadTeam)
        {
            for(int i = 0; i < RedTeam.size(); i++)
            {
                if(RedTeam.get(index).getSpeed() > RedTeam.get(i).getSpeed())
                {
                    index = i;
                }
            }
            return RedTeam.get(index);
        }
        else
        {
            for(int i = 0; i < BlueTeam.size(); i++)
            {
                if(BlueTeam.get(index).getSpeed() > BlueTeam.get(i).getSpeed())
                {
                    index = i;
                }
            }
            return BlueTeam.get(index);
        }
    }
    public Robot getLowestAttack(boolean isReadTeam)
    {
        int index = 0;
        if(isReadTeam)
        {
            for(int i = 0; i < RedTeam.size(); i++)
            {
                if(RedTeam.get(index).getAttack() > RedTeam.get(i).getAttack())
                {
                    index = i;
                }
            }
            return RedTeam.get(index);
        }
        else
        {
            for(int i = 0; i < BlueTeam.size(); i++)
            {
                if(BlueTeam.get(index).getAttack() > BlueTeam.get(i).getAttack())
                {
                    index = i;
                }
            }
            return BlueTeam.get(index);
        }
    }
    public Robot[] getLowestSpeed3(boolean isReadTeam)
    {
        int j = 0;
        ArrayList<Robot> copy = new ArrayList<>();
        for(int i = 0; i < RedTeam.size(); i++)
        {
            copy.add(RedTeam.get(i));
        }
        ArrayList<Robot> copy2 = new ArrayList<>();
        for(int i = 0; i < BlueTeam.size(); i++)
        {
            copy2.add(BlueTeam.get(i));
        }
        Robot[] result = new Robot[3];
        int index = 0;
        if(isReadTeam)
        {
            while(copy.size() > 0 && j < 3)
            {
                for(int i = 0; i < copy.size(); i++)
                {
                    if(copy.get(index).getSpeed() > copy.get(i).getSpeed())
                    {
                        index = i;
                    }
                }                
                result[j] = copy.get(index);
                copy.remove(index);
                index = 0;
                j++;            
            }
            return result;
        }
        else 
        {
            while(copy2.size() > 0 && j < 3)
            {
                for(int i = 0; i < copy2.size(); i++)
                {
                    if(copy2.get(index).getSpeed() > copy2.get(i).getSpeed())
                    {
                        index = i;
                    }
                }                
                result[j] = copy2.get(index);
                copy2.remove(index);
                index = 0;
                j++;            
            }
            return result;
        }        
    }
    public Robot[] getLowestSpeed31(boolean isReadTeam)
    {
        int index = 0;
        int j = 0;
        int k = 0;
        Robot[] result = new Robot[3];
        ArrayList<Robot> copy = new ArrayList<>();
        for(int i = 0; i < RedTeam.size(); i++)
        {
            copy.add(RedTeam.get(i));
        }
        ArrayList<Robot> copy2 = new ArrayList<>();
        for(int i = 0; i < BlueTeam.size(); i++)
        {
            copy2.add(BlueTeam.get(i));
        }
        if(isReadTeam)
        {
            if(copy.size() < 3)
            {
                result = new Robot[copy.size()];
                for(int i = 0; i < copy.size(); i++)
                {
                    result[i] = copy.get(i);
                }
            }
            else
            {
                for(int i = 0; i < copy.size(); i++)
                {
                    if(copy.get(index).getSpeed() > copy.get(i).getSpeed())
                    {
                        index = i;
                    }
                }                
                result[j] = copy.get(index);
                copy.remove(index);
                j++;
            }
        }
        else
        {
            if(copy2.size() < 3)
            {
                result = new Robot[copy2.size()];
                for(int i = 0; i < copy2.size(); i++)
                {
                    result[i] = copy2.get(i);
                }
            }
            else
            {
                for(int i = 0; i < copy2.size(); i++)
                {
                    if(copy2.get(index).getSpeed() > copy2.get(i).getSpeed())
                    {
                        index = i;
                    }
                }                
                result[k] = copy2.get(index);
                copy2.remove(index);
                k++;
            }
        }
        return result;
    }
    public void removeRobot(Robot r)
    {
        for(int i = 0; i < RedTeam.size(); i++)
        {
            if(r.getName().equals(RedTeam.get(i).getName()))
            {
                RedTeam.remove(i);
            }            
        }
        for(int j = 0; j < BlueTeam.size(); j++)
        {
            if(r.getName().equals(BlueTeam.get(j).getName()))
            {
                BlueTeam.remove(j);
            }
        }
    }

}
