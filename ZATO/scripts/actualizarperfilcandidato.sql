
/PROCEDIMIENTO QUE ACTUALIZAR LAS PK DE PERFIL CON LA PK DE CANDIDATO
create or replace procedure actualizarperfilcandidato(idcandidato perfil.pk_candidato%Type, idperfil perfil.pk_usuario%Type)
is 
begin
update perfil set pk_candidato=idcandidato where pk_usuario=idperfil;
end;