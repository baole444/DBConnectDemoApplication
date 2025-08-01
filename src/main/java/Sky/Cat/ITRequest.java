package Sky.Cat;

import dbConnect.DataModel;
import dbConnect.models.autogen.AutomaticField;
import dbConnect.models.autogen.PrimaryField;
import dbConnect.models.constrain.MaxLength;
import dbConnect.models.constrain.MongoOnly;
import dbConnect.models.constrain.MySQLOnly;
import dbConnect.models.meta.CollectionName;
import dbConnect.models.meta.TableName;
import dbConnect.models.notnull.NotNullField;
import org.bson.types.ObjectId;

@TableName("ITRequest")
@CollectionName("requests")
public class ITRequest extends DataModel<ITRequest> {
    @AutomaticField @PrimaryField @MySQLOnly
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
