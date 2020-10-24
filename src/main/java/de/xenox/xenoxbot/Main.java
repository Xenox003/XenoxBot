package de.xenox.xenoxbot;

import de.xenox.xenoxbot.listener.JDAReadyEvent;
import de.xenox.xenoxbot.listener.MessageListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) {

    }

    public static void startJDA(String token) {
        try {
            JDA jda = JDABuilder.createDefault(token).build();
            //Presence
            jda.getPresence().setActivity(Activity.playing("@XenoxBot for help!"));
            //EventListeners
            jda.addEventListener(new MessageListener());
            jda.addEventListener(new JDAReadyEvent());
        }catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
