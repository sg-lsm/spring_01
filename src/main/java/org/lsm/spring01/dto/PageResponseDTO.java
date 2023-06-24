package org.lsm.spring01.dto;

import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
public class PageResponseDTO<E> {
    private int page;
    private int size;
    private int total;

    private int start;
    private int end;

    private boolean prev;
    private boolean next;

    private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO dto, List<E> dtoList, int total){
        this.page = dto.getPage();
        this.size = dto.getSize();

        this.total = total;
        this.dtoList = dtoList;

        this.end = (int)(Math.ceil(this.page / 10.0)) * 10; // 현재 페이지를 10으로 나눈 값을 올림 후 10을 곱하여 (0.1->1) 끝 지점을 파악
        this.start = this.end - 9; // 10개씩 불러올 것이니 엔드지점부터 9개를 뺀 값을 시작점으로 삼는다.
        int last = (int)(Math.ceil(total / (double)size));
        this.end = end > last ? last : end;

        this.prev = this.start > 1;
        this.next = total > this.end * this.size;

    }

}
