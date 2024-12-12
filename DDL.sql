CREATE DATABASE IF NOT EXISTS PetPulse;

USE PetPulse;
CREATE TABLE IF NOT EXISTS Emergency_Contacts(
    ID_Emergency_Contact INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) ,
    Phone_Number VARCHAR(150) NOT NULL,
    ID_Card VARCHAR(100),         
    Address VARCHAR(100),         
    Email VARCHAR(100)           
);

INSERT INTO Emergency_Contacts (Name, Phone_Number, ID_Card, Address, Email)
VALUES
('Jane Doe', '987-654-3210', '987654321', '456 Elm St', 'janedoe@example.com'),
('John Smith', '123-456-7890', '123456789', '123 Main St', 'johnsmith@example.com'),
('Emily Johnson', '555-555-5555', '555555555', '789 Oak St', 'emilyjohnson@example.com');


CREATE TABLE IF NOT EXISTS Subscriptions(
    ID_Subscription INT PRIMARY KEY AUTO_INCREMENT,
    Subscription_Type VARCHAR(100),
    Price DECIMAL(10,2)
);
  INSERT INTO Subscriptions (Subscription_Type, Price)
VALUES
('Basic', 9.99),
('Premium', 19.99),
('VIP', 49.99);

CREATE TABLE IF NOT EXISTS Owners(
    ID_Owner INT PRIMARY KEY AUTO_INCREMENT,
   
    Name VARCHAR(100) ,
    ID_Card VARCHAR(100) NOT NULL UNIQUE,
    Address VARCHAR(100) ,
    Phone_Number VARCHAR(100) ,
    Email VARCHAR(100) ,
    ID_Emergency_Contact INT ,
    Subscription_ID INT,
    Loyalty_Points INT ,

    FOREIGN KEY (ID_Emergency_Contact) REFERENCES Emergency_Contacts(ID_Emergency_Contact),
    FOREIGN KEY (Subscription_ID) REFERENCES Subscriptions(ID_Subscription)
);
INSERT INTO Owners (Name, ID_Card, Address, Phone_Number, Email, ID_Emergency_Contact)
VALUES
('John Doe', '123456789', '123 Main St', '123-456-7890', 'johndoeample.com', 1),
('Jane Smith', '987654321', '456 Elm St', '987-654-3210', '@example.com', 2),
('Michael Johnson', '555555555', '789 Oak St', '555-555-5555', '@example.com', 3);





CREATE TABLE IF NOT EXISTS Species (
    ID_Species INT PRIMARY KEY AUTO_INCREMENT,
    SpeciesName VARCHAR(100) NOT NULL UNIQUE
);




INSERT INTO Species (SpeciesName) VALUES ('Mammal');
INSERT INTO Species (SpeciesName) VALUES ('Reptile');
INSERT INTO Species (SpeciesName) VALUES ('Bird');


CREATE TABLE IF NOT EXISTS Pets(
	ID_Pet INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    Birthdate DATE NOT NULL,
    Age INT NOT NULL,
    Sex VARCHAR(250)  NOT NULL,
    Photo VARCHAR(250) NOT NULL,
    Allergies VARCHAR(100),
    PreExistingConditions VARCHAR(100) NOT NULL,
    Available BOOLEAN NOT NULL,
    ID_Owner INT NULL,
     ID_Species INT,
     weight float,
     foreign key (ID_Species) references Species(ID_Species),
	FOREIGN KEY (ID_Owner) REFERENCES Owners(ID_Owner)
);

INSERT INTO Pets (Name, Birthdate, Age, Sex, Photo, Allergies, PreExistingConditions, Available, ID_Owner, ID_Species)
VALUES
('Buddy', '2022-01-01', 2, 'Male', 'buddy.jpg', 'Pollen', 'None', TRUE, NULL, 1),
('Bella', '2021-05-15', 3, 'Female', 'bella.jpg', 'Dust mites', 'Heartworm', TRUE, NULL, 2),
('Max', '2020-10-20', 4, 'Male', 'max.jpg', 'None', 'Arthritis', TRUE, NULL, 2),
('Coco', '2023-03-08', 1, 'Female', 'coco.jpg', 'Grass', 'None', TRUE, NULL, 3),
('Charlie', '2022-07-12', 2, 'Male', 'charlie.jpg', 'None', 'Kidney Disease', TRUE, NULL, 2);



CREATE TABLE IF NOT EXISTS SubCategory (
    ID_SubCategory INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL
);

