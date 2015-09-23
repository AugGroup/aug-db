--MASDIVISION
INSERT INTO MAS_DIVISION (NAME,CODE,ISACTIVE,AUDITFLAG,CREATEDTIMESTAMP,CREATEDBY) VALUES ('CEO Office of CEO','01',0,'C',NOW(),0);
INSERT INTO MAS_DIVISION (NAME,CODE,ISACTIVE,AUDITFLAG,CREATEDTIMESTAMP,CREATEDBY) VALUES ('F&A Finance & Administration','02',0,'C',NOW(),0);
INSERT INTO MAS_DIVISION (NAME,CODE,ISACTIVE,AUDITFLAG,CREATEDTIMESTAMP,CREATEDBY) VALUES ('MKT Marketing','04',0,'C',NOW(),0);
INSERT INTO MAS_DIVISION (NAME,CODE,ISACTIVE,AUDITFLAG,CREATEDTIMESTAMP,CREATEDBY) VALUES ('MoH Ministry of Happiness','05',0,'C',NOW(),0);
INSERT INTO MAS_DIVISION (NAME,CODE,ISACTIVE,AUDITFLAG,CREATEDTIMESTAMP,CREATEDBY) VALUES ('SAP SAP Services','06',0,'C',NOW(),0);
INSERT INTO MAS_DIVISION (NAME,CODE,ISACTIVE,AUDITFLAG,CREATEDTIMESTAMP,CREATEDBY) VALUES ('TXM Transformation','07',0,'C',NOW(),0);

--MASTECHNOLOGY
INSERT INTO MAS_TECHNOLOGY (NAME,auditFlag,createdTimeStamp,createdBy,ISACTIVE,CODE) VALUES ('.Net','C',NOW(),0,true,1);
INSERT INTO MAS_TECHNOLOGY (NAME,auditFlag,createdTimeStamp,createdBy,ISACTIVE,CODE) VALUES ('COBOL','C',NOW(),0,true,1);
INSERT INTO MAS_TECHNOLOGY (NAME,auditFlag,createdTimeStamp,createdBy,ISACTIVE,CODE) VALUES ('Java','C',NOW(),0,true,1);
INSERT INTO MAS_TECHNOLOGY (NAME,auditFlag,createdTimeStamp,createdBy,ISACTIVE,CODE) VALUES ('PHP','C',NOW(),0,true,1);
INSERT INTO MAS_TECHNOLOGY (NAME,auditFlag,createdTimeStamp,createdBy,ISACTIVE,CODE) VALUES ('SAP','C',NOW(),0,true,1);


--MASSPECIALTY
insert into MAS_SPECIALTY (name,code,isactive,auditFlag,createdTimeStamp,createdBy)
VALUES 
('ABAP','01',1,'C',NOW(),0),
('ASP.Net','02',1,'C',NOW(),0),
('Basis','03',1,'C',NOW(),0),
('BI','04',1,'C',NOW(),0),
('BPC - B','05',1,'C',NOW(),0),
('BPC - C','06',1,'C',NOW(),0),
('BW','07',1,'C',NOW(),0),
('C#','08',1,'C',NOW(),0),
('C++.Netframework','09',1,'C',NOW(),0),
('CO','10',1,'C',NOW(),0),
('CRM','11',1,'C',NOW(),0),
('CSS','12',1,'C',NOW(),0),
('Eclipse','13',1,'C',NOW(),0),
('FI','14',1,'C',NOW(),0),
('Hibernate','15',1,'C',NOW(),0),
('HTML','16',1,'C',NOW(),0),
('J2EE','17',1,'C',NOW(),0),
('Java Script','18',1,'C',NOW(),0),
('JBOSS','19',1,'C',NOW(),0),
('JQUERY SVN Respsoitry','20',1,'C',NOW(),0),
('JSF','21',1,'C',NOW(),0),
('MM','22',1,'C',NOW(),0),
('Mobility','23',1,'C',NOW(),0),
('MVC','24',1,'C',NOW(),0),
('Oracle','25',1,'C',NOW(),0),
('Oracle10g','26',1,'C',NOW(),0),
('Oracle9i','27',1,'C',NOW(),0),
('PI','28',1,'C',NOW(),0),
('PL/SQL','29',1,'C',NOW(),0),
('PM','30',1,'C',NOW(),0),
('PP','31',1,'C',NOW(),0),
('SD','32',1,'C',NOW(),0),
('Security','33',1,'C',NOW(),0),
('Spring','34',1,'C',NOW(),0),
('SRM','35',1,'C',NOW(),0),
('Symfony1,2','36',1,'C',NOW(),0),
('TR','37',1,'C',NOW(),0),
('VB.Net','38',1,'C',NOW(),0),
('Web App','39',1,'C',NOW(),0),
('Web Logic','40',1,'C',NOW(),0),
('WPF','41',1,'C',NOW(),0),
('Zend','42',1,'C',NOW(),0);


