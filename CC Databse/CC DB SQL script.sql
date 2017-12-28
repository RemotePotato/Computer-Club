--FACULTY TABLE
CREATE TABLE FACULTY (FACULTYCODE VARCHAR(4) NOT NULL, FACULTYNAME VARCHAR(200) NOT NULL, PRIMARY KEY (FACULTYCODE));
INSERT INTO ROOT.FACULTY (FACULTYCODE, FACULTYNAME) 
	VALUES ('FASC', 'Faculty of Applied Science and Computing');
INSERT INTO ROOT.FACULTY (FACULTYCODE, FACULTYNAME) 
	VALUES ('FAFB', 'Faculty of Accounting, Finance & Business');
INSERT INTO ROOT.FACULTY (FACULTYCODE, FACULTYNAME) 
	VALUES ('FSAH', 'Faculty of Social Science, Arts & Humanities');

--PROGRAMME TABLE
CREATE TABLE PROGRAMME (PROGCODE VARCHAR(3) NOT NULL, PROGNAME VARCHAR(200), FACULTYCODE VARCHAR(4) NOT NULL, PRIMARY KEY (PROGCODE));
INSERT INTO ROOT.PROGRAMME (PROGCODE, PROGNAME, FACULTYCODE) 
	VALUES ('DIA', 'Diploma in Science (Information Systems Engineering)', 'FASC');
INSERT INTO ROOT.PROGRAMME (PROGCODE, PROGNAME, FACULTYCODE) 
	VALUES ('DHM', 'Diploma in Hotel Management', 'FSAH');


--MEMBER TABLE
CREATE TABLE MEMBER (MEMBERID VARCHAR(10) NOT NULL, PROGCODE VARCHAR(3) NOT NULL, FIRSTNAME VARCHAR(255) NOT NULL, LASTNAME VARCHAR(255) NOT NULL, EMAIL VARCHAR(200) NOT NULL, CONTACTNUM VARCHAR(20) NOT NULL, ICNUM VARCHAR(12) NOT NULL, PASS VARCHAR(255) NOT NULL, GENDER VARCHAR(1) NOT NULL, MEMFEESTATS BOOLEAN DEFAULT false  NOT NULL, "POSITION" INTEGER NOT NULL, ACADEMICYEAR VARCHAR(9) NOT NULL, PRIMARY KEY (MEMBERID));
INSERT INTO ROOT.MEMBER (MEMBERID, PROGCODE, FIRSTNAME, LASTNAME, EMAIL, CONTACTNUM, ICNUM, PASS, GENDER, MEMFEESTATS, "POSITION", ACADEMICYEAR) 
	VALUES ('16SMD00990', 'DIA', 'Samuel', 'Wong Kim Foong', 'samuelwkf-sa16@student.tarc.edu.my', '014-5569877', '981130125591', 'Pj02Njg1Njc6Oj42', 'M', true, 5, '2016/2017');

--EVENT TABLE
CREATE TABLE EVENT (EVENTID VARCHAR(10) NOT NULL, EVENTNAME VARCHAR(255), EVENTTYPE INTEGER, EVENTDATE DATE, EVENTTIME TIME, EVENTLOCATION VARCHAR(255), PRIMARY KEY (EVENTID));

--EVENTMEMBER TABLE (BRIDGE TABLE FOR MEMBER && EVENT)
CREATE TABLE EVENTMEMBER (EVENTMEMBERID INTEGER NOT NULL, MEMBERID VARCHAR(10), EVENTID VARCHAR(10), PRIMARY KEY (EVENTMEMBERID));

--EVENTCOLLABORATOR TABLE (BRIDGE TABLE FOR EVENT && COLLABORATOR)
CREATE TABLE EVENTCOLLABORATOR (EVENTCOLLABID INTEGER NOT NULL, EVENTID VARCHAR(10), COLLABCODE VARCHAR(10), PRIMARY KEY (EVENTCOLLABID));

--COLLABORATOR TABLE
CREATE TABLE COLLABORATOR (COLLABCODE VARCHAR(10) NOT NULL, COLLABNAME VARCHAR(255) NOT NULL, COLLABTYPE INTEGER NOT NULL, CONTACTNO VARCHAR(20) NOT NULL, EMAIL VARCHAR(255), ADDITIONALNOTES VARCHAR(255), PRIMARY KEY (COLLABCODE));

--SPONSOREDITEM TABLE
CREATE TABLE SPONSOREDITEM (ITEMCODE VARCHAR(10) NOT NULL, COLLABCODE VARCHAR(10) NOT NULL, ITEMTYPE INTEGER NOT NULL, ITEMNAME VARCHAR(255) NOT NULL, ITEMQUANTITY INTEGER NOT NULL, PRIMARY KEY (ITEMCODE));

ALTER TABLE EVENTMEMBER ADD FOREIGN KEY(MEMBERID) REFERENCES MEMBER;
ALTER TABLE EVENTMEMBER ADD FOREIGN KEY(EVENTID) REFERENCES EVENT;
ALTER TABLE EVENTCOLLABORATOR ADD FOREIGN KEY(EVENTID) REFERENCES COLLABORATOR;
ALTER TABLE EVENTCOLLABORATOR ADD FOREIGN KEY(COLLABCODE) REFERENCES EVENT;
ALTER TABLE SPONSOREDITEM ADD FOREIGN KEY(COLLABCODE) REFERENCES COLLABORATOR;
