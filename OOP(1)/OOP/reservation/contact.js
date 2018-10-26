function Contact() {
    this.lastName = "";
    this.firstName = "";
    this.telephone = "";
    this.address = "";
    this.city = "";
    this.state = "";
    this.zip = "";

    this.getContacts = getContactInfo;
    this.updateContact = updateSelectedContact;
}

function getContactInfo() { 
    document.forms[0].lastname.value = this.lastName; 
    document.forms[0].firstname.value = this.firstName; 
    document.forms[0].telephone.value = this.telephone; 
    document.forms[0].address.value = this.address; 
    document.forms[0].city.value = this.city; 
    document.forms[0].state.value = this.state; 
    document.forms[0].zip.value = this.zip;
}

function updateSelectedContact(curIndex) { 
    this.lastName = document.forms[0].lastname.value; 
    this.firstName = document.forms[0].firstname.value; 
    this.telephone = document.forms[0].telephone.value; 
    this.address = document.forms[0].address.value; 
    this.city = document.forms[0].city.value; 
    this.state = document.forms[0].state.value; 
    this.zip = document.forms[0].zip.value; 
    document.forms[0].contacts.options[curIndex].value 
        = this.lastName + "," + this.firstName;
    document.forms[0].contacts.options[curIndex].text
        = this.lastName + "," + this.firstName;
    window.alert("Contact information updated.");
} 
