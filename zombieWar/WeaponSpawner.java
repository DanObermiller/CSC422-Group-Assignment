package zombieWar;
import java.util.Random;


public class WeaponSpawner {
	Random rng = new Random();

	public Weapon spawnWeapon() {
		int toSpawn = rng.nextInt(8);
		Weapon newWeapon = null;

		switch(toSpawn) {
		case(0):
			newWeapon = new Axe();
		break;
		case(1):
			newWeapon = new Crowbar();
		break;
		case(2):
			newWeapon = new FryingPan();
		break;
		case(3):
			newWeapon = new Pistol();
		break;
		case(4):
			newWeapon = new SMG();
		break;
		case(5):
			newWeapon = new AssaultRifle();
		break;
		case(6):
			newWeapon = new Shotgun();
		break;
		case(7):
			newWeapon = new SniperRifle();
		break;
		}
		return newWeapon;
	}
	
	public Weapon[] spawnManyWeapons(int toSpawn) {
		Weapon[] weapons = new Weapon[toSpawn];
		for(int i = 0; i < toSpawn; i++) {
			weapons[i] = spawnWeapon();			
		}
		return weapons;
	}
}