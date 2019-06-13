package com.bobmakesmoney.bots.ApeAtollAgiTrainer.branches;

import com.bobmakesmoney.bots.ApeAtollAgiTrainer.atApeAtollCourse;
import com.bobmakesmoney.bots.ApeAtollAgiTrainer.leafs.clickSkullSlope;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import java.util.Objects;

// import path.to.your.clickSkullSlope
// import path.to.your.atRope

/**
 * NOTES:
 * start of Skull slope?
 */
public class atSkullSlope extends BranchTask {

    private clickSkullSlope clickskullslope = new clickSkullSlope();
    private atRope atrope = new atRope();

    private Coordinate skullSlopeStart = new Coordinate(2747,2741,0);

    public static GameObject skullslope = GameObjects.newQuery().names("Skull slope").actions("Climb-up").results().first();

    @Override
    public boolean validate() {
        //if (skullslope == null) skullslope = GameObjects.newQuery().names("Skull slope").actions("Climb-up").results().first();

        if (Objects.equals(atApeAtollCourse.player.getPosition(), skullSlopeStart) &&
                ((skullslope = GameObjects.newQuery().names("Skull slope").actions("Climb-up").results().first()) != null))
        {
            return skullslope.isValid();
        } else return false;
    }

    @Override
    public TreeTask failureTask() {
        return atrope;
    }

    @Override
    public TreeTask successTask() {
        return clickskullslope;
    }
}
