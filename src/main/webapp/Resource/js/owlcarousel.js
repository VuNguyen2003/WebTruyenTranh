$(document).ready(function() {
    $(".owl-carousel").owlCarousel({
      items: 5,
      loop: true,
      margin: 0,
      autoplay: true,
      autoplayTimeout: 15000,
      nav: true, // Display navigation arrows
      navText: [
        "<i class='fa fa-chevron-left'></i>",
        "<i class='fa fa-chevron-right'></i>"
      ],
      
    });
  });