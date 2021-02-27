package com.vidvaan.queries;

public interface Queries {
	String EMP_FIND_ALL = "SELECT * FROM EMPLOYEE";
	String EMP_FIND_BY_ID = "SELECT * FROM EMPLOYEE WHERE EID = ?";
	String EMP_INSERT = "INSERT INTO EMPLOYEE VALUES(EMP_SEQ.NEXTVAL,?,?)";
	String EMP_UPDATE = "UPDATE EMPLOYEE SET ENAME = ?, ESAL = ? WHERE EID = ?";
	String EMP_DELETE = "DELETE FROM EMPLOYEE WHERE EID = ?";

}
