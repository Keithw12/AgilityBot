package com.bobmakesmoney.bots.ApeAtollAgiTrainer.leafs;

import com.bobmakesmoney.bots.ApeAtollAgiTrainer.ApeAtollAgiTrainer;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 * NOTES:
 * click Tropic tree 2
 */
public class turnCameraToRope extends LeafTask {

    //private static LocatableEntityQueryResults<GameObject> ropeObjQuery = GameObjects.newQuery().names("Rope").actions("Swing").results();
    private static GameObject rope = GameObjects.newQuery().names("Rope").actions("Swing").results().first();

    @Override
    public void execute() {
        //if (ropeObjQuery)
        if (((rope = GameObjects.newQuery().names("Rope").actions("Swing").results().first()) != null) && !rope.isVisible()) {
            System.out.println(ApeAtollAgiTrainer.runtimeStopwatch.getRuntimeAsString()+" Turning camera to rope");
            Camera.turnTo(rope);
        } else if ((rope != null)) {
            System.out.println(ApeAtollAgiTrainer.runtimeStopwatch.getRuntimeAsString()+" Clicking rope");
            rope.click();
            Execution.delay(2000);
        }
    }
}
