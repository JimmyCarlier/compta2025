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
    dateFormat: "Y-m",
    onChange: function (selectedDates, dateStr) {
      const [year, month] = dateStr.split("-");
      document.getElementById("mois").value = month;
      document.getElementById("annee").value = year;
    },
  });
});
