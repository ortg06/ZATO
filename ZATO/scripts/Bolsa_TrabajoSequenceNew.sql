/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     10/6/2019 16:13:12                           */
/*==============================================================*/


alter table APTITUD_CV
   drop constraint FK_APTITUD__CV;

alter table APTITUD_CV
   drop constraint FK_APTITUDCV__CATALOGOAPT;

alter table APTITUD_OFERTA
   drop constraint FK_APTITUDOF_OFERTA;

alter table APTITUD_OFERTA
   drop constraint FK_APTITUDOF_CATALOGOAPT;

alter table CANDIDATO
   drop constraint FK_CANDIDATO_GENERO;

alter table CANDIDATO
   drop constraint FK_CANDIDATO_MUNICIPIO;

alter table CATALOGO_HABILIDAD
   drop constraint FK_CATALOGOHAB_CATEGORIA;

alter table CATALOGO_PUESTO
   drop constraint FK_CATALOGOPUESTO_CATEGORIA;

alter table CONOCIMIENTO_ACADEMICOS
   drop constraint FK_CONOCIMIENTOAC_OFERTA;

alter table CONOCIMIENTO_ACADEMICOS
   drop constraint FK_CONOCIMITOAC_GRADOAC;

alter table CURSO_CAPACITACION
   drop constraint FK_CURSOCAP_CV;

alter table CV
   drop constraint FK_CV_CANDIDATO;

alter table DEPARTAMENTO
   drop constraint FK_DEPARTAM_DEPTO_PAI_PAIS;

alter table EMPRESA
   drop constraint FK_EMPRESA_MUNICIPIO;

alter table EMPRESA
   drop constraint FK_EMPRESA_SECTOR;

alter table EMPRESA
   drop constraint FK_EMPRESA_TIPOEMPRESA;

alter table ESCRITO
   drop constraint FK_ESCRITO_CATALOGOESCRITO;

alter table ESCRITO
   drop constraint FK_ESCRITO_CV;

alter table EVENTO
   drop constraint FK_EVENTO_CV;

alter table EVENTO
   drop constraint FK_EVENTO_PAIS;

alter table EXPERIENCIA_LABORAL
   drop constraint FK_EXPERIENLAB_CV;

alter table EXPERIENCIA_LABORAL
   drop constraint FK_EXPERIENLAB_SECTOR;

alter table FORMACION_ACADEMICA
   drop constraint FK_FORMACIONAC_GRADOAC;

alter table FORMACION_ACADEMICA
   drop constraint FK_FORMACIONAC_CV;

alter table HABILIDADES_CV
   drop constraint FK_HABILIDADCV_CV;

alter table HABILIDADES_CV
   drop constraint FK_HABILIDADCV_CATALOGOHAB;

alter table HABILIDAD_LINGUISICA_OFERTA
   drop constraint FK_HABLING_CATALOGOIDIOMA;

alter table HABILIDAD_LINGUISICA_OFERTA
   drop constraint FK_HABLING_CATALOGOPOND;

alter table HABILIDAD_LINGUISICA_OFERTA
   drop constraint FK_HABLING_OFERTA;

alter table HABILIDAD_LINGUISTICA_CV
   drop constraint FK_HABLINGCV_CV;

alter table HABILIDAD_LINGUISTICA_CV
   drop constraint FK_HABLINGCV_PONDERACION;

alter table HABILIDAD_LINGUISTICA_CV
   drop constraint FK_HANLINGCV_IDIOMA;

alter table HABILIDAD_OFERTA
   drop constraint FK_HABILIDADOF_OFERTA;

alter table HABILIDAD_OFERTA
   drop constraint FK_HABILIDADOF_CATALOGOHAB;

alter table ITEM_PRUEBA
   drop constraint FK_ITEMPRU_PRUEBA;

alter table LICENCIA_CANDIDATO
   drop constraint FK_LICENCIACAND_CV;

alter table LICENCIA_CANDIDATO
   drop constraint FK_LICENCIACAND_CATALOGOLIC;

alter table LICENCIA_OFERTA
   drop constraint FK_LICENCIAOF_OFERTA;

alter table LICENCIA_OFERTA
   drop constraint FK_LICENCIAOF_CATALOGOLIC;

alter table LOGRO
   drop constraint FK_LOGRO_CV;

alter table MUNICIPIO
   drop constraint FK_MUNICIPIO_DEPTO;

alter table OFERTA
   drop constraint FK_OFERTA_EMPRESA;

alter table OFERTA
   drop constraint FK_OFERTA_MUNICIPIO;

alter table OFERTA
   drop constraint FK_OFERTA_PUESTO;

alter table OPCIONES
   drop constraint FK_OPCIONES_ITEMPRUEBA;

alter table PERFIL
   drop constraint FK_PERFIL_CANDIDATO;

alter table PERFIL
   drop constraint FK_PERFIL_EMPRESA;

alter table PERFIL
   drop constraint FK_PERFIL_PERFIL_RO_ROL;

alter table POSTULACION
   drop constraint FK_POSTULACION_CV;

alter table POSTULACION
   drop constraint FK_POSTULACION_OFERTA;

alter table PRUEBA
   drop constraint FK_PRUEBA_PRUEBAOFERTA;

alter table PRUEBA
   drop constraint FK_PRUEBA_CATALOGOTIPOPRU;

alter table REFERENCIA
   drop constraint FK_REFERENCIA_CV;

alter table REFERENCIA
   drop constraint FK_REFERENCIA_TIPOREF;

alter table RESULTADO
   drop constraint FK_RESULTAD_POSTULACION;

alter table RESULTADO
   drop constraint FK_RESULTADO_PRUEBA;

alter table ROL_SUBMENU
   drop constraint FK_ROLSUBMU_SUBMENU;

alter table ROL_SUBMENU
   drop constraint FK_ROLSUBMU_ROL;

alter table SUBMENU
   drop constraint FK_SUBMENU_MENU;

drop index APT_CATAPT_CV_FK;

drop index APTITUD_CV_FK;

drop table APTITUD_CV cascade constraints;

drop index APT_CATAPT_OF_FK;

drop index APTOF_OF_FK;

drop table APTITUD_OFERTA cascade constraints;

drop index CAND_MUNICIPIO_FK;

drop index CAND_GENERO_FK;

drop table CANDIDATO cascade constraints;

drop table CATALOGO_APTITUD cascade constraints;

drop table CATALOGO_CATEGORIA cascade constraints;

drop table CATALOGO_CATEGORIA_HABILIDAD cascade constraints;

drop table CATALOGO_ESCRITO cascade constraints;

drop table CATALOGO_GENERO cascade constraints;

drop table CATALOGO_GRADO_ACADEMICO cascade constraints;

drop index CATHAB_CATG_FK;

drop table CATALOGO_HABILIDAD cascade constraints;

drop table CATALOGO_IDIOMA cascade constraints;

drop table CATALOGO_LICENCIA cascade constraints;

drop table CATALOGO_PONDERACION cascade constraints;

drop index PUESTO_CATEGORIA_FK;

drop table CATALOGO_PUESTO cascade constraints;

drop table CATALOGO_SECTOR_EMPRESA cascade constraints;

drop table CATALOGO_TIPO_EMPRESA cascade constraints;

drop table CATALOGO_TIPO_PRUEBA cascade constraints;

drop table CATALOGO_TIPO_REFERENCIA cascade constraints;

drop index CONACAD_CATACAD_OF_FK;

drop index CONACADEMICO_EMP_FK;

drop table CONOCIMIENTO_ACADEMICOS cascade constraints;

drop index CUR_CAP_CV_FK;

drop table CURSO_CAPACITACION cascade constraints;

drop index CV_CAND_FK;

drop table CV cascade constraints;

drop index DEPTO_PAIS_FK;

drop table DEPARTAMENTO cascade constraints;

drop index EMP_MUNICIPIO_FK;

drop index EMP_TIPOEMP_FK;

drop index EMP_SECTOR_FK;

drop table EMPRESA cascade constraints;

drop index ESCRITO_CATESCR_FK;

drop index ESCRITO_CV_FK;

drop table ESCRITO cascade constraints;

drop index EVENTO_PAIS_FK;

drop index EVENTO_CV_FK;

drop table EVENTO cascade constraints;

drop index EXPLAB_SECTOR_FK;

drop index EXPLAB_CV_FK;

drop table EXPERIENCIA_LABORAL cascade constraints;

