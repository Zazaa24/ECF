(function() {
  "use strict";

  /**
   * Easy selector helper function
   */
  const select = (el, all = false) => {
    el = el.trim()
    if (all) {
      return [...document.querySelectorAll(el)]
    } else {
      return document.querySelector(el)
    }
  }

  /**
   * Easy event listener function
   */
  const on = (type, el, listener, all = false) => {
    let selectEl = select(el, all)
    if (selectEl) {
      if (all) {
        selectEl.forEach(e => e.addEventListener(type, listener))
      } else {
        selectEl.addEventListener(type, listener)
      }
    }
  }

  /**
   * Mobile nav toggle
   */
  on('click', '.mobile-nav-toggle', function(e) {
    select('#navbar').classList.toggle('navbar-mobile')
    this.classList.toggle('bi-list')
    this.classList.toggle('bi-x')
  })


  /**
   * Mobile nav dropdowns activate
   */
  on('click', '.navbar .dropdown > a', function(e) {
    if (select('#navbar').classList.contains('navbar-mobile')) {
      e.preventDefault()
      this.nextElementSibling.classList.toggle('dropdown-active')
    }
  }, true)


  /**
   * Avis slider
   */
  new Swiper('.avis-slider', {
    speed: 600,
    loop: true,
    autoplay: {
      delay: 5000,
      disableOnInteraction: false
    },
    slidesPerView: 'auto',
    pagination: {
      el: '.swiper-pagination',
      type: 'bullets',
      clickable: true
    },
    breakpoints: {
      320: {
        slidesPerView: 1,
        spaceBetween: 20
      },

      1200: {
        slidesPerView: 3,
        spaceBetween: 20
      }
    }
  });

  /**
   * Animation on scroll
   */
  window.addEventListener('load', () => {
    AOS.init({
      duration: 1000,
      easing: 'ease-in-out',
      once: true,
      mirror: false
    })
  });

})();

/**
   * Image slider
   */
new Swiper('.image-slider', {
  speed: 400,
  loop: true,
  autoplay: {
    delay: 5000,
    disableOnInteraction: true
  },
  pagination: {
    el: '.swiper-pagination',
    type: 'bullets',
    clickable: true
  }
});

/**
   * Filtre genérique
   */
function filtreGenerique(filterId, tableId, trPosition1, trPosition2) {
  // Declare variables
  var input, filter, table, tbody, tr, tdCol1, tdCol2, i, txtValueCol1, txtValuecol2;
  input = document.getElementById(filterId);
  filter = input.value.toUpperCase();
  table = document.getElementById(tableId);
  tbody = table.getElementsByTagName("tbody");
  tr = tbody[0].children;

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    tdCol1 = tr[i].getElementsByTagName("td")[trPosition1];
    tdCol2 = tr[i].getElementsByTagName("td")[trPosition2];
    if (tdCol1 && tdCol2) {
      txtValueCol1 = tdCol1.textContent || tdCol1.innerText;
      txtValuecol2 = tdCol2.textContent || tdCol2.innerText;
      if (txtValueCol1.toUpperCase().indexOf(filter) > -1  || txtValuecol2.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
};

/**
   * Filtre animaux
   */
function filtrerapports(filterAnimalId, filterDateId, tableId, trPositionAnimal, trPositionDate) {
  // Declare variables
  var selectAnimal, inputDate, filterAnimal, filterDate, table, tbody, tr, tdColAnimal, tdColDate, i, txtValueColAnimal, txtValuecolDate;
  selectAnimal = document.getElementById(filterAnimalId);
  inputDate = document.getElementById(filterDateId);
  filterAnimal = selectAnimal.value.toUpperCase();
  filterDate = inputDate.value.toUpperCase();
  table = document.getElementById(tableId);
  tbody = table.getElementsByTagName("tbody");
  tr = tbody[0].children;

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    tdColAnimal = tr[i].getElementsByTagName("td")[trPositionAnimal];
    tdColDate = tr[i].getElementsByTagName("td")[trPositionDate];
    if (tdColAnimal && tdColDate) {
      txtValueColAnimal = tdColAnimal.textContent || tdColAnimal.innerText;
      txtValuecolDate = tdColDate.textContent || tdColDate.innerText;
      if(filterAnimal != "" && filterDate != ""){
        if (txtValueColAnimal.toUpperCase().indexOf(filterAnimal) > -1  && txtValuecolDate.toUpperCase().indexOf(filterDate) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      } else if(filterAnimal != "" && filterDate == ""){
        if (txtValueColAnimal.toUpperCase().indexOf(filterAnimal) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      } else if(filterAnimal == "" && filterDate != ""){
        if (txtValuecolDate.toUpperCase().indexOf(filterDate) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      } else {
        tr[i].style.display = "";
      }
    }
  }
};

/**
   * Aficher/Cacher un habitat
   */
function showHideHabitat(titreId, descriptionId, tableId) {
  // Declare variables
  let titreElement, descriptionElement, tableElement;
  titreElement = document.getElementById(titreId);
  descriptionElement = document.getElementById(descriptionId);
  tableElement = document.getElementById(tableId);
  
  if(descriptionElement.style.display === "none"){
    titreElement.style = "border-bottom: 1px solid var(--black-80);";
    descriptionElement.style = " ";
    tableElement.style = " ";
  } else {
    titreElement.style = " ";
    descriptionElement.style = "display: none";
    tableElement.style = "display: none";
  }
};