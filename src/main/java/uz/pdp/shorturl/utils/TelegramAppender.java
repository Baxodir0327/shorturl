package uz.pdp.shorturl.utils;


import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TelegramAppender extends AppenderBase<LoggingEvent> {

    private final String chatID = "922386806";
    private final String token = "6751856631:AAHbbTz9fEn1RdyJCxH87Y_g0aKtwrJGmNs";
//    private final String token = "6032607553:AAG93Tcwe9I4x3J_H30i8bYHq9UfNzdpmVE";
    private final TelegramBot telegramBot = new TelegramBot(token);

    public TelegramAppender() {
        addFilter(new Filter<>() {
            @Override
            public FilterReply decide(LoggingEvent loggingEvent) {
                return loggingEvent.getLevel().equals(Level.ERROR) ? FilterReply.ACCEPT : FilterReply.DENY;
            }
        });
    }

    @Override
    protected void append(LoggingEvent loggingEvent) {
        SendMessage sendMessage = new SendMessage(chatID, loggingEvent.getFormattedMessage());
        sendMessage.parseMode(ParseMode.Markdown);
        telegramBot.execute(sendMessage);
    }
}