package Sky.Cat;

import com.mongodb.MongoException;
import dbConnect.DataModel;
import dbConnect.mapper.DocumentInterface;
import dbConnect.mapper.ResultSetInterface;
import dbConnect.models.autogen.AutomaticField;
import dbConnect.models.autogen.PrimaryField;
import dbConnect.models.constrain.MaxLength;
import dbConnect.models.constrain.MongoOnly;
import dbConnect.models.meta.CollectionName;
import dbConnect.models.meta.TableName;
import dbConnect.models.notnull.NotNullField;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.sql.ResultSet;
import java.sql.SQLException;

@TableName("ITRequest")
@CollectionName("requests")
public class ITRequest extends DataModel<ITRequest> {
    @AutomaticField @PrimaryField
    private int ReqID;

    @MongoOnly @AutomaticField
    private ObjectId _id;

    @NotNullField @MaxLength
    private String ReqName;

    @NotNullField
    private java.util.Date ReqDate;

    @NotNullField @MaxLength
    private String ReqEmail;

    @MaxLength
    private String ReqType;

    @MaxLength
    private String ReqDetails;

    public ITRequest() {
    }

    public ITRequest(String reqName, java.util.Date reqDate, String reqEmail, String reqType, String reqDetails) {
        ReqName = reqName;
        ReqDate = reqDate;
        ReqEmail = reqEmail;
        ReqType = reqType;
        ReqDetails = reqDetails;
    }

    public ITRequest(int reqID, String reqName, java.util.Date reqDate, String reqEmail, String reqType, String reqDetails) {
        ReqID = reqID;
        ReqName = reqName;
        ReqDate = reqDate;
        ReqEmail = reqEmail;
        ReqType = reqType;
        ReqDetails = reqDetails;
    }

    public ITRequest(ObjectId id, String reqName, java.util.Date reqDate, String reqEmail, String reqType, String reqDetails) {
        _id = id;
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

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId id) {
        _id = id;

    }
    public String getReqName() {
        return ReqName;
    }

    public void setReqName(String reqName) {
        ReqName = reqName;
    }

    public java.util.Date getReqDate() {
        return ReqDate;
    }

    public void setReqDate(java.util.Date reqDate) {
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

    public static class ITRequestSQLMap implements ResultSetInterface<ITRequest> {
        @Override
        public ITRequest map(ResultSet resultSet) throws SQLException {
            int ReqID = resultSet.getInt("ReqID");
            String ReqName = resultSet.getString("ReqName");
            java.util.Date ReqDate = resultSet.getDate("ReqDate");
            String ReqEmail = resultSet.getString("ReqEmail");
            String ReqType = resultSet.getString("ReqType");
            String ReqDetails = resultSet.getString("ReqDetails");
            return new ITRequest(ReqID, ReqName, ReqDate, ReqEmail, ReqType, ReqDetails);
        }
    }

    public static class ITRequestMongoMap implements DocumentInterface<ITRequest> {
        @Override
        public ITRequest map(Document document) throws MongoException {
            ObjectId id = document.getObjectId("_id");
            String ReqName = document.getString("ReqName");
            java.util.Date ReqDate = document.getDate("ReqDate");
            String ReqEmail = document.getString("ReqEmail");
            String ReqType = document.getString("ReqType");
            String ReqDetails = document.getString("ReqDetails");
            return new ITRequest(id, ReqName, ReqDate, ReqEmail, ReqType, ReqDetails);
        }
    }

    @Override
    public ResultSetInterface<ITRequest> getTableMap() {
        return new ITRequestSQLMap();

    }

    @Override
    public DocumentInterface<ITRequest> getCollectionMap() {
        return new ITRequestMongoMap();
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
