package de.xenox.xenoxbot.commands;

import de.xenox.xenoxbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class InfoCommand implements ServerCommand {

    @Override
    public void execute(Member member, TextChannel channel, Message msg) {
        System.out.println(msg.getContentRaw());
    }
}
