package com.bobmakesmoney.bots.ApeAtollAgiTrainer.leafs;

import com.bobmakesmoney.bots.ApeAtollAgiTrainer.ApeAtollAgiTrainer;
import com.bobmakesmoney.bots.ApeAtollAgiTrainer.atApeAtollCourse;
import com.bobmakesmoney.bots.ApeAtollAgiTrainer.branches.atMonkeyBars;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 * NOTES:
 * click Monkey Bars
 */
public class clickBars extends LeafTask {

    @Override
    public void execute() {

        if (ApeAtollAgiTrainer.movingCheck) {
            if ((atApeAtollCourse.player = Players.getLocal()) != null) {
                if (atApeAtollCourse.player.isMoving()) {
                    return;
                }
            }
        }

        System.out.println(ApeAtollAgiTrainer.runtimeStopwatch.getRuntimeAsString()+" Clicking monkey bars");
        if (atMonkeyBars.monkeybar.interact("Swing Across"))
        {
            System.out.println(ApeAtollAgiTrainer.runtimeStopwatch.getRuntimeAsString()+" Clicked monkey bars");
            Execution.delay(4000);
        }

    }
}