INSERT INTO SubCategory (Name)
VALUES
('Species'),
('Variant'),
('Animal Type'),
('Sub Species'),
('Breed');

select * From SubCategory;


CREATE TABLE IF NOT EXISTS Attributes(
	ID_Attribute INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    ID_SubCategory INT NOT NULL,
    FOREIGN KEY (ID_SubCategory) REFERENCES SubCategory(ID_SubCategory)
);

INSERT INTO Attributes (Name, ID_SubCategory)
VALUES
    ('Mammal', 1),
    ('Bird', 1),
    ('Reptile', 1),
    ('Dog', 3),
    ('Cat', 3),
    ('Horse', 3),
    ('Guinea Pig', 3),
    ('Iguana', 4),
    ('Snake', 4),
    ('Guacamaya', 2),
    ('Parrot', 2),
    ('Beagle', 5),
    ('Golden Retriever', 5),
    ('Labrador Retriever', 5),
    ('German Shepherd', 5),
    ('Chihuahua', 5),
    ('Dalmatian', 5),
    ('Persian', 5),
    ('Siamese', 5),
    ('Maine Coon', 5),
    ('Arabian Horse', 5),
    ('Thoroughbred Horse', 5),
    ('Quarter Horse', 5),
    ('Other', 1);

CREATE TABLE IF NOT EXISTS PetsAttributes(
	ID_Attribute INT NOT NULL,
    ID_Pet INT ,
    PRIMARY KEY(ID_Attribute, ID_Pet),
	FOREIGN KEY (ID_Pet) REFERENCES Pets(ID_Pet),
    FOREIGN KEY (ID_Attribute) REFERENCES Attributes(ID_Attribute)
);

CREATE TABLE IF NOT EXISTS TransferPet(
	ID_Pet INT NOT NULL,
    ID_Owner INT NOT NULL,
    PRIMARY KEY(ID_Pet, ID_Owner),
    AssignmentDate DATE ,
    TransferType ENUM("Adoption", "Sale"),
    Cost DECIMAL(10,2),
    FOREIGN KEY (ID_Owner) REFERENCES Owners(ID_Owner)
);

CREATE TABLE IF NOT EXISTS Positions(
	ID_Position INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL UNIQUE
);

INSERT INTO Positions (Name) VALUES ('Veterinario');
INSERT INTO Positions (Name) VALUES ('Administrativo');
INSERT INTO Positions (Name) VALUES ('Secretaria');

CREATE TABLE IF NOT EXISTS Employees(
	ID_Employee INT PRIMARY KEY AUTO_INCREMENT,  -- check
    username VARCHAR(100),
    password VARCHAR(100),
    Name VARCHAR(100) , -- check
    ID_Card VARCHAR(100) NOT NULL UNIQUE, -- check
    Address VARCHAR(100) , -- check
    Phone_Number VARCHAR(15) , -- check
    Email VARCHAR(20) , -- check
    HireDate DATE ,
    State BOOLEAN ,
    ID_Position INT ,
	FOREIGN KEY (ID_Position) REFERENCES Positions(ID_Position)
);

CREATE TABLE IF NOT EXISTS States(
	ID_State INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100)  UNIQUE
);

CREATE TABLE IF NOT EXISTS Appointments(
	ID_Appointment INT PRIMARY KEY AUTO_INCREMENT,
    DateAppointment DATETIME ,
    Reason VARCHAR(100) ,
    ID_Pet INT NOT NULL,
	ID_State INT NOT NULL,
	FOREIGN KEY (ID_Pet) REFERENCES Pets(ID_Pet),
	FOREIGN KEY (ID_State) REFERENCES States(ID_State)
);


-- Tipos de Productos
CREATE TABLE IF NOT EXISTS ProductsTypes (
    ID_ProductsTypes INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) 
);

INSERT INTO ProductsTypes (Name) VALUES 
('Medicines'),
('Vaccines'),
('Medical Supplies'),
('Accessories'),
('Food');


CREATE TABLE IF NOT EXISTS Products (
    ID_Product INT PRIMARY KEY AUTO_INCREMENT,
    SKU VARCHAR(100) NOT NULL UNIQUE,    
    Name VARCHAR(100) NOT NULL,
    Batch VARCHAR(100) NOT NULL UNIQUE,
    Manufacturer VARCHAR(100) NOT NULL,
    EntryDate DATE NOT NULL,
    DueDate DATE NOT NULL,
    Stock INT NOT NULL,
    Price FLOAT NOT NULL,
    ID_ProductsTypes INT NULL,
    FOREIGN KEY (ID_ProductsTypes) REFERENCES ProductsTypes(ID_ProductsTypes)
);

