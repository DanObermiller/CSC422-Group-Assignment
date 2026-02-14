package zombieWar;

import java.util.Random;

//Character spawner for monsters and humans
//Written by Dan Obermiller for Zombie War project
//2/12/2026

public class characterSpawner {
    //Spawn one human
	Random rand = new Random();
    public Survivor spawnHuman(int survivorCount)
    {
        
        int randInt = rand.nextInt(3);
        Survivor human;
        
        //Random variable picks between soldier, child, and teacher
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
        
        //Add number to name
        String name = human.getName();
        human.setName("" + name + " " + (survivorCount + 1));
        return human;
    }
    
    //Spawn a specified number of humans
    public Survivor[] spawnManyHuman(int amount, int survivorCount)
    {
        Survivor[] humans = new Survivor[amount];
        //Random variable picks between soldier, child, and teacher
        for (int i = 0; i < amount; i++)
        {
            humans[i] = spawnHuman(survivorCount);
        }
        //Return array of humans
        return humans;
    }
    
    //Spawn a single zombie
    public Zombie spawnZombie(int zombieCount)
    {
        int randInt = rand.nextInt(2);
        Zombie monster;
        
        //Pick randomly between common infected or tank
        if (randInt == 0)
        {
            monster = new CommonInfected();
            
        }
        else {
            monster = new Tank();
        }
        
        //Add number to name and return
        String name = monster.getName();
        monster.setName("" + name + " " + (zombieCount + 1));
        return monster;
    }
    
    //Spawn a specified number of zombies
    public Zombie[] spawnManyZombie(int amount, int zombieCount)
    {
        Zombie[] monsters = new Zombie[amount];
        //For every zombie, pick between common infected or tank
        for (int i = 0; i < amount; i++)
        {
            monsters[i] = spawnZombie(zombieCount);
        }
        //Return list of monsters
        return monsters;
    }
}
