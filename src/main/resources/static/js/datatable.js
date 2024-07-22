let table = new DataTable('#rapportsTable', {
    searching: false,
    language:{
      "paginate": {
            "first": "Première",
            "last": "Dernière",
            "next": "Suivante",
            "previous": "Précédente"
        },
        "info": "Affichage de _START_ à _END_ sur _TOTAL_ entrées",
        "infoEmpty": "Affichage de 0 à 0 sur 0 entrées",
        "lengthMenu": "Afficher _MENU_ entrées"
    }
  });