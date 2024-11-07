package itemgateway.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Getter;
import lombok.ToString;

@Getter
@JsonTypeInfo(
	use = JsonTypeInfo.Id.NAME,
	include = JsonTypeInfo.As.EXISTING_PROPERTY,
	property = "type",
	visible = true
)
@JsonSubTypes({
	@JsonSubTypes.Type(value = AccommodationItemElementAdd.class, name = "ACCOMMODATION"),
	@JsonSubTypes.Type(value = TicketItemElementAdd.class, name = "TICKET")
})
@ToString
public abstract class ItemElementAdd {
	private final ItemType type;
	private final Integer price;
	
	protected ItemElementAdd(ItemType type, Integer price) {
		this.type = type;
		this.price = price;
	}
}
