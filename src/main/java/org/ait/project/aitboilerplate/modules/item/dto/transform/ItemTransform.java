package org.ait.project.aitboilerplate.modules.item.dto.transform;

import org.ait.project.aitboilerplate.modules.item.dto.request.ItemRequest;
import org.ait.project.aitboilerplate.modules.item.dto.response.ItemResponse;
import org.ait.project.aitboilerplate.modules.item.model.entity.Item;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemTransform {

    @Named("toItemResponse")
    ItemResponse toResponse(Item data);

    @Named("toItemListResponse")
    @IterableMapping(qualifiedByName = "toItemResponse")
    List<ItemResponse> toListResponse(List<Item> data);

    @Named("toEntity")
    @Mapping(target = "code", source = "data.code")
    @Mapping(target = "name", source = "data.name")
    @Mapping(target = "price", source = "data.price")
    @Mapping(target = "stock", source = "data.stock")
    Item toEntity(ItemRequest data);
}
