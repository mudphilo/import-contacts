package ke.co.allysuperapp.contacts;

public class ContactInfo {

    private String ContactName;
    private String ContactNumber;
    private String ContactEmail;

    /**
     * gets contact name
     * @return String
     */
    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    /**
     * get contact number
     * @return String
     */
    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }


    public void setContactEmail(String contactEmail) {
        ContactEmail = contactEmail;
    }

    /**
     * gets email
     * @return String
     */

    public String getContactEmail() {
        return ContactEmail;
    }

    @Override
    public String toString() {

        return "\nNAME: --> "+getContactName()+"\nEMAIL: --> "+getContactEmail()+"\nNUMBER: --> "+getContactNumber();
    }
}
