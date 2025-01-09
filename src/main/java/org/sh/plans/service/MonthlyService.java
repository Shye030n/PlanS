//package org.sh.plans.service;
//
//import org.sh.plans.entity.Monthly;
//
//public interface MonthlyService {
//    Monthly saveMonthly(Monthly monthly);
//}
package org.sh.plans.service;

import org.sh.plans.dto.MonthlyDTO;
import org.sh.plans.entity.Monthly;

import java.util.List;

public interface MonthlyService {
    List<Monthly> getAllEvents(); //전체 조회
    Monthly addEvent(MonthlyDTO monthlyDTO);//일정 추가
    Monthly updateEvent(Long id, MonthlyDTO monthlyDTO); //일정 수정
    void deleteEvent(Long id); //일정 삭제
}
