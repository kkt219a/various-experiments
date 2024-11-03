package hello;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemCreatorFactory {
	private final List<ItemCreator<? extends ItemSelectContent>> creators;
	
	public ItemCreatorFactory() {
		this.creators = List.of(
			new ProductItemCreator(),
			new PackagingItemCreator()
		);
		Map<Long, String> map = new HashMap<>();
		map.remove(1L);
	}
	
	final List<Long> create() {
		for(ItemCreator<? extends ItemSelectContent> creator : creators) {
			List<? extends ItemSelectContent> itemSelectContents = List.of(new ProductItemSelectContent());
			
			creator.create(itemSelectContents);
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println();
	}
}

interface ItemCreator<T extends ItemSelectContent> {
	String create(List<T> itemSelectContent);
}

class ProductItemCreator implements ItemCreator<ProductItemSelectContent> {
	
	@Override
	public String create(List<ProductItemSelectContent> productItemSelectContent) {
		System.out.println("product");
		return "";
	}
}

class PackagingItemCreator implements ItemCreator<PackagingItemSelectContent> {
	
	@Override
	public String create(List<PackagingItemSelectContent> productItemSelectContent) {
		System.out.println("packaging");
		return "";
	}
}

abstract class ItemSelectContent {}
final class ProductItemSelectContent extends ItemSelectContent {}
class PackagingItemSelectContent extends ItemSelectContent {}
