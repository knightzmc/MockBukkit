package be.seeseemelk.mockbukkit.help;

import org.bukkit.help.HelpMap;
import org.bukkit.help.HelpTopic;
import org.bukkit.help.HelpTopicFactory;

import java.util.*;

public class HelpMapMock implements HelpMap {
    private Map<String, HelpTopic> topicMap = new HashMap<>();

    @Override
    public HelpTopic getHelpTopic(String topicName) {
        return topicMap.get(topicName);
    }

    @Override
    public Collection<HelpTopic> getHelpTopics() {
        return new ArrayList<>();
    }

    @Override
    public void addTopic(HelpTopic topic) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void registerHelpTopicFactory(Class<?> commandClass, HelpTopicFactory<?> factory) {

    }

    @Override
    public List<String> getIgnoredPlugins() {
        return new ArrayList<>();
    }
}
