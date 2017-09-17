(function (){
	var viewWidth = $(window).width();
	var viewHeight = $(window).height();
	window.onload = function(){
		var scrollTop = $(window).scrollTop();
		//页面调整，包括窗口大小发生变化的的时候
		pageAdajust();
		//页面调整，只在资源加载完成后
		onceAdajust();
		//弹出层初始化
		popLayout();
	};

	$(window).resize(function(event) {
		/* Act on the event */
		//reset viewHeight,viewWidth
		viewWidth = $(window).width();
		viewHeight = $(window).height();
		pageAdajust();
		//页面调整，在只在窗口尺寸变化时候生效
		docReady();
		//弹出层调整在窗口尺寸发生变化的时候
		popLayout();
	});

	$(document).ready(function(){
		//页面调整，在DOM准备好，在onload之前
		onceReady();
	});

	$(window).scroll(function(){
		var scrollTop = $(window).scrollTop();
		delayImg(scrollTop);
		delayPlate(scrollTop);
		animateShow(scrollTop);
	});


	$('.stop-pop').on('click',function(event){
		var event = event || window.event;
		event.stopPropagation();
	});



	//背景图片加载，带样式，并带有background-size
	if($('.imageload')[0])
	{
		$('.imageload').each(function(index){
			var src = $(this).attr('origin-data');
			$(this).css({
				'background':'url("'+src+'") no-repeat center center',
				'background-size':'cover'
			});
		});
	}
	//背景图片加载，带样式，不带有background-size
	if($('.imageloadNoCover')[0])
	{
		$('.imageloadNoCover').each(function(index){
			var src = $(this).attr('origin-data');
			$(this).css({
				'background':'url("'+src+'") no-repeat center center'
			});
		});
	}
	//背景图片加载，不带样式
	if($('.imageloadNoStyle')[0])
	{
		$('.imageloadNoCover').each(function(index){
			var src = $(this).attr('origin-data');
			$(this).css({
				'background':'url("'+src+'")'
			});
		});
	}




    //背景图片加载，带样式，并带有background-size
    if($('.imageload')[0])
    {
        $('.imageload').each(function(index){
            var src = $(this).attr('origin-data');
            $(this).css({
                'background':'url("'+src+'") no-repeat center center',
                'background-size':'cover'
            });
        });
    }


	var delayImgObj = [];
	function docReady(){

	}


	function onceReady(){

	}
	function onceAdajust()
	{


	}
	function pageAdajust()
	{
		if($('#body .banner')[0]){
			$('#body .banner').css({
				'width' : viewWidth+'px',
				'height' : viewHeight+'px'
			});
			$('#body .banner .image').css({
                'width' : viewWidth+'px',
                'height' : viewHeight+'px'
            });
		}
	}

	function popLayout(){

	}

	$('.navs>ul>li').on('click',function(){
		if(!$(this).hasClass('active')){
            $('.navs>ul>li').removeClass("active");
            $(this).addClass('active');
		}

	});


	/*
	包含菜单的li被触发
	 */

	//init
	$('.navs .menu .scroll').width($('.navs .menu .scroll .plate').length*$('.navs .menu').width());

	var t_delay = null;//延时定时器
	var delay_interval = 300;
	$('.navs>ul>li.hasmenu').on('mouseenter',function(){
		if(t_delay){
            clearTimeout(t_delay);
		}

		var index = $('.navs>ul>li.hasmenu').index($(this));
		var long = $('.navs .menu').width();
		//切换版块
		$('.navs .menu .scroll').animate({
			left: -index*long+"px"
		},300);
		if(!$('.navs .menu-container').hasClass('open')){
            $('.navs .menu-container').addClass('open');
		}
        if(!$('.navs .menu-bg').hasClass('open')){
            $('.navs .menu-bg').addClass('open');
        }
	}).on('mouseleave',function(){
        $('.navs .menu-bg').removeClass('open');
        t_delay = setTimeout(function(){$('.navs .menu-container').removeClass('open');},delay_interval);
	});
    $('.navs .menu-container').on('mouseenter',function(){
        if(t_delay){
            clearTimeout(t_delay);
        }
        if(!$(this).hasClass('open')){
        	$(this).addClass('open');
		}
        if(!$('.navs .menu-bg').hasClass('open')){
            $('.navs .menu-bg').addClass('open');
        }

    }).on('mouseleave',function(){
    	var obj = $(this);
        t_delay = setTimeout(function(){obj.removeClass('open');},delay_interval);
        $('.navs .menu-bg').removeClass('open');

    });

})();