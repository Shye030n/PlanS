//package org.sh.plans.service;
//
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.sh.plans.entity.Monthly;
//import org.sh.plans.repository.MonthlyRepository;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class MonthlyServiceImpl implements MonthlyService {
//    private final MonthlyRepository monthlyRepository;
//    @Override
//    public Monthly saveMonthly(Monthly monthly) {
//        monthly.setTitle(monthly.getTitle());
//        monthly.setCreateDate(LocalDateTime.now());
//        monthly.setEventDate(monthly.getEventDate());
//        monthly.setColor(monthly.getColor());
//        //저장된 먼슬리 반환
//        return monthlyRepository.save(monthly);
//    }
//}
package org.sh.plans.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.sh.plans.dto.MonthlyDTO;
import org.sh.plans.entity.Monthly;
import org.sh.plans.repository.MonthlyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class MonthlyServiceImpl implements MonthlyService {

    private final MonthlyRepository monthlyRepository;

    @Override
    public List<Monthly> getAllEvents() { //전체 조회
        return monthlyRepository.findAll();
    }

    @Override
    public Monthly addEvent(MonthlyDTO monthlyDTO) { //일정 추가
        Monthly monthly = new Monthly();
        monthly.setTitle(monthlyDTO.getTitle());
        monthly.setEventDate(monthlyDTO.getEventDate());
        monthly.setColor(monthlyDTO.getColor());
        
        log.info("에드이벤트 로그"+monthly);
        return monthlyRepository.save(monthly);
    }

    @Override
    public Monthly updateEvent(Long id, MonthlyDTO monthlyDTO) { //일정 수정
        Monthly monthly = monthlyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일정을 찾을 수 없습니다!"));
        monthly.setTitle(monthlyDTO.getTitle());
        monthly.setEventDate(monthlyDTO.getEventDate());
        monthly.setColor(monthlyDTO.getColor());
        return monthlyRepository.save(monthly);
    }

    @Override
    public void deleteEvent(Long id) { // 일정삭제
        monthlyRepository.deleteById(id);
    }
}
