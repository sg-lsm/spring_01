package org.lsm.spring01.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Arrays;

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
    private String[] types;
    private String keyword;
    private boolean finished;
    private LocalDate from;
    private LocalDate to;

    public int getSkip(){

        return (page -1 ) * 10;
    }

    // 페이지 번호로 이동할 떄 size나 page 등을 같이 전달해줘야 조회 페이지에서 다시 리스트로 이동할 때 기존 페이지를 볼 수 있다.
    // 파라미터로 전달되는 PageRequestDTO는 Model로 자동 전송되기 때문에 별도의 처리가 필요없다.
    public String getLink(){

            StringBuilder builder = new StringBuilder();
            builder.append("page=" + this.page);
            builder.append("&size=" + this.size);
            if(finished){
                builder.append("&finished=on");
            }
            if(types != null && types.length > 0){
                for(int i=0; i<types.length; i++){
                    builder.append("&types=" + types[i]);
                }
            }

            if(keyword != null){
                try{
                    builder.append("&keyword=" + URLEncoder.encode(keyword, "UTF-8"));
                }catch (UnsupportedEncodingException e){
                    e.printStackTrace();
                }
            }

            if(from != null){
                builder.append("&from="+ from.toString());
            }
            if(to != null){
                builder.append("&to="+ to.toString());
            }

            return builder.toString();
    }

    public boolean checkType(String type){
        if(types == null || types.length == 0){
            return false;
        }
        return Arrays.stream(types).anyMatch(type::equals);
    }
}
