package itemgateway;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import itemgateway.domain.AccommodationItemElementAdd;
import itemgateway.domain.ItemAdd;
import itemgateway.domain.ItemElementAdd;
import itemgateway.domain.ItemType;
import itemgateway.domain.TicketItemElementAdd;
import itemgateway.service.ItemServiceFactory;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {
	private final ItemServiceFactory itemServiceFactory;
	
	@GetMapping
	public ResponseEntity<ItemAdd> get() {
		List<ItemElementAdd> elements = List.of(
			new AccommodationItemElementAdd(ItemType.ACCOMMODATION, 10_000, 5L,
											LocalDateTime.of(2024, 11, 9, 15, 0),
											LocalDateTime.of(2024, 11, 10, 11, 0)),
			new TicketItemElementAdd(ItemType.TICKET, 3_000, 2L, 3,
									 List.of(new TicketItemElementAdd.Option(53L, "프리미엄"))
									 ),
			new AccommodationItemElementAdd(ItemType.ACCOMMODATION, 50_000, 6L,
											LocalDateTime.of(2024, 11, 11, 16, 0),
											LocalDateTime.of(2024, 11, 12, 12, 0)),
			new TicketItemElementAdd(ItemType.TICKET, 5_000, 3L, 4,
									 List.of(new TicketItemElementAdd.Option(65L, "VIP"))
									 )
		);
		ItemAdd itemAdd = new ItemAdd("kkt219a", elements);
		return ResponseEntity.ok(itemAdd);
	}
	
	@PostMapping
	public ResponseEntity<Void> add(
		@RequestBody ItemAdd itemAdd
	) {
		for(ItemElementAdd element : itemAdd.elements()) {
			itemServiceFactory.add(element);
		}
		return ResponseEntity.ok()
							 .build();
	}
}
