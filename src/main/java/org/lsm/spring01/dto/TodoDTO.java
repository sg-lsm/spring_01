package org.lsm.spring01.dto;

import lombok.*;

import java.time.LocalDate;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
    private Long tno;
    private String title;
    private LocalDate localDate;
    private boolean finished;
    private String writer;
}
