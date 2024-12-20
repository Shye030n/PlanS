package org.sh.plans.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoListDTO {
    private Long id;
    private String title;
    private LocalDateTime createTime;
    private LocalDate donTime;
    private boolean isDone;

    private UserDTO userDTO;
}
