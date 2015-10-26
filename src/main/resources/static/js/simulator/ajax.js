$("#search").click(function(){

  $.ajax('//localhost:8080/client', {
      method: 'GET',
      dataType: 'json',
      data: {
        rfc: $('#rfc').val()
      }
      })
  .done(function(data) {
    var simulator = $('#simulator');
    simulator.find('#rfc').val(data.rfc);
    simulator.find('#nombre').val(data.nombre);
    simulator.find('#apellidoPaterno').val(data.apellidoPaterno);
    simulator.find('#apellidoMaterno').val(data.apellidoMaterno);
  })
  .fail(function(data, status){
    console.log(data, status)
  });
});
