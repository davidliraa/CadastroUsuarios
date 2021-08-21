CREATE TABLE CadastroUsuarios (
     id int IDENTITY PRIMARY KEY,
     nome VARCHAR(30),
     senha VARCHAR(10),
     email VARCHAR(50),
     telefone VARCHAR(100),
);