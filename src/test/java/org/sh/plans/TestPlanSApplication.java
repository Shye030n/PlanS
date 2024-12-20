package org.sh.plans;

import org.springframework.boot.SpringApplication;

public class TestPlanSApplication {

    public static void main(String[] args) {
        SpringApplication.from(PlanSApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
