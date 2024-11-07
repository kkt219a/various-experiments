package itemgateway.domain;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class TicketItemElementAdd extends ItemElementAdd {
	private final Long ticketId;
	private final Integer quantity;
	private final List<Option> option;
	
	public TicketItemElementAdd(
		ItemType type,
		Integer price,
		Long ticketId,
		Integer quantity,
		List<Option> option
	) {
		super(type, price);
		this.ticketId = ticketId;
		this.quantity = quantity;
		this.option = option;
	}
	
	@Getter
	@ToString
	public static final class Option {
		private final Long id;
		private final String name;
		
		public Option(Long id, String name) {
			this.id = id;
			this.name = name;
		}
	}
}
