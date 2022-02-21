package org.ait.project.aitboilerplate.modules.customer.dto.transform;

import org.ait.project.aitboilerplate.modules.customer.dto.request.CustomerRequest;
import org.ait.project.aitboilerplate.modules.customer.dto.response.CustomerResponse;
import org.ait.project.aitboilerplate.modules.customer.model.jpa.entity.CustomerDetil;
import org.ait.project.aitboilerplate.shared.dto.transform.GeneralTransform;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = GeneralTransform.class)
public interface CustomerTransform {

    @Named("toCustomerResponse")
    @Mapping(target = "username", source = "data.customer.username")
    @Mapping(target = "password", ignore = true)
    CustomerResponse toResponse(CustomerDetil data);

    @Named("toCustomerListResponse")
    @IterableMapping(qualifiedByName = "toCustomerResponse")
    List<CustomerResponse> toListResponse(List<CustomerDetil> data);

    @Named("toEntity")
    @Mapping(target = "customer.username", source = "data.username")
    @Mapping(target = "customer.password", source = "data.password", qualifiedByName = "passwordEncoder")
    @Mapping(target = "email", source = "data.email")
    @Mapping(target = "name", source = "data.name")
    @Mapping(target = "address", source = "data.address")
    @Mapping(target = "balance", constant = "0")
    CustomerDetil toEntity(CustomerRequest data);
}
