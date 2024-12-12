package campus.u2.petpulse.Vista.MenuFunction;

import campus.u2.petpulse.Controlador.Users.VeterinarianControlador;
import campus.u2.petpulse.Clases.Users.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class VeterinarianMenu {

   private static final Scanner scanner = new Scanner(System.in);

    public static void menuVeterinarios(){
        while (true) {
            System.out.println("\n---- Menú de Veterinarios ----");
            System.out.println("1. Registrar Veterinario");
            System.out.println("2. Listar Veterinarios");
            System.out.println("3. Buscar Veterinario por ID");
            System.out.println("4. Buscar Veterinario por ID Card");
            System.out.println("5. Actualizar Veterinario por ID Card");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    registrarVeterinario();
                    break;
                case 2:
                    listarVeterinarios();
                    break;
                case 3:
                    buscarVeterinarioPorId();
                    break;
                case 4:
                    buscarVeterinarioPorIdCard();
                    break;
                case 5:
                    actualizarVeterinarioPorIdCard();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    public static void registrarVeterinario() {
        System.out.println("\n---- Registrar Veterinario ----");
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("ID Card: ");
        String idCard = scanner.nextLine();
        System.out.print("Dirección: ");
        String address = scanner.nextLine();
        System.out.print("Teléfono: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Fecha de contratación (YYYY-MM-DD): ");
        String hireDateStr = scanner.nextLine();
        LocalDate hireDate = LocalDate.parse(hireDateStr);
        System.out.print("Estado (true/false): ");
        boolean state = scanner.nextBoolean();
        System.out.print("ID de posición: ");
        int idPosition = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Usuario: ");
        String username = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();
        Veterinarian veterinarian = new VeterinarianBuilder()
                .setname(name)
                .setIdCard(idCard)
                .setAddress(address)
                .setPhoneNumber(phone)
                .setEmail(email)
                .setHireDate(hireDate)
                .setState(state)
                .setIdPosition(idPosition)
                .setPassword(username)
                .setPasswordU(password)
                .build();
        boolean result = VeterinarianControlador.insertVeterinarian(veterinarian);
        if (result) {
            System.out.println("Veterinario registrado exitosamente.");
        } else {
            System.out.println("Error al registrar al veterinario.");
        }
    }

    public static void listarVeterinarios() {
        try {
            List<Veterinarian> veterinarians = VeterinarianControlador.listVeterinarians();
            if (veterinarians.isEmpty()) {
                System.out.println("No hay veterinarios registrados.");
            } else {
                for (Veterinarian vet : veterinarians) {
                    System.out.println(vet);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al listar veterinarios: " + e.getMessage());
        }
    }

    public static void buscarVeterinarioPorId() {
        try {
            System.out.print("Ingrese el ID del Veterinario: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 
            Veterinarian vet = VeterinarianControlador.getVeterinarianById(id);
            if (vet != null) {
                System.out.println(vet);
            } else {
                System.out.println("Veterinario no encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar veterinario por ID: " + e.getMessage());
        }
    }

    public static void buscarVeterinarioPorIdCard() {
        try {
            System.out.print("Ingrese el ID Card del Veterinario: ");
            String idCard = scanner.nextLine();
            Veterinarian vet = VeterinarianControlador.getVeterinarianByIdCard(idCard);
            if (vet != null) {
                System.out.println(vet);
            } else {
                System.out.println("Veterinario no encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar veterinario por ID Card: " + e.getMessage());
        }
    }

    public static void actualizarVeterinarioPorIdCard() {
        try {
            System.out.print("Ingrese el ID Card del Veterinario: ");
            String idCard = scanner.nextLine();
            Veterinarian vet = VeterinarianControlador.getVeterinarianByIdCard(idCard);
            if (vet != null) {
                System.out.println("\nSeleccione el atributo a actualizar:");
                System.out.println("1. Nombre");
                System.out.println("2. Dirección");
                System.out.println("3. Teléfono");
                System.out.println("4. Email");
                System.out.println("5. Estado");
                System.out.println("6. ID de posición");
                System.out.print("Opción: ");
                int option = scanner.nextInt();
                scanner.nextLine(); 

                switch (option) {
                    case 1:
                        System.out.print("Nuevo nombre: ");
                        String name = scanner.nextLine();
                        vet.setName(name);
                        break;
                    case 2:
                        System.out.print("Nueva dirección: ");
                        String address = scanner.nextLine();
                        vet.setAddress(address);
                        break;
                    case 3:
                        System.out.print("Nuevo teléfono: ");
                        String phone = scanner.nextLine();
                        vet.setPhone_Number(phone);
                        break;
                    case 4:
                        System.out.print("Nuevo email: ");
                        String email = scanner.nextLine();
                        vet.setEmail(email);
                        break;
                    case 5:
                        System.out.print("Nuevo estado (true/false): ");
                        boolean state = scanner.nextBoolean();
                        vet.setState(state);
                        break;
                    case 6:
                        System.out.print("Nuevo ID de posición: ");
                        int idPosition = scanner.nextInt();
                        vet.setIdPosition(idPosition);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        return;
                }

                boolean result = VeterinarianControlador.updateVeterinarian(vet);
                if (result) {
                    System.out.println("Veterinario actualizado exitosamente.");
                } else {
                    System.out.println("Error al actualizar al veterinario.");
                }
            } else {
                System.out.println("Veterinario no encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar veterinario: " + e.getMessage());
        }
    }
}
