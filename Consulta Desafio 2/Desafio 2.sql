/*Os formatos dos valores de 'name' e de 'email' da tabela 'employee' foram
 respectivamente alterados de INT(11) para VARCHAR(255), pois o valor anterior não permitia
 a inserção correta de dados*/

CREATE TABLE `employee` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(255) NOT NULL,
`email` VARCHAR(255) NOT NULL,
PRIMARY KEY(`id`)
);

CREATE TABLE `salary` (
`id`  INT(11) NOT NULL,
`value`  DECIMAL(10,0) NOT NULL,
`payment_date` DATE NOT NULL,
`employee_id` INT(11) NOT NULL,
KEY `employee_id` (`employee_id`),
CONSTRAINT `salary_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee`(`id`)
);

/*Consulta do Desafio*/
SELECT e.id, e.name, AVG(s.value) AS average_salary
FROM employee as e
JOIN salary as s ON e.id = s.employee_id
WHERE s.payment_date >= DATE_SUB(NOW(), INTERVAL 3 MONTH)
GROUP BY e.id, e.name
ORDER BY average_salary DESC
LIMIT 3;
