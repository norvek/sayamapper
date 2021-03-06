package dev.iomapper.dtos;

/**
 * Created by norveo on 8/7/18.
 */
public class UserDto {

    private String name;
    private String middleName;
    private String lastName;
    private String job;
    private String email;
    private AddressDto addressDto;
    private ScholarshipDto scholarship;
    private String years;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ScholarshipDto getScholarshipDto() {
        return scholarship;
    }

    public void setScholarshipDto(ScholarshipDto scholarshipDto) {
        this.scholarship = scholarshipDto;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

}