--MASJOBLEVEL
insert into MAS_JOBLEVEL(name,code,isactive,auditFlag,createdTimeStamp,createdBy) 
values('Account Execute','AE',1,'C',NOW(),0),
('Account Manager','AM',1,'C',NOW(),0),
('Business Division Director','BDD',1,'C',NOW(),0),
('Consultant','C',1,'C',NOW(),0),
('Manager','M',1,'C',NOW(),0),
('Managing Consultant','MC',1,'C',NOW(),0),
('Partner','P',1,'C',NOW(),0),
('Principal Consultant','PC',1,'C',NOW(),0),
('Professional','PF',1,'C',NOW(),0),
('Senior Account Manager','SAM',1,'C',NOW(),0),
('Senior Consultant','SC',1,'C',NOW(),0),
('Senior Manager','SM',1,'C',NOW(),0),
('Senior Professional','SP',1,'C',NOW(),0),
('Support Division Director','SDD',1,'C',NOW(),0);


--MASADDRESSTYPE
INSERT INTO MAS_ADDRESSTYPE(ADDRESSTYPENAME,CODE,ISACTIVE,auditFlag,createdTimeStamp,createdBy) VALUES ('Present address','P01',1,'C',NOW(),0),('Permanent address','M02',1,'C',NOW(),0),
('Permanent address','M02',1,'C',NOW(),0);


--MASDEGREETYPE
insert into MAS_DEGREETYPE (name,code,isactive,auditFlag,createdTimeStamp,createdBy)
VALUES
('Bachelor','a',1,'C',NOW(),0),
('Masters','a',1,'C',NOW(),0),
('Ph.D.','a',1,'C',NOW(),0);


--MASEMPLOYMENT
INSERT INTO MAS_EMPLOYMENT(NAME,CODE,ISACTIVE,auditFlag,createdTimeStamp,createdBy) VALUES ('Permanent','A01',1,'C',NOW(),0);
INSERT INTO MAS_EMPLOYMENT(NAME,CODE,ISACTIVE,auditFlag,createdTimeStamp,createdBy) VALUES ('Contract','A01',1,'C',NOW(),0);


--MASPROVINCE
insert into MAS_PROVINCE (PROVINCENAME,CODE,ISACTIVE,auditFlag,createdTimeStamp,createdBy)
VALUES
('Bangkok','a',1,'C',NOW(),0),
('Chiang Rai','a',1,'C',NOW(),0),
('Chiang Mai','a',1,'C',NOW(),0),
('Nan','a',1,'C',NOW(),0),
('Phayao','a',1,'C',NOW(),0),
('Phrae','a',1,'C',NOW(),0),
('Mae Hong Son','a',1,'C',NOW(),0),
('Lampang','a',1,'C',NOW(),0),
('Lamphun','a',1,'C',NOW(),0),
('Uttaradit','a',1,'C',NOW(),0),
('Kalasin','a',1,'C',NOW(),0),
('Khon Kaen','a',1,'C',NOW(),0),
('Chaiyaphum','a',1,'C',NOW(),0),
('Nakhon Phanom','a',1,'C',NOW(),0),
('Nakhon Ratchasima','a',1,'C',NOW(),0),
('Bueng Kan','a',1,'C',NOW(),0),
('Buri Ram','a',1,'C',NOW(),0),
('Maha Sarakham','a',1,'C',NOW(),0),
('Mukdahan','a',1,'C',NOW(),0),
('Yasothon','a',1,'C',NOW(),0),
('Roi Et','a',1,'C',NOW(),0),
('Loei','a',1,'C',NOW(),0),
('Si Sa Ket','a',1,'C',NOW(),0),
('Sakon Nakhon','a',1,'C',NOW(),0),
('Surin','a',1,'C',NOW(),0),
('Nong Khai','a',1,'C',NOW(),0),
('Nong Bua Lam Phu','a',1,'C',NOW(),0),
('Amnat Charoen','a',1,'C',NOW(),0),
('Udon Thani','a',1,'C',NOW(),0),
('Ubon Ratchathani','a',1,'C',NOW(),0),
('Kamphaeng Phet','a',1,'C',NOW(),0),
('Chai Nat','a',1,'C',NOW(),0),
('Nakhon Nayok','a',1,'C',NOW(),0),
('Nakhon Pathom','a',1,'C',NOW(),0),
('Nakhon Sawan','a',1,'C',NOW(),0),
('Nonthaburi','a',1,'C',NOW(),0),
('Pathum Thani','a',1,'C',NOW(),0),
('Phra Nakhon Si Ayutthaya','a',1,'C',NOW(),0),
('Phichit','a',1,'C',NOW(),0),
('Phitsanulok','a',1,'C',NOW(),0),
('Phetchabun','a',1,'C',NOW(),0),
('Lop Buri','a',1,'C',NOW(),0),
('Samut Prakan','a',1,'C',NOW(),0),
('Samut Songkhram','a',1,'C',NOW(),0),
('Samut Sakhon','a',1,'C',NOW(),0),
('Sing Buri','a',1,'C',NOW(),0),
('Sukhothai','a',1,'C',NOW(),0),
('Suphan Buri','a',1,'C',NOW(),0),
('Saraburi','a',1,'C',NOW(),0),
('Ang Thong','a',1,'C',NOW(),0),
('Uthai Thani','a',1,'C',NOW(),0),
('Chanthaburi','a',1,'C',NOW(),0),
('Chachoengsao','a',1,'C',NOW(),0),
('Chon Buri','a',1,'C',NOW(),0),
('Trat','a',1,'C',NOW(),0),
('Prachin Buri','a',1,'C',NOW(),0),
('Rayong','a',1,'C',NOW(),0),
('Sa Kaeo','a',1,'C',NOW(),0),
('Kanchanaburi','a',1,'C',NOW(),0),
('Tak','a',1,'C',NOW(),0),
('Prachuap Khiri Khan','a',1,'C',NOW(),0),
('Phetchaburi','a',1,'C',NOW(),0),
('Ratchaburi','a',1,'C',NOW(),0),
('Krabi','a',1,'C',NOW(),0),
('Chumphon','a',1,'C',NOW(),0),
('Trang','a',1,'C',NOW(),0),
('Nakhon Si Thammarat','a',1,'C',NOW(),0),
('Narathiwat','a',1,'C',NOW(),0),
('Pattani','a',1,'C',NOW(),0),
('Phangnga','a',1,'C',NOW(),0),
('Phatthalung','a',1,'C',NOW(),0),
('Phuket','a',1,'C',NOW(),0),
('Yala','a',1,'C',NOW(),0),
('Ranong','a',1,'C',NOW(),0),
('Songkhla','a',1,'C',NOW(),0),
('Satun','a',1,'C',NOW(),0),
('Surat Thani','a',1,'C',NOW(),0);


