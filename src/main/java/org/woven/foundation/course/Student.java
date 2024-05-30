package org.woven.foundation.course;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

@Data
@AllArgsConstructor
@ToString
@Getter
public final class Student {

    private UUID id;
    private final String name;
    private final LocalDate birthDate;
    private final String subject;
    private final BigDecimal marks;
    private final String city;
    private final Gender gender;

    public int getAge() {
        LocalDate currentDate = LocalDate.now();

        Period between = Period.ZERO;
        if (birthDate.isBefore(currentDate)) {
            between = Period.between(birthDate, currentDate);
        }

        return between.getYears();
    }
}
