-- Script DML para poblar la base de datos MySQL

-- Insertar datos en la tabla 'users'
INSERT INTO users (username, password, role) VALUES 
('admin', '$2a$10$DowjUuxeknE43mMLsQ/q5./cUmBtqZ6x21T7YF3T3AvP28RrMWMVa', 'ADMIN'), -- password: admin123
('user1', '$2a$10$DowjUuxeknE43mMLsQ/q5./cUmBtqZ6x21T7YF3T3AvP28RrMWMVa', 'USER'), -- password: user123
('user2', '$2a$10$DowjUuxeknE43mMLsQ/q5./cUmBtqZ6x21T7YF3T3AvP28RrMWMVa', 'USER'); -- password: user123

-- Insertar datos en la tabla 'surveys'
INSERT INTO surveys (created_at, update_at, name, description, published) VALUES 
(NOW(), NULL, 'Encuesta de Satisfacción', 'Encuesta para medir la satisfacción de los empleados.', true),
(NOW(), NULL, 'Encuesta de Productos', 'Encuesta para evaluar los productos de la empresa.', false);

-- Insertar datos en la tabla 'chapters'
INSERT INTO chapters (created_at, updated_at, chapter_number, chapter_title, survey_id) VALUES 
(NOW(), NULL, '1', 'Introducción', 1),
(NOW(), NULL, '2', 'Preguntas Generales', 1),
(NOW(), NULL, '1', 'Opinión sobre Productos', 2);

-- Insertar datos en la tabla 'questions'
INSERT INTO questions (created_at, updated_at, question_number, response_type, comment_question, question_text, chapter_id) VALUES 
(NOW(), NULL, '1', 'text', '¿Cuál es tu opinión sobre la empresa?', 'Opinión general sobre la empresa', 1),
(NOW(), NULL, '2', 'multiple_choice', NULL, '¿Cómo calificarías la atención al cliente?', 2),
(NOW(), NULL, '1', 'text', NULL, 'Describe tu experiencia con el producto.', 3);

-- Insertar datos en la tabla 'response_options'
INSERT INTO response_options (option_text, option_number, question_id) VALUES 
('Muy Satisfecho', '1', 2),
('Satisfecho', '2', 2),
('Neutral', '3', 2),
('Insatisfecho', '4', 2),
('Muy Insatisfecho', '5', 2);

-- Las IDs generadas automáticamente se relacionan entre las tablas, por lo que no es necesario especificarlas en los INSERTs.
