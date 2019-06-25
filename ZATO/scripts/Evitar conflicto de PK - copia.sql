CREATE OR REPLACE TRIGGER orders_aptitud
BEFORE INSERT ON catalogo_aptitud
FOR EACH ROW
BEGIN
  SELECT SEQUENCE_CATALOGOAPTITUD.nextval
INTO   :new.pk_catalogo_aptitud
   FROM   dual;
END;
/
CREATE OR REPLACE TRIGGER orders_categoria
BEFORE INSERT ON catalogo_categoria
FOR EACH ROW
BEGIN
  SELECT SEQUENCE_categoria.nextval
INTO   :new.pk_catalogo_categoria
   FROM   dual;
END;
/
CREATE OR REPLACE TRIGGER orders_cat_habilidad
BEFORE INSERT ON catalogo_categoria_habilidad
FOR EACH ROW
BEGIN
  SELECT SEQUENCE_CATEGORIAHABILIDAD.nextval
INTO   :new.pk_categoria_habilidad
   FROM   dual;
END;
/
CREATE OR REPLACE TRIGGER orders_escrito
BEFORE INSERT ON catalogo_escrito
FOR EACH ROW
BEGIN
  SELECT SEQUENCE_CATALOGOESCRITO.nextval
INTO   :new.pk_catalogo_escrito
   FROM   dual;
END;
/
CREATE OR REPLACE TRIGGER orders_genero
BEFORE INSERT ON catalogo_genero
FOR EACH ROW
BEGIN
  SELECT SEQUENCE_GENERO.nextval
INTO   :new.pk_genero
   FROM   dual;
END;
/
CREATE OR REPLACE TRIGGER orders_gra_academico
BEFORE INSERT ON catalogo_grado_academico
FOR EACH ROW
BEGIN
  SELECT SEQUENCE_GRADOACADEMICO.nextval
INTO   :new.pk_grado_academico
   FROM   dual;
END;
/
CREATE OR REPLACE TRIGGER orders_habilidad
BEFORE INSERT ON catalogo_habilidad
FOR EACH ROW
BEGIN
  SELECT SEQUENCE_HABILIDAD.nextval
INTO   :new.pk_habilidad
   FROM   dual;
END;
/
CREATE OR REPLACE TRIGGER orders_idioma
BEFORE INSERT ON catalogo_idioma
FOR EACH ROW
BEGIN
  SELECT SEQUENCE_IDIOMA.nextval
INTO   :new.pk_idioma
   FROM   dual;
END;
/
CREATE OR REPLACE TRIGGER orders_licencia
BEFORE INSERT ON catalogo_licencia
FOR EACH ROW
BEGIN
  SELECT SEQUENCE_CATALOGOLICENCIA.nextval
INTO   :new.pk_catalogo_licencia
   FROM   dual;
END;
/

CREATE OR REPLACE TRIGGER orders_ponderacion
BEFORE INSERT ON catalogo_ponderacion
FOR EACH ROW
BEGIN
  SELECT SEQUENCE_CATALOGOPONDERACION.nextval
INTO   :new.pk_catalogo_ponderacion
   FROM   dual;
END;
/
CREATE OR REPLACE TRIGGER orders_puesto
BEFORE INSERT ON catalogo_puesto
FOR EACH ROW
BEGIN
  SELECT SEQUENCE_PUESTO.nextval
INTO   :new.pk_catalogo_puesto
   FROM   dual;
END;
/
CREATE OR REPLACE TRIGGER orders_sec_empresa
BEFORE INSERT ON catalogo_sector_empresa
FOR EACH ROW
BEGIN
  SELECT SEQUENCE_SECTOR.nextval
INTO   :new.pk_sector
   FROM   dual;
END;
/
CREATE OR REPLACE TRIGGER orders_tip_empresa
BEFORE INSERT ON catalogo_tipo_empresa
FOR EACH ROW
BEGIN
  SELECT SEQUENCE_TIPOEMPRESA.nextval
INTO   :new.pk_tipo_empresa
   FROM   dual;
END;
/
CREATE OR REPLACE TRIGGER orders_tip_prueba
BEFORE INSERT ON catalogo_tipo_prueba
FOR EACH ROW
BEGIN
  SELECT SEQUENCE_TIPOPRUEBA.nextval
INTO   :new.PK_CAT_TIPO_PRUEBA
   FROM   dual;
END;
/
CREATE OR REPLACE TRIGGER orders_tip_ref
BEFORE INSERT ON catalogo_tipo_referencia
FOR EACH ROW
BEGIN
  SELECT SEQUENCE_TIPOREFERENCIA.nextval
INTO   :new.PK_tipo_referencia
   FROM   dual;
END;
/
CREATE OR REPLACE TRIGGER orders_pais
BEFORE INSERT ON pais
FOR EACH ROW
BEGIN
  SELECT SEQUENCE_PAIS.nextval
INTO   :new.PK_pais
   FROM   dual;
END;
/
CREATE OR REPLACE TRIGGER orders_departamento
BEFORE INSERT ON departamento
FOR EACH ROW
BEGIN
  SELECT SEQUENCE_DEPARTAMENTO.nextval
INTO   :new.PK_departamento
   FROM   dual;
END;
/
CREATE OR REPLACE TRIGGER orders_municipio
BEFORE INSERT ON municipio
FOR EACH ROW
BEGIN
  SELECT SEQUENCE_MUNICIPIO.nextval
INTO   :new.PK_municipio
   FROM   dual;
END;