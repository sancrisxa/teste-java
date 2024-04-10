CREATE TABLE pedidos (
    codigo_cliente int NOT NULL,
    data_cadastro DATETIME,
    nome varchar(255) NOT NULL,
    numero_controle int NOT NULL,
    quantidade int,
    valor DECIMAL(10, 2) NOT NULL,

    PRIMARY KEY (codigo_cliente)
);