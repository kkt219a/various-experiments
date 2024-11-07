package itemgateway.domain;

import java.util.List;

public record ItemAdd(String userId, List<ItemElementAdd> elements) {

}
