package org.ait.project.aitboilerplate.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplate<T> {

    @JsonProperty("response_code")
    private String responseCode;

    @JsonProperty("response_txt")
    private String responseText;

    @JsonProperty("data")
    private T data;
}
