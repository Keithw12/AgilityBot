package com.bobmakesmoney.bots.ApeAtollAgiTrainer;

import com.bobmakesmoney.bots.ApeAtollAgiTrainer.leafs.traverseToStart;
import com.runemate.game.api.client.ClientUI;
import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.local.hud.interfaces.Chatbox;
import com.runemate.game.api.script.framework.listeners.ChatboxListener;
import com.runemate.game.api.script.framework.listeners.events.MessageEvent;

import java.util.Objects;

public class myChatListener implements ChatboxListener {

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {

        if (messageEvent.getType() == Chatbox.Message.Type.SERVER)
        {
            System.out.println(messageEvent.getMessage());
            if (Objects.equals(messageEvent.getMessage(),"The nearby scout looks eager to talk to you.") ||
                    Objects.equals(messageEvent.getMessage(), "Talent scout: Come on, "+atApeAtollCourse.player.getName()+". I have a real opportunity for you!") ||
                    Objects.equals(messageEvent.getMessage(), "Looks like the nearby scout is trying to catch your attention."))
            {
                traverseToStart.trainerAvailable = true;
                ClientUI.sendTrayNotification("Agility Trainer is available.");
                Environment.getBot().stop("Agility Trainer is available!");
            }
        }
    }
}