--MasCoreSkill
INSERT INTO MAS_CORESKILL (NAME,CODE,ISACTIVE,auditFlag,createdTimeStamp,createdBy) VALUES 
('Administration','AD',b'1','C',NOW(),0),
('Application Analyst','AA',b'1','C',NOW(),0),
('Business Analyst','BA',b'1','C',NOW(),0),
('Business Development','BD',b'1','C',NOW(),0),
('Data Base Administrator','DBA',b'1','C',NOW(),0),
('Finance','FI',b'1','C',NOW(),0),
('Happiness','HP',b'1','C',NOW(),0),
('ITS','ITS',b'1','C',NOW(),0),
('Marketing','MK',b'1','C',NOW(),0),
('Ministry of Happiness','MHP',b'1','C',NOW(),0),
('Programmer','PG',b'1','C',NOW(),0),
('Project Coordinator','PC',b'1','C',NOW(),0),
('Project Manager','PM',b'1','C',NOW(),0),
('Recruitment','RC',b'1','C',NOW(),0),
('SAP','SAP',b'1','C',NOW(),0),
('Software Tester','ST',b'1','C',NOW(),0),
('Solution Architect','SR',b'1','C',NOW(),0),
('System Analyst','SA',b'1','C',NOW(),0),
('Transformation','TR',b'1','C',NOW(),0);


--MASLOCATION
INSERT INTO MAS_LOCATION(NAME,CODE,ISACTIVE,auditFlag,createdTimeStamp,createdBy) VALUES ('Thailand','TH',1,'C',NOW(),0),
 ('Singapore','SG',1,'C',NOW(),0),
 ('Indonesia','ID',1,'C',NOW(),0),
 ('Australia','AU',1,'C',NOW(),0);
 
 
 --MASSTAFFTYPE
INSERT INTO MAS_STAFFTYPE(
 AUDITFLAG,
 CREATEDBY,
 CREATEDTIMESTAMP,
 CODE,
 ISACTIVE,
 STAFFTYPENAME)
values
('C',0,NOW(),'01A',true,'Billable'), 
('C',0,NOW(),'02A',true,'Back office');


--MASRELATIONTYPE
INSERT INTO MAS_RELATIONTYPE(
 AUDITFLAG,
 CODE,
 CREATEDBY,
 CREATEDTIMESTAMP,
 ISACTIVE,
 RELATIONTYPE
) values
('C','01',0,NOW(),true,'SON'),
('C','2',0,NOW(),true,'DAUGTHER');


--MASLEAVETYPE
INSERT INTO MAS_LEAVETYPE (NAME,CODE,ISACTIVE,auditFlag,createdTimeStamp,createdBy) VALUES
('Annual Holiday Leave','L01',true,'C',NOW(),0),
('Maternity Leave','L02',true,'C',NOW(),0),
('Personal Leave','L03',true,'C',NOW(),0),
('Sick Leave','L04',true,'C',NOW(),0),
('Urgent Leave','L05',true,'C',NOW(),0),
('Other','L06',true,'C',NOW(),0);


