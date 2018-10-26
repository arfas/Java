/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    $("#isabsurl").keyup(function() {
        var thisVal = $(this).val();
        var isAbsUrl = $.mobile.path.isAbsoluteUrl(thisVal);
        $("#isabsurlresult").text(isAbsUrl);
    });
    $("#isrelurl").keyup(function() {
        var thisVal = $(this).val();
        var isRelUrl = $.mobile.path.isRelativeUrl(thisVal);
        $("#isrelurlresult").text(isRelUrl);
    });
    $("#makeurl,#makeurl2").keyup(function() {
        var urlVal1 = $("#makeurl").val();
        var urlVal2 = $("#makeurl2").val();
        var makeUrlResult = $.mobile.path.makeUrlAbsolute(urlVal1, urlVal2);
        $("#makeurlresult").text(makeUrlResult);
    });
    $("#pathget").keyup(function() {
        var thisVal = $(this).val();
        var path = $.mobile.path.get(thisVal);
        $("#pathgetresult").html(path);
    });
});
