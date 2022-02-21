package org.ait.project.aitboilerplate.modules.item.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.ait.project.aitboilerplate.modules.customer.dto.request.CustomerRequest;
import org.ait.project.aitboilerplate.modules.customer.dto.response.CustomerResponse;
import org.ait.project.aitboilerplate.modules.customer.service.internal.CustomerService;
import org.ait.project.aitboilerplate.modules.item.dto.request.ItemRequest;
import org.ait.project.aitboilerplate.modules.item.dto.response.ItemResponse;
import org.ait.project.aitboilerplate.modules.item.service.internal.ItemService;
import org.ait.project.aitboilerplate.modules.order.dto.request.OrdersRequest;
import org.ait.project.aitboilerplate.modules.order.dto.response.OrdersResponse;
import org.ait.project.aitboilerplate.shared.constant.GlobalConstant;
import org.ait.project.aitboilerplate.shared.dto.ResponseTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/items")
@Api(tags = GlobalConstant.documentationGroupItem)
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = GlobalConstant.documentationTagDataItem)
    public ResponseEntity<ResponseTemplate<List<ItemResponse>>> getItemList(){
        return itemService.getItemList();
    }

    @GetMapping(value = "/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = GlobalConstant.documentationTagDetilItem)
    public ResponseEntity<ResponseTemplate<ItemResponse>> getItemWithId(@PathVariable Long id){
        return itemService.getItemWithId(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = GlobalConstant.documentationTagCreateItem)
    public ResponseEntity<ResponseTemplate<ItemResponse>> addItem(@Valid @RequestBody ItemRequest itemRequest){
        return itemService.addItem(itemRequest);
    }
}
