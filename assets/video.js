function play() {
	//console.log('test');
	var video = document.getElementById('video');
	video.addEventListener('click',function(){
	  video.play();
	},false);
}

//window.onload = play;
