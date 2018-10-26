$(document).ready(function() {
    $(".guess").click(checkForPrize);

    function getRandom(num) {
        var randomNum = Math.floor(Math.random() * num);
        return randomNum;
    }

    var hidePrize = function() {
        var numRand = getRandom(4);
        $(".guess").each(function(index) {
            if (numRand == index) {
                $(this).append("<span id='hasPrize'></span>");
                return false;
            }
        });
    }

    hidePrize();

    function checkForPrize() {
        var message;
        if ($.contains(this, document.getElementById("hasPrize")))
        {
            var prize = getRandom(401) + 100;
            message = "<p><strong>Your prize is $" + prize + "</strong></p>";
        } else {
            message = "<p><strong>Sorry, no prize this time.</strong></p>";
        }
        $(this).append(message);

        $(".guess").each(function() {
            if ($.contains(this, document.getElementById("hasPrize"))) {
                $(this).addClass("prize");
            } else {
                $(this).addClass("noPrize");
            }
            $(this).unbind('click');
        });
    }

    $(".guess").hover(
            function() {
                $(this).addClass("myHover");
            },
            function() {
                $(this).removeClass("myHover");
            }
    );
});