# --- !Ups

CREATE TABLE product (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description TEXT,
  image_url VARCHAR(255),
  price DOUBLE PRECISION
);

CREATE TABLE revenue (
  id SERIAL PRIMARY KEY,
  month VARCHAR(255) NOT NULL,
  amount DOUBLE PRECISION
);

INSERT INTO product (name, description, image_url, price) VALUES 
('Serviço de Consultoria', 'Consultoria especializada em finanças e investimentos', '/assets/images/consultoria.jpg', 1500.00),
('Plano Básico', 'Acesso a ferramentas básicas de análise financeira', '/assets/images/plano-basico.jpg', 99.90),
('Plano Premium', 'Acesso completo a todas as ferramentas e suporte 24/7', '/assets/images/plano-premium.jpg', 199.90),
('Curso de Investimentos', 'Curso completo sobre investimentos no mercado financeiro', '/assets/images/curso.jpg', 499.00),
('Análise Personalizada', 'Análise detalhada do seu perfil financeiro', '/assets/images/analise.jpg', 299.00);

INSERT INTO revenue (month, amount) VALUES 
('Janeiro', 45000.00),
('Fevereiro', 52000.00),
('Março', 58000.00),
('Abril', 61000.00),
('Maio', 64000.00),
('Junho', 72000.00);

# --- !Downs

DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS revenue;
