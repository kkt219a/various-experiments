package itemgateway.service;

import org.springframework.stereotype.Component;

import itemgateway.domain.ItemElementAdd;
import itemgateway.domain.ItemType;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TicketItemService extends ItemService {
	
	@Override
	void add(ItemElementAdd elementAdd) {
		log.info("{} 티켓이 추가되었습니다.", elementAdd);
	}
	
	@Override
	ItemType supportType() {
		return ItemType.TICKET;
	}
}
