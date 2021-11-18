package kg.aika.demo.model;

import lombok.Data;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResult;

import java.util.List;

@Data
public class InlineQuerySend {
    private String inlineQueryId;
    private List<InlineQueryResult> inlineQueryResults;
    private Integer offset;
}
