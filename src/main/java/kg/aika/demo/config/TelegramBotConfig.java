package kg.aika.demo.config;

import kg.aika.demo.bot.TelegramBot;
import kg.aika.demo.enums.MessageType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class TelegramBotConfig {
    //other regular services also can inject bots like this and use it as in below bin definition.
    private final Set<TelegramBot> telegramBots;

    @Bean
    public Map<MessageType, TelegramBot> telegramBotMap() {
        return this.telegramBots.stream()
                .collect(Collectors.toMap(TelegramBot::getMessageType, x -> x));
    }
}
