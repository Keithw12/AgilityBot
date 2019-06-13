package com.bobmakesmoney.bots.ApeAtollAgiTrainer.leafs;

import com.bobmakesmoney.bots.ApeAtollAgiTrainer.ApeAtollAgiTrainer;
import com.bobmakesmoney.bots.ApeAtollAgiTrainer.atApeAtollCourse;
import com.bobmakesmoney.bots.ApeAtollAgiTrainer.branches.atTropicTree2;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 * NOTES:
 * click Tropic tree 2
 */
public class clickTropicTree2 extends LeafTask {


    @Override
    public void execute() {

        if (ApeAtollAgiTrainer.movingCheck) {
            if ((atApeAtollCourse.player = Players.getLocal()) != null) {
                if (atApeAtollCourse.player.isMoving()) {
                    return;
                }
            }
        }

        System.out.println(ApeAtollAgiTrainer.runtimeStopwatch.getRuntimeAsString()+" Clicking tropic tree 2");
        if (atTropicTree2.tropicTree2.interact("Climb-down"))
        {
            System.out.println(ApeAtollAgiTrainer.runtimeStopwatch.getRuntimeAsString()+" Clicked tropic tree 2");
            Execution.delay(4500);
        }
    }
}
