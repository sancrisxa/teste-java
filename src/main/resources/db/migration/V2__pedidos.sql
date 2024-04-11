CREATE TABLE pedidos (
    codigo_pedido int NOT NULL,
    data_cadastro DATETIME,
    nome varchar(255) NOT NULL,
    numero_controle int NOT NULL,
    quantidade int,
    valor DECIMAL(10, 2) NOT NULL,
    codigo_cliente int NOT NULL,
    valor_total DECIMAL(10, 2) NOT NULL,

    PRIMARY KEY (codigo_pedido),
    FOREIGN KEY (codigo_cliente) REFERENCES clientes(codigo_cliente)
);