
package campus.u2.petpulse.Clases.Services;

import java.time.LocalDate;
import java.time.LocalTime;


public interface SpecialFacroryInterface {
    Training createTraining(Integer idService, String results, LocalTime durationSession, int totalSessions);
    Baths createBaths(Integer idService, String haircutStyle, boolean nailTrimmingIncluded);
    DayCare createDayCare(Integer idService, String specialConditions, LocalDate startDate, LocalDate endDate);
}
