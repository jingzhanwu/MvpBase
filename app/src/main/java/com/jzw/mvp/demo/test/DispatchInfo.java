package com.jzw.mvp.demo.test;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @anthor created by jingzhanwu
 * @date 2018/1/4 0004
 * @change
 **/
public class DispatchInfo implements Parcelable {

    private String id;                 //201801101153466101030150,
    /**
     * 事件单号
     */
    private String incidentId;          //20180110115346610103011591,
    /**
     * 接警单号
     */
    private String receiveAlarmId;       //20180110115346610103011591,
    /**
     * 报警类别代码
     */
    private String alarmMode;            //null,
    /**
     * 报警类别名称
     */
    private String alarmModeCV;            //null,
    private String adminRegionId;          //610103,
    private String dispatchUnitCode;          //2,
    private String dispatchOfficerId;      //33,
    /**
     * 处警员
     */
    private String dispatchOfficerName;       //接警员1,
    private String dispatchAlarmDeskId;        //,
    private String dispatchAlarmDeskIP;         //,
    /**
     * 处警时间
     */
    private String dispatchTime;               //2018-01-10 11;//53;//47,
    private String dispatchRecordId;          //null,
    /**
     * 处警指令
     */
    private String dispatchOpinion;           //,
    /**
     * 出动单位类型
     */
    private String outUnitType;               //2,
    private String outUnitCode;               //41,
    private String outOfficerId;              //null,
    /**
     * 出动人
     */
    private String outOfficerName;              //null,
    private String dispatchEndTime;             //2018-01-10 11;//53;//47,
    /**
     * 到达时间
     */
    private String sendArriveTime;                //2018-01-10 11;//53;//47,
    /**
     * 接收时间
     */
    private String sendReceiveTime;                 //null,
    /**
     * 状态
     */
    private int alarmStatus;                     //30,
    private String outPerson;                      //null,
    private String outCar;                    //null,
    private String feedbackTime;               //null,
    private String createTime;               //2018-01-10 11;//53;//47,
    private String updateTime;               //2018-01-10 18;//50;//32

    public DispatchInfo() {

    }

    public DispatchInfo(String id, String level, String address, int status, String name, String time) {
        this.id = id;
        this.alarmMode = level;
        this.alarmStatus = status;
        this.dispatchOfficerName = name;
        this.dispatchTime = time;
    }

    protected DispatchInfo(Parcel in) {
        id = in.readString();
        incidentId = in.readString();
        receiveAlarmId = in.readString();
        alarmMode = in.readString();
        alarmModeCV = in.readString();
        adminRegionId = in.readString();
        dispatchUnitCode = in.readString();
        dispatchOfficerId = in.readString();
        dispatchOfficerName = in.readString();
        dispatchAlarmDeskId = in.readString();
        dispatchAlarmDeskIP = in.readString();
        dispatchTime = in.readString();
        dispatchRecordId = in.readString();
        dispatchOpinion = in.readString();
        outUnitType = in.readString();
        outUnitCode = in.readString();
        outOfficerId = in.readString();
        outOfficerName = in.readString();
        dispatchEndTime = in.readString();
        sendArriveTime = in.readString();
        sendReceiveTime = in.readString();
        alarmStatus = in.readInt();
        outPerson = in.readString();
        outCar = in.readString();
        feedbackTime = in.readString();
        createTime = in.readString();
        updateTime = in.readString();
    }

