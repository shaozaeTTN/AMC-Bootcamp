package com.ttn.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

// Sling Model based on Bootcamp SlingModel Assignment

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DetailGeneratorModel {

    private String fullname;
    private int age;
    private String honorific;

    @ValueMapValue @Default(values = "")
    private String firstname;
    @ValueMapValue @Default(values = "")
    private String lastname;
    @ValueMapValue @Default(values = "single")
    private String maritalStatus;
    @ValueMapValue @Default(values = "male")
    private String gender;
    @ValueMapValue
    private Calendar dob;

    @PostConstruct
    public void init(){
        // Concatenate firstname and lastename
        fullname = firstname + " " + lastname;

        // Generate Honorific
        if(gender.equals("male"))
            honorific = "Mr";
        else if(gender.equals("female") && maritalStatus.equals("single"))
            honorific = "Ms";
        else
            honorific = "Mrs";

        // Calculate Age
        if(dob == null)
            age = 0;
        else {
            LocalDate given = LocalDate.of(dob.get(Calendar.YEAR), dob.get(Calendar.MONTH)+1, dob.get(Calendar.DATE));
            LocalDate current = LocalDate.now();
            Period interval = Period.between(given, current);
            age = interval.getYears();
        }
    }

    public String getFullname() {
        return fullname;
    }
    public int getAge() {
        return age;
    }
    public String getHonorific() {
        return honorific;
    }


    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getMaritalStatus() {
        return maritalStatus;
    }
    public String getGender() {
        return gender;
    }
    public Calendar getDob() {
        return dob;
    }
}