drop index FORMAC_CATGRACAD_CV_FK;

drop index FORMAC_CV_FK;

drop table FORMACION_ACADEMICA cascade constraints;

drop index HAB_CATHAB_CV_FK;

drop index HABILIDAD_CV_FK;

drop table HABILIDADES_CV cascade constraints;

drop index HABLING_CATIDIOMA_OF_FK;

drop index HABLING_CATPOND_OF_FK;

drop index HABLING_OF_FK;

drop table HABILIDAD_LINGUISICA_OFERTA cascade constraints;

drop index HABLING_POND_CV_FK;

drop index HANLING_CATIDIOMA_CV_FK;

drop index HABLING_CV_FK;

drop table HABILIDAD_LINGUISTICA_CV cascade constraints;

drop index HAB_CATHAB_OF_FK;

drop index HABOF_OF_FK;

drop table HABILIDAD_OFERTA cascade constraints;

drop index ITEM_PRUEBA_FK;

drop table ITEM_PRUEBA cascade constraints;

drop index LIC_CV_FK;

drop index LIC_CV_CATLIC_FK;

drop table LICENCIA_CANDIDATO cascade constraints;

drop index LIC_OF_FK;

drop index LIC_OF_CATLIC_FK;

drop table LICENCIA_OFERTA cascade constraints;

drop index LOGRO_CV_FK;

drop table LOGRO cascade constraints;

drop table MENU cascade constraints;

drop index MUN_DEPTO_FK;

drop table MUNICIPIO cascade constraints;

drop index OF_MUNICIPIO_FK;

drop index OF_PUESTO_FK;

drop index EMPRESA_OF_FK;

drop table OFERTA cascade constraints;

drop index OPC_ITEM_FK;

drop table OPCIONES cascade constraints;

drop table PAIS cascade constraints;

drop index PERFIL_ROL_FK;

drop index PERFIL_EMP_FK;

drop index PERFIL_CAND_FK;

drop table PERFIL cascade constraints;

drop index POSTULACION_OF_FK;

drop index POSTULACION_CV_FK;

drop table POSTULACION cascade constraints;

drop index PRUEBA_TIPOPRUEBA_FK;

drop index PRUEBA_OF_FK;

drop table PRUEBA cascade constraints;

drop index REFERENCIA_CV_FK;

drop index REFERENCIA_TIPOREF_FK;

drop table REFERENCIA cascade constraints;

drop index POSTULACION_RESUL_FK;

drop index PRUEBA_RESUL_FK;

drop table RESULTADO cascade constraints;

drop table ROL cascade constraints;

drop index ROLSUBMENU_MENU_FK;

drop index ROLSUBMENU_ROL_FK;

drop table ROL_SUBMENU cascade constraints;

drop index SUBMENU_MENU_FK;

drop table SUBMENU cascade constraints;

drop sequence SEQUENCE_APTITUDCV;

drop sequence SEQUENCE_APTITUDOFERTA;

drop sequence SEQUENCE_CANDIDATO;

drop sequence SEQUENCE_CATALOGOAPTITUD;

drop sequence SEQUENCE_CATALOGOESCRITO;

drop sequence SEQUENCE_CATALOGOIDIOMA;

drop sequence SEQUENCE_CATALOGOLICENCIA;

drop sequence SEQUENCE_CATALOGOPONDERACION;

drop sequence SEQUENCE_CATEGORIA;

drop sequence SEQUENCE_CATEGORIAHABILIDAD;

drop sequence SEQUENCE_CONOCIMIENTOACADEMICO;

drop sequence SEQUENCE_CURSOCAPACITACION;

drop sequence SEQUENCE_CV;

drop sequence SEQUENCE_DEPARTAMENTO;

drop sequence SEQUENCE_EMPRESA;

drop sequence SEQUENCE_ESCRITO;

drop sequence SEQUENCE_EVENTO;

drop sequence SEQUENCE_EXPERIENCIALABORAL;

drop sequence SEQUENCE_FORMACIONACADEMICA;

drop sequence SEQUENCE_GENERO;

drop sequence SEQUENCE_GRADOACADEMICO;

drop sequence SEQUENCE_HABILIDAD;

drop sequence SEQUENCE_HABILIDADESCV;

drop sequence SEQUENCE_HABILIDADLINGCV;

drop sequence SEQUENCE_HABILIDADLINGOF;

drop sequence SEQUENCE_HABILIDADOFERTA;

drop sequence SEQUENCE_ITEMPRUEBA;

drop sequence SEQUENCE_LICENCIACANDIDATO;

drop sequence SEQUENCE_LICENCIAOFERTA;

drop sequence SEQUENCE_LOGRO;

drop sequence SEQUENCE_MENU;

drop sequence SEQUENCE_MUNICIPIO;

drop sequence SEQUENCE_OFERTA;

drop sequence SEQUENCE_OPCIONES;

drop sequence SEQUENCE_PAIS;

drop sequence SEQUENCE_PERFIL;

drop sequence SEQUENCE_POSTULACION;

drop sequence SEQUENCE_PRUEBA;

drop sequence SEQUENCE_PUESTO;

drop sequence SEQUENCE_REFERENCIA;

drop sequence SEQUENCE_RESULTADO;

drop sequence SEQUENCE_ROL;

drop sequence SEQUENCE_ROLSUBMENU;

drop sequence SEQUENCE_SECTOR;

drop sequence SEQUENCE_SUBMENU;

drop sequence SEQUENCE_TIPOEMPRESA;

drop sequence SEQUENCE_TIPOPRUEBA;

drop sequence SEQUENCE_TIPOREFERENCIA;

create sequence SEQUENCE_APTITUDCV
increment by 1
start with 1;

create sequence SEQUENCE_APTITUDOFERTA
increment by 1
start with 1;

create sequence SEQUENCE_CANDIDATO
increment by 1
start with 1;

create sequence SEQUENCE_CATALOGOAPTITUD
increment by 1
start with 1;

create sequence SEQUENCE_CATALOGOESCRITO
increment by 1
start with 1;

create sequence SEQUENCE_CATALOGOIDIOMA
increment by 1
start with 1;

create sequence SEQUENCE_CATALOGOLICENCIA
increment by 1
start with 1;

create sequence SEQUENCE_CATALOGOPONDERACION
increment by 1
start with 1;

create sequence SEQUENCE_CATEGORIA
increment by 1
start with 1;

create sequence SEQUENCE_CATEGORIAHABILIDAD
increment by 1
start with 1;

create sequence SEQUENCE_CONOCIMIENTOACADEMICO
increment by 1
start with 1;

create sequence SEQUENCE_CURSOCAPACITACION
increment by 1
start with 1;

create sequence SEQUENCE_CV
increment by 1
start with 1;

create sequence SEQUENCE_DEPARTAMENTO
increment by 1
start with 1;

create sequence SEQUENCE_EMPRESA
increment by 1
start with 1;

create sequence SEQUENCE_ESCRITO
increment by 1
start with 1;

create sequence SEQUENCE_EVENTO
increment by 1
start with 1;

create sequence SEQUENCE_EXPERIENCIALABORAL
increment by 1
start with 1;

create sequence SEQUENCE_FORMACIONACADEMICA
increment by 1
start with 1;

create sequence SEQUENCE_GENERO
increment by 1
start with 1;

create sequence SEQUENCE_GRADOACADEMICO
increment by 1
start with 1;

create sequence SEQUENCE_HABILIDAD
increment by 1
start with 1;

create sequence SEQUENCE_HABILIDADESCV
increment by 1
start with 1;

create sequence SEQUENCE_HABILIDADLINGCV
increment by 1
start with 1;

create sequence SEQUENCE_HABILIDADLINGOF
increment by 1
start with 1;

create sequence SEQUENCE_HABILIDADOFERTA
increment by 1
start with 1;

create sequence SEQUENCE_ITEMPRUEBA
increment by 1
start with 1;

create sequence SEQUENCE_LICENCIACANDIDATO
increment by 1
start with 1;

create sequence SEQUENCE_LICENCIAOFERTA
increment by 1
start with 1;

create sequence SEQUENCE_LOGRO
increment by 1
start with 1;

create sequence SEQUENCE_MENU
increment by 1
start with 1;

create sequence SEQUENCE_MUNICIPIO
increment by 1
start with 1;

create sequence SEQUENCE_OFERTA
increment by 1
start with 1;