    public static final Creator<DispatchInfo> CREATOR = new Creator<DispatchInfo>() {
        @Override
        public DispatchInfo createFromParcel(Parcel in) {
            return new DispatchInfo(in);
        }

        @Override
        public DispatchInfo[] newArray(int size) {
            return new DispatchInfo[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
    }

    public String getReceiveAlarmId() {
        return receiveAlarmId;
    }

    public void setReceiveAlarmId(String receiveAlarmId) {
        this.receiveAlarmId = receiveAlarmId;
    }

    public String getAlarmMode() {
        return alarmMode;
    }

    public void setAlarmMode(String alarmMode) {
        this.alarmMode = alarmMode;
    }

    public String getAlarmModeCV() {
        return alarmModeCV;
    }

    public void setAlarmModeCV(String alarmModeCV) {
        this.alarmModeCV = alarmModeCV;
    }

    public String getAdminRegionId() {
        return adminRegionId;
    }

    public void setAdminRegionId(String adminRegionId) {
        this.adminRegionId = adminRegionId;
    }

    public String getDispatchUnitCode() {
        return dispatchUnitCode;
    }

    public void setDispatchUnitCode(String dispatchUnitCode) {
        this.dispatchUnitCode = dispatchUnitCode;
    }

    public String getDispatchOfficerId() {
        return dispatchOfficerId;
    }

    public void setDispatchOfficerId(String dispatchOfficerId) {
        this.dispatchOfficerId = dispatchOfficerId;
    }

    public String getDispatchOfficerName() {
        return dispatchOfficerName;
    }

    public void setDispatchOfficerName(String dispatchOfficerName) {
        this.dispatchOfficerName = dispatchOfficerName;
    }

    public String getDispatchAlarmDeskId() {
        return dispatchAlarmDeskId;
    }

    public void setDispatchAlarmDeskId(String dispatchAlarmDeskId) {
        this.dispatchAlarmDeskId = dispatchAlarmDeskId;
    }

    public String getDispatchAlarmDeskIP() {
        return dispatchAlarmDeskIP;
    }

    public void setDispatchAlarmDeskIP(String dispatchAlarmDeskIP) {
        this.dispatchAlarmDeskIP = dispatchAlarmDeskIP;
    }

    public String getDispatchTime() {
        return dispatchTime;
    }

    public void setDispatchTime(String dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    public String getDispatchRecordId() {
        return dispatchRecordId;
    }

    public void setDispatchRecordId(String dispatchRecordId) {
        this.dispatchRecordId = dispatchRecordId;
    }

    public String getDispatchOpinion() {
        return dispatchOpinion;
    }

    public void setDispatchOpinion(String dispatchOpinion) {
        this.dispatchOpinion = dispatchOpinion;
    }

    public String getOutUnitType() {
        return outUnitType;
    }

    public void setOutUnitType(String outUnitType) {
        this.outUnitType = outUnitType;
    }

    public String getOutUnitCode() {
        return outUnitCode;
    }

    public void setOutUnitCode(String outUnitCode) {
        this.outUnitCode = outUnitCode;
    }

    public String getOutOfficerId() {
        return outOfficerId;
    }

    public void setOutOfficerId(String outOfficerId) {
        this.outOfficerId = outOfficerId;
    }

    public String getOutOfficerName() {
        return outOfficerName;
    }

    public void setOutOfficerName(String outOfficerName) {
        this.outOfficerName = outOfficerName;
    }

    public String getDispatchEndTime() {
        return dispatchEndTime;
    }

    public void setDispatchEndTime(String dispatchEndTime) {
        this.dispatchEndTime = dispatchEndTime;
    }

    public String getSendArriveTime() {
        return sendArriveTime;
    }

    public void setSendArriveTime(String sendArriveTime) {
        this.sendArriveTime = sendArriveTime;
    }

    public String getSendReceiveTime() {
        return sendReceiveTime;
    }

    public void setSendReceiveTime(String sendReceiveTime) {
        this.sendReceiveTime = sendReceiveTime;
    }

    public int getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(int alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    public String getOutPerson() {
        return outPerson;
    }

    public void setOutPerson(String outPerson) {
        this.outPerson = outPerson;
    }

    public String getOutCar() {
        return outCar;
    }

    public void setOutCar(String outCar) {
        this.outCar = outCar;
    }

    public String getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(String feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(incidentId);
        parcel.writeString(receiveAlarmId);
        parcel.writeString(alarmMode);
        parcel.writeString(alarmModeCV);
        parcel.writeString(adminRegionId);
        parcel.writeString(dispatchUnitCode);
        parcel.writeString(dispatchOfficerId);
        parcel.writeString(dispatchOfficerName);
        parcel.writeString(dispatchAlarmDeskId);
        parcel.writeString(dispatchAlarmDeskIP);
        parcel.writeString(dispatchTime);
        parcel.writeString(dispatchRecordId);
        parcel.writeString(dispatchOpinion);
        parcel.writeString(outUnitType);
        parcel.writeString(outUnitCode);
        parcel.writeString(outOfficerId);
        parcel.writeString(outOfficerName);
        parcel.writeString(dispatchEndTime);
        parcel.writeString(sendArriveTime);
        parcel.writeString(sendReceiveTime);
        parcel.writeInt(alarmStatus);
        parcel.writeString(outPerson);
        parcel.writeString(outCar);
        parcel.writeString(feedbackTime);
        parcel.writeString(createTime);
        parcel.writeString(updateTime);
    }
}
