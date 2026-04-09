-- Seed data for employee table
INSERT INTO employee (id, name, email, department) VALUES (1, 'John Doe', 'john.doe@example.com', 'Engineering');
INSERT INTO employee (id, name, email, department) VALUES (2, 'Jane Smith', 'jane.smith@example.com', 'Marketing');
INSERT INTO employee (id, name, email, department) VALUES (3, 'Michael Brown', 'michael.brown@example.com', 'Human Resources');
INSERT INTO employee (id, name, email, department) VALUES (4, 'Emily Davis', 'emily.davis@example.com', 'Sales');
INSERT INTO employee (id, name, email, department) VALUES (5, 'Chris Wilson', 'chris.wilson@example.com', 'Engineering');

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
