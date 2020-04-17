package be.seeseemelk.mockbukkit.help;

import org.bukkit.command.CommandSender;
import org.bukkit.help.HelpTopic;

public class HelpTopicMock extends HelpTopic {

    @Override
    public boolean canSee(CommandSender player) {
        return true;
    }
}
