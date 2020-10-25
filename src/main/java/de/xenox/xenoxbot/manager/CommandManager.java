package de.xenox.xenoxbot.manager;

import de.xenox.xenoxbot.commands.InfoCommand;
import de.xenox.xenoxbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.ConcurrentHashMap;

public class CommandManager {
    public ConcurrentHashMap<String, ServerCommand> commands;

    public CommandManager() {
        this.commands = new ConcurrentHashMap<>();

        commands.put("info",new InfoCommand());
        commands.put("<@650445702240927755>",new InfoCommand());
    }

    public boolean perform(String command, Member member, TextChannel channel, Message msg){
        ServerCommand cmd;
        if ((cmd = this.commands.get(command.toLowerCase())) != null) {
            cmd.execute(member,channel,msg);
            return true;
        }

        return false;
    }
}
