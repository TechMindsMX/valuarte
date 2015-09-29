var SimulatorController = (function() {

  var start = function() {
    $('.datepicker').pickadate({ });
  };

  return {
    start: start
  };
}());

$(function ($) {
  SimulatorController.start();
});


