package zombieWar;
/**
 *
 * @author CSC Group 4 (In alphabetical order, Dan Obermiller, Jarod Koenigsfeld, Jordon Jagunich, Sam Hang)
 */

import java.util.Arrays;
import java.util.Random;

public class Game {
	public void startGame() {
		// Create a character spawner
		characterSpawner spawner = new characterSpawner();

		// Create random number generator
		Random rand = new Random();
		int randInt;

		// Randomly spawn between 5 - 20 humans
		randInt = rand.nextInt(16) + 5; // Generates a random number between 5 and 20
		if (randInt <= 0) {
			randInt = 5;
		}
		Survivor[] survivors = spawner.spawnManyHuman(randInt);

		// Randomly spawn between 5 - 20 zombies
		randInt = rand.nextInt(16) + 5; // Generates a random number between 5 and 20
		if (randInt <= 0) {
			randInt = 5;
		}
		Zombie[] zombies = spawner.spawnManyZombie(randInt);

		long tankCount = Arrays.stream(zombies).filter(Tank.class::isInstance).count();
		long commonCount = Arrays.stream(zombies).filter(CommonInfected.class::isInstance).count();
		long soldierCount = Arrays.stream(survivors).filter(Soldier.class::isInstance).count();
		long teacherCount = Arrays.stream(survivors).filter(Teacher.class::isInstance).count();
		long childCount = Arrays.stream(survivors).filter(Child.class::isInstance).count();

		// Announce the start of the game
		if(childCount == 1) {
			System.out.println("We have " + survivors.length + " survivors trying to make it to safety. ("+soldierCount+" Soldiers, "+ teacherCount+" Teachers, "+childCount+" Child)");
		} else {
		System.out.println("We have " + survivors.length + " survivors trying to make it to safety. ("+soldierCount+" Soldiers, "+ teacherCount+" Teachers, "+childCount+" Children)");
		}
		System.out.println("But there are " + zombies.length + " zombies waiting for them. ("+commonCount+" Common Infected, "+tankCount+ " Tanks) ");

		// Main game loop
		while (!isGameOver(survivors, zombies)) {
			combatRound(survivors, zombies);
		}

		// After the game ends, print how many survivors made it to safety
		int survivorsAlive = countAlive(survivors);
		if (survivorsAlive > 0) {
			System.out.println("It seems " + survivorsAlive + " have made it to safety.");
		} else {
			System.out.println("None of the survivors made it.");
		}

	}

	private void combatRound(Survivor[] survivor, Zombie[] zombie) {
		// Survivors attack zombies
		for (int i = 0; i < survivor.length; i++) {
			for (int j = 0; j < zombie.length; j++) {
				if (survivor[i].getHealth() > 0 && zombie[j].getHealth() > 0) {
					zombie[j].damage(survivor[i].getAttack());
					if(zombie[j].getHealth() <= 0) {
						System.out.println(survivor[i].getName() + " Killed "+zombie[j].getName());
					}
				}
			}
		}

		// Zombies attack survivors
		for (int j = 0; j < zombie.length; j++) {
			for (int i = 0; i < survivor.length; i++) {
				if (zombie[j].getHealth() > 0 && survivor[i].getHealth() > 0) {
					survivor[i].damage(zombie[j].getAttack());
					if(survivor[i].getHealth() <= 0) {
						System.out.println(zombie[j].getName() + " Killed "+survivor[i].getName());
					}
				}
			}
		}
	}

	// Check if the game is over (all survivors or all zombies are dead)
	private boolean isGameOver(Survivor[] survivors, Zombie[] zombies) {
		// Check if any survivors or zombies are still alive
		boolean survivorsAlive = false;
		boolean zombiesAlive = false;

		// Check if any survivors are alive
		for (Survivor s : survivors) {
			if (s.getHealth() > 0) {
				survivorsAlive = true;
				break;
			}
		}

		// Check if any zombies are alive
		for (Zombie z : zombies) {
			if (z.getHealth() > 0) {
				zombiesAlive = true;
				break;
			}
		}

		// Game over if both group are completely dead
		return !survivorsAlive || !zombiesAlive;
	}

	// Count the number of survivors and zombies alive
	private int countAlive(Character[] arr) {
		int aliveCount = 0;
		for (Character entity : arr) {
			if (entity.getHealth() > 0) {
				aliveCount++;
			}
		}
		return aliveCount;
	}
}
