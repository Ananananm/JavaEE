

$(function(){

    ChangeSize();

    $(window).resize(function(){

        ChangeSize();

    });

});

function ChangeSize(){

    $(".z_user_center").css("margin-top",(($(window).height()-$(".z_user_center").height())/2));

    $(".z_bj,.z_bj i").css("height",($(window).height()));

}

