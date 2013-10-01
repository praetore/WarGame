package nl.hro.wargame.ConcreteFactories;

import nl.hro.wargame.AbstractFactories.ArmyFactory;
import nl.hro.wargame.AbstractProducts.Unit;

import java.util.List;

public class EgyptianArmyFactory implements ArmyFactory {
    @Override
    public int trainUnit(int reservesLeft, List<Unit> army) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
