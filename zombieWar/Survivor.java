package zombieWar;

/**
 * @author Jarod Koenigsfeld
 */
public abstract class Survivor implements Character{
	int attack;
	int health;
	String name;

	public int getAttack(){
		return attack;
	}    

	public int getHealth(){
		return health;
	}

	public String getName() {
		return name;
	}

	public void setAttack(int newAttack){
		attack = newAttack;
	}

	public void setHealth(int newHealth){
		health = newHealth;        
	}
	
	public void setName(String newName) {
		name = newName;
	}

	public void damage(int damageDealt){
		health = health-damageDealt;
	}
	
}
