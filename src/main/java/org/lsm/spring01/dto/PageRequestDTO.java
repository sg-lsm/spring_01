package org.lsm.spring01.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PageRequestDTO {
    @Builder.Default
    @Min(value = 1)
    @Max(value = 100)
    private int page = 1;

    @Builder.Default
    @Min(value = 10)
    @Max(value = 20)
    private int size = 10;

    public int getSkip(){

        return (page -1 ) * 10;
    }
}