create sequence SEQUENCE_OPCIONES
increment by 1
start with 1;

create sequence SEQUENCE_PAIS
increment by 1
start with 1;

create sequence SEQUENCE_PERFIL
increment by 1
start with 1;

create sequence SEQUENCE_POSTULACION
increment by 1
start with 1;

create sequence SEQUENCE_PRUEBA
increment by 1
start with 1;

create sequence SEQUENCE_PUESTO
increment by 1
start with 1;

create sequence SEQUENCE_REFERENCIA
increment by 1
start with 1;

create sequence SEQUENCE_RESULTADO
increment by 1
start with 1;

create sequence SEQUENCE_ROL
increment by 1
start with 1;

create sequence SEQUENCE_ROLSUBMENU
increment by 1
start with 1;

create sequence SEQUENCE_SECTOR
increment by 1
start with 1;

create sequence SEQUENCE_SUBMENU
increment by 1
start with 1;

create sequence SEQUENCE_TIPOEMPRESA
increment by 1
start with 1;

create sequence SEQUENCE_TIPOPRUEBA
increment by 1
start with 1;

create sequence SEQUENCE_TIPOREFERENCIA
increment by 1
start with 1;

/*==============================================================*/
/* Table: APTITUD_CV                                            */
/*==============================================================*/
create table APTITUD_CV 
(
   PK_APTITUD_CV        NUMBER(6)            not null,
   PK_CV                INTEGER              not null,
   PK_CATALOGO_APTITUD  INTEGER              not null,
   constraint PK_APTITUD_CV primary key (PK_APTITUD_CV)
);

/*==============================================================*/
/* Index: APTITUD_CV_FK                                         */
/*==============================================================*/
create index APTITUD_CV_FK on APTITUD_CV (
   PK_CV ASC
);

/*==============================================================*/
/* Index: APT_CATAPT_CV_FK                                      */
/*==============================================================*/
create index APT_CATAPT_CV_FK on APTITUD_CV (
   PK_CATALOGO_APTITUD ASC
);

/*==============================================================*/
/* Table: APTITUD_OFERTA                                        */
/*==============================================================*/
create table APTITUD_OFERTA 
(
   PK_APTITUD_OFERTA    NUMBER(6)            not null,
   PK_OFERTA            INTEGER              not null,
   PK_CATALOGO_APTITUD  INTEGER              not null,
   constraint PK_APTITUD_OFERTA primary key (PK_APTITUD_OFERTA)
);

/*==============================================================*/
/* Index: APTOF_OF_FK                                           */
/*==============================================================*/
create index APTOF_OF_FK on APTITUD_OFERTA (
   PK_OFERTA ASC
);

/*==============================================================*/
/* Index: APT_CATAPT_OF_FK                                      */
/*==============================================================*/
create index APT_CATAPT_OF_FK on APTITUD_OFERTA (
   PK_CATALOGO_APTITUD ASC
);

/*==============================================================*/
/* Table: CANDIDATO                                             */
/*==============================================================*/
create table CANDIDATO 
(
   PK_CANDIDATO         NUMBER(6)            not null,
   PK_GENERO            INTEGER              not null,
   PK_MUNICIPIO         INTEGER,
   NOMBRE_CANDIDATO     VARCHAR2(100)        not null,
   APELLIDO_CANDIDATO   VARCHAR2(100)        not null,
   NACIONALIDAD         VARCHAR2(20)         not null,
   DUI                  NUMBER(9)            not null,
   NIT                  NUMBER(14)           not null,
   NUP                  NUMBER(14),
   FECHA_NACIMIENTO     DATE                 not null,
   DIRECCION            VARCHAR2(250)        not null,
   TELEFONO             NUMBER(10),
   CELULAR              NUMBER(10),
   FACEBOOK             VARCHAR2(50),
   TWITTER              VARCHAR2(50),
   PASAPORTE            VARCHAR2(14),
   FOTO_CANDIDATO       BLOB,
   constraint PK_CANDIDATO primary key (PK_CANDIDATO)
);

/*==============================================================*/
/* Index: CAND_GENERO_FK                                        */
/*==============================================================*/
create index CAND_GENERO_FK on CANDIDATO (
   PK_GENERO ASC
);

/*==============================================================*/
/* Index: CAND_MUNICIPIO_FK                                     */
/*==============================================================*/
create index CAND_MUNICIPIO_FK on CANDIDATO (
   PK_MUNICIPIO ASC
);

/*==============================================================*/
/* Table: CATALOGO_APTITUD                                      */
/*==============================================================*/
create table CATALOGO_APTITUD 
(
   PK_CATALOGO_APTITUD  NUMBER(6)            not null,
   NOMBRE_APTITUD       VARCHAR2(50)         not null,
   constraint PK_CATALOGO_APTITUD primary key (PK_CATALOGO_APTITUD)
);

/*==============================================================*/
/* Table: CATALOGO_CATEGORIA                                    */
/*==============================================================*/
create table CATALOGO_CATEGORIA 
(
   PK_CATALOGO_CATEGORIA NUMBER(6)            not null,
   NOMBRE_CATALOGO_CATEGORIA VARCHAR2(50)         not null,
   constraint PK_CATALOGO_CATEGORIA primary key (PK_CATALOGO_CATEGORIA)
);

/*==============================================================*/
/* Table: CATALOGO_CATEGORIA_HABILIDAD                          */
/*==============================================================*/
create table CATALOGO_CATEGORIA_HABILIDAD 
(
   PK_CATEGORIA_HABILIDAD NUMBER(6)            not null,
   NOMBRE_CATEGORIA_HABILIDAD VARCHAR2(50)         not null,
   constraint PK_CATALOGO_CATEGORIA_HABILIDA primary key (PK_CATEGORIA_HABILIDAD)
);

/*==============================================================*/
/* Table: CATALOGO_ESCRITO                                      */
/*==============================================================*/
create table CATALOGO_ESCRITO 
(
   PK_CATALOGO_ESCRITO  NUMBER(6)            not null,
   NOMBRE_TIPO_ESCRITO  VARCHAR2(100)        not null,
   constraint PK_CATALOGO_ESCRITO primary key (PK_CATALOGO_ESCRITO)
);

/*==============================================================*/
/* Table: CATALOGO_GENERO                                       */
/*==============================================================*/
create table CATALOGO_GENERO 
(
   PK_GENERO            NUMBER(6)            not null,
   NOMBRE_GENERO        VARCHAR2(50)         not null,
   constraint PK_CATALOGO_GENERO primary key (PK_GENERO)
);

/*==============================================================*/
/* Table: CATALOGO_GRADO_ACADEMICO                              */
/*==============================================================*/
create table CATALOGO_GRADO_ACADEMICO 
(
   PK_GRADO_ACADEMICO   NUMBER(6)            not null,
   NOMBRE_GRADO_ACADEMICO VARCHAR2(100)        not null,
   constraint PK_CATALOGO_GRADO_ACADEMICO primary key (PK_GRADO_ACADEMICO)
);

/*==============================================================*/
/* Table: CATALOGO_HABILIDAD                                    */
/*==============================================================*/
create table CATALOGO_HABILIDAD 
(
   PK_HABILIDAD         NUMBER(6)            not null,
   PK_CATEGORIA_HABILIDAD INTEGER              not null,
   NOMBRE_HABILIDAD     VARCHAR2(100)        not null,
   constraint PK_CATALOGO_HABILIDAD primary key (PK_HABILIDAD)
);

/*==============================================================*/
/* Index: CATHAB_CATG_FK                                        */
/*==============================================================*/
create index CATHAB_CATG_FK on CATALOGO_HABILIDAD (
   PK_CATEGORIA_HABILIDAD ASC
);

/*==============================================================*/
/* Table: CATALOGO_IDIOMA                                       */
/*==============================================================*/
create table CATALOGO_IDIOMA 
(
   PK_IDIOMA            NUMBER(6)            not null,
   NOMBRE_IDIOMA        VARCHAR2(25)         not null,
   constraint PK_CATALOGO_IDIOMA primary key (PK_IDIOMA)
);

/*==============================================================*/
/* Table: CATALOGO_LICENCIA                                     */
/*==============================================================*/
create table CATALOGO_LICENCIA 
(
   PK_CATALOGO_LICENCIA NUMBER(6)            not null,
   NOMBRE_TIPO_LICENCIA VARCHAR2(50)         not null,
   constraint PK_CATALOGO_LICENCIA primary key (PK_CATALOGO_LICENCIA)
);

