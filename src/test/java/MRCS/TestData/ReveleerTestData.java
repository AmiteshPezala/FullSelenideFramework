package MRCS.TestData;

import MRCS.Utils.ExcelUtil;
import com.codoid.products.fillo.Recordset;

import java.util.Date;

public class ReveleerTestData {
    private String First_Name,Last_Name,Address,Address2,State,City,Zip_Code,Phone_Number,Email,TextArea,AdminContact,IT_Contact,EMR_System;

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAddress2() {
        return Address2;
    }

    public void setAddress2(String address2) {
        Address2 = address2;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getZip_Code() {
        return Zip_Code;
    }

    public void setZip_Code(String zip_Code) {
        Zip_Code = zip_Code;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
    public String getTextArea() {
        return TextArea;
    }

    public void setTextArea(String textArea) {
        TextArea = textArea;
    }
    public String getAdminContact() {
        return AdminContact;
    }

    public void setAdminContact(String adminContact) {
        AdminContact = adminContact;
    }

    public String getIT_Contact() {
        return IT_Contact;
    }

    public void setIT_Contact(String IT_Contact) {
        this.IT_Contact = IT_Contact;
    }

    public String getEMR_System() {
        return EMR_System;
    }

    public void setEMR_System(String EMR_System) {
        this.EMR_System = EMR_System;
    }
@Override
    public String toString() {
    return "ReveleerTestData{" +
            "First_Name='" + First_Name + '\'' +
            ", Last_Name='" + Last_Name + '\'' +
            ", Address='" + Address + '\'' +
            ", Address='" + Address2 + '\'' +
            ", State='" + State + '\'' +
            ", City='" + City + '\'' +
            ", Zip_Code='" + Zip_Code + '\'' +
            ", Phone_Number='" + Phone_Number + '\'' +
            ", Email='" + Email + '\'' +
            ", TextArea='" + TextArea + '\'' +
            ",EMR_System='" + EMR_System +'\'' +
            ",IT_Contact='" + IT_Contact +'\'' +
            ",AdminContact='" + AdminContact + '\'' +
            '}';
}

public void GetData(String module) throws Exception {
    Recordset rs = ExcelUtil.GetTestData("Data", module);
    Date d = new Date(System.currentTimeMillis());

    while (rs.next()) {

        this.setFirst_Name(rs.getField("First_Name"));
        this.setLast_Name(rs.getField("Last_Name"));
        this.setAddress(rs.getField("Address"));
        this.setState(rs.getField("State"));
        this.setCity(rs.getField("City"));
        this.setZip_Code(rs.getField("Zip_Code"));
        this.setAddress2(rs.getField("Address2"));
        this.setEmail(rs.getField("Email"));
        this.setPhone_Number(rs.getField("Phone_Number"));
        this.setTextArea(rs.getField("TextArea"));
        this.setAdminContact(rs.getField("AdminContact"));
        this.setIT_Contact(rs.getField("IT_Contact"));
        this.setEMR_System(rs.getField("EMR_System"));
    }
    rs.close();
}
}
