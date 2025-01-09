package org.sh.plans.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.sh.plans.dto.MonthlyDTO;
import org.sh.plans.entity.Monthly;
import org.sh.plans.service.MonthlyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/monthly")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class MonthlyController {

    private final MonthlyService monthlyService;

    // 전체 일정 조회
    @GetMapping
    public List<Monthly> getAllEvents() {
        return monthlyService.getAllEvents();
    }

    // 일정 추가
    @PostMapping
    public Monthly addEvent(@RequestBody MonthlyDTO monthlyDTO) {
        log.info("~~~~~~"+monthlyDTO);
        return monthlyService.addEvent(monthlyDTO);
    }

    // 일정 수정
    @PutMapping("/{id}")
    public Monthly updateEvent(@PathVariable Long id, @RequestBody MonthlyDTO monthlyDTO) {
        return monthlyService.updateEvent(id, monthlyDTO);
    }

    // 일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        monthlyService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}
