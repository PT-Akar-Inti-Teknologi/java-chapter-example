package org.ait.project.aitboilerplate.modules.item.service.internal;

import lombok.RequiredArgsConstructor;
import org.ait.project.aitboilerplate.modules.customer.dto.request.CustomerRequest;
import org.ait.project.aitboilerplate.modules.customer.dto.response.CustomerResponse;
import org.ait.project.aitboilerplate.modules.customer.dto.transform.CustomerTransform;
import org.ait.project.aitboilerplate.modules.customer.exception.CustomerException;
import org.ait.project.aitboilerplate.modules.customer.model.jpa.entity.CustomerDetil;
import org.ait.project.aitboilerplate.modules.customer.model.jpa.repository.CustomerDetilRepository;
import org.ait.project.aitboilerplate.modules.item.dto.request.ItemRequest;
import org.ait.project.aitboilerplate.modules.item.dto.response.ItemResponse;
import org.ait.project.aitboilerplate.modules.item.dto.transform.ItemTransform;
import org.ait.project.aitboilerplate.modules.item.model.entity.Item;
import org.ait.project.aitboilerplate.modules.item.model.repository.ItemRepository;
import org.ait.project.aitboilerplate.modules.order.dto.response.OrdersResponse;
import org.ait.project.aitboilerplate.shared.constant.enums.ResponseEnum;
import org.ait.project.aitboilerplate.shared.dto.ResponseTemplate;
import org.ait.project.aitboilerplate.shared.utils.ResponseHelpers;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ResponseHelpers responseHelpers;
    private final ItemTransform itemTransform;

    @Transactional(readOnly = true)
    public ResponseEntity<ResponseTemplate<List<ItemResponse>>> getItemList() {
        return responseHelpers.createResponse(ResponseEnum.SUCCESS,
                itemTransform.toListResponse(itemRepository.findAll()));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ResponseTemplate<ItemResponse>> getItemWithId(Long id) {
        Optional<Item> customerOptional = itemRepository.findById(id);
        if (!customerOptional.isPresent()) {
            throw new CustomerException(ResponseEnum.CUSTOMER_NOT_FOUND, id);
        }
        return responseHelpers.createResponse(ResponseEnum.SUCCESS,
                itemTransform.toResponse(customerOptional.get()));
    }

    @Transactional
    public ResponseEntity<ResponseTemplate<ItemResponse>> addItem(ItemRequest itemRequest) {
        if(itemRepository.findByCode(itemRequest.getCode()).isPresent()){
            throw new CustomerException(ResponseEnum.PARAM_INVALID, itemRequest.getCode());
        }
        return responseHelpers.createResponse(ResponseEnum.SUCCESS,
                itemTransform.toResponse(itemRepository
                        .saveAndFlush(itemTransform.toEntity(itemRequest))));
    }
}
