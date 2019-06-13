package com.bobmakesmoney.bots.ApeAtollAgiTrainer.leafs;

import com.bobmakesmoney.bots.ApeAtollAgiTrainer.ApeAtollAgiTrainer;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.cognizant.RegionPath;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 * NOTES:
 * click Tropic tree 2
 */
public class traverseToStart extends LeafTask {

    private Coordinate bottomLeft = new Coordinate(2757,2745,0);
    private Coordinate topRight = new Coordinate(2756,2742,0);

    private Area startArea = Area.rectangular(bottomLeft,topRight);
    private Coordinate randCoord;

    public static boolean trainerAvailable = false;

    private RegionPath movePlayer;

    @Override
    public void execute() {
        if (((movePlayer = RegionPath.buildTo(randCoord = startArea.getRandomCoordinate())) != null) && !trainerAvailable)
        {
            trainerAvailable = false;
            if (movePlayer.step())
            {
                System.out.println(ApeAtollAgiTrainer.runtimeStopwatch.getRuntimeAsString()+" Moving to "+randCoord.toString()+" using RegionPath");
                Execution.delay(3500);
            }
        }
    }
}
