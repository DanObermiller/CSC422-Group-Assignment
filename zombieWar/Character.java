package zombieWar;

/**
 * Character.java - Interface for characters
 * @author Jarod Koenigsfeld
 */
public interface Character {
	public boolean isAlive();
	public int getHealth();
	public int getAttack();
	public String getName();
	public void setHealth(int newHealth);
	public void setAttack(int newAttack);
	public void setName(String newName);
}
