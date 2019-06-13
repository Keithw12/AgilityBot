
package com.bobmakesmoney.bots.ApeAtollAgiTrainer;

import com.bobmakesmoney.bots.ApeAtollAgiTrainer.branches.atSteppingStone;
import com.bobmakesmoney.bots.ApeAtollAgiTrainer.leafs.getToApeAtoll;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.hybrid.util.calculations.Distance;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

/**
 * NOTES:
 * Player is in the ape atoll course area?
 */
public class atApeAtollCourse extends BranchTask {

    private atSteppingStone atsteppingstone = new atSteppingStone();
    private getToApeAtoll gettoapeatoll = new getToApeAtoll();

    private Coordinate atApeAtoll = new Coordinate(2765,2745,0);

    public static Player player;

    @Override

    public boolean validate() {

        if (ApeAtollAgiTrainer.movingCheck) {
            if ((atApeAtollCourse.player = Players.getLocal()) != null) {
                    Execution.delayWhile(() -> !atApeAtollCourse.player.isMoving(), 150);
            }
        }

        if (((player = Players.getLocal()) != null) && (Distance.between(atApeAtoll, player) < 50)) {
            return true;
        } else
        {
            return true;   //fix check later
        }
    }

    @Override
    public TreeTask failureTask() {
        return gettoapeatoll;
    }

    @Override
    public TreeTask successTask() {
        return atsteppingstone;
    }

}