--MASROLE
INSERT INTO MAS_ROLE(TYPE,AUDITFLAG,CREATEDBY,CREATEDTIMESTAMP,ISACTIVE) VALUES
 ('ROLE_ADMIN','C',0,NOW(),1),
 ('ROLE_STAFF','C',0,NOW(),1),
 ('ROLE_HR','C',0,NOW(),1);
 
 
 --MASALLOWANCES
INSERT INTO MAS_ALLOWANCES (ALLOWANCES_TYPE,AMOUNT_ALLOWANCES,CODE,ISACTIVE,auditFlag,createdTimeStamp,createdBy) VALUES 
('ลดหย่อนส่วนบุคคล-ผู้มีเงินได้',30000,'A1',1,'C',NOW(),0),
('ลดหย่อนส่วนบุคคล-คู่สมรส ที่ไม่มีเงินได้',30000,'A2',1,'C',NOW(),0),
('ลดหย่อนส่วนบุคคล-บุตรที่ศึกษาในประเทศ',17000,'A3',1,'C',NOW(),0),
('ลดหย่อนส่วนบุคคล-บุตรที่ไม่ได้ศึกษาหรือศึกษาในต่างประเทศ',15000,'A4',1,'C',NOW(),0),
('ลดหย่อนส่วนบุคคล-ค่าอุปการะเลี้ยงดูบิดา มารดาของผู้มีเงินได้',30000,'A5',1,'C',NOW(),0),
('ลดหย่อนส่วนบุคคล-ค่าอุปการะเลี้ยงดูคนพิการหรือคนทุพพลภาพ',60000,'A6',1,'C',NOW(),0),
('ลดหย่อนและยกเว้น สำหรับเบี้ยประกันชีวิต-ผู้มีเงินได้',100000,'A7',1,'C',NOW(),0),
('ลดหย่อนและยกเว้น สำหรับเบี้ยประกันชีวิต-คู่สมรสที่ไม่มีเงินได้',10000,'A8',1,'C',NOW(),0),
('ยกเว้นเบี้ยประกันสุขภาพ บิดา มารดา ของผู้มีเงินได้ และบิดา มารดาของคู่สมรส ที่ไม่มีเงินได้',15000,'A9',1,'C',NOW(),0),
('ลดหย่อนและยกเว้นเงินสะสมที่จ่ายเข้ากองทุนสำรองเลี้ยงชีพ',500000,'A10',1,'C',NOW(),0),
('ยกเว้นค่าซื้อหน่วยลงทุนในกองทุนรวมเพื่อการเลี้ยงชีพ RMF',500000,'A11',1,'C',NOW(),0),
('ยกเว้นค่าซื้อหน่วยลงทุนในกองทุนรวมหุ้นระยะยาว  LTF',500000,'A12',1,'C',NOW(),0),
('ยกเว้นเงินสะสม กบข.',500000,'A13',1,'C',NOW(),0),
('ยกเว้นเงินสะสมกองทุนสงเคราะห์ครูโรงเรียนเอกชน',500000,'A14',1,'C',NOW(),0),
('ยกเว้นเงินค่าชดเชยที่ได้รับตามกฎหมายว่าด้วยการคุ้มครองแรงงาน',300000,'A15',1,'C',NOW(),0),
('ลดหย่อนและยกเว้น สำหรับดอกเบี้ยเงินกู้ยืมเพื่อการมีที่อยู่อาศัย-ผู้มีเงินได้กู้ยืมคนเดียว',100000,'A16',1,'C',NOW(),0),
('ลดหย่อนและยกเว้น สำหรับดอกเบี้ยเงินกู้ยืมเพื่อการมีที่อยู่อาศัย-ผู้มีเงินได้หลายคนร่วมกันกู้ยืม',100000,'A17',1,'C',NOW(),0),
('ลดหย่อนเงินสมทบที่จ่ายเข้ากองทุนประกันสังคม',9000,'A18',1,'C',NOW(),0),
('ลดหย่อนและยกเว้นเงินบริจาค-ยกเว้นค่าใช้จ่ายเพื่อสนับสนุนการศึกษา',null,'A19',1,'C',NOW(),0),
('ลดหย่อนและยกเว้นเงินบริจาค-ยกเว้นค่าใช้จ่ายและเงินบริจาค',null,'A22',1,'C',NOW(),0),
('ลดหย่อนและยกเว้นเงินบริจาค-ลดหย่อนเงินบริจาคทั่วไป',null,'A23',1,'C',NOW(),0),
('ลดหย่อนและยกเว้นเงินบริจาค-ลดหย่อนเงินบริจาคเพื่อช่วยเหลือผู้ประสบอุทกภัย',null,'A24',1,'C',NOW(),0),
('ยกเว้นเงินได้ที่ผู้มีเงินได้ซึ่งเป็นผู้อยู่ในไทย และมีอายุ ไม่ต่ำกว่า 65 ปี บริบูรณ์',190000,'A25',1,'C',NOW(),0),
('ยกเว้นเงินได้ที่ผู้มีเงินได้ซึ่งเป็นคนพิการอยู่ในไทย และมีอายุไม่เกิน 65 ปี บริบูรณ์',190000,'A26',1,'C',NOW(),0),
('ยกเว้นเงินได้จากการซื้ออสังหาริมทรัพย์ฯ',5000000,'A27',1,'C',NOW(),0),
('ยกเว้นเงินได้ที่ได้จ่ายเป็นค่าซ่อมแซมบ้านที่ได้รับผลกระทบจากอุทกภัยที่เกิดขึ้นในระหว่างวันที่ 25 ก.ค. 2554  – 31 ธ.ค. 2554',100000,'A28',1,'C',NOW(),0),
('ยกเว้นเงินได้ที่ได้จ่ายเป็นค่าซ่อมแซมรถยนต์ที่ได้รับผลกระทบจากอุทกภัยที่เกิดขึ้นในระหว่างวันที่ 25 ก.ค. 2554 – 31 ธ.ค. 2554',30000,'A29',1,'C',NOW(),0);


