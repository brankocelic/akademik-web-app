var slideIndex = 0;
showSlides();

// function plusSlides(n) {
// showSlides(slideIndex += n);
// }
//
// function currentSlide(n) {
// showSlides(slideIndex = n);
// }

function showSlides() {
	var i;
	var slides = document.getElementsByClassName("mySlides");
	var dots = document.getElementsByClassName("dot");
	for (i = 0; i < slides.length; i++) {
		slides[i].style.display = "none";
	}
	slideIndex++;
	if (slideIndex > slides.length) {
		slideIndex = 1
	}
	for (i = 0; i < dots.length; i++) {
		dots[i].className = dots[i].className.replace(" active", "");
	}
	slides[slideIndex - 1].style.display = "block";
	dots[slideIndex - 1].className += " active";
	setTimeout(showSlides, 2000); // Change image every 2 seconds
}

function openNav() {
	document.getElementById("mySidebar").style.width = "100%";
}

function openNav1() {
	document.getElementById("mySidebar").style.width = "250px";
}

function closeNav() {
	document.getElementById("mySidebar").style.width = "0";
}

function closeNav1() {
	document.getElementById("mySidebar").style.width = "0";
}

function initMap() {
	// The location of Uluru
	var uluru = {
		lat : 44.766150,
		lng : 17.201085
	};
	var map = new google.maps.Map(document.getElementById('map'), {
		zoom : 17,
		center : uluru
	});

	var marker = new google.maps.Marker({
		position : uluru,
		map : map,
		title : 'Cafe Akademik!'
	});

}

function send() {
	  setTimeout(function() {
	    window.open("mailto:" + document.getElementById('email').value + "?subject=" + document.getElementById('subject').value + "&body=" + document.getElementById('text-area').value);
	  }, 320);
	}
