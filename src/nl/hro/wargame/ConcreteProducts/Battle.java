package nl.hro.wargame.ConcreteProducts;

import nl.hro.wargame.AbstractProducts.Ground;

public class Battle {
    boolean dayTime;
    Player attacker;
    Player defender;
    Ground terrain;
    BattleController controller;
    boolean turn;

    public Battle() {
        attacker = new Player();
        defender = new Player();
    }

    public void commence() {
        while ((!attacker.isDefeated()) && (!defender.isDefeated())) {
            if (turn) turn = controller.getDecisionInput(attacker, defender, turn);
            else turn = controller.getDecisionInput(defender, attacker, turn);
        }
    }
}
