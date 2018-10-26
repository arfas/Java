$(document).ready(function () {

    var v = false;
    var $f, $m;

    $("button#linuxOn").click(function () {
        if (v == false) {

            $f = $(".ms").parent().parent().detach();


            $(".db").replaceWith("<li class='mysql'><em>MySql Database</em></li>");
            $(".mysql").parent().parent().addClass("openSource");

            $(".os").after("<li class='linux'><em>Linux OS</em></li>");
            $m = $(".os").detach();
            $(".linux").parent().parent().addClass("openSource");

            v = true;
        } // end if
    }); //end veg button

    $("button#restoreMenu").click(function () {

        if (v == true) {
            $(".mysql").parent().parent().removeClass("openSource");
            $(".mysql").replaceWith("<li class='db'>MS SQL Server</li>");

            $(".menu_systems li").first().before($f);

            $(".linux").parent().parent().removeClass("openSource");
            $(".os").each(function (i) {
                $(this).after($m[i]);
            }); //end each
            $(".os").remove();
            v = false;
        } //end if
    }); //end restoreMe button
}); //end doc ready
