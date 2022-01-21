ALTER TABLE `unit_expenses`
ADD COLUMN     `id_unity` BIGINT NOT NULL,
ADD CONSTRAINT `fk_unity` FOREIGN KEY (`id_unity`)
REFERENCES      units(`id`);

ALTER TABLE `units`
ADD COLUMN     `id_tenant` BIGINT NOT NULL,
ADD CONSTRAINT `fk_tenant` FOREIGN KEY (`id_tenant`)
REFERENCES      tenants(`id`);