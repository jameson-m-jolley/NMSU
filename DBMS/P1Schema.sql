

drop database IF EXISTS mydb;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;



-- -----------------------------------------------------
-- Table `mydb`.`Physician`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Physician` (
  `physicianID` INT NOT NULL,
  `name` VARCHAR(40) NOT NULL,
  `position` VARCHAR(40) NULL CHECK (`position` IN ('Intern', 'Surgeon', 'Senior', 'Chief of Medicine', 'Resident', 'Psychiatrist')),
  `ssn` VARCHAR(40) NULL,
  PRIMARY KEY (`physicianID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Department` (
  `deptID` INT NOT NULL,
  `name` VARCHAR(45) NULL CHECK (`name` IN ("General Medicine", "Surgery","Psychiatry")),
  `headID` INT NOT NULL,
  PRIMARY KEY (`deptID`),
  INDEX `physicianID_idx` (`headID` ASC) VISIBLE,
  CONSTRAINT `physicianID`
    FOREIGN KEY (`headID`)
    REFERENCES `mydb`.`Physician` (`physicianID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`AffiliatedWith`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`AffiliatedWith` (
  `physicianID` INT NOT NULL,
  `departmentID` INT NOT NULL,
  INDEX `departmentID_idx` (`departmentID` ASC) VISIBLE,
  INDEX `physicianID_idx` (`physicianID` ASC) VISIBLE,
  CONSTRAINT `fk_AffiliatedWith_physicianID`
    FOREIGN KEY (`physicianID`)
    REFERENCES `mydb`.`Physician` (`physicianID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AffiliatedWith_departmentID`
    FOREIGN KEY (`departmentID`)
    REFERENCES `mydb`.`Department` (`deptID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Procedure`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Procedure` (
  `procID` INT NOT NULL,
  `name` VARCHAR(40) NOT NULL,
  `cost` REAL NULL,
  PRIMARY KEY (`procID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Nurse`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Nurse` (
  `nurseID` INT NOT NULL,
  `name` VARCHAR(40) NULL,
  `position` VARCHAR(40) NULL CHECK (`position` IN ("Head Nurse" ,"Nurse")),
  `ssn` INT NULL,
  PRIMARY KEY (`nurseID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Medication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Medication` (
  `medID` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`medID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Patient` (
  `patientID` INT NOT NULL,
  `ssn` INT NOT NULL,
  `name` VARCHAR(40) NULL,
  `address` VARCHAR(100) NULL,
  `dob` DATE NULL,
  `phone` VARCHAR(16) NULL,
  `insuranceNumber` INT NULL,
  `primaryPhysID` INT NULL,
  PRIMARY KEY (`patientID`),
  INDEX `primaryPhysID_idx` (`primaryPhysID` ASC) VISIBLE,
  CONSTRAINT `fk_Patient_primaryPhysID`
    FOREIGN KEY (`primaryPhysID`)
    REFERENCES `mydb`.`Physician` (`physicianID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Prescribes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Prescribes` (
  `physicianID` INT NOT NULL,
  `patientID` INT NULL,
  `medicationID` INT NULL,
  `prescribedDate` DATE NULL,
  `dose` VARCHAR(40) NULL,
  INDEX `medicationID_idx` (`medicationID` ASC) VISIBLE,
  INDEX `patientID_idx` (`patientID` ASC) VISIBLE,
  CONSTRAINT `fk_Prescribes_physicianID`
    FOREIGN KEY (`physicianID`)
    REFERENCES `mydb`.`Physician` (`physicianID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Prescribes_medicationID`
    FOREIGN KEY (`medicationID`)
    REFERENCES `mydb`.`Medication` (`medID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Prescribes_patientID`
    FOREIGN KEY (`patientID`)
    REFERENCES `mydb`.`Patient` (`patientID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Room` (
  `roomID` INT NOT NULL,
  `roomType` VARCHAR(40) NULL CHECK (`roomType` IN ("Single" ,"Double")),
  PRIMARY KEY (`roomID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Stay`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Stay` (
  `stayID` INT NOT NULL,
  `patientID` INT NULL,
  `roomID` INT NULL,
  `startDate` DATE NULL,
  `endDate` VARCHAR(45) NULL,
  PRIMARY KEY (`stayID`),
  INDEX `patientID_idx` (`patientID` ASC) VISIBLE,
  INDEX `roomID_idx` (`roomID` ASC) VISIBLE,
  CONSTRAINT `fk_Stay_patientID`
    FOREIGN KEY (`patientID`)
    REFERENCES `mydb`.`Patient` (`patientID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Stay_roomID`
    FOREIGN KEY (`roomID`)
    REFERENCES `mydb`.`Room` (`roomID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Undergoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Undergoes` (
  `patientID` INT NOT NULL,
  `procedureID` INT NOT NULL,
  `stayID` INT NOT NULL,
  `procDate` DATE NOT NULL,
  `physicianID` INT NOT NULL,
  `nurseID` INT NOT NULL,
  INDEX `patientID_idx` (`patientID` ASC) VISIBLE,
  CONSTRAINT `fk_Undergoes_patientID`
    FOREIGN KEY (`patientID`)
    REFERENCES `mydb`.`Patient` (`patientID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Undergoes_procedureID`
    FOREIGN KEY (`procedureID`)
    REFERENCES `mydb`.`Procedure` (`procID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Undergoes_stayID`
    FOREIGN KEY (`stayID`)
    REFERENCES `mydb`.`Stay` (`stayID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Undergoes_physicianID`
    FOREIGN KEY (`physicianID`)
    REFERENCES `mydb`.`Physician` (`physicianID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Undergoes_nurseID`
    FOREIGN KEY (`nurseID`)
    REFERENCES `mydb`.`Nurse` (`nurseID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`OnCall`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`OnCall` (
  `nurseID` INT NOT NULL,
  `startDate` DATE NOT NULL,
  `endDate` DATE NOT NULL,
  CONSTRAINT `fk_OnCall_nurseID`
    FOREIGN KEY (`nurseID`)
    REFERENCES `mydb`.`Nurse` (`nurseID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Appointment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Appointment` (
  `appID` INT NOT NULL,
  `patientID` INT NULL,
  `physicianID` INT NULL,
  `startDateTime` DATETIME NULL,
  `endDateTime` DATETIME NULL,
  `nurseID` INT NULL,
  PRIMARY KEY (`appID`),
  INDEX `patientID_idx` (`patientID` ASC) VISIBLE,
  INDEX `nurseID_idx` (`nurseID` ASC) VISIBLE,
  INDEX `physicianID_idx` (`physicianID` ASC) VISIBLE,
  CONSTRAINT `fk_Appointment_patientID`
    FOREIGN KEY (`patientID`)
    REFERENCES `mydb`.`Patient` (`patientID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Appointment_nurseID`
    FOREIGN KEY (`nurseID`)
    REFERENCES `mydb`.`Nurse` (`nurseID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Appointment_physicianID`
    FOREIGN KEY (`physicianID`)
    REFERENCES `mydb`.`Physician` (`physicianID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

