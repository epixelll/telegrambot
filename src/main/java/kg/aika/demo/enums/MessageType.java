package kg.aika.demo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MessageType {
    REPEAT,
    HELLO,
    CRAZY,
    LAZY;
}
