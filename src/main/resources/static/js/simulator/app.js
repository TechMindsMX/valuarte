var SimulatorController = (function() {

  var start = function() {
    $('.datepicker').pickadate({
      labelMonthNext: 'Siguiente',
      labelMonthPrev: 'Previo',
      labelMonthSelect: 'Selecciona un mes',
      labelYearSelect: 'Selecciona un año',
      monthsFull: [ 'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre' ],
      monthsShort: [ 'Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic' ],
      weekdaysFull: [ 'Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado' ],
      weekdaysShort: [ 'Dom', 'Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab' ],
      weekdaysLetter: [ 'D', 'L', 'M', 'X', 'J', 'V', 'S' ],
      today: 'Hoy',
      clear: 'Limpiar',
      close: 'Cerrar'
    });
  };

  return {
    start: start
  };
}());

$(function ($) {
  SimulatorController.start();
});


