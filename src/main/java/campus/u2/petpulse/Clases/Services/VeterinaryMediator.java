package campus.u2.petpulse.Clases.Services;

import campus.u2.petpulse.Clases.Appointments.Appointment;
import campus.u2.petpulse.Clases.Users.Veterinarian;
import campus.u2.petpulse.Clases.Products.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VeterinaryMediator {

    private List<Appointment> appointments;
    private Map<Service, List<Product>> productsService;
    private Map<Appointment, Map<Service, Veterinarian>> employeeService;

    public VeterinaryMediator() {
        this.appointments = new ArrayList<>();
        this.productsService = new HashMap<>();
        this.employeeService = new HashMap<>();
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
        employeeService.put(appointment, new HashMap<>());
    }

    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
        employeeService.remove(appointment);
    }

    public Veterinarian getEmployeeService(Appointment appointment, Service service) {
        if (!employeeService.containsKey(appointment)) {
            throw new IllegalArgumentException("La cita no existe en el sistema.");
        }
        if (!employeeService.get(appointment).containsKey(service)) {
            throw new IllegalArgumentException("El servicio no está asignado a la cita.");
        }
        return employeeService.get(appointment).get(service);
    }

    public void addServiceAppointment(Appointment appointment, Service service) {
        appointment.addService(service);
    }

    public void removeServiceFromAppointment(Appointment appointment, Service service) {
        
        if (employeeService.containsKey(appointment) && employeeService.get(appointment).containsKey(service)) {
            employeeService.get(appointment).remove(service);
        }
    }

    public void addProductService(Service service, Product product) {
        productsService.computeIfAbsent(service, k -> new ArrayList<>()).add(product);
    }

    public List<Appointment> getAppointment() {
        return appointments;
    }

}
