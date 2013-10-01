package nl.hro.wargame.AbstractProducts;

import nl.hro.wargame.AbstractStrategies.Strategy;
import nl.hro.wargame.ConcreteProducts.Player;

public abstract class Unit {
    protected String type;
    protected int attack;
    protected int defense;
    protected Weapon weapon;
    protected Training specialty;

    public abstract int fight(Strategy s, Player defender);
}
