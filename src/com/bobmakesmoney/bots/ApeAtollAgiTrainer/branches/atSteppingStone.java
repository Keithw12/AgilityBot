package com.bobmakesmoney.bots.ApeAtollAgiTrainer.branches;

import com.bobmakesmoney.bots.ApeAtollAgiTrainer.atApeAtollCourse;
import com.bobmakesmoney.bots.ApeAtollAgiTrainer.leafs.clickStone;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import java.util.Objects;

public class atSteppingStone extends BranchTask {

    private clickStone clickstone = new clickStone();
    private atTropicTree attropictree = new atTropicTree();

    private Coordinate topRight = new Coordinate(2757, 2746, 0);
    private Coordinate bottomLeft = new Coordinate(2756, 2742, 0);

    private Coordinate rockFailPosition = new Coordinate(2757, 2748, 0);

    public static GameObject steppingstone = GameObjects.newQuery().names("Stepping stone").actions("Jump-to").results().first();


    @Override
    public boolean validate() {




        if (atApeAtollCourse.player != null) {
            if ((Area.rectangular(bottomLeft, topRight).contains(atApeAtollCourse.player) || Objects.equals(atApeAtollCourse.player.getPosition(), rockFailPosition)) &&
                    ((steppingstone = GameObjects.newQuery().names("Stepping stone").actions("Jump-to").results().first()) != null)) {
                if (steppingstone.isValid()) {
                    if (!steppingstone.isVisible()) {
                        Camera.concurrentlyTurnTo(177, 0.419);
                    }
                    return true;
                } else return false;
            } else return false;
        } else return false;
    }

    @Override
    public TreeTask failureTask() {
        return attropictree;
    }

    @Override
    public TreeTask successTask() {
        return clickstone;
    }
}
