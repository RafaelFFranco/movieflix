ALTER TABLE filme
    ADD COLUMN data_lancamento date,
    ADD COLUMN nota numeric,
    ADD COLUMN data_criacao timestamp,
    ADD COLUMN data_atualizacao timestamp;