CREATE DATABASE db_fai_lds WITH OWNER = postgres
ENCODING = 'UTF8' CONNECTION LIMIT = -1;

DROP TABLE comentario;
DROP TABLE usuario_jogo;
DROP TABLE imagem_jogo;
DROP TABLE jogo;
DROP TABLE usuario;

CREATE TABLE usuario
(
    id BIGSERIAL,
    nome_usuario VARCHAR (50) UNIQUE NOT NULL,
    senha VARCHAR (50) NOT NULL,
    nome_completo VARCHAR (150) NOT NULL,
    email VARCHAR (50) UNIQUE NOT NULL,
    tipo VARCHAR (20) NOT NULL,
    telefone VARCHAR (50) NOT NULL,
    criado_em TIMESTAMP NOT NULL,
    avatar bytea,
    PRIMARY KEY(id)
);

CREATE TABLE jogo
(
    id BIGSERIAL,
    genero VARCHAR (50) NOT NULL,
    nome VARCHAR (50) UNIQUE NOT NULL,
    descricao VARCHAR NOT NULL,
    preco DECIMAL DEFAULT 249.90,
    desenvolvido_por VARCHAR (100) NOT NULL,
    data_lancamento VARCHAR(50) DEFAULT '-',
    plataforma VARCHAR (50) NOT NULL,
    imagem_principal VARCHAR,
    PRIMARY KEY (id)
);

CREATE TABLE imagem_jogo
(
    id BIGSERIAL,
    jogo_id_fk BIGINT NOT NULL,
    imagem VARCHAR,
    PRIMARY KEY (id)
);

ALTER TABLE imagem_jogo
    ADD CONSTRAINT imagem_jogo_jogo_fk
        FOREIGN KEY (jogo_id_fk)
            REFERENCES jogo (id)
            ON DELETE CASCADE;



CREATE TABLE usuario_jogo
(
    usuario_id_fk BIGINT NOT NULL,
    jogo_id_fk BIGINT NOT NULL,
    possui_jogo BOOLEAN,
    possui_interesse BOOLEAN,
    nota BIGINT NOT NULL,
    PRIMARY KEY (usuario_id_fk, jogo_id_fk)
);

ALTER TABLE usuario_jogo
    ADD CONSTRAINT usuario_jogo_usuario_fk
        FOREIGN KEY (usuario_id_fk)
            REFERENCES usuario (id)
            ON DELETE SET NULL;

ALTER TABLE usuario_jogo
    ADD CONSTRAINT usuario_jogo_jogo_fk
        FOREIGN KEY (jogo_id_fk)
            REFERENCES jogo (id)
            ON DELETE SET NULL;


