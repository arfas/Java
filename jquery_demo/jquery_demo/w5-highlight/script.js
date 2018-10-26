$(document).ready(function() { 
   $("#btn1").click( function(){
      $("#mybox").addClass("hover");
      $("#mybox").removeClass("no_hover"); 
   });
   $("#btn2").click( function(){ 
      $("#mybox").removeClass("hover");        $("#mybox").addClass("no_hover");
   }); 
});