/*==============================================================*/
/* Table: CATALOGO_PONDERACION                                  */
/*==============================================================*/
create table CATALOGO_PONDERACION 
(
   PK_CATALOGO_PONDERACION NUMBER(6)            not null,
   ETIQUETA_PONDERACION VARCHAR2(25)         not null,
   DESCRIPCION_ETIQUETA VARCHAR2(100)        not null,
   constraint PK_CATALOGO_PONDERACION primary key (PK_CATALOGO_PONDERACION)
);

/*==============================================================*/
/* Table: CATALOGO_PUESTO                                       */
/*==============================================================*/
create table CATALOGO_PUESTO 
(
   PK_CATALOGO_PUESTO   NUMBER(6)            not null,
   PK_CATALOGO_CATEGORIA INTEGER              not null,
   NOMBRE_CATALOGO_PUESTO VARCHAR2(50)         not null,
   constraint PK_CATALOGO_PUESTO primary key (PK_CATALOGO_PUESTO)
);

/*==============================================================*/
/* Index: PUESTO_CATEGORIA_FK                                   */
/*==============================================================*/
create index PUESTO_CATEGORIA_FK on CATALOGO_PUESTO (
   PK_CATALOGO_CATEGORIA ASC
);

/*==============================================================*/
/* Table: CATALOGO_SECTOR_EMPRESA                               */
/*==============================================================*/
create table CATALOGO_SECTOR_EMPRESA 
(
   PK_SECTOR            NUMBER(6)            not null,
   NOMBRE_SECTOR        VARCHAR2(50)         not null,
   constraint PK_CATALOGO_SECTOR_EMPRESA primary key (PK_SECTOR)
);

/*==============================================================*/
/* Table: CATALOGO_TIPO_EMPRESA                                 */
/*==============================================================*/
create table CATALOGO_TIPO_EMPRESA 
(
   PK_TIPO_EMPRESA      NUMBER(6)            not null,
   NOMBRE_TIPO_EMPRESA  VARCHAR2(100)        not null,
   constraint PK_CATALOGO_TIPO_EMPRESA primary key (PK_TIPO_EMPRESA)
);

/*==============================================================*/
/* Table: CATALOGO_TIPO_PRUEBA                                  */
/*==============================================================*/
create table CATALOGO_TIPO_PRUEBA 
(
   PK_CAT_TIPO_PRUEBA   NUMBER(6)            not null,
   NOMBRE_TIPO_PRUEBA   VARCHAR2(100)        not null,
   constraint PK_CATALOGO_TIPO_PRUEBA primary key (PK_CAT_TIPO_PRUEBA)
);

/*==============================================================*/
/* Table: CATALOGO_TIPO_REFERENCIA                              */
/*==============================================================*/
create table CATALOGO_TIPO_REFERENCIA 
(
   PK_TIPO_REFERENCIA   NUMBER(6)            not null,
   TIPO_REFERENCIA      VARCHAR2(100)        not null,
   constraint PK_CATALOGO_TIPO_REFERENCIA primary key (PK_TIPO_REFERENCIA)
);

/*==============================================================*/
/* Table: CONOCIMIENTO_ACADEMICOS                               */
/*==============================================================*/
create table CONOCIMIENTO_ACADEMICOS 
(
   PK_CONOCIMIENTO_ACADEMICO NUMBER(6)            not null,
   PK_OFERTA            INTEGER              not null,
   PK_GRADO_ACADEMICO   INTEGER              not null,
   constraint PK_CONOCIMIENTO_ACADEMICOS primary key (PK_CONOCIMIENTO_ACADEMICO)
);

/*==============================================================*/
/* Index: CONACADEMICO_EMP_FK                                   */
/*==============================================================*/
create index CONACADEMICO_EMP_FK on CONOCIMIENTO_ACADEMICOS (
   PK_OFERTA ASC
);

/*==============================================================*/
/* Index: CONACAD_CATACAD_OF_FK                                 */
/*==============================================================*/
create index CONACAD_CATACAD_OF_FK on CONOCIMIENTO_ACADEMICOS (
   PK_GRADO_ACADEMICO ASC
);

/*==============================================================*/
/* Table: CURSO_CAPACITACION                                    */
/*==============================================================*/
create table CURSO_CAPACITACION 
(
   PK_CURSO_CAPACITACION NUMBER(6)            not null,
   PK_CV                INTEGER              not null,
   NOMBRE_CURSO_CAPACITACION VARCHAR2(200)        not null,
   FECHA_CURSO          DATE                 not null,
   NOMBRE_INSTITUTO_PONENTE VARCHAR2(250)        not null,
   DURACION             VARCHAR2(100),
   LUGAR_CAPACITACION   VARCHAR2(250)        not null,
   constraint PK_CURSO_CAPACITACION primary key (PK_CURSO_CAPACITACION)
);

/*==============================================================*/
/* Index: CUR_CAP_CV_FK                                         */
/*==============================================================*/
create index CUR_CAP_CV_FK on CURSO_CAPACITACION (
   PK_CV ASC
);

/*==============================================================*/
/* Table: CV                                                    */
/*==============================================================*/
create table CV 
(
   PK_CV                NUMBER(6)            not null,
   PK_CANDIDATO         INTEGER              not null,
   NOMBRE_CV            VARCHAR2(100)        not null,
   FECHA_REGISTRO       DATE                 not null,
   FECHA_ACTUALIZADO    DATE                 not null,
   constraint PK_CV primary key (PK_CV)
);

/*==============================================================*/
/* Index: CV_CAND_FK                                            */
/*==============================================================*/
create index CV_CAND_FK on CV (
   PK_CANDIDATO ASC
);

/*==============================================================*/
/* Table: DEPARTAMENTO                                          */
/*==============================================================*/
create table DEPARTAMENTO 
(
   PK_DEPARTAMENTO      NUMBER(6)            not null,
   PK_PAIS              INTEGER,
   NOMBRE_DEPARTAMENTO  VARCHAR2(50)         not null,
   constraint PK_DEPARTAMENTO primary key (PK_DEPARTAMENTO)
);

/*==============================================================*/
/* Index: DEPTO_PAIS_FK                                         */
/*==============================================================*/
create index DEPTO_PAIS_FK on DEPARTAMENTO (
   PK_PAIS ASC
);

/*==============================================================*/
/* Table: EMPRESA                                               */
/*==============================================================*/
create table EMPRESA 
(
   PK_EMPRESA           NUMBER(6)            not null,
   PK_SECTOR            INTEGER              not null,
   PK_TIPO_EMPRESA      INTEGER              not null,
   PK_MUNICIPIO         INTEGER,
   NOM_EMPRESA          VARCHAR2(100)        not null,
   NIT_EMPRESA          NUMBER(14)           not null,
   DIRECCION_EMPRESA    VARCHAR2(250)        not null,
   RAZON_SOCIAL         VARCHAR2(250)        not null,
   NUMERO_TRABAJADORES  INTEGER,
   DESCRIPCION_EMPRESA  VARCHAR2(250)        not null,
   PAGINA_WEB           VARCHAR2(100),
   LOGO_EMPRESA         BLOB,
   NOMBRE_CONTACTO_EMPRESA VARCHAR2(100)        not null,
   CARGO_CONTACTO       VARCHAR2(100),
   TELEFONO_CONTACTO    NUMBER(25)           not null,
   constraint PK_EMPRESA primary key (PK_EMPRESA)
);

/*==============================================================*/
/* Index: EMP_SECTOR_FK                                         */
/*==============================================================*/
create index EMP_SECTOR_FK on EMPRESA (
   PK_SECTOR ASC
);

/*==============================================================*/
/* Index: EMP_TIPOEMP_FK                                        */
/*==============================================================*/
create index EMP_TIPOEMP_FK on EMPRESA (
   PK_TIPO_EMPRESA ASC
);

/*==============================================================*/
/* Index: EMP_MUNICIPIO_FK                                      */
/*==============================================================*/
create index EMP_MUNICIPIO_FK on EMPRESA (
   PK_MUNICIPIO ASC
);

