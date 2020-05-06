-- Tables creation
create table question (
  noquestion NUMERIC(9,0) NOT NULL,
  nrquestion NUMERIC(9,0) NOT NULL,
  lbquestion CHARACTER  VARYING(128) NOT NULL,
  notopic NUMERIC(9,0) NOT NULL
);

create table answer (
  noanswer NUMERIC(9,0) NOT NULL,
  nranswer NUMERIC(9,0) NOT NULL,
  lbanswer CHARACTER VARYING(128) NOT NULL,
  noquestion NUMERIC(9,0) NOT NULL
);

create table topic (
  notopic NUMERIC(9,0) NOT NULL,
  lbtopic CHARACTER VARYING(64) NOT NULL
);


-- Primary keys constraints
ALTER TABLE ONLY question ADD CONSTRAINT pk_question PRIMARY KEY (noquestion);
ALTER TABLE ONLY answer ADD CONSTRAINT pk_answer PRIMARY KEY (noanswer);
ALTER TABLE ONLY topic ADD CONSTRAINT pk_topic PRIMARY KEY (notopic);


-- Foreign keys constraints
ALTER TABLE ONLY question
  ADD CONSTRAINT fk_question_topic FOREIGN KEY (notopic) REFERENCES topic(notopic)
  ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE ONLY answer
  ADD CONSTRAINT fk_answer_question FOREIGN KEY (noquestion) REFERENCES question(noquestion)
  ON UPDATE RESTRICT ON DELETE RESTRICT;


-- Add data
insert into topic (notopic, lbtopic) values (0, 'test');
insert into topic (notopic, lbtopic) values (1, 'soft');
insert into topic (notopic, lbtopic) values (2, 'medium');
insert into topic (notopic, lbtopic) values (3, 'hardcore');

insert into question (noquestion, nrquestion, lbquestion, notopic) VALUES (1, 1, 'Question1', 0);
insert into question (noquestion, nrquestion, lbquestion, notopic) VALUES (2, 2, 'Question2', 0);
insert into question (noquestion, nrquestion, lbquestion, notopic) VALUES (3, 3, 'Question3', 0);

insert into answer (noanswer, nranswer, lbanswer, noquestion) values (1, 1, 'Answer1.1', 1);
insert into answer (noanswer, nranswer, lbanswer, noquestion) values (2, 2, 'Answer1.2', 1);
insert into answer (noanswer, nranswer, lbanswer, noquestion) values (3, 1, 'Answer2.1', 2);
insert into answer (noanswer, nranswer, lbanswer, noquestion) values (4, 2, 'Answer2.2', 2);
insert into answer (noanswer, nranswer, lbanswer, noquestion) values (5, 1, 'Answer3.1', 3);
insert into answer (noanswer, nranswer, lbanswer, noquestion) values (6, 2, 'Answer3.2', 3);
insert into answer (noanswer, nranswer, lbanswer, noquestion) values (7, 3, 'Answer3.3', 3);
insert into answer (noanswer, nranswer, lbanswer, noquestion) values (8, 4, 'Answer3.4', 3);