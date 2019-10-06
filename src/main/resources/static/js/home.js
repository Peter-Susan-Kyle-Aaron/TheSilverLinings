$(document).ready(function(){

    $('.slider').slider({
        height: 600
    });


    $('.slider').height(600);

    $('.sidenav').sidenav();


    setInterval(function(){
        $('.slider').slider('next');
    }, 5000);



});




