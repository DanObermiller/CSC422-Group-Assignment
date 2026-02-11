package zombieWar;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zombie[] array = new Zombie[20];
		ZombieFactory zf = new ZombieFactory();
		
		for(int i = 0; i < 19; i++) {
			
			array[i] = zf.build();
			System.out.println(array[i].getName());
			
		}
	}

}
