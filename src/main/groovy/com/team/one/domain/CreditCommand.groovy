package com.team.one.domain

import com.team.one.domain.enums.*

class CreditCommand {

  String montoPrestamo
  //Primera seccion
  String nombre
  String apellidoPaterno
  String apellidoMaterno
  Date fechaNacimiento
  Integer edad
  EstadoCivil estadoCivil
  RegimenMatrimonial regimen
  GradoMaximoEstudios grado
  String gradoOtro
  Genero genero
  TipoIdentificacion identificacion
  String identificacionOtro
  String rfc
  String fiel
  String curp
  String claveElector
  String telefono
  String celular
  String telefonoOficina
  String email
  String nacionalidad
  TipoVivienda vivienda
  String tiempoResidencia
  String rentaCosto
  String hipotecaCosto
  Integer dependientes
  String codigoPostal
  String calleYNumero
  String colonia
  String delegacionMunicipio
  String ciudadOEstado
  String pais
  String referenciaDomicilio
  String profecion
  String empresa
  String giroActividad
  TipoContrato contrato
  Date fechaIngreso
  String sueldoMensual
  String domicilioEmpresa
  String ciudadEstadoEmpresa
  String telefonoEmpresa
  //Segunda seccion
  String nombreAval
  String apellidoPaternoAval
  String apellidoMaternoAval
  Date fechaNacimeintoAval
  TipoIdentificacion identificacionAval
  String identificacionOtroAval
  String nombreEmpresaAval
  String giroActividadAval
  String telefonoTrabajoAval
  TipoContrato contratoAval
  String sueldoMensualAval
  String domicilioEmpresaAval
  String ciudadEstadoAval
  //Tercera seccion
  String nombreCompletoRefFamiliar
  String parentescoFamiliar
  String telefonoFamiliar
  String domicilioFamiliar
  String nombreCompletoRefLaboral
  String parentescoLaboral
  String telefonoLaboral
  String domicilioLaboral
  String nombreCompletoRefPersonal1
  String parentescoPersonal1
  String telefonoPersonal1
  String domicilioPersonal1
  String nombreCompletoRefPersonal2
  String parentescoPersonal2
  String telefonoPersonal2
  String domicilioPersonal2
  //Cuarta seccion
  Boolean creditoActual
  Boolean avalCreditoTercero
  String tipoCreditoDeuda1
  String institucionDeuda1
  String numeroCreditoDeuda1
  Date fechaAperturaDeuda1
  Date fechaTerminoDeuda1
  String montoOtorgadoDeuda1
  String tipoCreditoDeuda2
  String institucionDeuda2
  String numeroCreditoDeuda2
  Date fechaAperturaDeuda2
  Date fechaTerminoDeuda2
  String montoOtorgadoDeuda2
  String tipoCreditoDeuda3
  String institucionDeuda3
  String numeroCreditoDeuda3
  Date fechaAperturaDeuda3
  Date fechaTerminoDeuda3
  String montoOtorgadoDeuda3
  String tipoCreditoDeuda4
  String institucionDeuda4
  String numeroCreditoDeuda4
  Date fechaAperturaDeuda4
  Date fechaTerminoDeuda4
  String montoOtorgadoDeuda4
  String nombreBeneficiario
  //Quita seccion
  String tipoSeguro
  String nombreBeneficiario1
  String nombreBeneficiario2
  String domicilioBeneficiario1
  String domicilioBeneficiario2
  //Septima seccion
  FuenteIngresos fuenteIngresos
  String fuenteIngresosOtros
  String profesionOcupacion
  String actividadGiroNegocio
  RangoMensual rangoMensual
  OrigenRecursos origenRecursos
  InstrumentoPago instrumentoPago



}