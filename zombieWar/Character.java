package zombieWar;

/**
 * Character.java - Interface for characters
 * @author Jarod Koenigsfeld
 */
public interface Character {
	public int getHealth();
	public int getAttack();
	public int getAccuracy();
	public String getWeapon();
	public String getName();
	public void setHealth(int newHealth);
	public void setAttack(int newAttack);
	public void setName(String newName);
	public void equipWeapon(Weapon w);
}
