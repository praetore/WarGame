package nl.hro.wargame.ConcreteProducts;

import nl.hro.wargame.AbstractProducts.Army;
import nl.hro.wargame.AbstractStrategies.Strategy;
import nl.hro.wargame.ConcreteFactories.BarbarianArmyFactory;
import nl.hro.wargame.ConcreteFactories.EgyptianArmyFactory;
import nl.hro.wargame.ConcreteFactories.RomanArmyFactory;
import nl.hro.wargame.ConcreteStrategies.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static nl.hro.wargame.Config.Consts.INVALID;

public class Player {
    private Army playerArmy;
    private int score;

    public Player() {
        selectArmy();
    }


    public void selectArmy() {
        BufferedReader bufferedCharsIn = new BufferedReader( new InputStreamReader(System.in) );
        int armyChoice = 0;

        System.out.println("Sir! Who will we represent?");
        System.out.println("[1] - Rome\n[2] - Barbarians\n[3] - Egypt");

        try {
            armyChoice = Integer.parseInt(bufferedCharsIn.readLine());
        } catch (IOException e) {
            System.out.println(INVALID);
            selectArmy();
        }

        if (armyChoice == 1) playerArmy = new RomanArmy(new RomanArmyFactory());
        else if (armyChoice == 2) playerArmy = new BarbarianArmy(new BarbarianArmyFactory());
        else if (armyChoice == 3) playerArmy = new EgyptianArmy(new EgyptianArmyFactory());
        else {
            System.out.println(INVALID);
            selectArmy();
        }
    }

    public Strategy selectStrategy() {
        BufferedReader bufferedCharsIn = new BufferedReader( new InputStreamReader(System.in) );
        int strategyChoice = 0;
        Strategy strategy = null;

        System.out.println("Sir! How will we do battle?");
        System.out.println("[1] - Attack them head-on!");
        System.out.println("[2] - Let's set an ambush and wait...");
        System.out.println("[3] - Rain fire from above!");
        System.out.println("[4] - Maneuver to envelop their position!");

        try {
            strategyChoice = Integer.parseInt(bufferedCharsIn.readLine());
        } catch (IOException e) {
            System.out.println(INVALID);
            selectStrategy();
        }

        if (strategyChoice == 1) strategy = new HeadOn();
        else if (strategyChoice == 2) strategy = new Ambush();
        else if (strategyChoice == 3) strategy = new Fire();
        else if (strategyChoice == 4) strategy = new Surround();
        else {
            System.out.println(INVALID);
            selectStrategy();
        }

        return strategy;
    }

    public boolean isDefeated() {
        if (playerArmy.getUnitCount() + playerArmy.getReserveCount() == 0) return true;
        else return false;
    }

    public Army getArmy() {
        return playerArmy;
    }

    public void addScore(int damage) {
        score += damage;
    }

    public int getScore() {
        return score;
    }
}