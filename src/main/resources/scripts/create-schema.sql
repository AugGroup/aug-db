
    alter table ALLOWANCES 
        drop 
        foreign key FKCD0A575BA405A4AA;

    alter table FAMILY 
        drop 
        foreign key FK7B2B4F6430240285;

    drop table if exists ABILITY;

    drop table if exists ADDRESS;

    drop table if exists ALLOWANCES;

    drop table if exists CERTIFICATION;

    drop table if exists EDUCATION;

    drop table if exists EMP_CARD;

    drop table if exists EXPERIENCE;

    drop table if exists FAMILY;

    drop table if exists HEALTH;

    drop table if exists HISTORY;

    drop table if exists LEAVES;

    drop table if exists LOGIN;

    drop table if exists MAS_ADDRESSTYPE;

    drop table if exists MAS_ALLOWANCES;

    drop table if exists MAS_DEGREETYPE;

    drop table if exists MAS_DIVISION;

    drop table if exists MAS_EMPLOYMENT;

    drop table if exists MAS_JOBLEVEL;

    drop table if exists MAS_LOCATION;

    drop table if exists MAS_PROVINCE;

    drop table if exists MAS_RELATIONTYPE;

    drop table if exists MAS_ROLE;

    drop table if exists MAS_SPECIALTY;

    drop table if exists MAS_STAFFTYPE;

    drop table if exists MAS_TECHNOLOGY;

    drop table if exists OFFICIAL;

    drop table if exists PUNISH;

    drop table if exists REWARD;

    drop table if exists SITE;

    drop table if exists SKILLLANGUAGE;

    create table ABILITY (
        ID integer not null auto_increment,
        auditFlag varchar(255),
        createdBy integer,
        createdTimeStamp datetime,
        updatedBy integer,
        updatedTimeStamp datetime,
        RANK integer not null,
        primary key (ID)
    );

    create table ADDRESS (
        ID integer not null auto_increment,
        auditFlag varchar(255),
        createdBy integer,
        createdTimeStamp datetime,
        updatedBy integer,
        updatedTimeStamp datetime,
        DISTRICT varchar(255),
        HOUSE_NO varchar(255),
        ROAD varchar(255),
        SUB_DISTRICT varchar(255),
        ZIPCODE integer,
        primary key (ID),
        unique (HOUSE_NO, DISTRICT)
    );

    create table ALLOWANCES (
        ID integer not null auto_increment,
        auditFlag varchar(255),
        createdBy integer,
        createdTimeStamp datetime,
        updatedBy integer,
        updatedTimeStamp datetime,
        AMOUNT double precision not null,
        MAS_ALLOWANCES_ID integer not null,
        primary key (ID)
    );

    create table CERTIFICATION (
        ID integer not null auto_increment,
        auditFlag varchar(255),
        createdBy integer,
        createdTimeStamp datetime,
        updatedBy integer,
        updatedTimeStamp datetime,
        CERTIFICATION_FORM varchar(255),
        DESCRICPION varchar(255),
        NAME varchar(255),
        YEAR varchar(255),
        primary key (ID)
    );

    create table EDUCATION (
        ID integer not null auto_increment,
        auditFlag varchar(255),
        createdBy integer,
        createdTimeStamp datetime,
        updatedBy integer,
        updatedTimeStamp datetime,
        CERTIFICATION varchar(255),
        DEGREETYPE_ID varchar(255),
        FACULTY varchar(255),
        GPA double precision,
        GRADUATED_DATE datetime,
        MAJOR varchar(255),
        START_DATE datetime,
        UNIVERSITY varchar(255),
        primary key (ID)
    );

    create table EMP_CARD (
        ID integer not null auto_increment,
        CARDNO varchar(255) not null,
        END_DATE datetime,
        REMARK varchar(255),
        START_DATE datetime not null,
        STATUS varchar(255) not null,
        primary key (ID)
    );

    create table EXPERIENCE (
        ID integer not null auto_increment,
        auditFlag varchar(255),
        createdBy integer,
        createdTimeStamp datetime,
        updatedBy integer,
        updatedTimeStamp datetime,
        ADDRESS varchar(255),
        DATE_FROM datetime,
        DATE_TO datetime,
        POSITION varchar(255),
        REASON varchar(255),
        REFERENCE varchar(255),
        RESPONSIBILITY varchar(255),
        SALARY bigint,
        TYPE_OF_BUSINESS varchar(255),
        primary key (ID)
    );

    create table FAMILY (
        ID integer not null auto_increment,
        AUDITFLAG varchar(1) not null,
        CREATEDBY integer not null,
        CREATEDTIMESTAMP datetime not null,
        UPDATEDBY integer,
        UPDATEDTIMESTAMP datetime,
        ADDRESS varchar(255) not null,
        AGE integer not null,
        NAME varchar(255) not null,
        GENDER varchar(10) not null,
        TELEPHONE varchar(12) not null,
        OCCUPATION varchar(255),
        POSITION varchar(255),
        MASRELATION_ID integer not null,
        primary key (ID)
    );

    create table HEALTH (
        ID integer not null auto_increment,
        AUDITFLAG varchar(1) not null,
        CREATEDBY integer not null,
        CREATEDTIMESTAMP datetime not null,
        UPDATEDBY integer,
        UPDATEDTIMESTAMP datetime,
        CONGENITAL_DISEASE varchar(255) not null,
        CONGENITAL_DISEASE_SPECIFIED1 varchar(255),
        CONGENITAL_DISEASE_SPECIFIED2 varchar(255),
        CONGENITAL_DISEASE_SPECIFIED3 varchar(255),
        GENETIC_DISEASE varchar(255) not null,
        GENETIC_DISEASE_SPECIFIED1 varchar(255),
        GENETIC_DISEASE_SPECIFIED2 varchar(255),
        GENETIC_DISEASE_SPECIFIED3 varchar(255),
        INTOLERANCE varchar(255) not null,
        INTOLERANCE_EXPLAIN varchar(255),
        TAKE_MEDICINE varchar(255) not null,
        TAKE_MEDICINE_EXPLAIN varchar(255),
        primary key (ID)
    );

    create table HISTORY (
        ID integer not null auto_increment,
        auditFlag varchar(255),
        createdBy integer,
        createdTimeStamp datetime,
        updatedBy integer,
        updatedTimeStamp datetime,
        ADJUSTMENT_TIME integer,
        DATE_OF_ADJUSTMENT datetime not null,
        OLD_SALARY double precision,
        POSITION varchar(255) not null,
        REASON_OF_ADJUSTMENT varchar(255),
        SALARY double precision not null,
        primary key (ID)
    );

    create table LEAVES (
        ID integer not null auto_increment,
        auditFlag varchar(255),
        createdBy integer,
        createdTimeStamp datetime,
        updatedBy integer,
        updatedTimeStamp datetime,
        AIM varchar(255) not null,
        END_TIME datetime,
        ENDTIMESTRING varchar(255),
        REASON varchar(255),
        START_TIME datetime,
        STARTTIMESTRING varchar(255),
        SUMTIME integer,
        primary key (ID)
    );

    create table LOGIN (
        ID integer not null auto_increment,
        auditFlag varchar(255),
        createdBy integer,
        createdTimeStamp datetime,
        updatedBy integer,
        updatedTimeStamp datetime,
        PASSWORD varchar(13) not null,
        USERNAME varchar(255) not null,
        primary key (ID),
        unique (ID)
    );

    create table MAS_ADDRESSTYPE (
        ID integer not null auto_increment,
        auditFlag varchar(255),
        createdBy integer,
        createdTimeStamp datetime,
        updatedBy integer,
        updatedTimeStamp datetime,
        CODE varchar(255) not null,
        ISACTIVE varchar(255) not null,
        ADDRESSTYPENAME varchar(255) not null,
        primary key (ID)
    );

    create table MAS_ALLOWANCES (
        ALLO_ID integer not null auto_increment,
        auditFlag varchar(255),
        createdBy integer,
        createdTimeStamp datetime,
        updatedBy integer,
        updatedTimeStamp datetime,
        ALLOWANCES_TYPE varchar(255) not null,
        AMOUNT_ALLOWANCES double precision,
        CODE varchar(255) not null,
        ISACTIVE bit not null,
        primary key (ALLO_ID)
    );

    create table MAS_DEGREETYPE (
        DEGREETYPE_ID integer not null auto_increment,
        auditFlag varchar(255),
        createdBy integer,
        createdTimeStamp datetime,
        updatedBy integer,
        updatedTimeStamp datetime,
        CODE varchar(255) not null,
        ISACTIVE bit not null,
        NAME varchar(200) not null,
        primary key (DEGREETYPE_ID)
    );

    create table MAS_DIVISION (
        ID integer not null auto_increment,
        auditFlag varchar(255),
        createdBy integer,
        createdTimeStamp datetime,
        updatedBy integer,
        updatedTimeStamp datetime,
        CODE varchar(255) not null,
        ISACTIVE bit not null,
        NAME varchar(255) not null,
        primary key (ID)
    );

    create table MAS_EMPLOYMENT (
        ID integer not null auto_increment,
        auditFlag varchar(255),
        createdBy integer,
        createdTimeStamp datetime,
        updatedBy integer,
        updatedTimeStamp datetime,
        CODE varchar(255) not null,
        ISACTIVE bit not null,
        NAME varchar(200) not null,
        primary key (ID)
    );

    create table MAS_JOBLEVEL (
        ID integer not null auto_increment,
        auditFlag varchar(255),
        createdBy integer,
        createdTimeStamp datetime,
        updatedBy integer,
        updatedTimeStamp datetime,
        CODE varchar(255) not null,
        ISACTIVE bit not null,
        NAME varchar(255) not null,
        primary key (ID)
    );

    create table MAS_LOCATION (
        ID integer not null auto_increment,
        auditFlag varchar(255),
        createdBy integer,
        createdTimeStamp datetime,
        updatedBy integer,
        updatedTimeStamp datetime,
        CODE varchar(255) not null,
        ISACTIVE bit not null,
        NAME varchar(200) not null,
        primary key (ID)
    );

    create table MAS_PROVINCE (
        ID integer not null auto_increment,
        auditFlag varchar(255),
        createdBy integer,
        createdTimeStamp datetime,
        updatedBy integer,
        updatedTimeStamp datetime,
        CODE varchar(255) not null,
        ISACTIVE bit not null,
        PROVINCENAME varchar(255) not null,
        primary key (ID)
    );

    create table MAS_RELATIONTYPE (
        ID integer not null auto_increment,
        AUDITFLAG varchar(1) not null,
        CODE varchar(10) not null,
        CREATEDBY integer not null,
        CREATEDTIMESTAMP datetime not null,
        ISACTIVE bit not null,
        UPDATEDBY integer,
        UPDATEDTIMESTAMP datetime,
        RELATIONTYPE varchar(255) not null,
        primary key (ID)
    );

    create table MAS_ROLE (
        ID integer not null auto_increment,
        auditFlag varchar(255),
        createdBy integer,
        createdTimeStamp datetime,
        updatedBy integer,
        updatedTimeStamp datetime,
        ISACTIVE bit not null,
        TYPE varchar(255) not null,
        primary key (ID)
    );

    create table MAS_SPECIALTY (
        SPEC_ID integer not null auto_increment,
        auditFlag varchar(255),
        createdBy integer,
        createdTimeStamp datetime,
        updatedBy integer,
        updatedTimeStamp datetime,
        CODE varchar(255) not null,
        ISACTIVE bit,
        NAME varchar(255) not null,
        primary key (SPEC_ID)
    );

    create table MAS_STAFFTYPE (
        ID integer not null auto_increment,
        AUDITFLAG varchar(1) not null,
        CREATEDBY integer not null,
        CREATEDTIMESTAMP datetime not null,
        UPDATEDBY integer,
        UPDATEDTIMESTAMP datetime,
        CODE varchar(255),
        ISACTIVE bit not null,
        STAFFTYPENAME varchar(255) not null,
        primary key (ID)
    );

    create table MAS_TECHNOLOGY (
        ID integer not null auto_increment,
        auditFlag varchar(255),
        createdBy integer,
        createdTimeStamp datetime,
        updatedBy integer,
        updatedTimeStamp datetime,
        CODE varchar(255) not null,
        ISACTIVE bit not null,
        NAME varchar(255) not null,
        primary key (ID)
    );

    create table OFFICIAL (
        ID integer not null auto_increment,
        auditFlag varchar(255),
        createdBy integer,
        createdTimeStamp datetime,
        updatedBy integer,
        updatedTimeStamp datetime,
        END_WORK_DATE datetime,
        OFFICIAL_DATE datetime,
        POSITION_APPLIED_FOR varchar(255),
        PROBATION_DATE datetime,
        SALARY_EXPECTED varchar(255),
        START_WORK_DATE datetime,
        primary key (ID),
        unique (ID)
    );

    create table PUNISH (
        ID integer not null auto_increment,
        DATEPUNISH datetime not null,
        DESCRIPTION varchar(255) not null,
        PENALTY varchar(255) not null,
        primary key (ID)
    );

    create table REWARD (
        ID integer not null auto_increment,
        auditFlag varchar(255),
        createdBy integer,
        createdTimeStamp datetime,
        updatedBy integer,
        updatedTimeStamp datetime,
        ISACTIVE bit,
        REASON varchar(255),
        TYPE_REWARD varchar(255) not null,
        YEAR varchar(255) not null,
        primary key (ID)
    );

    create table SITE (
        ID integer not null auto_increment,
        AUDITFLAG varchar(1) not null,
        CREATEDBY integer not null,
        CREATEDTIMESTAMP datetime not null,
        UPDATEDBY integer,
        UPDATEDTIMESTAMP datetime,
        ENDDATE datetime not null,
        PROJECTNAME varchar(255) not null,
        PROJECTOWNER varchar(255) not null,
        PROJECTOWNERCONTACT varchar(255) not null,
        STARTDATE datetime not null,
        primary key (ID)
    );

    create table SKILLLANGUAGE (
        ID integer not null auto_increment,
        AUDITFLAG varchar(1) not null,
        CREATEDBY integer not null,
        CREATEDTIMESTAMP datetime not null,
        UPDATEDBY integer,
        UPDATEDTIMESTAMP datetime,
        nameLanguage varchar(255),
        reading varchar(255),
        speaking varchar(255),
        understanding varchar(255),
        writing varchar(255),
        primary key (ID)
    );

    alter table ALLOWANCES 
        add index FKCD0A575BA405A4AA (MAS_ALLOWANCES_ID), 
        add constraint FKCD0A575BA405A4AA 
        foreign key (MAS_ALLOWANCES_ID) 
        references MAS_ALLOWANCES (ALLO_ID);

    alter table FAMILY 
        add index FK7B2B4F6430240285 (MASRELATION_ID), 
        add constraint FK7B2B4F6430240285 
        foreign key (MASRELATION_ID) 
        references MAS_RELATIONTYPE (ID);
