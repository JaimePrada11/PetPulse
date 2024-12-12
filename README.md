# Sistema de Gestión de Clínica Veterinaria 🐾

Este proyecto tiene como objetivo desarrollar un sistema que permita gestionar eficientemente las operaciones de una clínica veterinaria. El sistema está diseñado para manejar la información de las mascotas, sus dueños, historial de salud, inventario de medicamentos y vacunas, agenda de consultas y procedimientos médicos, así como la facturación y servicios adicionales.

## Funcionalidades

### 1. Gestión de Mascotas y Dueños
#### 1.1. Registro de Mascotas 🐶🐱
Cada mascota registrada en el sistema contará con la siguiente información:
- **Datos básicos**: Nombre, especie (perro, gato, ave, etc.), raza, edad, fecha de nacimiento (estimada si es desconocida), sexo (macho o hembra).
- **Información médica**: Historial de vacunas (nombre, lote, fecha de aplicación, próxima dosis), alergias conocidas y condiciones preexistentes (ej.: diabetes, epilepsia), peso y otras medidas relevantes según la especie, procedimientos realizados (esterilización, cirugía, limpieza dental, etc.).
- **Identificación única**: Microchip o tatuaje (si aplica), foto de la mascota para una identificación visual.

#### 1.2. Registro de Dueños 🧑👩
Cada dueño podrá registrar una o varias mascotas con:
- Nombre completo, identificación (cédula), dirección, teléfono y correo electrónico.
- Información de contacto de emergencia (opcional).
- Historial de visitas al centro veterinario.

#### 1.3. Relación Mascota-Dueño 🐾❤️🧑
El sistema garantiza que cada mascota esté asociada a un dueño registrado. Además, permite transferir la responsabilidad de la mascota a otro dueño en casos de adopción o venta.

### 2. Gestión de Salud y Vacunación 🩺💉
#### 2.1. Vacunación y Desparasitación 💊
El sistema permite:
- Registrar el historial completo de vacunas con tipo de vacuna, fabricante, lote y fecha de administración, fecha de vencimiento y recordatorio para la próxima dosis.
- Registrar tratamientos antiparasitarios internos y externos.
- Generar alertas automáticas para recordatorios de vacunas o desparasitaciones próximas.

#### 2.2. Consultas Médicas 📅
El sistema gestiona consultas médicas con:
- Fecha y hora de la consulta.
- Veterinario asignado.
- Motivo de la visita (chequeo general, consulta por enfermedad, etc.).
- Diagnóstico y recomendaciones.
- Prescripción de medicamentos o procedimientos requeridos.

#### 2.3. Cirugías y Procedimientos Especiales 🏥
Para cirugías u otros procedimientos médicos, se registra:
- Información preoperatoria: análisis requeridos, tiempo estimado.
- Detalle del procedimiento: tipo de cirugía, insumos utilizados, tiempo de recuperación.
- Seguimiento postoperatorio: citas de control, estado de recuperación.

### 3. Gestión de Inventarios y Medicamentos 🗃️💊
#### 3.1. Inventario de Insumos Médicos 📦
El sistema permite registrar y controlar:
- Medicamentos: Nombre, tipo (antibiótico, antiinflamatorio, antiparasitario, etc.), fabricante, cantidad en stock, fecha de vencimiento.
- Vacunas: Tipo, lote, fecha de ingreso, fecha de vencimiento.
- Material médico: Gasas, jeringas, vendas, etc.

#### 3.2. Alertas de Vencimiento ⏰
- Notificaciones automáticas para productos cercanos a su fecha de vencimiento.
- Restricción para usar medicamentos vencidos o sin stock disponible.

#### 3.3. Reabastecimiento 📥
- Generación de órdenes de compra automáticas según niveles mínimos de inventario.
- Registro de proveedores de insumos médicos.

### 4. Agenda de Servicios Veterinarios 📆
#### 4.1. Citas y Agenda Médica 🗓️
El sistema gestiona las citas médicas con:
- Fecha y hora.
- Mascota y dueño asignados.
- Motivo de la consulta.
- Estado de la cita: Programada, Completada, Cancelada.