INSERT INTO Products (SKU, Name, Batch, Manufacturer, EntryDate, DueDate, Stock, Price, ID_ProductsTypes) VALUES
('SKU001', 'Canine Multivitamin', 'BCH001', 'VetHealth', '2024-01-10', '2025-01-10', 100, 19.99, 1),
('SKU002', 'Feline Vaccine - Rabies', 'BCH002', 'AnimalCare', '2024-02-15', '2026-02-15', 50, 25.49, 2),
('SKU003', 'Surgical Gloves - Large', 'BCH003', 'MediSupply', '2024-03-05', '2026-03-05', 200, 15.99, 3),
('SKU004', 'Dog Leash - Medium', 'BCH004', 'PawGear', '2024-01-20', '2026-01-20', 150, 12.99, 4),
('SKU005', 'Dry Cat Food - Salmon', 'BCH005', 'PetNourish', '2024-02-01', '2024-08-01', 300, 29.99, 5),
('SKU006', 'Horse Dewormer', 'BCH006', 'EquiCare', '2024-03-10', '2025-03-10', 80, 34.99, 1),
('SKU007', 'Puppy Vaccine - Distemper', 'BCH007', 'VetVaccines', '2024-04-15', '2025-04-15', 60, 24.99, 2),
('SKU008', 'Bandages - Small', 'BCH008', 'MediSupply', '2024-03-01', '2025-03-01', 500, 5.99, 3),
('SKU009', 'Cat Collar - Adjustable', 'BCH009', 'PawGear', '2024-01-25', '2026-01-25', 200, 8.49, 4),
('SKU010', 'Canned Dog Food - Chicken', 'BCH010', 'PetNourish', '2024-02-20', '2024-07-20', 400, 2.49, 5);


CREATE TABLE IF NOT EXISTS MedicinesType (
    ID_MedicineType INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL
);

INSERT INTO MedicinesType (Name) VALUES
('Antibiotics'),
('Antiparasitics'),
('Anti-inflammatories'),
('Vaccines'),
('Pain Relievers');

-- Medicamentos
CREATE TABLE IF NOT EXISTS Medicines (
    ID_Product INT PRIMARY KEY,
    Dosage INT NOT NULL,
    PrescriptionRequired BOOLEAN NOT NULL,
    unitofMeasure VARCHAR(100) NOT NULL,
    quantityPerPackage INT NOT NULL,
    doseInterval VARCHAR(100) NOT NULL,
    ID_MedicineType INT NOT NULL,
    FOREIGN KEY (ID_Product) REFERENCES Products(ID_Product),
    FOREIGN KEY (ID_MedicineType) REFERENCES MedicinesType(ID_MedicineType)
);

INSERT INTO Medicines (ID_Product, Dosage, PrescriptionRequired, unitofMeasure, quantityPerPackage, doseInterval, ID_MedicineType) VALUES
(1, 500, 1, 'mg', 10, '12 hours', 1), -- Canine Multivitamin (example with antibiotics)
(6, 300, 1, 'mg', 5, '24 hours', 2), -- Horse Dewormer (antiparasitic)
(7, 2, 0, 'ml', 1, '1 dose', 4), -- Puppy Vaccine - Distemper (vaccine)
(3, 250, 1, 'mg', 20, '8 hours', 3), -- Anti-inflammatory drug
(8, 100, 1, 'mg', 30, 'As needed', 5); -- Unique ID for another medicine



-- Tabla AdministrationMethods
CREATE TABLE IF NOT EXISTS AdministrationMethods (
    ID_AdministrationMethod INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL
);

INSERT INTO AdministrationMethods (Name) VALUES
('Oral'),
('Injection'),
('Topical'),
('Inhalation');

-- Tabla Vaccines
CREATE TABLE IF NOT EXISTS Vaccines (
    ID_Product INT PRIMARY KEY,
    StorageTemperature FLOAT NOT NULL,
    ID_AdministrationMethod INT NOT NULL,
    numberOfDoses INT NOT NULL,
    period INT NOT NULL,
    FOREIGN KEY (ID_Product) REFERENCES Products(ID_Product),
    FOREIGN KEY (ID_AdministrationMethod) REFERENCES AdministrationMethods(ID_AdministrationMethod)
);

