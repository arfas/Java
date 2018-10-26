/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var Db;

function init()
{
    console.log("Entering init");
    alert("init");

    var purgeStatus, purgeInterval;

    //Set the default value for the date input field the first
    // time the form opens (afterwards just use the previous
    // value entered by the user)
    var now = new Date();
    var todayStr = now.getFullYear() + '-' + (now.getMonth() + 1) + '-' + now.getDate();
    $('#editDate').val(todayStr);

    //Create or open the database
    console.log("Opening database");
    Db = window.openDatabase("etDB", "1.0", "Expense Tracker", 3 * 1024 * 1024);
    console.log("Checking Db");
    if (Db)
    {
        console.log(Db);
        console.log("Creating table");
        Db.transaction(createTable, onTxError, onTxSuccess);
        console.log("Finished creating table");
    }
    else
    {
        console.log("Db object has not been created");
        alert("this code shouldn't ever execute");
    }

    //Get purgeStatus from the persistent storage area 
    purgeStatus = window.localStorage.getItem("purgeStatus");
    //Get purgeInterval from the persistent storage area
    purgeInterval = window.localStorage.getItem("purgeInterval");
    //if purge is enabled, then do the purge
    if (purgeStatus == "true")
    {
        //Set the purgeStatus value on the config screen
        $("#purgeStatus").attr("checked", true);
        //Now set the purgeInterval value on the config screen
        $("#purgeInterval").attr('value', purgeInterval);
        //See if there's any old data to purge
        doPurge(purgeInterval);
    }
    console.log("Leaving init");
}

function createTable(tx)
{
    console.log("Entering createTable");
    var sqlStr = 'CREATE TABLE IF NOT EXISTS EXPENSE (spentDate INT, amount REAL, notes TEXT)';
    console.log(sqlStr);
    tx.executeSql(sqlStr, [], onSqlSuccess, onSqlError);
    console.log("Leaving createTable");
}

function onTxSuccess()
{
    console.log("TX: success");
}

function onTxError(tx, err)
{
    console.log("Entering onTxError");
    var msgText;
    //Check if we get an error object?
    if (err)
    {
        //Tell the user what happened
        msgText = "TX: " + err.message + " (" + err.code + ")";
    }
    else
    {
        msgText = "TX: Unkown error";
    }
    console.error(msgText);
    alert(msgText);
    console.log("Leaving onTxError");
}

function onSqlSuccess(tx, res)
{
    console.log("SQL: success");
    if (res)
    {
        console.log(res);
    }
}

function onSqlError(tx, err)
{
    console.log("Entering onSqlError");
    var msgText;
    if (err)
    {
        msgText = "SQL: " + err.message + " (" + err.code + ")";
    }
    else
    {
        msgText = "SQL: Unknown error";
    }
    console.error(msgText);
    alert(msgText);
    console.log("Leaving onSqlError");
}

function saveRecord()
{
    console.log("Entering saveRecord");
    //Make sure we have a valid date before trying to save the entry

    //Make sure amount > 0 before trying to save the entry

    //Write the record to the database
    Db.transaction(insertRecord, onTxError, onTxSuccess);
    console.log("Leaving saveRecord");
}

function insertRecord(tx)
{
    console.log("Entering insertRecord");
    //Create a new date object to hold the date the user entered
    var dateStr = document.getElementById("editDate").value;
    console.log("Date: " + dateStr);
    var amount = document.getElementById("editAmount").value;
    console.log("Amount: " + amount);
    var notes = document.getElementById("editNotes").value;
    console.log("Notes: " + notes);
    var sqlStr = 'INSERT INTO EXPENSE (spentDate, amount, notes) VALUES (?, ?, ?)';
    console.log(sqlStr);
    tx.executeSql(sqlStr, [Date.parse(dateStr), amount, notes], onSqlSuccess, onSqlError);

    //Reset the form by setting a blank value for the input values
    // using the jQuery $ selector
    var blankVal = {
        value: ''
    };
    $("#editAmount").attr(blankVal);
    $("#editNotes").attr(blankVal);
    console.log("Leaving insertRecord");
}

