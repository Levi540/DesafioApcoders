CREATE TABLE `tenants` (
  `id`        BIGINT      NOT NULL AUTO_INCREMENT,
  `name`      VARCHAR(45) NOT NULL,
  `age`       INT         NOT NULL,
  `sex`       VARCHAR(1)  NOT NULL,
  `telephone` VARCHAR(30) NOT NULL,
  `email`     VARCHAR(70) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `units` (
  `id`          BIGINT       NOT NULL AUTO_INCREMENT,
  `owner`       VARCHAR(45)  NOT NULL,
  `condominium` VARCHAR(45)  NOT NULL,
  `address`     VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `unit_expenses` (
  `id`                       BIGINT        NOT NULL AUTO_INCREMENT,
  `unit_expense_description` VARCHAR(100)  NOT NULL,
  `type_expense`             VARCHAR(45)   NOT NULL,
  `amount`                   DECIMAL(10,2) NOT NULL,
  `invoice_due_date`         DATE          NOT NULL,
  `payment_status`           VARCHAR(20)   NOT NULL,
  PRIMARY KEY (`id`)
);