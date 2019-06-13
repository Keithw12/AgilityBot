package com.bobmakesmoney.bots.ApeAtollAgiTrainer.leafs;

import com.bobmakesmoney.bots.ApeAtollAgiTrainer.ApeAtollAgiTrainer;
import com.bobmakesmoney.bots.ApeAtollAgiTrainer.atApeAtollCourse;
import com.bobmakesmoney.bots.ApeAtollAgiTrainer.branches.atTropicTree;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 * NOTES:
 * click tropic tree
 */
public class clickTree extends LeafTask {

    @Override
    public void execute() {

        if (ApeAtollAgiTrainer.movingCheck) {
            if ((atApeAtollCourse.player = Players.getLocal()) != null) {
                if (atApeAtollCourse.player.isMoving()) {
                    return;
                }
            }
        }

        System.out.println(ApeAtollAgiTrainer.runtimeStopwatch.getRuntimeAsString()+" Clicking tropic tree 1");
        if (atTropicTree.tropicTree.interact("Climb"))
        {
            System.out.println(ApeAtollAgiTrainer.runtimeStopwatch.getRuntimeAsString()+" Clicked tropic tree 1");
            Execution.delay(2000);
        }
    }
}