/*==============================================================*/
/* Table: ESCRITO                                               */
/*==============================================================*/
create table ESCRITO 
(
   PK_ESCRITO           NUMBER(6)            not null,
   PK_CV                INTEGER              not null,
   PK_CATALOGO_ESCRITO  INTEGER              not null,
   FECHA_PUBLICACION    DATE                 not null,
   LUGAR_PUBLICACION    VARCHAR2(150)        not null,
   NOMBRE_EDITOR        VARCHAR2(100)        not null,
   NOMBRE_ESCRITO       VARCHAR2(150)        not null,
   constraint PK_ESCRITO primary key (PK_ESCRITO)
);

/*==============================================================*/
/* Index: ESCRITO_CV_FK                                         */
/*==============================================================*/
create index ESCRITO_CV_FK on ESCRITO (
   PK_CV ASC
);

/*==============================================================*/
/* Index: ESCRITO_CATESCR_FK                                    */
/*==============================================================*/
create index ESCRITO_CATESCR_FK on ESCRITO (
   PK_CATALOGO_ESCRITO ASC
);

/*==============================================================*/
/* Table: EVENTO                                                */
/*==============================================================*/
create table EVENTO 
(
   PK_EVENTO            NUMBER(6)            not null,
   PK_CV                INTEGER              not null,
   PK_PAIS              INTEGER              not null,
   NOMBRE_EVENTO        VARCHAR2(250)        not null,
   DESCRIPCION_EVENTO   VARCHAR2(450)        not null,
   LUGAR_EVENTO         VARCHAR2(150)        not null,
   ANFITRION_EVENTO     VARCHAR2(100)        not null,
   FECHA_EVENTO         DATE                 not null,
   constraint PK_EVENTO primary key (PK_EVENTO)
);

/*==============================================================*/
/* Index: EVENTO_CV_FK                                          */
/*==============================================================*/
create index EVENTO_CV_FK on EVENTO (
   PK_CV ASC
);

/*==============================================================*/
/* Index: EVENTO_PAIS_FK                                        */
/*==============================================================*/
create index EVENTO_PAIS_FK on EVENTO (
   PK_PAIS ASC
);

/*==============================================================*/
/* Table: EXPERIENCIA_LABORAL                                   */
/*==============================================================*/
create table EXPERIENCIA_LABORAL 
(
   PK_EXPERIENCIA_LABORAL NUMBER(6)            not null,
   PK_CV                INTEGER              not null,
   PK_SECTOR            INTEGER              not null,
   NOMBRE_EXP_EMPRESA   VARCHAR2(150)        not null,
   CARGO                VARCHAR2(100)        not null,
   PERIODO_INICIO       DATE                 not null,
   PERIODO_FIN          DATE                 not null,
   DESCRIPCION_FUNCIONES VARCHAR2(1000)       not null,
   NOMBRE_CONTACTO_EXP  VARCHAR2(100),
   TELEFONO_CONTACTO_EXP NUMBER(14),
   CORREO_CONTACTO_EXP  VARCHAR2(100),
   constraint PK_EXPERIENCIA_LABORAL primary key (PK_EXPERIENCIA_LABORAL)
);

/*==============================================================*/
/* Index: EXPLAB_CV_FK                                          */
/*==============================================================*/
create index EXPLAB_CV_FK on EXPERIENCIA_LABORAL (
   PK_CV ASC
);

/*==============================================================*/
/* Index: EXPLAB_SECTOR_FK                                      */
/*==============================================================*/
create index EXPLAB_SECTOR_FK on EXPERIENCIA_LABORAL (
   PK_SECTOR ASC
);

/*==============================================================*/
/* Table: FORMACION_ACADEMICA                                   */
/*==============================================================*/
create table FORMACION_ACADEMICA 
(
   PK_FORMACION_ACADEMICA NUMBER(6)            not null,
   PK_CV                INTEGER              not null,
   PK_GRADO_ACADEMICO   INTEGER              not null,
   NOMBRE_INSTITUCION   VARCHAR2(100)        not null,
   ANO_INICIO           DATE                 not null,
   ANO_FIN              DATE,
   NOMBRE_TITULO        VARCHAR2(100)        not null,
   EN_CURSO             INTEGER,
   constraint PK_FORMACION_ACADEMICA primary key (PK_FORMACION_ACADEMICA)
);

/*==============================================================*/
/* Index: FORMAC_CV_FK                                          */
/*==============================================================*/
create index FORMAC_CV_FK on FORMACION_ACADEMICA (
   PK_CV ASC
);

/*==============================================================*/
/* Index: FORMAC_CATGRACAD_CV_FK                                */
/*==============================================================*/
create index FORMAC_CATGRACAD_CV_FK on FORMACION_ACADEMICA (
   PK_GRADO_ACADEMICO ASC
);

/*==============================================================*/
/* Table: HABILIDADES_CV                                        */
/*==============================================================*/
create table HABILIDADES_CV 
(
   PK_HABILIDADES_CV    NUMBER(6)            not null,
   PK_CV                INTEGER              not null,
   PK_HABILIDAD         INTEGER              not null,
   constraint PK_HABILIDADES_CV primary key (PK_HABILIDADES_CV)
);

/*==============================================================*/
/* Index: HABILIDAD_CV_FK                                       */
/*==============================================================*/
create index HABILIDAD_CV_FK on HABILIDADES_CV (
   PK_CV ASC
);

/*==============================================================*/
/* Index: HAB_CATHAB_CV_FK                                      */
/*==============================================================*/
create index HAB_CATHAB_CV_FK on HABILIDADES_CV (
   PK_HABILIDAD ASC
);

/*==============================================================*/
/* Table: HABILIDAD_LINGUISICA_OFERTA                           */
/*==============================================================*/
create table HABILIDAD_LINGUISICA_OFERTA 
(
   PK_HABILIDAD_LIN_OF  NUMBER(6)            not null,
   PK_OFERTA            INTEGER              not null,
   PK_CATALOGO_PONDERACION INTEGER              not null,
   PK_IDIOMA            INTEGER              not null,
   POND_CONVERSACION_OF INTEGER              not null,
   POND_ESCUCHA_OF      INTEGER              not null,
   POND_ESCRITO_OF      INTEGER              not null,
   POND_LECTURA_OF      INTEGER              not null,
   constraint PK_HABILIDAD_LINGUISICA_OFERTA primary key (PK_HABILIDAD_LIN_OF)
);

/*==============================================================*/
/* Index: HABLING_OF_FK                                         */
/*==============================================================*/
create index HABLING_OF_FK on HABILIDAD_LINGUISICA_OFERTA (
   PK_OFERTA ASC
);

/*==============================================================*/
/* Index: HABLING_CATPOND_OF_FK                                 */
/*==============================================================*/
create index HABLING_CATPOND_OF_FK on HABILIDAD_LINGUISICA_OFERTA (
   PK_CATALOGO_PONDERACION ASC
);

/*==============================================================*/
/* Index: HABLING_CATIDIOMA_OF_FK                               */
/*==============================================================*/
create index HABLING_CATIDIOMA_OF_FK on HABILIDAD_LINGUISICA_OFERTA (
   PK_IDIOMA ASC
);

/*==============================================================*/
/* Table: HABILIDAD_LINGUISTICA_CV                              */
/*==============================================================*/
create table HABILIDAD_LINGUISTICA_CV 
(
   PK_HAB_LING_CV       NUMBER(6)            not null,
   PK_CV                INTEGER              not null,
   PK_IDIOMA            INTEGER              not null,
   PK_CATALOGO_PONDERACION INTEGER              not null,
   POND_CONVERSACION_CV INTEGER              not null,
   POND_ESCUCHA_CV      INTEGER              not null,
   POND_ESCRITO_CV      INTEGER              not null,
   POND_LECTURA_CV      INTEGER              not null,
   constraint PK_HABILIDAD_LINGUISTICA_CV primary key (PK_HAB_LING_CV)
);

/*==============================================================*/
/* Index: HABLING_CV_FK                                         */
/*==============================================================*/
create index HABLING_CV_FK on HABILIDAD_LINGUISTICA_CV (
   PK_CV ASC
);

/*==============================================================*/
/* Index: HANLING_CATIDIOMA_CV_FK                               */
/*==============================================================*/
create index HANLING_CATIDIOMA_CV_FK on HABILIDAD_LINGUISTICA_CV (
   PK_IDIOMA ASC
);

/*==============================================================*/
/* Index: HABLING_POND_CV_FK                                    */
/*==============================================================*/
create index HABLING_POND_CV_FK on HABILIDAD_LINGUISTICA_CV (
   PK_CATALOGO_PONDERACION ASC
);

