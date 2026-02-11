package zombieWar;

import java.util.Random;

public class characterSpawner {
    public Survivor spawnHuman(int survivorCount)
    {
        Random rand = new Random();
        int randInt = rand.nextInt(3);
        Survivor human;
        
        if (randInt == 0)
        {
            human = new Soldier();
            
        }
        else if (randInt == 1)
        {
            human = new Child();
        }
        else {
            human = new Teacher();
        }
        
        String name = human.getName();
        human.setName("" + name + " " + (survivorCount + 1));
        return human;
    }
}
