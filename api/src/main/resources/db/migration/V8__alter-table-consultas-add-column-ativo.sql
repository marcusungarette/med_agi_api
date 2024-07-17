alter table consultas add column ativo tinyint;
update consultas set ativo = 1;
alter table consultas modify ativo tinyint not null;