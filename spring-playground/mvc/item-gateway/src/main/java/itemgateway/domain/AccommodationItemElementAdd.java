package itemgateway.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class AccommodationItemElementAdd extends ItemElementAdd {
	private final Long accommodationId;
	private final LocalDateTime checkIn;
	private final LocalDateTime checkOut;
	
	public AccommodationItemElementAdd(
		ItemType type, Integer price, Long accommodationId, LocalDateTime checkIn, LocalDateTime checkOut
	) {
		super(type, price);
		this.accommodationId = accommodationId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
}