--APPLICANT
insert INTO APPLICANT (APPLICANT_CODE,FIRSTNAME_TH,FIRSTNAME_EN,LASTNAME_TH,LASTNAME_EN,NICKNAME_TH,NICKNAME_EN,BIRTHDATE,AGE,HEIGHT,WEIGHT,SEX,RELIGION,NATIONALITY,TEL,EMAIL,APPLICANT_STATUS,APPLY_DATE,EMERGENCY_NAME,EMERGENCY_TEL,EMERGENCY_ADDRESS,NOTICE_NEWSPAPER,NOTICE_MAGAZINE,NOTICE_FRIEND,NOTICE_WEBSITE,NOTICE_OTHER,NEWSPAPER_DESCRIPTION,MAGAZINE_DESCRIPTION,FRIEND_DESCRIPTION,WEBSITE_DESCRIPTION,OTHER_DESCRIPTION,MASJOBLEVEL_ID,MASTECHNOLOGY_ID,TRACKING_STATUS,EXPECTED_SALARY,CARD_ID,CARD_ISSUED_OFFICE,CARD_EXPIRY_DATE,MILITARY_FROM_YEAR,MILITARY_TO_YEAR,MILITARY_PLACE,MILITARY_SERVICE_NO,MILITARY_REASON,NUMBER_OF_CHILDREN,SPOUSE_NAME,MARRIAGE_CERTIFICATE_NO,ISSUE_OFFICE_MARRIAGE,OCCUPATION_MARRIAGE,PLACE_BIRTH,SCORE,TECH_SCORE,ATTITUDE_HOME,ATTITUDE_OFFICE,NOW_EMPLOYED,EMPLOYED_NAME,EMPLOYED_POSITION,EMPLOYED_RELATION,BRANCH_SERVICE,PREVIOUS_EMPLOYERS,PREVIOUS_EMPLOYERS_REASON,DATE_TO_BE_DRAFTED,MARRIAGE_ADDRESS,RESUME,TRANSCRIPT,IMAGE,MILITARY_STATUS,AUDITFLAG,CREATEDBY,CREATEDTIMESTAMP)
VALUES ('C201501','แย้ม','Yam','หมั่นกิจ','Mankit','แย้ม','Yam',STR_TO_DATE('26/01/1940','%d/%m/%Y'),75,165,45,'Female','Buddha','Thai','(021) 234-5678','yam@gmail.com','Married',STR_TO_DATE('26/05/2015','%d/%m/%Y'),'ประเทือง หมั่นกิจ','(091) 234-5678','บ้านหนองนมวัว','No','No','No','Yes','No','No','No','No','WEBSITE','No','4','2','Waiting for consider','25000','1111-1222-2334-4','บ้านหนองนมวัว',STR_TO_DATE('27/05/2017','%d/%m/%Y'),'No','No','No','No','No',3,'ประเทือง หมั่นกิจ','1234','บ้านหนองนมวัว','ชาวนา','Nakon Sawan','40/50','Pass','C#26','S#22','Yes','Ashley','Consultant','friend','No','No','Recently graduated',STR_TO_DATE('27/05/2030','%d/%m/%Y'),'72/2 Moo 5 Behind Somchai Estate,Soi 3,Bangkruay Sai Noi Road, Bangkruay Sub District, Bangkruay District, Nonthaburi Province 11130','resume.pdf','transcript.pdf','image.png','No','C',0,NOW()),
('C201502','แย้ม','Yam','หมั่นกิจ','Mankit','แย้ม','Yam',STR_TO_DATE('26/01/1940','%d/%m/%Y'),75,165,45,'Female','Buddha','Thai','(022) 234-5678','yam@gmail.com','Married',STR_TO_DATE('27/05/2015','%d/%m/%Y'),'ประเทือง หมั่นกิจ','(092) 234-5678','บ้านหนองนมวัว','No','No','No','Yes','No','No','No','No','WEBSITE','No','1','2','Waiting for consider','25000','1111-1222-2334-5','บ้านหนองนมวัว',STR_TO_DATE('27/05/2017','%d/%m/%Y'),'No','No','No','No','No',3,'ประเทือง หมั่นกิจ','1234','บ้านหนองนมวัว','ชาวนา','Nakon Sawan','40/50','Pass','C#26','S#22','Yes','Ashley','Consultant','friend','No','No','Recently graduated',STR_TO_DATE('27/05/2030','%d/%m/%Y'),'72/2 Moo 5 Behind Somchai Estate,Soi 3,Bangkruay Sai Noi Road, Bangkruay Sub District, Bangkruay District, Nonthaburi Province 11130','resume.pdf','transcript.pdf','image.png','No','C',0,NOW()),
('C201503','แย้ม','Yam','หมั่นกิจ','Mankit','แย้ม','Yam',STR_TO_DATE('26/01/1940','%d/%m/%Y'),75,165,45,'Male','Buddha','Thai','(023) 234-5678','yam@gmail.com','Married',STR_TO_DATE('29/06/2015','%d/%m/%Y'),'ประเทือง หมั่นกิจ','(093) 234-5678','บ้านหนองนมวัว','No','No','No','Yes','No','No','No','No','WEBSITE','No','1','2','Waiting for consider','25000','1111-1222-2334-6','บ้านหนองนมวัว',STR_TO_DATE('27/05/2017','%d/%m/%Y'),'No','No','No','No','No',3,'ประเทือง หมั่นกิจ','1234','บ้านหนองนมวัว','ชาวนา','Nakon Sawan','40/50','Not','I#24','C#22','Yes','Ashley','Consultant','friend','No','No','Recently graduated',STR_TO_DATE('27/05/2030','%d/%m/%Y'),'72/2 Moo 5 Behind Somchai Estate,Soi 3,Bangkruay Sai Noi Road, Bangkruay Sub District, Bangkruay District, Nonthaburi Province 11130','resume.pdf','transcript.pdf','image.png','No','C',0,NOW()),
('C201504','แย้ม','Yam','หมั่นกิจ','Mankit','แย้ม','Yam',STR_TO_DATE('26/01/1940','%d/%m/%Y'),75,165,45,'Female','Buddha','Thai','(024) 234-5678','yam@gmail.com','Married',STR_TO_DATE('28/06/2015','%d/%m/%Y'),'ประเทือง หมั่นกิจ','(094) 234-5678','บ้านหนองนมวัว','No','No','No','Yes','No','No','No','No','WEBSITE','No','1','2','Waiting for consider','25000','1111-1222-2334-7','บ้านหนองนมวัว',STR_TO_DATE('27/05/2017','%d/%m/%Y'),'No','No','No','No','No',3,'ประเทือง หมั่นกิจ','1234','บ้านหนองนมวัว','ชาวนา','Nakon Sawan','40/50','Pass','D#26','I#24','Yes','Ashley','Consultant','friend','No','No','Recently graduated',STR_TO_DATE('27/05/2030','%d/%m/%Y'),'72/2 Moo 5 Behind Somchai Estate,Soi 3,Bangkruay Sai Noi Road, Bangkruay Sub District, Bangkruay District, Nonthaburi Province 11130','resume.pdf','transcript.pdf','image.png','No','C',0,NOW());



