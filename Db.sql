CREATE SCHEMA `cobranca` ;

CREATE TABLE `cobranca`.`clientes` (
  `idClientes` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(60) NOT NULL,
  `Endereco` VARCHAR(60) NOT NULL,
  `Uf` VARCHAR(2) NOT NULL,
  `Telefone` VARCHAR(16) NOT NULL,
  `Documento` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(70) NOT NULL,
  `Cpf` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`idClientes`),
  UNIQUE INDEX `Cpf_UNIQUE` (`Cpf`)
);
