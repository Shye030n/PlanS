package org.sh.plans.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "monthly")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Monthly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName = "id", updatable = false)
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(name = "create_Date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;

    @Enumerated(EnumType.STRING)
    @Column(name="color", nullable = true)
    private Color color;



}
