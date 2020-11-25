package com.dkit.sd2a.jessicasavage;

public class StudentBooking {
    private int bookingID;
    private String bookingTimeDate;
    private String returnTimeDate;
    private String type;
    private String assetTag;
    private String studentID;

    public StudentBooking(int bookingID, String bookingTimeDate, String returnTimeDate, String type, String assetTag, String studentID) {
        this.bookingID = bookingID;
        this.bookingTimeDate = bookingTimeDate;
        this.returnTimeDate = returnTimeDate;
        this.type = type;
        this.assetTag = assetTag;
        this.studentID = studentID;
    }

    public int getBookingID() {
        return bookingID;
    }

    public String getBookingTimeDate() {
        return bookingTimeDate;
    }

    public String getReturnTimeDate() {
        return returnTimeDate;
    }

    public String getType() {
        return type;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public String getStudentID() {
        return studentID;
    }

    @Override
    public String toString() {
        return "StudentBooking{" +
                "bookingID=" + bookingID +
                ", bookingTimeDate='" + bookingTimeDate + '\'' +
                ", returnTimeDate='" + returnTimeDate + '\'' +
                ", type='" + type + '\'' +
                ", assetTag='" + assetTag + '\'' +
                ", studentID='" + studentID + '\'' +
                '}';
    }
}
