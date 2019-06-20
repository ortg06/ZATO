
INSERT INTO PAIS (PK_PAIS, NOMBRE_PAIS) VALUES ('1', 'El Salvador');
INSERT INTO PAIS (PK_PAIS, NOMBRE_PAIS) VALUES ('2', 'Guatemala');
INSERT INTO PAIS (PK_PAIS, NOMBRE_PAIS) VALUES ('3', 'Honduras');

--ROLES--
INSERT INTO ROL (PK_ROL, NOMBRE_ROL) VALUES ('1', 'Candidato');
INSERT INTO ROL (PK_ROL, NOMBRE_ROL) VALUES ('2', 'Empresa');
INSERT INTO ROL (PK_ROL, NOMBRE_ROL) VALUES ('3', 'Administrador');

-- GENERO--
INSERT INTO CATALOGO_GENERO (PK_GENERO, NOMBRE_GENERO) VALUES ('1', 'Masculino');
INSERT INTO CATALOGO_GENERO (PK_GENERO, NOMBRE_GENERO) VALUES ('2', 'Femenino');
-- DEPARTAMENTO--
INSERT INTO DEPARTAMENTO (PK_DEPARTAMENTO, NOMBRE_DEPARTAMENTO, PK_PAIS) VALUES ('1', 'La Libertad', '1');

--MUNICIPIO--
INSERT INTO MUNICIPIO (PK_MUNICIPIO, NOMBRE_MUNICIPIO,PK_DEPARTAMENTO) VALUES ('1', 'Santa Tecla', '1');

-- CANDIDATO--
INSERT INTO CANDIDATO (PK_CANDIDATO, NOMBRE_CANDIDATO, APELLIDO_CANDIDATO,CELULAR, DIRECCION, DUI,FECHA_NACIMIENTO,NACIONALIDAD, NIT,NUP, PASAPORTE,TELEFONO,TWITTER,FACEBOOK,PK_GENERO,PK_MUNICIPIO,FOTO_CANDIDATO) 
VALUES ('1', 'JUAN','LOPEZ','55555555','Santa tecla','12345678','13/06/19','Salvadoreña','1234567890','0987654321','0987654321','123456','','','1','1','');

-- MENU --
INSERT INTO MENU (PK_MENU,MENU) VALUES (1,'Administración');
INSERT INTO MENU (PK_MENU,MENU) VALUES (2,'Usuarios');
INSERT INTO MENU (PK_MENU,MENU) VALUES (3,'Perfil Candidato');
INSERT INTO MENU (PK_MENU,MENU) VALUES (4,'Perfil Empresa');

-- SUBMENU --

