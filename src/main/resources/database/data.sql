-- Seed data for employee table
INSERT INTO employee (name, email, department, salary) VALUES ('John Doe', 'john.doe@example.com', 'ENGINEERING', '90000');
INSERT INTO employee (name, email, department, salary) VALUES ('Jane Smith', 'jane.smith@example.com', 'MARKETING', '50000');
INSERT INTO employee (name, email, department, salary) VALUES ('Michael Brown', 'michael.brown@example.com', 'HUMAN_RESOURCES', '3');
INSERT INTO employee (name, email, department, salary) VALUES ('Emily Davis', 'emily.davis@example.com', 'SALES', '67');
INSERT INTO employee (name, email, department, salary) VALUES ('Chris Wilson', 'chris.wilson@example.com', 'ENGINEERING', '696969');

-- Seed data for employee_address table
INSERT INTO employee_address (employee_id, street, city, state, zip_code, country)
VALUES (1, '123 Tech Lane', 'San Francisco', 'CA', '94105', 'USA');
INSERT INTO employee_address (employee_id, street, city, state, zip_code, country)
VALUES (2, '456 Market St', 'New York', 'NY', '10001', 'USA');
INSERT INTO employee_address (employee_id, street, city, state, zip_code, country)
VALUES (3, '789 HR Road', 'Chicago', 'IL', '60601', 'USA');
INSERT INTO employee_address (employee_id, street, city, state, zip_code, country)
VALUES (4, '101 Sales Blvd', 'Dallas', 'TX', '75201', 'USA');
INSERT INTO employee_address (employee_id, street, city, state, zip_code, country)
VALUES (5, '202 Engineering Ave', 'Seattle', 'WA', '98101', 'USA');
