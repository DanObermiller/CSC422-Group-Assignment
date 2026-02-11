/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package zombieWar;

/**
 *
 * @author jarodK,samH,danO,jordonJ
 */
public interface Character {
	public int getHealth();
	public int getAttack();
	public String getName();
	public void setHealth(int newHealth);
	public void setAttack(int newAttack);
	public void setName(String newName);
}
