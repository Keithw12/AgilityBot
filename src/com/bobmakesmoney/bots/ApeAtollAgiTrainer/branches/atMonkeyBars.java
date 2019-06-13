package com.bobmakesmoney.bots.ApeAtollAgiTrainer.branches;

import com.bobmakesmoney.bots.ApeAtollAgiTrainer.atApeAtollCourse;
import com.bobmakesmoney.bots.ApeAtollAgiTrainer.leafs.clickBars;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import java.util.Objects;

// import path.to.your.clickBars
// import path.to.your.atSkullSlope

/**
 * NOTES:
 * start of Monkey Bars?
 */
public class atMonkeyBars extends BranchTask {

    private clickBars clickbars = new clickBars();
    private atSkullSlope atskullslope = new atSkullSlope();

    private Coordinate monkeyBarStart = new Coordinate(2753,2742,2);

    public static GameObject monkeybar = GameObjects.newQuery().names("Monkeybars").actions("Swing Across").results().nearest();

    @Override
    public boolean validate() {

        return Objects.equals(atApeAtollCourse.player.getPosition(), monkeyBarStart) && ((monkeybar = GameObjects.newQuery().names("Monkeybars").actions("Swing Across").results().nearest()) != null);
    }

    @Override
    public TreeTask failureTask() {
        return atskullslope;
    }

    @Override
    public TreeTask successTask() {
        return clickbars;
    }
}
