package kg.aika.demo.service;

import kg.aika.demo.enums.MessageType;
import kg.aika.demo.model.AuthenticationInfo;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NotificationConfigService {
    public static final Map<MessageType, AuthenticationInfo> AUTHENTICATION_STORAGE = Map.of(
            MessageType.REPEAT, new AuthenticationInfo("repeat bot", "AikaRepeatBot", "2127395532:AAHdBKrnItW_U-NEwlGUJ2oknnjWdWeDlOs"),
            MessageType.HELLO, new AuthenticationInfo("hello bot", "AikaHelloBot", "2114211208:AAEkKrYrAkKifqxt0t6NU3ArtuMIH3XPLho"),
            MessageType.CRAZY, new AuthenticationInfo("crazy bot", "AikaCrazyBot", "2120751992:AAHr6XHmjD2yYU3QQvUIMIYYDDzg4i3UUWk"),
            MessageType.LAZY, new AuthenticationInfo("lazy bot", "AikaLazyBot", "2111512070:AAHvlwbih3NbSXpuJ9L_vKHi6jXv7jDS_dw")
    );

    public AuthenticationInfo getNotificationConfig(MessageType messageType) {
        return AUTHENTICATION_STORAGE.get(messageType);
    }
}
