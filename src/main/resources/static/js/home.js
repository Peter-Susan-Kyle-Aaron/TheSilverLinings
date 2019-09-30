$(document).ready(function(){
    $('.slider').slider({
        height: 600
    });
});


setInterval(function(){
    $('.slider').slider('next');
}, 5000);



