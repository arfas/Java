$(document).ready(function () {

    var v = "win";
    var $f, $m;
    
    $("button#linuxOn").click(function () {
        if (v == "win") {
	    $f = $(".ms").parent().parent().detach();


            $(".db").replaceWith("<li class='mysql'><em>MySql Database</em></li>");
            $(".mysql").parent().parent().addClass("openSource");

            $(".os").after("<li class='linux'><em>Linux OS</em></li>");
            $m = $(".os").detach();
            $(".linux").parent().parent().addClass("openSource");

            v = "linux";
	    
	    // save it to the local storage
	    localStorage.setItem("myChoice", v);
        } // end if
    }); //end linux button

    $("button#restoreMenu").click(function () {

        if (v == "linux") {
            $(".mysql").parent().parent().removeClass("openSource");
            $(".mysql").replaceWith("<li class='db'>MS SQL Server</li>");

            $(".menu_systems li").first().before($f);

            $(".linux").parent().parent().removeClass("openSource");
            $(".os").each(function (i) {
                $(this).after($m[i]);
            }); //end each
            $(".os").remove();
            v = "win";
	    
	    // save it to the local storage
	    localStorage.setItem("myChoice", v);
        } //end if
    }); //end restoreMenu button
    
     // retreive from the local storage
    v = localStorage.getItem("myChoice");
    if (v != null)
    {
	if (v == "linux")
	{ 
	 v = "win";
	 $("button#linuxOn").trigger('click');
	}
    }
    else
	v = "win";
}); //end doc ready
