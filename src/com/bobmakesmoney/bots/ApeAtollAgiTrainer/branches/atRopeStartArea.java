package com.bobmakesmoney.bots.ApeAtollAgiTrainer.branches;

import com.bobmakesmoney.bots.ApeAtollAgiTrainer.atApeAtollCourse;
import com.bobmakesmoney.bots.ApeAtollAgiTrainer.leafs.DoNothing;
import com.bobmakesmoney.bots.ApeAtollAgiTrainer.leafs.clickRope;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class atRopeStartArea extends BranchTask {

    private clickRope clickrope = new clickRope();
    private DoNothing donothing = new DoNothing();

    private static final Coordinate topRight = new Coordinate(2750,2734,0);
    private static final Coordinate bottomLeft = new Coordinate(2747,2732,0);

    public static Area ropeStart = Area.rectangular(bottomLeft, topRight);

    public static GameObject rope = GameObjects.newQuery().names("Rope").actions("Swing").results().first();

    @Override
    public boolean validate() {

        if (ropeStart.contains(atApeAtollCourse.player) &&
                ((rope = GameObjects.newQuery().names("Rope").actions("Swing").results().first()) != null))
        {
            if (rope.isValid())
            {
                if (!rope.isVisible()) {
                    Camera.concurrentlyTurnTo(rope);
                }
                return true;
            } else return false;
        } else {
            return false;
        }

    }

    @Override
    public TreeTask failureTask() {
        return donothing;
    }

    @Override
    public TreeTask successTask() {
        return clickrope;
    }
}
