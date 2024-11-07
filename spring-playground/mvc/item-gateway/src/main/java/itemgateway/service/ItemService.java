package itemgateway.service;

import org.springframework.stereotype.Component;

import itemgateway.domain.ItemElementAdd;
import itemgateway.domain.ItemType;

@Component
public abstract class ItemService {
	abstract void add(ItemElementAdd element);
	abstract ItemType supportType();
}
