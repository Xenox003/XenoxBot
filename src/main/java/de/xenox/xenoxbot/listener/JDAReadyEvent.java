package de.xenox.xenoxbot.listener;

import de.xenox.xenoxbot.Main;
import de.xenox.xenoxbot.manager.MySQLManager;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JDAReadyEvent extends ListenerAdapter {
    public void onReady(ReadyEvent event) {
        List<Guild> guilds = event.getJDA().getGuilds();
        for (int i = 0; i < guilds.size(); i++) {
            try {
                Guild guild = guilds.get(i);
                ResultSet rs = MySQLManager.onQuery("SELECT * FROM guilddata WHERE guildId = " + guild.getId());
                if (rs != null && rs.next()) {
                    //update existierenden Eintrag
                    MySQLManager.onCommand("");
                } else {
                    //neuer Eintrag
                    MySQLManager.onCommand("INSERT INTO guilddata(guildId, guildName, guildPrefix, guildPremiumStatus) " +
                            "VALUES(\"" + guild.getId() + "\", \"" + guild.getName() + "\"" +
                            "\"" + Main.defaultPrefix + "\", false)");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
