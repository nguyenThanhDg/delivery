/*===You Listing Sticky Header====*/
// When the user scrolls the page, execute myFunction 
/*
window.onscroll = function() {myFunction()};

// Get the header
var header = document.getElementById("stikyheader");

// Get the offset position of the navbar
var sticky = header.offsetTop;

// Add the sticky class to the header when you reach its scroll position. Remove "sticky" when you leave the scroll position
function myFunction() {
  if (window.pageYOffset > sticky) {
    header.classList.add("sticky");
  } else {
    header.classList.remove("sticky");
  }
}
*/
/*========Menu Effect Side=======*/
function openNav() {
    document.getElementById("mySidenav").style.width = "225px";
   // document.getElementById("main").style.marginLeft = "226px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    //document.getElementById("main").style.marginLeft= "0";
}
/*========Right Side Effect Side=======*/

// When the user clicks on div, open the popup
function myFunctionnoti() {
  var popup = document.getElementById("notification");
  popup.classList.toggle("show");
}
function myFunctionmsg() {
  var popup = document.getElementById("message");
  popup.classList.toggle("show");
}
function myFunctionicon() {
  var popup = document.getElementById("icon");
  popup.classList.toggle("show");
}
function signin() {
  var popup = document.getElementById("signin");
  popup.classList.toggle("show");
}

$(document).ready(function() {
              var owl = $('.owl-carousel');
              owl.owlCarousel({
                margin: 10,
                nav: true,
                loop: true,
                responsive: {
                  0: {
                    items: 1
                  },
                  600: {
                    items: 3
                  },
                  1000: {
                    items: 4
                  }
                }
              })
            })
			
			