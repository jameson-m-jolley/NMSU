USE `mydb`;

-- Inserting into Physician
INSERT INTO Physician (physicianID, name, position, ssn) VALUES
(2, "Dr. Squidward", "Surgeon", 22222222),
(3, "Dr. Patrick", "Intern", 33333333),
(4, "Dr. Sandy", "Senior", 44444444),
(5, "Dr. Krabs", "Chief of Medicine", 55555555),
(6, "Dr. Plankton", "Psychiatrist", 66666666);

-- Inserting into Department
INSERT INTO Department (deptID, name, headID) VALUES
(2, "General Medicine", 2),
(3, "Psychiatry", 3),
(4, "Surgery", 4),
(5, "General Medicine", 5),
(6, "Psychiatry", 6);

-- Inserting into AffiliatedWith
INSERT INTO AffiliatedWith (physicianID, departmentID) VALUES
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6);

-- Inserting into Procedure
INSERT INTO `Procedure` (procID, name, cost) VALUES
(2, "Jellyfish Stings", 200.0),
(3, "Karate Injury", 300.0),
(4, "Anchor Arm Removal", 400.0),
(5, "Bubble Therapy", 500.0),
(6, "Chum Poisoning", 600.0);

-- Inserting into Nurse
INSERT INTO Nurse (nurseID, name, position, ssn) VALUES
(2, "Nurse Pearl", "Head Nurse", 777777),
(3, "Nurse Bubble Bass", "Nurse", 888888),
(4, "Nurse Barnacle Boy", "Nurse", 999999),
(5, "Nurse Larry", "Nurse", 101010),
(6, "Nurse Mermaid Man", "Head Nurse", 111111);

-- Inserting into Medication
INSERT INTO Medication (medID, name) VALUES
(2, "Kelp Cream"),
(3, "Jellyfish Serum"),
(4, "Bubble Solution"),
(5, "Chum Detox"),
(6, "Barnacle Balm");

-- Inserting into Patient
INSERT INTO Patient (patientID, ssn, name, address, dob, phone, insuranceNumber, primaryPhysID) VALUES
(2, 100002, "SpongeBob SquarePants", "124 Conch St", "1986-07-14", "555-222-2222", 234567, 2),
(3, 100003, "Patrick Star", "120 Conch St", "1985-08-17", "555-333-3333", 345678, 3),
(4, 100004, "Squidward Tentacles", "122 Conch St", "1978-10-09", "555-444-4444", 456789, 4),
(5, 100005, "Mr. Krabs", "Krusty Krab", "1965-11-30", "555-555-5555", 567890, 5),
(6, 100006, "Sandy Cheeks", "Tree Dome", "1987-05-12", "555-666-6666", 678901, 6);

-- Inserting into Prescribes
INSERT INTO Prescribes (physicianID, patientID, medicationID, prescribedDate, dose) VALUES
(2, 2, 2, "2023-02-15", "1/day"),
(3, 3, 3, "2023-03-20", "2/day"),
(4, 4, 4, "2023-04-25", "3/day"),
(5, 5, 5, "2023-05-10", "4/day"),
(6, 6, 6, "2023-06-05", "5/day");

-- Inserting into Room
INSERT INTO Room (roomID, roomType) VALUES
(2, "Single"),
(3, "Double"),
(4, "Single"),
(5, "Double"),
(6, "Single");

-- Inserting into Stay
INSERT INTO Stay (stayID, patientID, roomID, startDate, endDate) VALUES
(2, 2, 2, "2023-02-10", "2023-02-20"),
(3, 3, 3, "2023-03-15", "2023-03-25"),
(4, 4, 4, "2023-04-05", "2023-04-15"),
(5, 5, 5, "2023-05-12", "2023-05-22"),
(6, 6, 6, "2023-06-01", "2023-06-11");

-- Inserting into Undergoes
INSERT INTO Undergoes (patientID, procedureID, stayID, procDate, physicianID, nurseID) VALUES
(2, 2, 2, "2023-02-15", 2, 2),
(3, 3, 3, "2023-03-20", 3, 3),
(4, 4, 4, "2023-04-10", 4, 4),
(5, 5, 5, "2023-05-18", 5, 5),
(6, 6, 6, "2023-06-07", 6, 6);

-- Inserting into OnCall
INSERT INTO OnCall (nurseID, startDate, endDate) VALUES
(2, "2023-01-01", "2023-01-10"),
(3, "2023-02-01", "2023-02-10"),
(4, "2023-03-01", "2023-03-10"),
(5, "2023-04-01", "2023-04-10"),
(6, "2023-05-01", "2023-05-10");

-- Inserting into Appointment
INSERT INTO Appointment (appID, patientID, physicianID, startDateTime, endDateTime, nurseID) VALUES
(2, 2, 2, "2023-02-10 09:00", "2023-02-10 10:00", 2),
(3, 3, 3, "2023-03-15 10:00", "2023-03-15 11:00", 3),
(4, 4, 4, "2023-04-05 11:00", "2023-04-05 12:00", 4),
(5, 5, 5, "2023-05-12 12:00", "2023-05-12 13:00", 5),
(6, 6, 6, "2023-06-01 13:00", "2023-06-01 14:00", 6);