INSERT INTO Vaccines (ID_Product, StorageTemperature, ID_AdministrationMethod, numberOfDoses, period) VALUES
(7, 2.0, 2, 1, 365), -- Puppy Vaccine - Distemper
(2, 4.0, 2, 1, 365); -- Feline Vaccine - Rabies

CREATE TABLE IF NOT EXISTS MaterialTypes (
    ID_MaterialType INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL
);

INSERT INTO MaterialTypes (Name) VALUES
('Plastic'),         -- Usado para jeringas, envases de medicamentos, y accesorios.
('Metal'),           -- Material resistente para collares, correas, y herramientas quirúrgicas.
('Fabric'),          -- Para camas, ropa para mascotas, y accesorios.
('Rubber'),          -- Utilizado en juguetes, guantes médicos, y productos antideslizantes.          -- Usado en guantes quirúrgicos o productos médicos específicos.
('Ceramic');



-- Tabla MedicalMaterials
CREATE TABLE IF NOT EXISTS MedicalMaterials (
    ID_Product INT PRIMARY KEY,
    Size INT NOT NULL,
    ID_MaterialType INT NOT NULL,
    Reusable BOOLEAN NOT NULL,
    FOREIGN KEY (ID_MaterialType) REFERENCES MaterialTypes(ID_MaterialType),
    FOREIGN KEY (ID_Product) REFERENCES Products(ID_Product)
);

INSERT INTO MedicalMaterials (ID_Product, Size, ID_MaterialType, Reusable) VALUES
(3, 7, 1, 1), -- Surgical Gloves - Large
(8, 5, 1, 1); -- Bandages - Small

-- Tabla PetFoods
CREATE TABLE IF NOT EXISTS PetFoods (
    ID_Product INT PRIMARY KEY,
    weight DOUBLE NOT NULL,
    calories INT NOT NULL,
    isOrganic BOOLEAN NOT NULL,
    FOREIGN KEY (ID_Product) REFERENCES Products(ID_Product)
);

INSERT INTO PetFoods (ID_Product, weight, calories, isOrganic) VALUES
(5, 2.5, 400, 0), -- Dry Cat Food - Salmon
(10, 0.5, 250, 1); -- Canned Dog Food - Chicken

-- Tabla AccessoriesType
CREATE TABLE IF NOT EXISTS AccessoriesType (
    ID_AccessoryType INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL
);

INSERT INTO AccessoriesType (Name) VALUES
('Collars'),
('Leashes'),
('Toys'),
('Hygiene Items');

-- Tabla Accessory
CREATE TABLE IF NOT EXISTS Accessory (
    ID_Product INT PRIMARY KEY,
    ID_MaterialType INT NOT NULL,
    dimensions VARCHAR(100) NOT NULL,
    ID_AccessoryType INT NOT NULL,
    FOREIGN KEY (ID_MaterialType) REFERENCES MaterialTypes(ID_MaterialType),
    FOREIGN KEY (ID_AccessoryType) REFERENCES AccessoriesType(ID_AccessoryType),
    FOREIGN KEY (ID_Product) REFERENCES Products(ID_Product)
);

INSERT INTO Accessory (ID_Product, ID_MaterialType, dimensions, ID_AccessoryType) VALUES
(4, 2, '120cm x 2cm', 2), -- Dog Leash - Medium
(9, 3, '35cm x 1cm', 1); -- Cat Collar - Adjustable


CREATE TABLE IF NOT EXISTS Suppliers(
	ID_Supplier INT PRIMARY KEY AUTO_INCREMENT,
    Company_Name VARCHAR(100) NOT NULL,
    NIT VARCHAR(20) NOT NULL UNIQUE,
    contactName VARCHAR(100) NOT NULL,
    Phone_Number VARCHAR(15) NOT NULL,
    Email VARCHAR(20) NOT NULL
);


INSERT INTO Suppliers (Company_Name, NIT, ContactName, Phone_Number, Email)
VALUES
('Acme Corporation', '123456789', 'John Doe', '123-456-7890', 'johndoe@acme.com'),
('Global Supplies', '987654321', 'Jane Smith', '987-654-3210', 'janesmith@global.com'),
('Local Supply Store', '555555555', 'Michael Johnson', '555-555-5555', 'michaelj@local.com');

