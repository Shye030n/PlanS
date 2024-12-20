package org.sh.plans.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sh.plans.entity.Color;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MonthlyDTO {
    private Long id;
    private String title;
    private LocalDateTime createDate;
    private LocalDate eventDate;
    private Color color;
}