function openView(viewType)
{
    console.log("Entering openView");
    var headerTxt, sqlStr;

    //Get the current date
    var now = new Date();
    //Remove everything but just the date portion
    var todayStr = now.getFullYear() + '-' + (now.getMonth() + 1) + '-' + now.getDate();
    //The todayVal variable is the current date in milliseconds
    var date = Date(todayStr);
    console.log(todayStr);
    var todayVal = Date.parse(todayStr);
    console.log(todayVal);
    //Now let's process our different view types
    switch (viewType)
    {
        case 1:
            headerTxt = "Today's Expenses";
            //Build a SQL string using the current date value
            sqlStr = "SELECT * FROM EXPENSE WHERE spentDate = " + todayVal + " ORDER BY spentDate ASC";
            break;
        case 2:
            headerTxt = "Expense Last 7 Days";
            //Last week is today - the number of milliseconds in 7 days.
            //which is (1000 * 60 * 60 * 24 * 7) or 604,800,000
            var lastWeek = todayVal - 604800000;
            sqlStr = "SELECT * FROM EXPENSE WHERE spentDate >= " + lastWeek + " ORDER BY spentDate ASC";
            break;
        case 3:
            headerTxt = "Expenses By Date";
            sqlStr = "SELECT * FROM EXPENSE ORDER BY spentDate ASC";
            break;
    }
    //Set the heading on the page
    $("#viewTitle").html(headerTxt);

    console.log("SQL: " + sqlStr);
    Db.transaction(function(tx) {
        tx.executeSql(sqlStr, [], onQuerySuccess, onQueryFailure);
    }, onTxError, onTxSuccess);
    console.log("Leaving openView");
}

function onQuerySuccess(tx, results)
{
    console.log("Entering onQuerySuccess");
    if (results.rows)
    {
        console.log("Rows: " + results.rows);
        var htmlStr = "";
        var len = results.rows.length;
        if (len > 0)
        {
            for (var i = 0; i < len; i++)
            {
                var date = new Date(results.rows.item(i).spentDate);
                htmlStr += '<b>Date:</b> ' + date.toDateString() + '<br />';
                var amount = results.rows.item(i).amount;
                htmlStr += '<b>Amount:</b> ' + amount + ' dollars<br />';

                //Check to see if there are any notes before writing
                // anything to the page
                var notes = results.rows.item(i).notes;
                htmlStr += '<b>Notes:</b> ' + notes + '<br />';
                htmlStr += '<hr />';
            }

            $("#viewData").html(htmlStr);
            //Open the View page to display the data
            $.mobile.changePage("#dataView", "slide", false, true);
        }
        else
        {
            //This should never happen
            alert("No rows.");
        }
    }
    else
    {
        alert("No records match selection criteria.");
    }
    console.log("Leaving openView");
}

function onQueryFailure(tx, err)
{
    console.log("Entering onQueryFailure");
    var msgText;
    if (err)
    {
        msgText = "Query: " + err;
    }
    else
    {
        msgText = "Query: Unknown error";
    }
    console.error(msgText);
    alert(msgText);
    console.log("Leaving onQueryFailure");
}

function deleteRecord(tx)
{
    console.log("Entering deteleRecord");
    //Create a new date object to hold the date the user entered

    //Get purgeInterval from the persistent storage area
    purgeInterval = window.localStorage.getItem("purgeInterval")

    // Find today in string format 
    var now = new Date();
    var todayStr = now.getFullYear() + '-' + (now.getMonth() + 1) + '-' + now.getDate();
    var deleteDateVal = Date.parse(todayStr) - purgeInterval * 24 * 60 * 60 * 1000;

    var sqlStr = 'DELETE FROM EXPENSE WHERE spentDate < ' + deleteDateVal;
    console.log(sqlStr);
    tx.executeSql(sqlStr, [], onSqlSuccess, onSqlError);

    console.log("Leaving deteleRecord");
}

function doPurge(pi)
{
    console.log("Entering saveRecord");
    //Write some code here to purge the database after a the
    // specified purge interval

    //Delete the record from the database
    Db.transaction(deleteRecord, onTxError, onTxSuccess);
    console.log("Leaving saveRecord");

}

function showConfigPage()
{
    $.mobile.changePage("#config", "flip", false, true);
}

function showViewPage()
{
    $.mobile.changePage("#viewList", "slide", false, true);
}

function saveConfig()
{
    //Write the config settings to localstorage
    window.localStorage.setItem("purgeStatus", document.getElementById("purgeStatus").checked);
    window.localStorage.setItem("purgeInterval", document.getElementById("purgeInterval").value);
    //Then switch back to the main page
    $.mobile.changePage("#main", "flip", false, false);
}

