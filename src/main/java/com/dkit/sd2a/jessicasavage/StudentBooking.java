package com.dkit.sd2a.jessicasavage;

import java.time.LocalDate;
import java.util.Objects;

public class StudentBooking{
    private int bookingID;
    private LocalDate bookingTimeDate;
    private LocalDate returnTimeDate = null;
    private String type;
    private String assetTag;
    private String studentID;

    public StudentBooking(int bookingID, LocalDate bookingTimeDate, LocalDate returnTimeDate, String type, String assetTag, String studentID) {
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

    public LocalDate getBookingTimeDate() {
        return bookingTimeDate;
    }

    public LocalDate getReturnTimeDate() {
        return returnTimeDate;
    }

    public String getType() {
        return type;
    }

    public String getAssetTag() { return assetTag; }

    public String getStudentID() {
        return studentID;
    }

    public void setBookingID(int bookingID) { this.bookingID = bookingID; }

    public void setBookingTimeDate(LocalDate bookingTimeDate) { this.bookingTimeDate = bookingTimeDate; }

    public void setReturnTimeDate(LocalDate returnTimeDate) { this.returnTimeDate = returnTimeDate; }

    public void setType(String type) { this.type = type; }

    public void setAssetTag(String assetTag) { this.assetTag = assetTag; }

    public void setStudentID(String studentID) { this.studentID = studentID; }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentBooking that = (StudentBooking) o;
        return bookingID == that.bookingID &&
                Objects.equals(bookingTimeDate, that.bookingTimeDate) &&
                Objects.equals(returnTimeDate, that.returnTimeDate) &&
                Objects.equals(type, that.type) &&
                Objects.equals(assetTag, that.assetTag) &&
                Objects.equals(studentID, that.studentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingID, bookingTimeDate, returnTimeDate, type, assetTag, studentID);
    }
}
