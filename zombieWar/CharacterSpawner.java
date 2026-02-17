package zombieWar;

import java.util.Random;

//Character spawner for monsters and humans
//Written by Dan Obermiller for Zombie War project
//2/12/2026

public class CharacterSpawner {
	//Spawn one human
	Random rand = new Random();
	int soldierCount;
	int teacherCount;
	int childCount;
	int commonCount;
	int tankCount;
	public Survivor spawnHuman()
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

		return human;
	}

	//Spawn a specified number of humans
	public Survivor[] spawnManyHuman(int amount)
	{
		soldierCount = 0;
		teacherCount = 0;
		childCount = 0;
		Survivor[] humans = new Survivor[amount];
		//Random variable picks between soldier, child, and teacher
		for (int i = 0; i < amount; i++)
		{
			humans[i] = spawnHuman();
			//Add number to name
			String name = humans[i].getName();
			switch(name){
			case("Soldier"):
				humans[i].setName("" + name + " " + (soldierCount + 1));
				soldierCount++;
				continue;
			case("Teacher"):
				humans[i].setName("" + name + " " + (teacherCount + 1));
				teacherCount++;
				continue;
			case("Child"):
				humans[i].setName("" + name + " " + (childCount + 1));
				childCount++;
				continue;

			}

		}
		//Return array of humans
		return humans;
	}

	//Spawn a single zombie
	public Zombie spawnZombie()
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

		return monster;
	}

	//Spawn a specified number of zombies
	public Zombie[] spawnManyZombie(int amount)
	{
		Zombie[] monsters = new Zombie[amount];
		//For every zombie, pick between common infected or tank
		for (int i = 0; i < amount; i++)
		{
			monsters[i] = spawnZombie();
			String name = monsters[i].getName();
			switch(name){
			case("Common"):
				monsters[i].setName("" + name + " " + (commonCount + 1));
				commonCount++;
				continue;
			case("Tank"):
				monsters[i].setName("" + name + " " + (tankCount + 1));
				tankCount++;
				continue;
			}
		}
		//Return array of monsters
		return monsters;
	}
}

