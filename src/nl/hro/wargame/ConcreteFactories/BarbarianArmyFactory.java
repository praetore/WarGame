package nl.hro.wargame.ConcreteFactories;

import nl.hro.wargame.AbstractFactories.ArmyFactory;
import nl.hro.wargame.AbstractProducts.BarbarianUnit;
import nl.hro.wargame.AbstractProducts.Unit;
import nl.hro.wargame.ConcreteProducts.Berserker;
import nl.hro.wargame.ConcreteProducts.Druid;
import nl.hro.wargame.ConcreteProducts.WoadRaider;

import static nl.hro.wargame.Config.Consts.INVALID;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

public class BarbarianArmyFactory implements ArmyFactory {

    @Override
    public int trainUnit(int reservesLeft, List<Unit> units) {
        BufferedReader bufferedCharsIn = new BufferedReader( new InputStreamReader(System.in) );
        int amount = 0;
        int unitChoice = 0;
        BarbarianUnit unitType = null;

        String[] places = {"Gallia","Belgica", "Briton", "Dacia"};
        int pickPlace = new Random().nextInt(places.length);

        System.out.println("Welcome sir! we've got some new boys from " + pickPlace + " for ya! Might wanna check 'um out!");
        System.out.println("How many boys yu'd like to order? You currently have " + reservesLeft + " in reserves.");

        try {
            amount = Integer.parseInt(bufferedCharsIn.readLine());
        } catch (IOException e) {
            System.out.println(INVALID);
            trainUnit(reservesLeft, units);
        }

        System.out.println("What type a unit ya'd like to order?");
        System.out.println("[1] - Woad Raiders, a frontline unit. Pretty agressive lads.");
        System.out.println("[2] - Berserkers, did I say Woad Raiders are agressive? I meant these. Like... Holy Mother...");
        System.out.println("[3] - Druids, these guys can cast spells to damage entire groups or heal other men");

        try {
            unitChoice = Integer.parseInt(bufferedCharsIn.readLine());
        } catch (IOException e) {
            System.out.println(INVALID);
            trainUnit(reservesLeft, units);
        }

        if (unitChoice == 1) unitType = new WoadRaider();
        else if (unitChoice == 2) unitType = new Berserker();
        else if (unitChoice == 3) unitType = new Druid();
        else {
            System.out.println(INVALID);
            trainUnit(reservesLeft, units);
        }

        for (int i = 0; i < amount; i++) {
            units.add(unitType);
        }

        return amount;
    }
}
