
package campus.u2.petpulse.Clases.Services;

import java.time.LocalDate;


public class MedicalFactory implements MedicalFactoryInterface {

    @Override
    public Consultation createConsultation(Integer IDService, String reason, String diagnosis, String recommendations, LocalDate consultationDate) {
        return new Consultation(IDService, reason, diagnosis, recommendations, consultationDate);
    }

    @Override
    public Vaccination createVaccination(Integer idService, LocalDate applicationDate, LocalDate nextDoseDate) {
        return new Vaccination(idService, applicationDate, nextDoseDate);
    }

    @Override
    public Procedure createProcedure(Integer ID_Service, TypeProcedure procedureTypes, String recoveryTime) {
        return new Procedure(ID_Service, procedureTypes, recoveryTime);
    }

    @Override
    public PreOperatory createPreOperatory(Integer idService, Procedure procedure, String analysis, LocalDate estimatedTime) {
        return new PreOperatory(idService, procedure, analysis, estimatedTime);
    }

    @Override
    public PostOperatory createPostOperatory(Integer idService, LocalDate nextControlAppointments, Procedure procedure, String recoveryStatus, String postOpCareInstructions) {
        return new PostOperatory(idService, nextControlAppointments, procedure, recoveryStatus, postOpCareInstructions);
    }


    
    
}
