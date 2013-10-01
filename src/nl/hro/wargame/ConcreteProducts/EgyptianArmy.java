package nl.hro.wargame.ConcreteProducts;

import nl.hro.wargame.AbstractFactories.ArmyFactory;
import nl.hro.wargame.AbstractProducts.Army;

public class EgyptianArmy extends Army {
    public EgyptianArmy(ArmyFactory factory) {
        super(factory);
    }
}
