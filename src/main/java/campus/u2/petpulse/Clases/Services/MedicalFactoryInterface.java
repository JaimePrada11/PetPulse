
package campus.u2.petpulse.Clases.Services;

import java.time.LocalDate;


public interface MedicalFactoryInterface {
    
    Consultation createConsultation(Integer IDService, String reason, String diagnosis, String recommendations, LocalDate consultationDate);
    Vaccination createVaccination(Integer idService, LocalDate applicationDate, LocalDate nextDoseDate);
    Procedure createProcedure(Integer ID_Service, TypeProcedure procedureTypes, String recoveryTime);
    PreOperatory createPreOperatory(Integer idService, Procedure procedure, String analysis, LocalDate estimatedTime);
    PostOperatory createPostOperatory(Integer idService, LocalDate nextControlAppointments, Procedure procedure, String recoveryStatus, String postOpCareInstructions);
    
}
