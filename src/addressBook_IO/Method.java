package addressBook_IO;

import java.util.*;

public class Method {
    static Scanner sc = new Scanner(System.in);

    HashMap<String, HashSet<PersonDetails>> bookMap = new HashMap<String, HashSet<PersonDetails>>();

    // Add Record Details to the addressBook.
    public void addRecord() {
        System.out.println("Enter the Name of Address Book to add record: ");
        String name = sc.next();

        for (Map.Entry<String, HashSet<PersonDetails>> m : bookMap.entrySet()) { //iterate over hashmap
            if (m.getKey().equals(name)) {                                        //check for key

                System.out.println("Enter the record details:");
                System.out.println("Enter First Name");
                String firstName = sc.next();
                System.out.println("Enter last Name");
                String lastName = sc.next();
                System.out.println("Enter Address ");
                String address = sc.next();
                System.out.println("Enter City ");
                String city = sc.next();
                System.out.println("Enter State ");
                String state = sc.next();
                System.out.println("Enter  Email ");
                String email = sc.next();
                System.out.println("Enter phone Number");
                String phoneNumber = sc.next();
                System.out.println("Enter Zip code");
                String zip = sc.next();

                HashSet<PersonDetails> value = m.getValue();
                PersonDetails b = new PersonDetails(firstName, lastName, address, city, state, email, phoneNumber, zip);
                boolean add = value.add(b);
                if(add==false)
                    System.out.println("details already exists,try new");
                else
                    bookMap.put(m.getKey(), value);
            }else
                System.out.println("addressbook not found,u need to create it");
        }
    }

    // Edit record Detail By Firstname
    public void editRecord() {
        System.out.println("Enter the Person First name to edit details: ");
        String name = sc.next();

        int flag = 0;
        for (Map.Entry<String, HashSet<PersonDetails>> m : bookMap.entrySet()) { //iterate over hashmap
            for (PersonDetails record : m.getValue()) {//iterates over hashset
                if (record.getFirstName().equals(name)) {

                    System.out.println("Select an option to edit\n"
                            + "1] First Name\n"
                            + "2] Last Name\n"
                            + "3] Address\n"
                            + "4] City\n"
                            + "5] State\n"
                            + "6] Email\n"
                            + "7] phone Number\n"
                            + "8] ZIP code\n"
                            + "9] Exit\n");

                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1: {
                            System.out.println("Enter First Name: ");
                            String firstName = sc.next();
                            record.setFirstName(firstName);
                            break;
                        }
                        case 2: {
                            System.out.println("Enter last name: ");
                            String lastName = sc.next();
                            record.setLastName(lastName);
                            break;
                        }
                        case 3: {
                            System.out.println("Enter Address: ");
                            String address = sc.next();
                            record.setAddress(address);
                            break;
                        }
                        case 4: {
                            System.out.println("Enter City: ");
                            String city = sc.next();
                            record.setCity(city);
                            break;
                        }
                        case 5: {
                            System.out.println("Enter State: ");
                            String state = sc.next();
                            record.setState(state);
                            break;
                        }
                        case 6: {
                            System.out.println("Enter Email: ");
                            String email = sc.next();
                            record.setZip(email);
                            break;
                        }
                        case 7: {
                            System.out.println("Enter Phone Number:");
                            String phoneNumber = sc.next();
                            record.setPhoneNumber(phoneNumber);
                            break;
                        }
                        case 8: {
                            System.out.println("Enter Zip Code: ");
                            String zip = sc.next();
                            record.setZip(zip);
                            break;
                        }
                        case 9:
                            return;
                    }
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                System.out.println("List Edited Successfully");
            } else {
                System.out.println("List Cannot be Edited");
            }
        }
    }

    //	Display record Details
    public void displayBook() {
        System.out.println("Enter the Name of Address Book: ");
        String name = sc.next();

        for (Map.Entry<String, HashSet<PersonDetails>> m : bookMap.entrySet()) { //iterate over hashmap
            if (m.getKey().equals(name)) {
                for (PersonDetails value : m.getValue()) {                           //iterates over hashset
                    System.out.println(value);

                }
            }
        }
    }

    //Display all addressBook details
    public void displayAll() {
        for (Map.Entry<String, HashSet<PersonDetails>> m : bookMap.entrySet()) { //iterate over hashmap
            System.out.println("addressBook :: " + m.getKey());

            for (PersonDetails value : m.getValue()) {                           //iterates over hashset
                System.out.println("record :" + value);
            }
            System.out.println("===================");
        }
    }

    // Delete record Details
    public void deleteRecord() {
        System.out.println("Enter the first name of record to be deleted:");
        String name = sc.next();
        boolean flag = false;

        for (Map.Entry<String, HashSet<PersonDetails>> m : bookMap.entrySet()) { //iterate over hashmap
            for (PersonDetails value : m.getValue()) {                           //iterates over hashset
                if (value.getFirstName().equals(name)) {
                    m.getValue().remove(value);
                    System.out.println("Record deleted successfully");
                    flag = true;
                }
            }
        }
        if (flag == false) {
            System.out.println("record not found");
        }
    }

    //Create a new addressBook and store details
    public void addAddressBook() {
        System.out.println("Enter the Name of Address Book: ");
        String name = sc.next();
        bookMap.put(name, addDetails());
        displayAll();
        System.out.println("addressBook added successfully");
    }

    public HashSet<PersonDetails> addDetails() {

        System.out.println("Enter the record details:");
        System.out.println("Enter First Name");
        String firstName = sc.next();
        System.out.println("Enter last Name");
        String lastName = sc.next();
        System.out.println("Enter Address ");
        String address = sc.next();
        System.out.println("Enter City ");
        String city = sc.next();
        System.out.println("Enter State ");
        String state = sc.next();
        System.out.println("Enter  Email ");
        String email = sc.next();
        System.out.println("Enter phone Number");
        String phoneNumber = sc.next();
        System.out.println("Enter Zip code");
        String zip = sc.next();


        PersonDetails b = new PersonDetails(firstName, lastName, address, city, state, email, phoneNumber, zip);
        HashSet<PersonDetails> bookname = new HashSet<PersonDetails>();
        bookname.add(b);
        return bookname;
    }

    //Search person by state
    void searchPersonByState() {
        System.out.println("Enter the state");
        String name = sc.next();
        boolean flag = false;

        for (Map.Entry<String, HashSet<PersonDetails>> m : bookMap.entrySet()) { //iterate over hashmap
            for (PersonDetails value : m.getValue()) {                           //iterates over hashset
                if (value.getState().equals(name)) {
                    System.out.println(value);
                    flag = true;
                }
            }
        }
        if (flag == false) {
            System.out.println("record not found");
        }
    }

    //Search person by state
    void searchPersonByCity() {
        System.out.println("Enter the city");
        String name = sc.next();
        boolean flag = false;

        for (Map.Entry<String, HashSet<PersonDetails>> m : bookMap.entrySet()) { //iterate over hashmap
            for (PersonDetails value : m.getValue()) {                           //iterates over hashset
                if (value.getCity().equals(name)) {
                    System.out.println(value);
                }
            }
        }
        if (flag == false) {
            System.out.println("record not found");
        }
    }


}
/*
    public void getPersonNameByState(String stateName) {
        list = book.stream().filter(p ->.collect(Collectors));
        for (PersonDetails r : list) {
            System.out.println("first name");
            System.out.println("last name");


        }
    }

    public void getPersonNameByCity(String cityName) {
        list = book.stream().filter(p ->.collect(Collectors));
        for (PersonDetails r : list) {
            System.out.println("last name");
            System.out.println("last name");


        }
    }
}*/