/*==============================================================*/
/* Table: HABILIDAD_OFERTA                                      */
/*==============================================================*/
create table HABILIDAD_OFERTA 
(
   PK_HABILIDAD_OFERTA  NUMBER(6)            not null,
   PK_OFERTA            INTEGER              not null,
   PK_HABILIDAD         INTEGER              not null,
   constraint PK_HABILIDAD_OFERTA primary key (PK_HABILIDAD_OFERTA)
);

/*==============================================================*/
/* Index: HABOF_OF_FK                                           */
/*==============================================================*/
create index HABOF_OF_FK on HABILIDAD_OFERTA (
   PK_OFERTA ASC
);

/*==============================================================*/
/* Index: HAB_CATHAB_OF_FK                                      */
/*==============================================================*/
create index HAB_CATHAB_OF_FK on HABILIDAD_OFERTA (
   PK_HABILIDAD ASC
);

/*==============================================================*/
/* Table: ITEM_PRUEBA                                           */
/*==============================================================*/
create table ITEM_PRUEBA 
(
   PK_ITEM              NUMBER(6)            not null,
   PK_PRUEBA            INTEGER              not null,
   PREGUNTA             VARCHAR2(450)        not null,
   constraint PK_ITEM_PRUEBA primary key (PK_ITEM)
);

/*==============================================================*/
/* Index: ITEM_PRUEBA_FK                                        */
/*==============================================================*/
create index ITEM_PRUEBA_FK on ITEM_PRUEBA (
   PK_PRUEBA ASC
);

/*==============================================================*/
/* Table: LICENCIA_CANDIDATO                                    */
/*==============================================================*/
create table LICENCIA_CANDIDATO 
(
   PK_LICENCIA_CANDIDATO NUMBER(6)            not null,
   PK_CATALOGO_LICENCIA INTEGER              not null,
   PK_CV                INTEGER,
   PK_CANDIDATO         INTEGER              not null,
   constraint PK_LICENCIA_CANDIDATO primary key (PK_LICENCIA_CANDIDATO)
);

/*==============================================================*/
/* Index: LIC_CV_CATLIC_FK                                      */
/*==============================================================*/
create index LIC_CV_CATLIC_FK on LICENCIA_CANDIDATO (
   PK_CATALOGO_LICENCIA ASC
);

/*==============================================================*/
/* Index: LIC_CV_FK                                             */
/*==============================================================*/
create index LIC_CV_FK on LICENCIA_CANDIDATO (
   PK_CV ASC
);

/*==============================================================*/
/* Table: LICENCIA_OFERTA                                       */
/*==============================================================*/
create table LICENCIA_OFERTA 
(
   PK_LICENCIA_OFERTA   NUMBER(6)            not null,
   PK_CATALOGO_LICENCIA INTEGER              not null,
   PK_OFERTA            INTEGER              not null,
   constraint PK_LICENCIA_OFERTA primary key (PK_LICENCIA_OFERTA)
);

/*==============================================================*/
/* Index: LIC_OF_CATLIC_FK                                      */
/*==============================================================*/
create index LIC_OF_CATLIC_FK on LICENCIA_OFERTA (
   PK_CATALOGO_LICENCIA ASC
);

/*==============================================================*/
/* Index: LIC_OF_FK                                             */
/*==============================================================*/
create index LIC_OF_FK on LICENCIA_OFERTA (
   PK_OFERTA ASC
);

/*==============================================================*/
/* Table: LOGRO                                                 */
/*==============================================================*/
create table LOGRO 
(
   PK_LOGRO             NUMBER(6)            not null,
   PK_CV                INTEGER              not null,
   NOMBRE_LOGRO         VARCHAR2(250)        not null,
   FECHA_LOGRO          DATE                 not null,
   DESCRIPCION_LOGRO    VARCHAR2(450)        not null,
   constraint PK_LOGRO primary key (PK_LOGRO)
);

/*==============================================================*/
/* Index: LOGRO_CV_FK                                           */
/*==============================================================*/
create index LOGRO_CV_FK on LOGRO (
   PK_CV ASC
);

/*==============================================================*/
/* Table: MENU                                                  */
/*==============================================================*/
create table MENU 
(
   PK_MENU              NUMBER(6)            not null,
   MENU                 VARCHAR2(50)         not null,
   constraint PK_MENU primary key (PK_MENU)
);

/*==============================================================*/
/* Table: MUNICIPIO                                             */
/*==============================================================*/
create table MUNICIPIO 
(
   PK_MUNICIPIO         NUMBER(6)            not null,
   PK_DEPARTAMENTO      INTEGER,
   NOMBRE_MUNICIPIO     VARCHAR2(50)         not null,
   constraint PK_MUNICIPIO primary key (PK_MUNICIPIO)
);

/*==============================================================*/
/* Index: MUN_DEPTO_FK                                          */
/*==============================================================*/
create index MUN_DEPTO_FK on MUNICIPIO (
   PK_DEPARTAMENTO ASC
);

/*==============================================================*/
/* Table: OFERTA                                                */
/*==============================================================*/
create table OFERTA 
(
   PK_OFERTA            NUMBER(6)            not null,
   PK_EMPRESA           INTEGER              not null,
   PK_CATALOGO_PUESTO   INTEGER              not null,
   PK_MUNICIPIO         INTEGER,
   DESCRIPCION_OFERTA   VARCHAR2(250)        not null,
   SALARIO_MIN_OFERTA   NUMBER(6),
   SALARIO_MAX_OFERTA   NUMBER(6),
   FECHA_INICIO_OFERTA  DATE                 not null,
   FECHA_FIN_OFERTA     DATE                 not null,
   ESTADO               VARCHAR2(50)         not null,
   constraint PK_OFERTA primary key (PK_OFERTA)
);

/*==============================================================*/
/* Index: EMPRESA_OF_FK                                         */
/*==============================================================*/
create index EMPRESA_OF_FK on OFERTA (
   PK_EMPRESA ASC
);

/*==============================================================*/
/* Index: OF_PUESTO_FK                                          */
/*==============================================================*/
create index OF_PUESTO_FK on OFERTA (
   PK_CATALOGO_PUESTO ASC
);

/*==============================================================*/
/* Index: OF_MUNICIPIO_FK                                       */
/*==============================================================*/
create index OF_MUNICIPIO_FK on OFERTA (
   PK_MUNICIPIO ASC
);

/*==============================================================*/
/* Table: OPCIONES                                              */
/*==============================================================*/
create table OPCIONES 
(
   PK_OPCIONES          NUMBER(6)            not null,
   PK_ITEM              INTEGER              not null,
   OPCION               VARCHAR2(250)        not null,
   PUNTAJE_OPCION       NUMBER(2,2)          not null,
   IMAGEN_OPCION        BLOB,
   constraint PK_OPCIONES primary key (PK_OPCIONES)
);

/*==============================================================*/
/* Index: OPC_ITEM_FK                                           */
/*==============================================================*/
create index OPC_ITEM_FK on OPCIONES (
   PK_ITEM ASC
);

/*==============================================================*/
/* Table: PAIS                                                  */
/*==============================================================*/
create table PAIS 
(
   PK_PAIS              NUMBER(6)            not null,
   NOMBRE_PAIS          VARCHAR2(50)         not null,
   constraint PK_PAIS primary key (PK_PAIS)
);

/*==============================================================*/
/* Table: PERFIL                                                */
/*==============================================================*/
create table PERFIL 
(
   PK_USUARIO           NUMBER(6)            not null,
   PK_CANDIDATO         INTEGER,
   PK_EMPRESA           INTEGER,
   PK_ROL               INTEGER              not null,
   USUARIO              VARCHAR2(50)         not null,
   CONTRASENA           VARCHAR2(50)         not null,
   CORREO_ELECTRONICO   VARCHAR2(100)        not null,
   TIPO_PERFIL          INTEGER              not null,
   ESTADO               VARCHAR2(50)         not null,
   constraint PK_PERFIL primary key (PK_USUARIO)
);

/*==============================================================*/
/* Index: PERFIL_CAND_FK                                        */
/*==============================================================*/
create index PERFIL_CAND_FK on PERFIL (
   PK_CANDIDATO ASC
);

/*==============================================================*/
/* Index: PERFIL_EMP_FK                                         */
/*==============================================================*/
create index PERFIL_EMP_FK on PERFIL (
   PK_EMPRESA ASC
);

