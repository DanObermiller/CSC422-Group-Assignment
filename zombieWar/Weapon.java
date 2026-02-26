package zombieWar;

public abstract class Weapon {
	
	String name = "Weapon";
	int accuracy = 100;
	int damageBonus = 0;
	
	public String getName() {
		return this.name;
	}

}

class Axe extends Weapon{
	public Axe() {
		this.accuracy = 95;
		this.damageBonus = 1;
		this.name = "Axe";
	}
}

class Crowbar extends Weapon{
	public Crowbar() {
		this.accuracy = 100;
		this.damageBonus = 1;
		this.name = "Crowbar";
	}
}

class FryingPan extends Weapon{
	public FryingPan() {
		this.accuracy = 100;
		this.damageBonus = 1;
		this.name = "Frying Pan";
	}
}

class Pistol extends Weapon{
	public Pistol() {
		this.accuracy = 75;
		this.damageBonus = 5;
		this.name = "Pistol";
	}
}

class SMG extends Weapon{
	public SMG() {
		this.accuracy = 75;
		this.damageBonus = 5;
		this.name = "SMG";
	}
}

class AssaultRifle extends Weapon{
	public AssaultRifle() {
		this.accuracy = 75;
		this.damageBonus = 5;
		this.name = "Assault Rifle";
	}
}

class Shotgun extends Weapon{
	public Shotgun() {
		this.accuracy = 60;
		this.damageBonus = 30;
		this.name = "Shotgun";
	}
}

class SniperRifle extends Weapon{
	public SniperRifle() {
		this.accuracy = 100;
		this.damageBonus = 10;
		this.name = "Sniper Rifle";
	}
}
