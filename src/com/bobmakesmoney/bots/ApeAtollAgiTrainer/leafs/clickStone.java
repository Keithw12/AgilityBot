package com.bobmakesmoney.bots.ApeAtollAgiTrainer.leafs;

import com.bobmakesmoney.bots.ApeAtollAgiTrainer.ApeAtollAgiTrainer;
import com.bobmakesmoney.bots.ApeAtollAgiTrainer.atApeAtollCourse;
import com.bobmakesmoney.bots.ApeAtollAgiTrainer.branches.atSteppingStone;
import com.runemate.game.api.hybrid.local.hud.interfaces.InterfaceComponent;
import com.runemate.game.api.hybrid.local.hud.interfaces.Interfaces;
import com.runemate.game.api.hybrid.queries.results.InterfaceComponentQueryResults;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 * NOTES:
 * Click stepping stone
 */
public class clickStone extends LeafTask {

//    public static boolean lapJustCompleted = false;
//    public static boolean startedWatch = false;
//
//    StopWatch lapStopWatch = new StopWatch();

    private int iBackPack = 93782016;
    //private int bagOpen = 29943;
    //private int bagClosed = 29940;
    private InterfaceComponent backpackComponent;
    private InterfaceComponentQueryResults myBackPackResults = Interfaces.newQuery().names("Backpack").ids(iBackPack).results();

    @Override
    public void execute() {

//        if (!startedWatch) {
//            lapStopWatch.start();
//            startedWatch = true;
//        }
//        if (lapJustCompleted)
//        {
//            System.out.println("Lap completed in "+lapStopWatch.getRuntime(TimeUnit.SECONDS)+" seconds");
//            lapStopWatch.reset();
//            lapJustCompleted = false;
//        }

        if (ApeAtollAgiTrainer.movingCheck) {
            if ((atApeAtollCourse.player = Players.getLocal()) != null) {
                if (atApeAtollCourse.player.isMoving()) {
                    return;
                }
            }
        }

        System.out.println(ApeAtollAgiTrainer.runtimeStopwatch.getRuntimeAsString()+" Clicking stepping stone");
        if (atSteppingStone.steppingstone.interact("Jump-to"))
        {
            System.out.println(ApeAtollAgiTrainer.runtimeStopwatch.getRuntimeAsString()+" Clicked stepping stone");
            Execution.delay(1500);
        }
        else {
            if (!myBackPackResults.isEmpty())
            {
                backpackComponent = myBackPackResults.first();
                if (backpackComponent != null) {
                    if (backpackComponent.getSpriteId() == 29943) {
                        //backpackComponent.interact("Open Backpack")
                        backpackComponent.click();
                    }
                }
            } else {
                myBackPackResults = Interfaces.newQuery().names("Backpack").ids(iBackPack).results();
                System.out.println(ApeAtollAgiTrainer.runtimeStopwatch.getRuntimeAsString()+" myBackPackResults is empty.  Update backpack Query");
            }
        }
    }
}