/*==============================================================*/
/* Index: PERFIL_ROL_FK                                         */
/*==============================================================*/
create index PERFIL_ROL_FK on PERFIL (
   PK_ROL ASC
);

/*==============================================================*/
/* Table: POSTULACION                                           */
/*==============================================================*/
create table POSTULACION 
(
   PK_POSTULACION       NUMBER(6)            not null,
   PK_CV                INTEGER              not null,
   PK_OFERTA            INTEGER              not null,
   PORCENTAJE_ACOPLAMIENTO NUMBER(2),
   FECHA_POSTULACION    DATE                 not null,
   ESTADO               VARCHAR2(50)         not null,
   constraint PK_POSTULACION primary key (PK_POSTULACION)
);

/*==============================================================*/
/* Index: POSTULACION_CV_FK                                     */
/*==============================================================*/
create index POSTULACION_CV_FK on POSTULACION (
   PK_CV ASC
);

/*==============================================================*/
/* Index: POSTULACION_OF_FK                                     */
/*==============================================================*/
create index POSTULACION_OF_FK on POSTULACION (
   PK_OFERTA ASC
);

/*==============================================================*/
/* Table: PRUEBA                                                */
/*==============================================================*/
create table PRUEBA 
(
   PK_PRUEBA            NUMBER(6)            not null,
   PK_OFERTA            INTEGER              not null,
   PK_CAT_TIPO_PRUEBA   INTEGER              not null,
   NOMBRE_PRUEBA        VARCHAR2(100)        not null,
   constraint PK_PRUEBA primary key (PK_PRUEBA)
);

/*==============================================================*/
/* Index: PRUEBA_OF_FK                                          */
/*==============================================================*/
create index PRUEBA_OF_FK on PRUEBA (
   PK_OFERTA ASC
);

/*==============================================================*/
/* Index: PRUEBA_TIPOPRUEBA_FK                                  */
/*==============================================================*/
create index PRUEBA_TIPOPRUEBA_FK on PRUEBA (
   PK_CAT_TIPO_PRUEBA ASC
);

/*==============================================================*/
/* Table: REFERENCIA                                            */
/*==============================================================*/
create table REFERENCIA 
(
   PK_REFERENCIA        NUMBER(6)            not null,
   PK_TIPO_REFERENCIA   INTEGER              not null,
   PK_CV                INTEGER              not null,
   NOMBRE_REFERENCIA    VARCHAR2(100)        not null,
   TELEFONO_REFERENCIA  NUMBER(14)           not null,
   EMPRESA_REFERENCIA   VARCHAR2(250),
   RECOMENDACION_PDF    BLOB,
   constraint PK_REFERENCIA primary key (PK_REFERENCIA)
);

/*==============================================================*/
/* Index: REFERENCIA_TIPOREF_FK                                 */
/*==============================================================*/
create index REFERENCIA_TIPOREF_FK on REFERENCIA (
   PK_TIPO_REFERENCIA ASC
);

/*==============================================================*/
/* Index: REFERENCIA_CV_FK                                      */
/*==============================================================*/
create index REFERENCIA_CV_FK on REFERENCIA (
   PK_CV ASC
);

/*==============================================================*/
/* Table: RESULTADO                                             */
/*==============================================================*/
create table RESULTADO 
(
   PK_RESULTADO         NUMBER(6)            not null,
   PK_PRUEBA            INTEGER,
   PK_POSTULACION       INTEGER,
   RESULTADO            VARCHAR2(25)         not null,
   constraint PK_RESULTADO primary key (PK_RESULTADO)
);

/*==============================================================*/
/* Index: PRUEBA_RESUL_FK                                       */
/*==============================================================*/
create index PRUEBA_RESUL_FK on RESULTADO (
   PK_PRUEBA ASC
);

/*==============================================================*/
/* Index: POSTULACION_RESUL_FK                                  */
/*==============================================================*/
create index POSTULACION_RESUL_FK on RESULTADO (
   PK_POSTULACION ASC
);

/*==============================================================*/
/* Table: ROL                                                   */
/*==============================================================*/
create table ROL 
(
   PK_ROL               NUMBER(6)            not null,
   NOMBRE_ROL           VARCHAR2(50)         not null,
   constraint PK_ROL primary key (PK_ROL)
);

/*==============================================================*/
/* Table: ROL_SUBMENU                                           */
/*==============================================================*/
create table ROL_SUBMENU 
(
   ID_ROL_SUBMENU       NUMBER(6)            not null,
   PK_ROL               INTEGER,
   PK_SUBMENU           INTEGER,
   constraint PK_ROL_SUBMENU primary key (ID_ROL_SUBMENU)
);

/*==============================================================*/
/* Index: ROLSUBMENU_ROL_FK                                     */
/*==============================================================*/
create index ROLSUBMENU_ROL_FK on ROL_SUBMENU (
   PK_ROL ASC
);

/*==============================================================*/
/* Index: ROLSUBMENU_MENU_FK                                    */
/*==============================================================*/
create index ROLSUBMENU_MENU_FK on ROL_SUBMENU (
   PK_SUBMENU ASC
);

/*==============================================================*/
/* Table: SUBMENU                                               */
/*==============================================================*/
create table SUBMENU 
(
   PK_SUBMENU           NUMBER(6)            not null,
   PK_MENU              INTEGER,
   SUBMENU              VARCHAR2(100)        not null,
   ORDEN                VARCHAR2(100)        not null,
   URL                  VARCHAR2(100)        not null,
   constraint PK_SUBMENU primary key (PK_SUBMENU)
);

/*==============================================================*/
/* Index: SUBMENU_MENU_FK                                       */
/*==============================================================*/
create index SUBMENU_MENU_FK on SUBMENU (
   PK_MENU ASC
);

alter table APTITUD_CV
   add constraint FK_APTITUD__CV foreign key (PK_CV)
      references CV (PK_CV);

alter table APTITUD_CV
   add constraint FK_APTITUDCV__CATALOGOAPT foreign key (PK_CATALOGO_APTITUD)
      references CATALOGO_APTITUD (PK_CATALOGO_APTITUD);

alter table APTITUD_OFERTA
   add constraint FK_APTITUDOF_OFERTA foreign key (PK_OFERTA)
      references OFERTA (PK_OFERTA);

alter table APTITUD_OFERTA
   add constraint FK_APTITUDOF_CATALOGOAPT foreign key (PK_CATALOGO_APTITUD)
      references CATALOGO_APTITUD (PK_CATALOGO_APTITUD);

alter table CANDIDATO
   add constraint FK_CANDIDATO_GENERO foreign key (PK_GENERO)
      references CATALOGO_GENERO (PK_GENERO);

alter table CANDIDATO
   add constraint FK_CANDIDATO_MUNICIPIO foreign key (PK_MUNICIPIO)
      references MUNICIPIO (PK_MUNICIPIO);

alter table CATALOGO_HABILIDAD
   add constraint FK_CATALOGOHAB_CATEGORIA foreign key (PK_CATEGORIA_HABILIDAD)
      references CATALOGO_CATEGORIA_HABILIDAD (PK_CATEGORIA_HABILIDAD);

alter table CATALOGO_PUESTO
   add constraint FK_CATALOGOPUESTO_CATEGORIA foreign key (PK_CATALOGO_CATEGORIA)
      references CATALOGO_CATEGORIA (PK_CATALOGO_CATEGORIA);

alter table CONOCIMIENTO_ACADEMICOS
   add constraint FK_CONOCIMIENTOAC_OFERTA foreign key (PK_OFERTA)
      references OFERTA (PK_OFERTA);

alter table CONOCIMIENTO_ACADEMICOS
   add constraint FK_CONOCIMITOAC_GRADOAC foreign key (PK_GRADO_ACADEMICO)
      references CATALOGO_GRADO_ACADEMICO (PK_GRADO_ACADEMICO);

alter table CURSO_CAPACITACION
   add constraint FK_CURSOCAP_CV foreign key (PK_CV)
      references CV (PK_CV);

alter table CV
   add constraint FK_CV_CANDIDATO foreign key (PK_CANDIDATO)
      references CANDIDATO (PK_CANDIDATO);

alter table DEPARTAMENTO
   add constraint FK_DEPARTAM_DEPTO_PAI_PAIS foreign key (PK_PAIS)
      references PAIS (PK_PAIS);

alter table EMPRESA
   add constraint FK_EMPRESA_MUNICIPIO foreign key (PK_MUNICIPIO)
      references MUNICIPIO (PK_MUNICIPIO);

