/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author: oturish
 * Created: 07-01-2019
 */
create or replace procedure insertresultado(idpostulacion RESULTADO.PK_POSTULACION%Type, idpruebaoferta RESULTADO.PK_PRUEBA_OFERTA%Type)
is 
begin
INSERT INTO RESULTADO(PK_RESULTADO,PK_POSTULACION,PK_PRUEBA_OFERTA) VALUES (SEQUENCE_RESULTADO.NEXTVAL,idpostulacion,idpruebaoferta) ;
commit;
end;