CREATE TABLE comentario
(
    id BIGSERIAL,
    jogo_id_fk BIGINT NOT NULL,
    usuario_id_fk BIGINT NOT NULL,
    enviado_em TIMESTAMP NOT NULL,
    comentario VARCHAR NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE comentario
    ADD CONSTRAINT comentario_jogo_fk
        FOREIGN KEY (jogo_id_fk)
            REFERENCES jogo (id)
            ON DELETE SET NULL;

ALTER TABLE comentario
    ADD CONSTRAINT comentario_usuario_fk
        FOREIGN KEY (usuario_id_fk)
            REFERENCES usuario (id)
            ON DELETE SET NULL;






------------------
INSERT INTO usuario
(senha, nome_completo, email, tipo, telefone, criado_em)
VALUES('admin', 'admin', 'Administrador', 'admin@email.com', 'ADMINISTRATOR', '35-1234-1234', now());
INSERT INTO usuario
(senha, nome_completo, email, tipo, telefone, criado_em)
VALUES('tiburssio', '123456', 'Tiburssio Tiburssius', 'tiburssio@email.com', 'CLIENT', '35-1234-1234', now());
INSERT INTO usuario
(senha, nome_completo, email, tipo, telefone, criado_em)
VALUES('aroldo', '123456', 'Aroldo Aroldus', 'aroldo@email.com', 'EMPLOYEE', '35-1234-1234', now());


------------------
INSERT INTO jogo
(genero, nome, descricao, preco, desenvolvido_por, data_lancamento, plataforma)
VALUES('MMORPG', 'FINAL FANTASY® XIV: SHADOWBRINGERS', 'Embarque na nova saga do aclamado jogo FINAL FANTASY® XIV Online com o novo e lendário pacote de expansão SHADOWBRINGERS!

Novos jobs, incluindo Gunbreaker
Nova raça jogável: Viera
Limite de nível aumentado de 70 para 80
Explore novas e grandes áreas, como Rak’tika Greatwood, Amh Araeng e Il Mheg.
Novos primals, como Pixie King Titania
Novas tribos: fadas, Nu Mou, anões.
Uma gama de novas masmorras para explorar
Novas incursões desafiadoras para 8 jogadores
Uma nova e emocionante série de incursões de alianças YoRHa: Dark Apocalypse
Explore as masmorras que aparecem na história principal de Shadowbringers ao lado de NPCs famosos com o novo sistema Trust.', 199.90, 'SQUARE ENIX CO. LTD.', '1981-01-01 21:00:00-03', 'PS4, PC');

------------------
INSERT INTO jogo
(genero, nome, descricao, preco, desenvolvido_por, data_lancamento, plataforma)
VALUES('Luta', 'DRAGON BALL FIGHTERZ', 'DRAGON BALL FighterZ foi inspirado no que torna a série DRAGON BALL tão famosa: lutas infinitas e espetaculares entre guerreiros poderosos.

Em parceria com a Arc System Works, DRAGON BALL FighterZ traz gráficos de anime de alta qualidade e oferece uma mecânica de jogo fácil de aprender, mas difícil de dominar.

Suporte/permuta no 3v3
Monte uma superequipe e aprimore suas técnicas para trocar de jogador com agilidade.

Incríveis Recursos Online
Partidas ranqueadas, salas interativas, partidas malucas com 6 jogadores... Tem para todos os gostos!

Exclusivo Modo História
Explore cenários inéditos com a Androide 21, uma nova personagem criada sob a supervisão do próprio Akira Toriyama.

Lutas Espetaculares
Curta combos aéreos, cenários destrutíveis e cenas famosas do anime DRAGON BALL reproduzidas em 60FPS e resolução de 1080p!', 429.99, 'BANDAI NAMCO', '8 jul 2020', 'PS4, PC, XBOX_ONE');

------------------
INSERT INTO jogo
(genero, nome, descricao, preco, desenvolvido_por, data_lancamento, plataforma)
VALUES('Ação', 'Assassins Creed® Unity', 'Paris, 1789. A Revolução Francesa transformou uma cidade outrora magnífica em um lugar de terror e caos. Suas ruas de paralelepípedos ficaram manchadas com o sangue do povo que se atreveu a levantar-se contra a aristocracia opressiva. Enquanto a nação se fragmenta, um jovem chamado Arno embarcará em uma viagem extraordinária para desmascarar as forças ocultas por trás da Revolução. Sua busca irá colocá-lo em meio a uma luta implacável pelo destino de uma nação, transformando-o em um verdadeiro Mestre Assassino.

Apresentamos o jogo Assassin’s Creed® Unity, a evolução desta franquia de sucesso para a próxima geração de plataformas, com um novíssimo engine de jogo. Da Queda da Bastilha à execução do rei Luís XVI, explore a Revolução Francesa como você nunca imaginou e ajude o povo francês a moldar um novo destino.', 29.90, 'Ubisoft Entertainment', '11 nov 2014', 'PS4');

------------------
INSERT INTO jogo
(genero, nome, descricao, preco, desenvolvido_por, data_lancamento, plataforma)
VALUES('Survival', 'RESIDENT EVIL 7 biohazard', 'RESIDENT EVIL 7 biohazard, Medo e isolamento se infiltram nas paredes de uma casa de campo abandonada. 7 marca um novo início para o horror de sobrevivência com a Visão Isolada da visceral perspectiva em primeira pessoa. Através do motor gráfico RE, o horror atinge uma imersão incrível conforme os jogadores entram em um novo e aterrorizante mundo lutando para sobreviver', 74.99, 'Capcom U.S.A., Inc.', '24 jan 2017', 'PC');

------------------
INSERT INTO jogo
(genero, nome, descricao, preco, desenvolvido_por, data_lancamento, plataforma)
VALUES('Ação, RPG', 'Horizon Zero Dawn: The Frozen Wilds', 'Mais além das montanhas do norte, as regiões fronteiriças da tribo Banuk desafiam qualquer um que ouse tentar sobreviver às circunstâncias extremas. Mas, agora, essa natureza selvagem congelada abriga uma nova ameaça e, para Aloy, um novo mistério. E ela está determinada a descobri-lo.

The Frozen Wilds possui conteúdo adicional de Horizon Zero Dawn, inclusive novas histórias, personagens e experiências em uma nova região bela, mas implacável.', 15.45, 'Sony Interactive Entertainment', '7 nov 2017', 'PS4, XBOX_ONE');




-----------------
INSERT INTO imagem_jogo
(jogo_id_fk, imagem)
VALUES(1, '/Documents/images/img-1.jpg');
INSERT INTO imagem_jogo
(jogo_id_fk, imagem)
VALUES(1, '/Documents/images/img-2.jpg');
INSERT INTO imagem_jogo
(jogo_id_fk, imagem)
VALUES(1, '/Documents/images/img-3.jpg');

INSERT INTO imagem_jogo
(jogo_id_fk, imagem)
VALUES(2, '/Documents/images/img-1.jpg');
INSERT INTO imagem_jogo
(jogo_id_fk, imagem)
VALUES(2, '/Documents/images/img-2.jpg');
INSERT INTO imagem_jogo
(jogo_id_fk, imagem)
VALUES(2, '/Documents/images/img-3.jpg');

INSERT INTO imagem_jogo
(jogo_id_fk, imagem)
VALUES(3, '/Documents/images/img-1.jpg');
INSERT INTO imagem_jogo
(jogo_id_fk, imagem)
VALUES(3, '/Documents/images/img-2.jpg');
INSERT INTO imagem_jogo
(jogo_id_fk, imagem)
VALUES(3, '/Documents/images/img-3.jpg');

-----------------

INSERT INTO usuario_jogo
(usuario_id_fk, jogo_id_fk, possui_jogo, possui_interesse, nota)
VALUES(1, 1, false, false, 5);
INSERT INTO usuario_jogo
(usuario_id_fk, jogo_id_fk, possui_jogo, possui_interesse, nota)
VALUES(1, 2, false, false, 3);
INSERT INTO usuario_jogo
(usuario_id_fk, jogo_id_fk, possui_jogo, possui_interesse, nota)
VALUES(1, 3, true, true, 4);

INSERT INTO usuario_jogo
(usuario_id_fk, jogo_id_fk, possui_jogo, possui_interesse, nota)
VALUES(2, 3, true, false, 1);
INSERT INTO usuario_jogo
(usuario_id_fk, jogo_id_fk, possui_jogo, possui_interesse, nota)
VALUES(2, 4, true, true, 4);
INSERT INTO usuario_jogo
(usuario_id_fk, jogo_id_fk, possui_jogo, possui_interesse, nota)
VALUES(2, 5, false, false, 2);

INSERT INTO usuario_jogo
(usuario_id_fk, jogo_id_fk, possui_jogo, possui_interesse, nota)
VALUES(3, 5, true, true, 3);
INSERT INTO usuario_jogo
(usuario_id_fk, jogo_id_fk, possui_jogo, possui_interesse, nota)
VALUES(3, 2, false, true, 4);
INSERT INTO usuario_jogo
(usuario_id_fk, jogo_id_fk, possui_jogo, possui_interesse, nota)
VALUES(3, 4, true, false, 1);

-----------------

INSERT INTO comentario
(jogo_id_fk, usuario_id_fk, enviado_em, comentario)
VALUES(1, 1, now(), 'Comentario 1');
INSERT INTO comentario
(jogo_id_fk, usuario_id_fk, enviado_em, comentario)
VALUES(1, 2, now(), 'Comentario 2');
INSERT INTO comentario
(jogo_id_fk, usuario_id_fk, enviado_em, comentario)
VALUES(1, 3, now(), 'Comentario 3');

INSERT INTO comentario
(jogo_id_fk, usuario_id_fk, enviado_em, comentario)
VALUES(2, 1, now(), 'Comentario 4');
INSERT INTO comentario
(jogo_id_fk, usuario_id_fk, enviado_em, comentario)
VALUES(2, 2, now(), 'Comentario 5');
INSERT INTO comentario
(jogo_id_fk, usuario_id_fk, enviado_em, comentario)
VALUES(2, 3, now(), 'Comentario 6');

INSERT INTO comentario
(jogo_id_fk, usuario_id_fk, enviado_em, comentario)
VALUES(3, 1, now(), 'Comentario 7');
INSERT INTO comentario
(jogo_id_fk, usuario_id_fk, enviado_em, comentario)
VALUES(3, 2, now(), 'Comentario 8');
INSERT INTO comentario
(jogo_id_fk, usuario_id_fk, enviado_em, comentario)
VALUES(3, 3, now(), 'Comentario 9');

