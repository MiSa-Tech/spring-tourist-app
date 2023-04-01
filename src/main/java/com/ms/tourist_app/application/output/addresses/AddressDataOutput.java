package com.ms.tourist_app.application.output.addresses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDataOutput {
    private Long id;
    private Long createBy;
    private LocalDateTime createAt;
    private Long updateBy;
    private LocalDateTime updateAt;
    private String other;
    private Double longitude;
    private Double latitude;
    private String province;
    private String detailAddress;
}