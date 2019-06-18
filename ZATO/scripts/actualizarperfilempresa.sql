/PROCEDIMIENTO QUE ACTUALIZAR LAS PK DE PERFIL CON LA PK DE EMPRESA

create or replace procedure actualizarperfilempresa(idempresa perfil.pk_empresa%Type, idperfil perfil.pk_usuario%Type)
is 
begin
update perfil set pk_empresa=idempresa where pk_usuario=idperfil;
end;

