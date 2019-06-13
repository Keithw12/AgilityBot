package com.bobmakesmoney.bots.ApeAtollAgiTrainer.branches;

import com.bobmakesmoney.bots.ApeAtollAgiTrainer.atApeAtollCourse;
import com.bobmakesmoney.bots.ApeAtollAgiTrainer.leafs.clickTree;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import java.util.Objects;

// import path.to.your.clickTree
// import path.to.your.atMonkeyBars

/**
 * NOTES:
 * start of tropic tree?
 */
public class atTropicTree extends BranchTask {

    private clickTree clicktree = new clickTree();
    private atMonkeyBars atmonkeybars = new atMonkeyBars();

    private Coordinate tropicTreeBegin = new Coordinate(2753,2742,0);



    public static GameObject tropicTree = GameObjects.newQuery().names("Tropical tree").actions("Climb").results().first();

    @Override
    public boolean validate() {
        //if (tropicTree == null) tropicTree = GameObjects.newQuery().names("Tropical tree").actions("Climb").results().first();

        if (Objects.equals(atApeAtollCourse.player.getPosition(),tropicTreeBegin) &&
                ((tropicTree = GameObjects.newQuery().names("Tropical tree").actions("Climb").results().first()) != null))
        {
            return tropicTree.isValid();
        } else return false;
    }

    @Override
    public TreeTask failureTask() {
        return atmonkeybars;
    }

    @Override
    public TreeTask successTask() {
        return clicktree;
    }
}
