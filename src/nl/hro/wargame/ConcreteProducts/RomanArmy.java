package nl.hro.wargame.ConcreteProducts;

import nl.hro.wargame.AbstractFactories.ArmyFactory;
import nl.hro.wargame.AbstractProducts.Army;

public class RomanArmy extends Army {
    public RomanArmy(ArmyFactory factory) {
        super(factory);
    }
}
