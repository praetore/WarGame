package nl.hro.wargame.AbstractProducts;

import nl.hro.wargame.AbstractFactories.ArmyFactory;
import nl.hro.wargame.ConcreteProducts.Player;
import nl.hro.wargame.AbstractStrategies.Strategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Army {
    private List<Unit> unitComposition = new ArrayList<Unit>();
    private Strategy strategy;
    private ArmyFactory unitTrainer;
    private int reserves = 1000;

    public Army(ArmyFactory factory) {
        unitTrainer = factory;
    }

    public void attack(Player attacker, Player defender) {
        strategy = attacker.selectStrategy();
        int totalDamage = 0;

        Iterator it = unitComposition.iterator();
        while (it.hasNext()) {
            Unit unit = (Unit) it.next();
            totalDamage += unit.fight(strategy, defender);
        }

        attacker.addScore(totalDamage);
    }

    public void reinforce() {
        reserves -= unitTrainer.trainUnit(reserves, this.getUnitComposition());
    }

    public void train() {
        //To change body of created methods use File | Settings | File Templates.
    }

    public void supply() {
        //To change body of created methods use File | Settings | File Templates.
    }

    public int getUnitCount() {
        return unitComposition.size();
    }

    public int getReserveCount() {
        return reserves;
    }

    public List<Unit> getUnitComposition() {
        return unitComposition;
    }
}
