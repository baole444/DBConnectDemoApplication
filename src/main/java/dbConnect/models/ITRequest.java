package dbConnect.models;

import dbConnect.DBMapper;
import dbConnect.models.autogen.AutomaticField;
import dbConnect.models.autogen.PrimaryField;
import dbConnect.models.constrain.MaxLength;
import dbConnect.models.enums.Table;
import dbConnect.models.notnull.NotNullField;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ITRequest {
    @AutomaticField @PrimaryField
    private int ReqID;

    @NotNullField @MaxLength
    private String ReqName;

    @NotNullField
    private Date ReqDate;

    @NotNullField @MaxLength
    private String ReqEmail;

    @MaxLength
    private String ReqType;

    @MaxLength
    private String ReqDetails;

    public ITRequest() {
    }

    public ITRequest(String reqName, Date reqDate, String reqEmail, String reqType, String reqDetails) {
        ReqName = reqName;
        ReqDate = reqDate;
        ReqEmail = reqEmail;
        ReqType = reqType;
        ReqDetails = reqDetails;
    }

    public ITRequest(int reqID, String reqName, Date reqDate, String reqEmail, String reqType, String reqDetails) {
        ReqID = reqID;
        ReqName = reqName;
        ReqDate = reqDate;
        ReqEmail = reqEmail;
        ReqType = reqType;
        ReqDetails = reqDetails;
    }

    public int getReqID() {
        return ReqID;
    }

    public void setReqID(int reqID) {
        ReqID = reqID;
    }

    public String getReqName() {
        return ReqName;
    }

    public void setReqName(String reqName) {
        ReqName = reqName;
    }

    public Date getReqDate() {
        return ReqDate;
    }

    public void setReqDate(Date reqDate) {
        ReqDate = reqDate;
    }

    public String getReqEmail() {
        return ReqEmail;
    }

    public void setReqEmail(String reqEmail) {
        ReqEmail = reqEmail;
    }

    public String getReqType() {
        return ReqType;
    }

    public void setReqType(String reqType) {
        ReqType = reqType;
    }

    public String getReqDetails() {
        return ReqDetails;
    }

    public void setReqDetails(String reqDetails) {
        ReqDetails = reqDetails;
    }

    public static class ITRequestMap implements DBMapper<ITRequest> {
        @Override
        public ITRequest map(ResultSet resultSet) throws SQLException {
            int ReqID = resultSet.getInt("ReqID");
            String ReqName = resultSet.getString("ReqName");
            Date ReqDate = resultSet.getDate("ReqDate");
            String ReqEmail = resultSet.getString("ReqEmail");
            String ReqType = resultSet.getString("ReqType");
            String ReqDetails = resultSet.getString("ReqDetails");
            return new ITRequest(ReqID, ReqName, ReqDate, ReqEmail, ReqType, ReqDetails);
        }
    }

    public static Table getTable() {
        return Table.ITRequest;
    }

    public static DBMapper<ITRequest> getMap() {
        return new ITRequestMap();

    }

    @Override
    public String toString() {
        return "ID: " + ReqID + " | From: " + ReqEmail;

    }

    public String toPrettyString() {
        return "IT Request System" +
                "\nRequest ID: " + ReqID +
                "\nFrom: " + ReqEmail +
                "\nWith name: " + ReqName +
                "\nAt: " + ReqDate.toString() +
                "\nTask: " + ReqType +
                "\nAdditional note: " + ReqDetails + "\n \n";


    }
}
