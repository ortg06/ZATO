/Inserta un registro en la tabla prueba oferta la relacion prueba y oferta.

create or replace procedure insertarpruebaoferta(idprueba PRUEBA_OFERTA.PK_PRUEBA%Type, idoferta PRUEBA_OFERTA.PK_OFERTA%Type)
is 
begin
INSERT INTO PRUEBA_OFERTA(PK_PRUEBA_OFERTA,PK_PRUEBA,PK_OFERTA) VALUES (SEQUENCE_OFERTA_PRUEBA.NEXTVAL,idprueba,idoferta) ;
commit;
end;

