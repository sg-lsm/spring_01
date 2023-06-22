package org.lsm.spring01.dto;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Future;
import java.time.LocalDate;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
    private Long tno;
    @NotEmpty
    private String title;
    private LocalDate localDate;
    private boolean finished;
    @NotEmpty
    private String writer;
}
