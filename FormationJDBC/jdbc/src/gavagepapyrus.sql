CREATE OR REPLACE FUNCTION bonjour (nom VARCHAR)
RETURN CHAR AS
BEGIN
	RETURN 'Bonjour ' || nom;
END;
/
CREATE OR REPLACE
PACKAGE TYPES
AS
    TYPE ref_cursor IS REF CURSOR;
END TYPES;
/
CREATE OR REPLACE
PROCEDURE LST_FOURNIS 
    (
        pnumfou IN VARCHAR2,
        lstfour OUT types.ref_cursor
    ) AS
    curfour types.ref_cursor;
BEGIN
    OPEN lstfour FOR
    SELECT * FROM FOURNIS WHERE NUMFOU > pnumfou;
END LST_FOURNIS;
