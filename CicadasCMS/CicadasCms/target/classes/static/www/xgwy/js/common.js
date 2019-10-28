$(function() {

        


    /*var resizeTimer = null;
    $(window).on('scroll', function() {
        if (resizeTimer) {
            clearTimeout(resizeTimer)
        }
        resizeTimer = setTimeout(function() {
            //console.log($(document).scrollTop());
            if($(document).scrollTop()>76){
            	$('.wide').addClass('black');
            }else{
            	$('.wide').removeClass('black');

            }

        }, 0);
    });*/

/*footer微信背景图放大*/
        $('.ewm').hover(function() {
            $('.ewm_big').stop().fadeIn(500);
        }, function() {
            $('.ewm_big').stop().fadeOut(400)
        });


/*footer电话放大*/
        $('.icon-phone').hover(function() {
            $('.phone_foot').stop().fadeIn(400);
        }, function() {
            $('.phone_foot').stop().fadeOut(200)
        });


});

// 调整当前对象的比例，以适应父容器的尺寸
    function init_cont($obj, origin_size,min,max) {
        if($obj.parent().innerWidth()<max && $obj.parent().innerWidth()>min){TweenMax.to($obj,1,{scale:$obj.parent().innerWidth()/origin_size});
        }
    }