--OFFICIAL
INSERT INTO OFFICIAL(OFFICIAL_DATE,START_WORK_DATE,END_WORK_DATE,POSITION_APPLIED_FOR,SALARY_EXPECTED,PROBATION_DATE,AUDITFLAG,CREATEDBY,CREATEDTIMESTAMP) VALUES (NOW(),'2010-03-04',NOW(),'Programmer',30000.00,NOW(),'C',0,NOW());
INSERT INTO OFFICIAL(OFFICIAL_DATE,START_WORK_DATE,END_WORK_DATE,POSITION_APPLIED_FOR,SALARY_EXPECTED,PROBATION_DATE,AUDITFLAG,CREATEDBY,CREATEDTIMESTAMP) VALUES (NOW(),'2010-03-04',NOW(),'SA',30000.00,NOW(),'C',0,NOW());
INSERT INTO OFFICIAL(OFFICIAL_DATE,START_WORK_DATE,END_WORK_DATE,POSITION_APPLIED_FOR,SALARY_EXPECTED,PROBATION_DATE,AUDITFLAG,CREATEDBY,CREATEDTIMESTAMP) VALUES (NOW(),'2010-03-04',NOW(),'TESTER',30000.00,NOW(),'C',0,NOW());
INSERT INTO OFFICIAL(OFFICIAL_DATE,START_WORK_DATE,END_WORK_DATE,POSITION_APPLIED_FOR,SALARY_EXPECTED,PROBATION_DATE,AUDITFLAG,CREATEDBY,CREATEDTIMESTAMP) VALUES (NOW(),'2010-03-04',NOW(),'TESTERS',38000.00,NOW(),'C',0,NOW());


