import java.util.Scanner;

public class RunRobo {
    
    public static void main(String[] args) {
        
        Simulation s = new Simulation();
        Scanner input = new Scanner(System.in);
        System.out.print("Team Size: ");        
        int number = input.nextInt();
        System.out.print(number);
        s.initialize(number);
        System.out.println("Red Team:");
        for(int i = 0; i < s.RedTeam.size(); i++)
        {
            System.out.println(s.RedTeam.get(i));
        }
        System.out.println("Blue Team:");
        for(int i = 0; i < s.BlueTeam.size(); i++)
        {
            System.out.println(s.BlueTeam.get(i));
        }
        s.simulate();
        if(s.BlueTeam.size() == 0)
        {
            System.out.println("Red team wins");
            System.out.println(s.RedTeam);
        }
        else if(s.RedTeam.size() == 0)
        {
            System.out.println("Blue team wins");
            System.out.println(s.BlueTeam);
        }     
    }
}
