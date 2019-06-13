package com.bobmakesmoney.bots.ApeAtollAgiTrainer.branches;

import com.bobmakesmoney.bots.ApeAtollAgiTrainer.atApeAtollCourse;
import com.bobmakesmoney.bots.ApeAtollAgiTrainer.leafs.clickTropicTree2;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

//import com.bobmakesmoney.bots.ApeAtollAgiTrainer.branches.atEndOfCourse;

// import path.to.your.clickTropicTree2

/**
 * NOTES:
 * start of TropicTree2?
 */
public class atTropicTree2 extends BranchTask {

    private clickTropicTree2 clicktropictree2 = new clickTropicTree2();
    private atEndOfCourse atendofcourse = new atEndOfCourse();

    private Coordinate bottomLeft = new Coordinate(2756,2729,0);
    private Coordinate topRight = new Coordinate(2760,2737,0);

    private Area tropicTree2Area = Area.rectangular(bottomLeft, topRight);

    public static GameObject tropicTree2 = GameObjects.newQuery().names("Tropical tree").actions("Climb-down").results().first();

    @Override
    public boolean validate() {

        if (tropicTree2Area.contains(atApeAtollCourse.player) &&
                ((tropicTree2 = GameObjects.newQuery().names("Tropical tree").actions("Climb-down").results().first()) != null))
        {
            return tropicTree2.isValid();
        } else return false;
    }

    @Override
    public TreeTask failureTask() { return atendofcourse; }

    @Override
    public TreeTask successTask() {
        return clicktropictree2;
    }
}
