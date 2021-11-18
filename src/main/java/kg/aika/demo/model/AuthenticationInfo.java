package kg.aika.demo.model;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class AuthenticationInfo {
    String botName;
    String botUsername;
    String token;
}
