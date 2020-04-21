# AMC Bootcamp Assignments
## Sling Models
### Assignment


##### Questions

	
1. Create a custom component(name 'MyDetail') which inputs following details from the dialog:

    * First Name <Textfield>

    * Last Name <Textfield>

    * Date of Birth <Date>

    * Gender <Dropdown: Male,Female>

    * Marital Status <Dropdown: Married, Single>

2. Create a sling model for this component and this sling model should inject all these fields and should have getter methods for them.

3. Model class should also have following 2 methods :

    * getFullName() : This method to concatenate the first and last name.

    * getAge() : This method would compute the age as per the authored DOB.

    * getHonorific() : This method would return 'Mr' if the gender is 'Male' , 'Ms' if gender is             'Female' and 'Marital Status' is 'Single', 'Mrs' if gender is 'Female' and Marital                         tatus is 'Married'.

4. Display the Honorific, Full Name and Age from HTL.


Example : If the user has inputted following details :

FirstName : Abc

LastName : Def

DOB : 1/1/1995

Gender : Male

Marital Status : Single

Following details should be displayed on the page :

_Mr Abc Def_

_25_






