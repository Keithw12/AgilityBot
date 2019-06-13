package com.bobmakesmoney.bots.ApeAtollAgiTrainer.leafs;

import com.bobmakesmoney.bots.ApeAtollAgiTrainer.ApeAtollAgiTrainer;
import com.bobmakesmoney.bots.ApeAtollAgiTrainer.atApeAtollCourse;
import com.bobmakesmoney.bots.ApeAtollAgiTrainer.branches.atRopeStartArea;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 * NOTES:
 * click Rope
 */
public class clickRope extends LeafTask {

    @Override
    public void execute() {

        if (ApeAtollAgiTrainer.movingCheck) {
            if ((atApeAtollCourse.player = Players.getLocal()) != null) {
                if (atApeAtollCourse.player.isMoving()) {
                    return;
                }
            }
        }

        System.out.println(ApeAtollAgiTrainer.runtimeStopwatch.getRuntimeAsString()+" Clicking rope");
        if (atRopeStartArea.rope.interact("Swing"))
        {
            System.out.println(ApeAtollAgiTrainer.runtimeStopwatch.getRuntimeAsString()+" Clicked rope");
            Execution.delay(650);
        }

    }
}
