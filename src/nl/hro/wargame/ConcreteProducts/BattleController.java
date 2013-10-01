package nl.hro.wargame.ConcreteProducts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static nl.hro.wargame.Config.Consts.INVALID;

public class BattleController {
    public boolean getDecisionInput(Player attacker, Player defender,  boolean turn) {
        BufferedReader bufferedCharsIn = new BufferedReader( new InputStreamReader(System.in) );
        int decision = 0;

        System.out.println("Sir! What should we do?");
        System.out.println("[1] - Attack\n[2] - Reinforce\n[3] - Train units\n[4] - Supply units");

        while (decision < 1 || decision > 5) {
            try {
                decision = Integer.parseInt(bufferedCharsIn.readLine());
            } catch (IOException e) {
                System.out.println(INVALID);
            }
        }

        if (decision == 1) attacker.getArmy().attack(attacker, defender);
        else if (decision == 2) attacker.getArmy().reinforce();
        else if (decision == 3) attacker.getArmy().train();
        else if (decision == 4) attacker.getArmy().supply();
        else {
            System.out.println(INVALID);
            getDecisionInput(attacker, defender, turn);
        }

        return !turn;
    }
}
