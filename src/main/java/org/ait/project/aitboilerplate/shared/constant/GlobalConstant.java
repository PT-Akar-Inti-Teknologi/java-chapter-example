package org.ait.project.aitboilerplate.shared.constant;

public class GlobalConstant {
    /** Tag Authentication **/
    public static final String anyPath      = "/.*";
    public static final String tagHeader    = "header";
    public static final String tagToken     = "Bearer ";
    public static final String tagAuthHeader= "Authorization";
    public static final String tagGlobal    = "global";

    /** Security Configuration **/
    public static final String[] authWhitelist = new String[]{
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/swagger-ui",
            "/swagger-ui/**",
            "/v2/api-docs",
            "/v3/api-docs/**",
            "/webjars/**",
            "/actuator/**"};

    /** Documentation */
    public static final String documentationGroupCustomer   = "Customer";
    public static final String documentationPackageCustomer = "modules.customer.controller";
    public static final String documentationGroupItem       = "Item";
    public static final String documentationPackageItem     = "modules.item.controller";
    public static final String documentationGroupOrder      = "Order";
    public static final String documentationPackageOrder    = "modules.order.controller";

    /** Tag Documentation */
    /* Customer */
    public static final String documentationTagModuleCustomer = "Customer Module";
    public static final String documentationTagCreateCustomer = "Create Customer";
    public static final String documentationTagDataCustomer   = "List Data Customer";
    public static final String documentationTagDetilCustomer  = "Detil Customer";
    /* Item */
    public static final String documentationTagDataItem     = "List Data Item";
    public static final String documentationTagDetilItem    = "Detil Item";
    public static final String documentationTagCreateItem    = "Create Item";
    /* Customer */
    public static final String documentationTagModuleOrder = "Order Module";
    public static final String documentationTagCreateOrder = "Create Order";
    public static final String documentationTagDataOrder   = "List Data Order";
    public static final String documentationTagDetilOrder  = "Detil Order";
}