--EMPLOYEE
INSERT INTO EMPLOYEE (EMPLOYEE_CODE,NAME_THAI,NAME_ENG,TEL_HOME,TEL_MOBILE,EMERGENCY_CONTACT,
EMERGENCY_CONTACT_PHONE_NUMBER,DATEOFBIRTH,ID_CARD,DIVISION_ID,JOBLEVEL_ID,TECHNOLOGY_ID,EMAIL,LOCATION_ID,EMPLOYMENT_ID,OFFICIAL_ID,STATUSEMP,AUDITFLAG,CREATEDBY,CREATEDTIMESTAMP,APPLICANT_ID) VALUES
('TH2009188','Bill','Bill',0811111111,0822222222,'Mom',191,'1991-01-01',12345678,1,1,1,'bill@gmail.com',1,1,1,'Employee','C',0,NOW(),1),
('TH2009189','Bill01','Bill01',0811111111,0822222222,'Mom',191,'1991-01-01',12345678,1,1,1,'bill@gmail.com',1,1,2,'Employee','C',0,NOW(),2),
('TH2009181','Bill','Bill01',0811111111,0822222222,'Mom',191,'1991-01-01',12345678,1,1,1,'bill@gmail.com',1,1,3,'Employee','C',0,NOW(),3);

--EMPLOYEE
INSERT INTO EMPLOYEE (EMPLOYEE_CODE,NAME_THAI,NAME_ENG,TEL_HOME,TEL_MOBILE,EMERGENCY_CONTACT,
EMERGENCY_CONTACT_PHONE_NUMBER,DATEOFBIRTH,ID_CARD,DIVISION_ID,JOBLEVEL_ID,TECHNOLOGY_ID,EMAIL,LOCATION_ID,EMPLOYMENT_ID,OFFICIAL_ID,STATUSEMP,AUDITFLAG,CREATEDBY,CREATEDTIMESTAMP,APPLICANT_ID,AIM_EMP_ID) VALUES
('TH20091875','Bill','Bill',0811111111,0822222222,'Mom',191,'1991-01-01',12345678,1,1,1,'bill@gmail.com',1,1,4,'Employee','C',0,NOW(),4,1);


--LOGIN
INSERT INTO LOGIN ( AUDITFLAG, CREATEDBY,CREATEDTIMESTAMP,USERNAME,PASSWORD,EMPLOYEE_ID,MAS_LOCATION_ID) VALUES
('C',0,NOW(),'admin','password',1,1),
('C',0,NOW(),'staff','password',2,2),
('C',0,NOW(),'hr','password',3,2);



--CERTIFICATION
insert INTO CERTIFICATION(APPLICANT_ID,CERTIFICATION_FORM,DESCRICPION,NAME,YEAR,AUDITFLAG,CREATEDBY,CREATEDTIMESTAMP)
VALUES ('1','java','java','java','2010','C',0,NOW()),('2','ccna','ccna','ccna','2010','C',0,NOW()),('3','.net','.net','.net','2010','C',0,NOW()),('4','microsoft','microsoft','microsoft','2010','C',0,NOW());


--EXPERIENCE
INSERT INTO EXPERIENCE (APPLICANT_ID,AUDITFLAG,CREATEDBY,CREATEDTIMESTAMP,ADDRESS,TYPE_OF_BUSINESS,DATE_FROM, DATE_TO, POSITION, REASON, REFERENCE, RESPONSIBILITY, SALARY)
VALUES('1','C',0,NOW(),'22/3 Bangkok','IT',STR_TO_DATE('01/04/2012','%d/%m/%Y'),STR_TO_DATE('01/08/2012','%d/%m/%Y'),'Consultance','-','John','-','30000'),
('2','C',0,NOW(),'22/4 Bangkok','IT',STR_TO_DATE('01/04/2012','%d/%m/%Y'),STR_TO_DATE('01/08/2012','%d/%m/%Y'),'Consultance','-','John','-','30000'),
('3','C',0,NOW(),'22/5 Bangkok','IT',STR_TO_DATE('01/04/2012','%d/%m/%Y'),STR_TO_DATE('01/08/2012','%d/%m/%Y'),'Consultance','-','John','-','30000'),
('4','C',0,NOW(),'22/6 Bangkok','IT',STR_TO_DATE('01/04/2012','%d/%m/%Y'),STR_TO_DATE('01/08/2012','%d/%m/%Y'),'Consultance','-','John','-','30000');


 --EDUCATION
