package campus.u2.petpulse.Clases.Services;

import java.time.LocalDate;
import java.time.LocalTime;

public class SpecialFactory implements SpecialFacroryInterface {

    @Override
    public Training createTraining(Integer idService, String results, LocalTime durationSession, int totalSessions) {
        return new Training(idService, results, durationSession, totalSessions);
    }

    @Override
    public Baths createBaths(Integer idService, String haircutStyle, boolean nailTrimmingIncluded) {
        return new Baths(idService, haircutStyle, nailTrimmingIncluded);
    }

    @Override
    public DayCare createDayCare(Integer idService, String specialConditions, LocalDate startDate, LocalDate endDate) {
        return new DayCare(idService, specialConditions, startDate, endDate);
    }

}
