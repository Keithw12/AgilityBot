package com.bobmakesmoney.bots.ApeAtollAgiTrainer.branches;

import com.bobmakesmoney.bots.ApeAtollAgiTrainer.atApeAtollCourse;
import com.bobmakesmoney.bots.ApeAtollAgiTrainer.leafs.turnCameraToRope;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import java.util.Objects;

// import path.to.your.clickRope
// import path.to.your.atTropicTree2

/**
 * NOTES:
 * start of Rope?
 */
public class atRope extends BranchTask {

    private turnCameraToRope traversetoropearea = new turnCameraToRope();
    private atTropicTree2 attropictree2 = new atTropicTree2();

    private Coordinate skullSlopeEnd = new Coordinate(2742,2741,0);

    @Override
    public boolean validate() {
        return Objects.equals(atApeAtollCourse.player.getPosition(), skullSlopeEnd);

    }

    @Override
    public TreeTask failureTask() {
        return attropictree2;
    }

    @Override
    public TreeTask successTask() {
        return traversetoropearea;
    }
}