INSERT INTO SUBMENU (PK_SUBMENU,PK_MENU,SUBMENU,ORDEN,URL) VALUES(1,1,'Catálogo Rol',1,'/Rol/listar');
INSERT INTO SUBMENU (PK_SUBMENU,PK_MENU,SUBMENU,ORDEN,URL) VALUES(2,1,'Catálogo Menu',2,'/Menu/listar');
INSERT INTO SUBMENU (PK_SUBMENU,PK_MENU,SUBMENU,ORDEN,URL) VALUES(3,1,'Catálogo Submenu',3,'/submenu/listar');
INSERT INTO SUBMENU (PK_SUBMENU,PK_MENU,SUBMENU,ORDEN,URL) VALUES(4,1,'Catálogo Rol submenu',4,'/Rolsubmenu/listar');
INSERT INTO SUBMENU (PK_SUBMENU,PK_MENU,SUBMENU,ORDEN,URL) VALUES(5,1,'Catálogo Pais',5,'/Pais/listar');
INSERT INTO SUBMENU (PK_SUBMENU,PK_MENU,SUBMENU,ORDEN,URL) VALUES(6,1,'Catálogo Departamento',6,'/departamento/listar');
INSERT INTO SUBMENU (PK_SUBMENU,PK_MENU,SUBMENU,ORDEN,URL) VALUES(7,1,'Catálogo Municipio',7,'/municipio/listar');
INSERT INTO SUBMENU (PK_SUBMENU,PK_MENU,SUBMENU,ORDEN,URL) VALUES(8,1,'Catálogo Idiomas',8,'/CatalogoIdioma/listar');
INSERT INTO SUBMENU (PK_SUBMENU,PK_MENU,SUBMENU,ORDEN,URL) VALUES(9,1,'Catálogo Genero',9,'/catalogoGenero/listar');
INSERT INTO SUBMENU (PK_SUBMENU,PK_MENU,SUBMENU,ORDEN,URL) VALUES(10,1,'Catálogo Aptitudes',10,'/catalogoAptitud/listar');
INSERT INTO SUBMENU (PK_SUBMENU,PK_MENU,SUBMENU,ORDEN,URL) VALUES(11,1,'Catálogo Grado Academico',11,'/catalogoGradoAcademico/listar');
INSERT INTO SUBMENU (PK_SUBMENU,PK_MENU,SUBMENU,ORDEN,URL) VALUES(12,1,'Catálogo Categoria',12,'/Categoria/listar');
INSERT INTO SUBMENU (PK_SUBMENU,PK_MENU,SUBMENU,ORDEN,URL) VALUES(13,1,'Catálogo Puestos',13,'/CatalogoPuesto/listar');
INSERT INTO SUBMENU (PK_SUBMENU,PK_MENU,SUBMENU,ORDEN,URL) VALUES(14,1,'Catálogo Ponderaciones',14,'/CatalogoPonderacion/listar');
INSERT INTO SUBMENU (PK_SUBMENU,PK_MENU,SUBMENU,ORDEN,URL) VALUES(15,1,'Catálogo Categoria habilidad',15,'/catalogoCategoriaHabilidad/listar');
INSERT INTO SUBMENU (PK_SUBMENU,PK_MENU,SUBMENU,ORDEN,URL) VALUES(16,1,'Catálogo Habilidad',16,'/CatalogoHabilidad/listar');
INSERT INTO SUBMENU (PK_SUBMENU,PK_MENU,SUBMENU,ORDEN,URL) VALUES(17,1,'Catálogo Sector empresa',17,'/Sector/listar');
INSERT INTO SUBMENU (PK_SUBMENU,PK_MENU,SUBMENU,ORDEN,URL) VALUES(18,1,'Catálogo Tipo de empresa',18,'/TipoEmpresa/listar');
INSERT INTO SUBMENU (PK_SUBMENU,PK_MENU,SUBMENU,ORDEN,URL) VALUES(19,1,'Catálogo Tipo de licencia',19,'/catalogoLicencia/listar');
INSERT INTO SUBMENU (PK_SUBMENU,PK_MENU,SUBMENU,ORDEN,URL) VALUES(20,1,'Catálogo Tipo de referencia',20,'/catalogoTipoReferencia/listar');
INSERT INTO SUBMENU (PK_SUBMENU,PK_MENU,SUBMENU,ORDEN,URL) VALUES(21,1,'Catálogo Tipo de escritos',21,'/catalogoEscrito/listar');
INSERT INTO SUBMENU (PK_SUBMENU,PK_MENU,SUBMENU,ORDEN,URL) VALUES(22,1,'Catálogo Tipo de Prueba',22,'/catalogoTipoPrueba/listar');
INSERT INTO SUBMENU (PK_SUBMENU,PK_MENU,SUBMENU,ORDEN,URL) VALUES(23,2,'Usuarios',1,'/Perfil/listar');


-- ROL SUBMENU --

INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(1,3,1);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(2,3,2);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(3,3,3);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(4,3,4);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(5,3,5);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(6,3,6);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(7,3,7);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(8,3,8);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(9,3,9);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(10,3,10);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(11,3,11);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(12,3,12);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(13,3,13);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(14,3,14);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(15,3,15);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(16,3,16);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(17,3,17);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(18,3,18);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(19,3,19);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(20,3,20);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(21,3,21);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(22,3,22);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(23,3,23);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(24,3,24);
INSERT INTO ROL_SUBMENU(ID_ROL_SUBMENU,PK_ROL,PK_SUBMENU) VALUES(25,3,25);

