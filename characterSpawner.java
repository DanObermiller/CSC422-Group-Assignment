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
    
    public Survivor[] spawnManyHuman(int amount, int survivorCount)
    {
        Random rand = new Random();
        int randInt = rand.nextInt(3);
        Survivor[] humans;
        for (int i = 0; i < amount; i++)
        {
            if (randInt == 0)
            {
                humans[i] = new Soldier();

            }
            else if (randInt == 1)
            {
                humans[i] = new Child();
            }
            else {
                humans[i] = new Teacher();
            }

            String name = humans[i].getName();
            humans[i].setName("" + name + " " + (survivorCount + 1 + i));
            randInt = rand.nextInt(3);
        }
        return humans[];
    }
}
