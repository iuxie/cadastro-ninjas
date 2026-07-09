-- V2 -> Migrations que adiciona coluna RANK em tb_cadastro

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);