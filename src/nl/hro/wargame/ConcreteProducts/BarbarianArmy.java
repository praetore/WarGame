package nl.hro.wargame.ConcreteProducts;

import nl.hro.wargame.AbstractFactories.ArmyFactory;
import nl.hro.wargame.AbstractProducts.Army;

public class BarbarianArmy extends Army {
    public BarbarianArmy(ArmyFactory factory) {
        super(factory);
    }
}
