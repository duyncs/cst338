package Monsters;

import Abilities.Attack;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public abstract class Monster {
    /**
     * @author Duy Nguyen
     * @since 04/07/2023
     * Title: Monsters.Monster.java
     * Description: This class defines the basic attributes
     * of a monster in a game
     */
    private Integer hp;
    private Integer xp = 10;
    private Integer maxHP;
    private HashMap<String, Integer> items = new HashMap<>();

    Integer agi = 10;
    Integer def = 10;
    Integer str = 10;
    Attack attack;

    public Monster(Integer maxHP, Integer xp, HashMap<String, Integer> items) {
        this.maxHP = maxHP;
        hp = this.maxHP;
        this.xp = xp;
        this.items = items;
        this.agi = agi;
        this.def = def;
        this.str = str;
    }

    // This method return an integer value between min and max.
    Integer getAttribute(Integer min, Integer max) {
        Random rand = new Random();
        if (min > max) {
            Integer temp = min;
            min = max;
            max = temp;
        }
        //returns a random number between min and max inclusive
        return rand.nextInt(max - min) + min;
    }

    public boolean takeDamage(Integer damage) {
        if (damage > 0) {
            hp -= damage;
            System.out.println("The creature was hit for " + damage + " damage.");
            if (hp <= 0) {
                System.out.println("Oh no! The creature has perished.");
                return false;
            }
            System.out.println(this.toString());
        }
        return true;
    }

    public Integer attackTarget(Monster target) {
        Integer damage = attack.attack(target);
        target.takeDamage(damage);
        return damage;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getXp() {
        return xp;
    }

    public Integer getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(Integer maxHP) {
        this.maxHP = maxHP;
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "hp=" + hp + "/" + maxHP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return hp.equals(monster.hp) && xp.equals(monster.xp) && maxHP.equals(monster.maxHP) && items.equals(monster.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hp, xp, maxHP, items);
    }

    public Integer getAgi() {
        return agi;
    }

    public Integer getDef() {
        return def;
    }

    public Integer getStr() {
        return str;
    }
}