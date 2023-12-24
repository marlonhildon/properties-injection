package br.com.marlonhildon.propertiesinjection.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class OrderStatusDTO {

    private final String code;
    private final String message;

}
