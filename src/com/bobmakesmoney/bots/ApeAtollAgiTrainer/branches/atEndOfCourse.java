package com.bobmakesmoney.bots.ApeAtollAgiTrainer.branches;

import com.bobmakesmoney.bots.ApeAtollAgiTrainer.ApeAtollAgiTrainer;
import com.bobmakesmoney.bots.ApeAtollAgiTrainer.atApeAtollCourse;
import com.bobmakesmoney.bots.ApeAtollAgiTrainer.leafs.traverseToStart;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class atEndOfCourse extends BranchTask {

    private traverseToStart traversetostart = new traverseToStart();
    private atRopeStartArea atropestartarea = new atRopeStartArea();

    private Coordinate bottomLeft = new Coordinate(2770,2747,0);
    private Coordinate topRight = new Coordinate(2765,2740,0);

    private Area endOfCourseArea = Area.rectangular(bottomLeft,topRight);

    @Override
    public boolean validate() {
        if ((atApeAtollCourse.player != null) && endOfCourseArea.contains(atApeAtollCourse.player)) {
            System.out.println(ApeAtollAgiTrainer.runtimeStopwatch.getRuntimeAsString()+" Player is at end of course area");
            return true;
        } else {
            return false;
        }

    }

    @Override
    public TreeTask failureTask() {
        return atropestartarea;
    }

    @Override
    public TreeTask successTask() {
        return traversetostart;
    }
}

