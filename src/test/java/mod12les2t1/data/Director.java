package mod12les2t1.data;

import java.sql.Date;

public class Director {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String country;

    public Director(int id, String firstName, String lastName, Date birthDate, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getCountry() {
        return country;
    }


    @Override
    public boolean equals(Object object){
        if (!(object instanceof Director)) {
            return false;
        }

        Director anotherDirector = (Director) object;

        if (this.id == anotherDirector.getId()
                && this.firstName.equals(anotherDirector.getFirstName())
                && this.lastName.equals(anotherDirector.getLastName())
                && this.birthDate.equals(anotherDirector.getBirthDate())
                && this.country.equals(anotherDirector.getCountry()))
            return true;
        else {
            System.out.println(this.id + " " +  anotherDirector.getId());
            System.out.println(this.firstName + " " +  anotherDirector.getFirstName());
            System.out.println(this.lastName + " " +  anotherDirector.getLastName());
            System.out.println(this.birthDate + " " +  anotherDirector.getBirthDate());
            System.out.println(this.country + " " +  anotherDirector.getCountry());
            return false;
        }
    }
}
