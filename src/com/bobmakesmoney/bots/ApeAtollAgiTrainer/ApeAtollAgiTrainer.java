package com.bobmakesmoney.bots.ApeAtollAgiTrainer;

import com.bobmakesmoney.bots.ApeAtollAgiTrainer.leafs.traverseToStart;
import com.runemate.game.api.hybrid.input.Mouse;
import com.runemate.game.api.hybrid.util.StopWatch;
import com.runemate.game.api.script.framework.tree.TreeBot;
import com.runemate.game.api.script.framework.tree.TreeTask;


public class ApeAtollAgiTrainer extends TreeBot {


    private myChatListener listen = new myChatListener();
    public static boolean movingCheck = true;
    public static StopWatch runtimeStopwatch = new StopWatch();

    @Override
    public TreeTask createRootTask() {
        return new atApeAtollCourse();
    }

    public void onStart(java.lang.String... arguments) {
        Mouse.setPathGenerator(Mouse.MLP_PATH_GENERATOR);       //The RuneMate Dev Gods say this is best to use
        if (runtimeStopwatch == null) runtimeStopwatch = new StopWatch();
        runtimeStopwatch.start();
        setLoopDelay(700, 1200);

        System.out.println(runtimeStopwatch.getRuntimeAsString()+"Starting ChatBox Listener");
        getEventDispatcher().addListener(listen);
    }

    @Override
    public void onPause() {
        System.out.println(runtimeStopwatch.getRuntimeAsString()+" Paused");
        runtimeStopwatch.stop();
        traverseToStart.trainerAvailable = false;
    }

    @Override
    public void onResume() {
        System.out.println(runtimeStopwatch.getRuntimeAsString()+" Resumed");
        runtimeStopwatch.start();
    }

    @Override
    public void onStop() {
        System.out.println(runtimeStopwatch.getRuntimeAsString()+" Stopped");
        runtimeStopwatch.stop();
        runtimeStopwatch = null;
    }
}