INSERT INTO EDUCATION(APPLICANT_ID, AUDITFLAG, CREATEDBY, CREATEDTIMESTAMP, UNIVERSITY, DEGREETYPE_ID, MAJOR, FACULTY, GPA, START_DATE, GRADUATED_DATE, CERTIFICATION)
VALUES ('1','C',0,NOW(),'THAMMASAT UNIVERSITY','1','COM','SCIENCE','3.0',STR_TO_DATE('26/01/1940','%d/%m/%Y'),STR_TO_DATE('26/01/1944','%d/%m/%Y'),'TOEIC 400'),
('2','C',0,NOW(),'MAHIDOL UNIVERSITY','1','COM','SCIENCE','3.0',STR_TO_DATE('26/01/1940','%d/%m/%Y'),STR_TO_DATE('26/01/1944','%d/%m/%Y'),'TOEIC 400'),
('3','C',0,NOW(),'KASETSART UNIVERSITY','1','MARKETING','BA','2.5',STR_TO_DATE('26/01/1940','%d/%m/%Y'),STR_TO_DATE('26/01/1944','%d/%m/%Y'),'TOEIC 400'),
('4','C',0,NOW(),'BANGKOK UNIVERSITY','2','ENVI','SCIENCE','2.0',STR_TO_DATE('26/01/1940','%d/%m/%Y'),STR_TO_DATE('26/01/1944','%d/%m/%Y'),'TOEIC 400');



--LOGINROLE
INSERT INTO LOGINROLE ( LOGIN_ID,MASROLE_ID) VALUES
(2,2),
(3,2);


--REWARD
INSERT INTO REWARD(TYPE_REWARD,YEAR,EMPLOYEE_ID,AUDITFLAG,CREATEDBY,CREATEDTIMESTAMP)
VALUES('nobel','1991',1,'C',0,NOW());


-- REFERENCE
INSERT INTO REFERENCE(NAME,ADDRESS,TELEPHONE,OCCUPATION,AUDITFLAG,CREATEDBY,CREATEDTIMESTAMP,APPLICANT_ID)
VALUES ('A','22/1 Bangkok','0817334542','Consultant','C',0,NOW(),1),
('B','22/2 Bangkok','0817334542','Actor','C',0,NOW(),2),
('C','22/3 Bangkok','0817334542','HR','C',0,NOW(),3),
('D','22/4 Bangkok','0817334542','Freelance','C',0,NOW(),4);


--Allowances
INSERT INTO ALLOWANCES(AMOUNT,EMPLOYEE_ID,MAS_ALLOWANCES_ID,AUDITFLAG,CREATEDBY,CREATEDTIMESTAMP)
VALUES(6000,1,1,'C',0,NOW()),
(3000,1,1,'C',0,NOW());

--HISTORY
INSERT INTO HISTORY (POSITION,SALARY,DATE_OF_ADJUSTMENT,EMPLOYEE_ID,AUDITFLAG,CREATEDBY,CREATEDTIMESTAMP) 
VALUES ('CEO',45000,'2015-09-09',1,'C',0,NOW()),
('HR',15000,'2015-09-09',1,'C',0,NOW());


-- RROBATION
INSERT INTO PROBATION(DATE_FROM,DATE_TO,STATUS,REASON,AUDITFLAG,CREATEDBY,CREATEDTIMESTAMP,EMPLOYEE_ID)
VALUES ('1991-01-01','1991-01-01','Pass','Study','C',0,NOW(),1),
('1991-01-01','1991-01-01','Not Pass','Study','C',0,NOW(),2);

-- Aug Request
insert INTO AUG_REQUEST (REQUEST_DATE,REQUESTER_NAME,STATUS,APPROVAL_NAME,APPROVE_DATE,NUMBER_APPLICANT,SPECIFIC_SKILL,YEAR_EXPERIENCE, AUDITFLAG, CREATEDBY, CREATEDTIMESTAMP)
VALUES (STR_TO_DATE('26/05/2015','%d/%m/%Y'),'SamSmith','New Request','ChrisBrown',STR_TO_DATE('27/05/2015','%d/%m/%Y'),'2','HibernateSping','3','C',0,NOW()),
(STR_TO_DATE('26/05/2015','%d/%m/%Y'),'SamSmith','New Request','ChrisBrown',STR_TO_DATE('27/05/2015','%d/%m/%Y'),'2','HibernateSping','3','C',0,NOW());

--Address
INSERT INTO ADDRESS(HOUSE_NO,ROAD,DISTRICT,SUB_DISTRICT,ZIPCODE,APPLICANT_ID,ADDRESSTYPE_ID,PROVINCE_ID,auditFlag,createdBy,createdTimeStamp)
VALUES('528','Sukhumvit','Mung','Mung',10250,2,1,30,'C',0,NOW());
