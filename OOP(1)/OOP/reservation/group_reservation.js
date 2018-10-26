var dateObject = new Date();
var month = dateObject.getMonth();
var monthArray = new Array("January", "February",
        "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December");
function getTodayDate() {
    var dateToday = monthArray[month] + " "
            + dateObject.getDate() + ", "
            + dateObject.getFullYear();
    document.forms[0].reservationDate.value = dateToday;
}


function calcGroupDiscount(groupSize) {
    var dailyRate = 49;
    if (groupSize >= 5 && groupSize <= 10)
        dailyRate = 49 / 1.1;
    else if (groupSize > 10 && groupSize < 25)
        dailyRate = 49 / 1.2;
    else if (groupSize > 24)
        dailyRate = 49 / 1.25;
    var groupRate = groupSize * dailyRate;
    //groupRate = groupRate.toFixed(2);
    groupRate = Math.round(groupRate);
    document.forms[0].discount.value = groupRate.toLocaleString();
}

var contactList = new Object();

function addContact() {
    var newContact = 0;
    for (contact in contactList) {
        ++newContact;
    }
    //alert(newContact);
    if (document.forms[0].lastname.value == "" || document.forms[0].firstname.value == "")
        alert("You must enter the contact's first and last names.");
    else {
        contactList["contact" + newContact] = new Contact();
        contactList["contact" + newContact].lastName = document.forms[0].lastname.value;
        contactList["contact" + newContact].firstName = document.forms[0].firstname.value;
        contactList["contact" + newContact].telephone = document.forms[0].telephone.value;
        contactList["contact" + newContact].address = document.forms[0].address.value;
        contactList["contact" + newContact].city = document.forms[0].city.value;
        contactList["contact" + newContact].state = document.forms[0].state.value;
        contactList["contact" + newContact].zip = document.forms[0].zip.value;
        var createContact = new Option();
        createContact.value = contactList["contact" + newContact].lastName + "," 
                + contactList["contact" + newContact].firstName;
        createContact.text = contactList["contact" + newContact].lastName + ","
                + contactList["contact" + newContact].firstName;
        document.forms[0].contacts.options[newContact] = createContact;
        
        calcGroupDiscount(newContact + 1);
    }
}

function deleteContact() {
    var contactSelected = false;
    var selectedContact = 0;
    for (var i = 0; i < document.forms[0].contacts.options.length; ++i) {
        if (document.forms[0].contacts.options[i].selected == true) {
            contactSelected = true;
            selectedContact = i;
            break;
        }
    }
    document.forms[0].contacts.options[i] = null;

    if (contactSelected == true) {
        for (prop in contactList) {
            delete contactList[prop]
        }
        for (var i = 0; i < document.forms[0].contacts.options.length; ++i) {
            contactList["contact" + i] = new Contact();
            contactList["contact" + i].lastName = document.forms[0].lastname.value;
            contactList["contact" + i].firstName = document.forms[0].firstname.value;
            contactList["contact" + i].telephone = document.forms[0].telephone.value;
            contactList["contact" + i].address = document.forms[0].address.value;
            contactList["contact" + i].city = document.forms[0].city.value;
            contactList["contact" + i].state = document.forms[0].state.value;
            contactList["contact" + i].zip = document.forms[0].zip.value;
        }
    calcGroupDiscount(document.forms[0].contacts.options.length);
    }
    else
        window.alert("You must select a contact in the list.");

} 
