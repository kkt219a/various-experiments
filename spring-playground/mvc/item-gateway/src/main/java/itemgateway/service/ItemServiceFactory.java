package itemgateway.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import itemgateway.domain.ItemElementAdd;
import itemgateway.domain.ItemType;

@Component
public class ItemServiceFactory {
	private final Map<ItemType, ItemService> maps;
	
	public ItemServiceFactory(List<ItemService> factories) {
		this.maps = factories.stream()
							 .collect(
								 Collectors.toUnmodifiableMap(factory -> Objects.requireNonNull(factory.supportType()),
															  Function.identity()));
	}
	
	public void add(ItemElementAdd element) {
		ItemService itemService = maps.get(element.getType());
		itemService.add(element);
	}
}
