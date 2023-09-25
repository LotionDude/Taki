package lnd.lotan.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Range<T> {
    private T from;
    private T to;
}
