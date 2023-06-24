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

    private String link;

    public int getSkip(){

        return (page -1 ) * 10;
    }

    // 페이지 번호로 이동할 떄 size나 page 등을 같이 전달해줘야 조회 페이지에서 다시 리스트로 이동할 때 기존 페이지를 볼 수 있다.
    // 파라미터로 전달되는 PageRequestDTO는 Model로 자동 전송되기 때문에 별도의 처리가 필요없다.
    public String getLink(){
        if(link == null){
            StringBuilder builder = new StringBuilder();
            builder.append("page=" + this.page);
            builder.append("&size=" + this.size);
            link = builder.toString();
        }
        return link;
    }
}
