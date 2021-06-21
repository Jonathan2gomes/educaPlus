DROP TABLE IF EXISTS pergunta CASCADE;

CREATE TABLE pergunta (
id varchar PRIMARY KEY,
categoria varchar,
pergunta varchar
);

CREATE TABLE resposta (
id varchar PRIMARY KEY,
id_pergunta varchar,
resposta_correta boolean,
descricao varchar
);
ALTER TABLE resposta
ADD CONSTRAINT fk_pergunta_resp FOREIGN KEY (id_pergunta) REFERENCES pergunta (id);

