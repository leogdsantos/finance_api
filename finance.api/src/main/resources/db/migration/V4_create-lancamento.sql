CREATE TABLE lancamento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    usuario_id BIGINT NOT NULL,
    CONSTRAINT fk_lancamento_usuario
        FOREIGN KEY (usuario_id)
        REFERENCES usuario(id)
);