CREATE TABLE IF NOT EXISTS ProductsSuppliers(
	ID_Product INT NOT NULL,
    ID_Supplier INT NOT NULL,
    PRIMARY KEY(ID_Product, ID_Supplier),
	FOREIGN KEY (ID_Product) REFERENCES Products(ID_Product),
	FOREIGN KEY (ID_Supplier) REFERENCES Suppliers(ID_Supplier)
);

INSERT INTO ProductsSuppliers (ID_Product, ID_Supplier)
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 1),
(5, 2);


CREATE TABLE IF NOT EXISTS Purchases(
	ID_Purchase INT PRIMARY KEY AUTO_INCREMENT,
    DatePurchase DATE , 
	ID_Supplier INT ,
    Estado boolean default false,
    Total int default 0,
	FOREIGN KEY (ID_Supplier) REFERENCES Suppliers(ID_Supplier)
);

INSERT INTO Purchases (DatePurchase, ID_Supplier, Total)
VALUES
('2023-11-22', 1, 1000),
('2023-12-05', 2, 500),
('2024-01-15', 3, 800);
 
CREATE TABLE IF NOT EXISTS PurchaseDetails(
	ID_Product INT NOT NULL,
	ID_Purchase INT NOT NULL,
    Quantity INT NOT NULL,
    subTotal float,
    PRIMARY KEY(ID_Product, ID_Purchase),
	FOREIGN KEY (ID_Product) REFERENCES Products(ID_Product),
	FOREIGN KEY (ID_Purchase) REFERENCES Purchases(ID_Purchase)
);

INSERT INTO PurchaseDetails (ID_Product, ID_Purchase, Quantity, Subtotal)
VALUES
(1, 2, 2, (SELECT Price FROM Products WHERE ID_Product = 1) * 2),
(3, 3, 3, (SELECT Price FROM Products WHERE ID_Product = 3) * 3),
(4, 2, 4, (SELECT Price FROM Products WHERE ID_Product = 4) * 4),
(5, 1, 2, (SELECT Price FROM Products WHERE ID_Product = 5) * 2);

CREATE TABLE IF NOT EXISTS serviceTypes(
	ID_ServiceType INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL
);

INSERT INTO serviceTypes (Name) VALUES ('Grooming');
INSERT INTO serviceTypes (Name) VALUES ('Vaccination');
INSERT INTO serviceTypes (Name) VALUES ('Checkup');
INSERT INTO serviceTypes (Name) VALUES ('Surgery');
INSERT INTO serviceTypes (Name) VALUES ('Emergency Care');


CREATE TABLE IF NOT EXISTS Services(
	ID_Service INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    Description VARCHAR(100) NOT NULL,
    Price DECIMAL(10,2) NOT NULL,
    Points INT NOT NULL,
    ID_ServiceType INT NOT NULL,
	FOREIGN KEY (ID_ServiceType) REFERENCES serviceTypes(ID_ServiceType)
);

INSERT INTO Services (Name, Description, Price, Points, ID_ServiceType) VALUES ('Basic Grooming', 'Includes bath and haircut', 30.00, 10, 1);
INSERT INTO Services (Name, Description, Price, Points, ID_ServiceType) VALUES ('Rabies Vaccination', 'Rabies vaccine for dogs and cats', 25.00, 8, 2);
INSERT INTO Services (Name, Description, Price, Points, ID_ServiceType) VALUES ('Annual Checkup', 'Full health checkup for your pet', 50.00, 15, 3);
INSERT INTO Services (Name, Description, Price, Points, ID_ServiceType) VALUES ('Spaying Surgery', 'Spay surgery for female pets', 200.00, 50, 4);
INSERT INTO Services (Name, Description, Price, Points, ID_ServiceType) VALUES ('Emergency Consultation', '24/7 emergency consultation', 100.00, 30, 5);


CREATE TABLE IF NOT EXISTS ProductsServices(
	ID_Product INT NOT NULL,
    ID_Service INT NOT NULL,
    PRIMARY KEY(ID_Product, ID_Service),
	FOREIGN KEY (ID_Product) REFERENCES Products(ID_Product),
    FOREIGN KEY (ID_Service) REFERENCES Services(ID_Service)
);

CREATE TABLE IF NOT EXISTS Consultation (
    ID_Service INT NOT NULL,
    Reason VARCHAR(100) NOT NULL,
    Diagnosis VARCHAR(100) NOT NULL,
    Recommendations VARCHAR(100) NOT NULL,
    PRIMARY KEY(ID_Service),
    FOREIGN KEY (ID_Service) REFERENCES Services(ID_Service)
);

