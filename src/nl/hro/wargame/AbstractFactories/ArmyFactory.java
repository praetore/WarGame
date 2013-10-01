package nl.hro.wargame.AbstractFactories;

import nl.hro.wargame.AbstractProducts.Unit;

import java.util.List;

public interface ArmyFactory {
    public abstract int trainUnit(int reservesLeft, List<Unit> army);
}
