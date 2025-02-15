const btnAdd = document.querySelector("#addButton");
const form = document.querySelector("#formAdd");
let showForm = false;

btnAdd.addEventListener("click", () => {
  showForm = !showForm;
  if (showForm) {
    form.style.display = "block";
  } else {
    form.style.display = "none";
  }
});

// mon_script.js
document.addEventListener("DOMContentLoaded", function () {
  flatpickr("#monthPicker", {
    dateFormat: "Y-m", // Format : année-mois
    altInput: true, // Afficher une version alternative pour plus de clarté
    altFormat: "F Y", // Affichage alternatif (ex. "Janvier 2025")
    disableMobile: true, // Désactive la version mobile (optionnelle)
    mode: "single", // Ne permet de sélectionner qu'un seul mois
    showMonths: 1, // Affiche un seul mois
    monthSelectorType: "static", // Affichage sous forme de calendrier mais uniquement avec les mois et années
  });
});