CREATE TABLE IF NOT EXISTS Vaccination (
    ID_Service INT NOT NULL,
    ApplicationDate DATE NOT NULL,
    NextDoseDate DATE NOT NULL,
    PRIMARY KEY(ID_Service),
    FOREIGN KEY (ID_Service) REFERENCES Services(ID_Service)
);

CREATE TABLE IF NOT EXISTS ProcedureTypes(
	ID_ProcedureType INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS Procedures (
    ID_Service INT NOT NULL,
    ID_Procedure INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    ApplicationDate DATE NOT NULL,
	RecoveryTime DATE NOT NULL,
    ID_ProcedureType INT NOT NULL,
    FOREIGN KEY (ID_Service) REFERENCES Services(ID_Service),
    FOREIGN KEY (ID_ProcedureType) REFERENCES ProcedureTypes(ID_ProcedureType)
);

CREATE TABLE IF NOT EXISTS Preoperative(
	ID_Procedure INT NOT NULL,
    Analysis VARCHAR(150) NOT NULL,
    EstimatedTime DATE NOT NULL,
    FOREIGN KEY (ID_Procedure) REFERENCES Procedures(ID_Procedure)
);

CREATE TABLE IF NOT EXISTS PostOperative(
	ID_Procedure INT NOT NULL,
    nextControlAppointments DATE NOT NULL,
    RecoveryStatus VARCHAR(150) NOT NULL,
    FOREIGN KEY (ID_Procedure) REFERENCES Procedures(ID_Procedure)
);

CREATE TABLE IF NOT EXISTS serviceAppointments(
	ID_Service INT NOT NULL,
    ID_Appointment INT NOT NULL,
    ID_Employee INT NOT NULL,
    PRIMARY KEY (ID_Appointment, ID_Service),
    FOREIGN KEY (ID_Employee) REFERENCES Employees(ID_Employee),
    FOREIGN KEY (ID_Service) REFERENCES Services(ID_Service),
    FOREIGN KEY (ID_Appointment) REFERENCES Appointments(ID_Appointment)
);

CREATE TABLE IF NOT EXISTS Invoices(
	CUFE INT PRIMARY KEY AUTO_INCREMENT,
    DateInvoice DATE NOT NULL,
    State BOOLEAN NOT NULL, 
    ID_Owner INT NOT NULL,
     Total double,
    FOREIGN KEY (ID_Owner) REFERENCES Owners(ID_Owner)
);



CREATE TABLE IF NOT EXISTS ProductsInvoices(
	CUFE INT NOT NULL,
    ID_Product INT NOT NULL,
    Quantity INT NOT NULL,
    PRIMARY KEY (CUFE, ID_Product),
   
    FOREIGN KEY (ID_Product) REFERENCES Products(ID_Product),
    FOREIGN KEY (CUFE) REFERENCES Invoices(CUFE)
);

CREATE TABLE IF NOT EXISTS ServiceInvoices(
	CUFE INT NOT NULL,
    ID_Service INT NOT NULL,
    ID_Employee INT NOT NULL,
    ID_Pet INT NOT NULL,
    Performance DECIMAL(10, 2) NOT NULL,
    Observations VARCHAR(200) NOT NULL,
    PRIMARY KEY (CUFE, ID_Service),
    FOREIGN KEY (ID_Service) REFERENCES Services(ID_Service),
	FOREIGN KEY (ID_Employee) REFERENCES Employees(ID_Employee),
    FOREIGN KEY (ID_Pet) REFERENCES Pets(ID_Pet),
    FOREIGN KEY (CUFE) REFERENCES Invoices(CUFE)
);

CREATE TABLE IF NOT EXISTS PaymentMethods (
	ID_PaymentMethod INT PRIMARY KEY NOT NULL,
    Name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS TransactionTypes(
	ID_TransactionType INT PRIMARY KEY NOT NULL,
    Name VARCHAR(100) NOT NULL UNIQUE
    
);

CREATE TABLE IF NOT EXISTS Transactions(
	CUFE INT NOT NULL PRIMARY KEY,
    DateTransaction DATE NOT NULL,
	ID_PaymentMethod INT NOT NULL,
    ID_TransactionType INT NOT NULL,
	FOREIGN KEY (CUFE) REFERENCES Invoices(CUFE),
	FOREIGN KEY (ID_PaymentMethod) REFERENCES PaymentMethods(ID_PaymentMethod),
    FOREIGN KEY (ID_TransactionType) REFERENCES TransactionTypes(ID_TransactionType)
);
CREATE TABLE IF NOT EXISTS EventTypes ( ID_EventType INT PRIMARY KEY AUTO_INCREMENT, Name VARCHAR(50) NOT NULL UNIQUE );



CREATE TABLE IF NOT EXISTS Events (
    ID_Event INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL UNIQUE,
    StartDate DATE NOT NULL,
    EndDate DATE NOT NULL,
    Location VARCHAR(100) NOT NULL,
    ID_EventType INT NOT NULL,  -- Foreign key referencing EventTypes
    FOREIGN KEY (ID_EventType) REFERENCES EventTypes(ID_EventType)
);


CREATE TABLE IF NOT EXISTS EmployeesEvent(
	ID_Event INT NOT NULL,
    ID_Employee INT NOT NULL,
    PRIMARY KEY (ID_Event, ID_Employee),
	FOREIGN KEY (ID_Event) REFERENCES Events(ID_Event),
    FOREIGN KEY (ID_Employee) REFERENCES Employees(ID_Employee)
);

CREATE TABLE IF NOT EXISTS PetsEvent(
	ID_Event INT NOT NULL,
    ID_Pet INT NOT NULL,
    PRIMARY KEY (ID_Event, ID_Pet),
	FOREIGN KEY (ID_Event) REFERENCES Events(ID_Event),
    FOREIGN KEY (ID_Pet) REFERENCES Pets(ID_Pet)
);

CREATE TABLE IF NOT EXISTS ServicesEvent(
	ID_Event INT NOT NULL,
    ID_Service INT NOT NULL,
    PRIMARY KEY (ID_Event, ID_Service),
	FOREIGN KEY (ID_Event) REFERENCES Events(ID_Event),
    FOREIGN KEY (ID_Service) REFERENCES Services(ID_Service)
);

DELIMITER $$

CREATE TRIGGER UpdateInvoiceTotalAfterProductInsert
AFTER INSERT ON ProductsInvoices
FOR EACH ROW
BEGIN
    DECLARE productTotal DECIMAL(10, 2) DEFAULT 0;
    DECLARE serviceTotal DECIMAL(10, 2) DEFAULT 0;
    DECLARE invoiceTotal DECIMAL(10, 2);

    -- Calcular el total de productos
    SELECT SUM(p.Price * pi.Quantity) INTO productTotal
    FROM Products p
    JOIN ProductsInvoices pi ON p.ID_Product = pi.ID_Product
    WHERE pi.CUFE = NEW.CUFE;

    -- Calcular el total de servicios
    SELECT SUM(si.Performance) INTO serviceTotal
    FROM ServiceInvoices si
    WHERE si.CUFE = NEW.CUFE;

    -- Calcular el total de la factura (productos + servicios)
    SET invoiceTotal = COALESCE(productTotal, 0) + COALESCE(serviceTotal, 0);

    -- Actualizar la columna Total en la tabla Invoices
    UPDATE Invoices
    SET Total = invoiceTotal
    WHERE CUFE = NEW.CUFE;
END$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER UpdateInvoiceTotalAfterServiceInsert
AFTER INSERT ON ServiceInvoices
FOR EACH ROW
BEGIN
    DECLARE productTotal DECIMAL(10, 2) DEFAULT 0;
    DECLARE serviceTotal DECIMAL(10, 2) DEFAULT 0;
    DECLARE invoiceTotal DECIMAL(10, 2);

    -- Calcular el total de productos
    SELECT SUM(p.Price * pi.Quantity) INTO productTotal
    FROM Products p
    JOIN ProductsInvoices pi ON p.ID_Product = pi.ID_Product
    WHERE pi.CUFE = NEW.CUFE;

    -- Calcular el total de servicios
    SELECT SUM(si.Performance) INTO serviceTotal
    FROM ServiceInvoices si
    WHERE si.CUFE = NEW.CUFE;

    -- Calcular el total de la factura (productos + servicios)
    SET invoiceTotal = COALESCE(productTotal, 0) + COALESCE(serviceTotal, 0);

    -- Actualizar la columna Total en la tabla Invoices
    UPDATE Invoices
    SET Total = invoiceTotal
    WHERE CUFE = NEW.CUFE;
END;