alter table EMPRESA
   add constraint FK_EMPRESA_SECTOR foreign key (PK_SECTOR)
      references CATALOGO_SECTOR_EMPRESA (PK_SECTOR);

alter table EMPRESA
   add constraint FK_EMPRESA_TIPOEMPRESA foreign key (PK_TIPO_EMPRESA)
      references CATALOGO_TIPO_EMPRESA (PK_TIPO_EMPRESA);

alter table ESCRITO
   add constraint FK_ESCRITO_CATALOGOESCRITO foreign key (PK_CATALOGO_ESCRITO)
      references CATALOGO_ESCRITO (PK_CATALOGO_ESCRITO);

alter table ESCRITO
   add constraint FK_ESCRITO_CV foreign key (PK_CV)
      references CV (PK_CV);

alter table EVENTO
   add constraint FK_EVENTO_CV foreign key (PK_CV)
      references CV (PK_CV);

alter table EVENTO
   add constraint FK_EVENTO_PAIS foreign key (PK_PAIS)
      references PAIS (PK_PAIS);

alter table EXPERIENCIA_LABORAL
   add constraint FK_EXPERIENLAB_CV foreign key (PK_CV)
      references CV (PK_CV);

alter table EXPERIENCIA_LABORAL
   add constraint FK_EXPERIENLAB_SECTOR foreign key (PK_SECTOR)
      references CATALOGO_SECTOR_EMPRESA (PK_SECTOR);

alter table FORMACION_ACADEMICA
   add constraint FK_FORMACIONAC_GRADOAC foreign key (PK_GRADO_ACADEMICO)
      references CATALOGO_GRADO_ACADEMICO (PK_GRADO_ACADEMICO);

alter table FORMACION_ACADEMICA
   add constraint FK_FORMACIONAC_CV foreign key (PK_CV)
      references CV (PK_CV);

alter table HABILIDADES_CV
   add constraint FK_HABILIDADCV_CV foreign key (PK_CV)
      references CV (PK_CV);

alter table HABILIDADES_CV
   add constraint FK_HABILIDADCV_CATALOGOHAB foreign key (PK_HABILIDAD)
      references CATALOGO_HABILIDAD (PK_HABILIDAD);

alter table HABILIDAD_LINGUISICA_OFERTA
   add constraint FK_HABLING_CATALOGOIDIOMA foreign key (PK_IDIOMA)
      references CATALOGO_IDIOMA (PK_IDIOMA);

alter table HABILIDAD_LINGUISICA_OFERTA
   add constraint FK_HABLING_CATALOGOPOND foreign key (PK_CATALOGO_PONDERACION)
      references CATALOGO_PONDERACION (PK_CATALOGO_PONDERACION);

alter table HABILIDAD_LINGUISICA_OFERTA
   add constraint FK_HABLING_OFERTA foreign key (PK_OFERTA)
      references OFERTA (PK_OFERTA);

alter table HABILIDAD_LINGUISTICA_CV
   add constraint FK_HABLINGCV_CV foreign key (PK_CV)
      references CV (PK_CV);

alter table HABILIDAD_LINGUISTICA_CV
   add constraint FK_HABLINGCV_PONDERACION foreign key (PK_CATALOGO_PONDERACION)
      references CATALOGO_PONDERACION (PK_CATALOGO_PONDERACION);

alter table HABILIDAD_LINGUISTICA_CV
   add constraint FK_HANLINGCV_IDIOMA foreign key (PK_IDIOMA)
      references CATALOGO_IDIOMA (PK_IDIOMA);

alter table HABILIDAD_OFERTA
   add constraint FK_HABILIDADOF_OFERTA foreign key (PK_OFERTA)
      references OFERTA (PK_OFERTA);

alter table HABILIDAD_OFERTA
   add constraint FK_HABILIDADOF_CATALOGOHAB foreign key (PK_HABILIDAD)
      references CATALOGO_HABILIDAD (PK_HABILIDAD);

alter table ITEM_PRUEBA
   add constraint FK_ITEMPRU_PRUEBA foreign key (PK_PRUEBA)
      references PRUEBA (PK_PRUEBA);

alter table LICENCIA_CANDIDATO
   add constraint FK_LICENCIACAND_CV foreign key (PK_CV)
      references CV (PK_CV);

alter table LICENCIA_CANDIDATO
   add constraint FK_LICENCIACAND_CATALOGOLIC foreign key (PK_CATALOGO_LICENCIA)
      references CATALOGO_LICENCIA (PK_CATALOGO_LICENCIA);

alter table LICENCIA_OFERTA
   add constraint FK_LICENCIAOF_OFERTA foreign key (PK_OFERTA)
      references OFERTA (PK_OFERTA);

alter table LICENCIA_OFERTA
   add constraint FK_LICENCIAOF_CATALOGOLIC foreign key (PK_CATALOGO_LICENCIA)
      references CATALOGO_LICENCIA (PK_CATALOGO_LICENCIA);

alter table LOGRO
   add constraint FK_LOGRO_CV foreign key (PK_CV)
      references CV (PK_CV);

alter table MUNICIPIO
   add constraint FK_MUNICIPIO_DEPTO foreign key (PK_DEPARTAMENTO)
      references DEPARTAMENTO (PK_DEPARTAMENTO);

alter table OFERTA
   add constraint FK_OFERTA_EMPRESA foreign key (PK_EMPRESA)
      references EMPRESA (PK_EMPRESA);

alter table OFERTA
   add constraint FK_OFERTA_MUNICIPIO foreign key (PK_MUNICIPIO)
      references MUNICIPIO (PK_MUNICIPIO);

alter table OFERTA
   add constraint FK_OFERTA_PUESTO foreign key (PK_CATALOGO_PUESTO)
      references CATALOGO_PUESTO (PK_CATALOGO_PUESTO);

alter table OPCIONES
   add constraint FK_OPCIONES_ITEMPRUEBA foreign key (PK_ITEM)
      references ITEM_PRUEBA (PK_ITEM);

alter table PERFIL
   add constraint FK_PERFIL_CANDIDATO foreign key (PK_CANDIDATO)
      references CANDIDATO (PK_CANDIDATO);

alter table PERFIL
   add constraint FK_PERFIL_EMPRESA foreign key (PK_EMPRESA)
      references EMPRESA (PK_EMPRESA);

alter table PERFIL
   add constraint FK_PERFIL_PERFIL_RO_ROL foreign key (PK_ROL)
      references ROL (PK_ROL);

alter table POSTULACION
   add constraint FK_POSTULACION_CV foreign key (PK_CV)
      references CV (PK_CV);

alter table POSTULACION
   add constraint FK_POSTULACION_OFERTA foreign key (PK_OFERTA)
      references OFERTA (PK_OFERTA);

alter table PRUEBA
   add constraint FK_PRUEBA_PRUEBAOFERTA foreign key (PK_OFERTA)
      references OFERTA (PK_OFERTA);

alter table PRUEBA
   add constraint FK_PRUEBA_CATALOGOTIPOPRU foreign key (PK_CAT_TIPO_PRUEBA)
      references CATALOGO_TIPO_PRUEBA (PK_CAT_TIPO_PRUEBA);

alter table REFERENCIA
   add constraint FK_REFERENCIA_CV foreign key (PK_CV)
      references CV (PK_CV);

alter table REFERENCIA
   add constraint FK_REFERENCIA_TIPOREF foreign key (PK_TIPO_REFERENCIA)
      references CATALOGO_TIPO_REFERENCIA (PK_TIPO_REFERENCIA);

alter table RESULTADO
   add constraint FK_RESULTAD_POSTULACION foreign key (PK_POSTULACION)
      references POSTULACION (PK_POSTULACION);

alter table RESULTADO
   add constraint FK_RESULTADO_PRUEBA foreign key (PK_PRUEBA)
      references PRUEBA (PK_PRUEBA);

alter table ROL_SUBMENU
   add constraint FK_ROLSUBMU_SUBMENU foreign key (PK_SUBMENU)
      references SUBMENU (PK_SUBMENU);

alter table ROL_SUBMENU
   add constraint FK_ROLSUBMU_ROL foreign key (PK_ROL)
      references ROL (PK_ROL);

alter table SUBMENU
   add constraint FK_SUBMENU_MENU foreign key (PK_MENU)
      references MENU (PK_MENU);

