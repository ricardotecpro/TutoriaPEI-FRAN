INSERT INTO tb_usuario (cpf, nome) VALUES ('$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'Rodrigo Soares');
INSERT INTO tb_usuario (cpf, nome) VALUES ('$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'Matheus César');
INSERT INTO tb_usuario (cpf, nome) VALUES ('$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'Paulo');

INSERT INTO tb_dados_familia (pai, mae, responsavel, estrutura_familiar, num_pai, num_mae, num_responsavel) VALUES ('José Mendes', 'Andréia Mendes', '', 'separados, mora com a mãe', 987654321, 987654321, NULL);
INSERT INTO tb_dados_familia (pai, mae, responsavel, estrutura_familiar, num_pai, num_mae, num_responsavel) VALUES ('Nélio Alves', 'Carla Alves', 'Henrique Alves', 'separados, mora com o avô', NULL, NULL, 234567890);
INSERT INTO tb_dados_familia (pai, mae, responsavel, estrutura_familiar, num_pai, num_mae, num_responsavel) VALUES ('Carlos de Souza', 'Maria de Souza', '', 'casados', 123456789, 123456789, NULL);

INSERT INTO tb_escolaridade(contato_fora, dif_aprendizagem, apoio_pedagogico, disciplinas_facilidade, disciplinas_dificuldade, atividade_extra, dif_locomotiva, dif_visao, dif_atencao, dif_fala, dif_escrita, adaptacao_grupo, reprovado) VALUES (true, true, true, '[matemática, portugues]', '[geografia]',  false, false, false, false, false, false, true, false);

INSERT INTO tb_aluno (ra, nome, email, data_nasc, idade, telefone, transporte, projeto_vida, serie, dado_familia_id, endereco, img_url, escolaridade_id) VALUES (123456789, 'Leandro Mendes', '123456789@exemplo.com', '2011-05-01', 14, 987654321, 'A pé', 'Ser médico', '8 ano A', 1, 'Rua A', 'imagem1.png', 1);

