package itemgateway.service;

import org.springframework.stereotype.Component;

import itemgateway.domain.ItemElementAdd;
import itemgateway.domain.ItemType;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AccommodationItemService extends ItemService {
	
	@Override
	void add(ItemElementAdd element) {
		log.info("{} 숙소가 추가되었습니다.", element);
	}
	
	@Override
	ItemType supportType() {
		return ItemType.ACCOMMODATION;
	}
}
