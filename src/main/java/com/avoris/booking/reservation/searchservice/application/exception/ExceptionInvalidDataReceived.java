package com.avoris.booking.reservation.searchservice.application.exception;

public class ExceptionInvalidDataReceived extends Exception{

    private final int errorCode;

    public ExceptionInvalidDataReceived(int errorCode) {
        super();
        this.errorCode=errorCode;
        getMessage();
    }


    public Integer getCode(){
        return errorCode;
    }

    public String getOriginalMessage(){
        return super.getMessage();
    }

    @Override
    public String getMessage(){

        String message="";

        switch(errorCode){
            case 1000:
                message="Error al cargar, el mensaje es nulo.";
                break;
            case 1001:
                message="Error al cargar, ProcessingInfo esta vacio.";
                break;
            case 1002:
                message="Error al cargar, IdPayrollEngine esta vacio.";
                break;
            case 1003:
                message="Error al cargar, eL mensaje recibido es incorrecto y no se puede introducir en el objeto.";
                break;
            case 1004:
                message="User code no puede estar vacio.";
                break;
            case 1005:
                message="Service id no puede estar vacio.";
                break;
            case 1006:
                message="User code no encontrado en la BBDD";
                break;
            case 1007:
                message="Service id tiene formato incorrecto";
                break;
            case 1008:
                message="Este servicio ya esta activado.";
                break;
            case 1009:
                message="No existe este servicio para este usuario.";
                break;
            case 1010:
                message="El campo employee_id no puede estar vacio.";
                break;
            case 1011:
                message="El campo employee_id no es numerico.";
                break;
            case 1012:
                message="Ningun departamento encontrado con los datos introducidos.";
                break;
            case 1013:
                message="No se ha encontrado ninguna categoria-pais con estos codigos.";
                break;
            case 1014:
                message="El campo status no puede estar vacio.";
                break;
            case 1015:
                message="No se ha encontrado el contrato real seccion a modificar.";
                break;
            case 1016:
                message="No se ha encontrado la categoria contrato a modificar.";
                break;
            case 1100:
                message="Datos incorrectos, excepción de formato incorrecto.";
                break;
            default:
                message = "Unknown Error";

        }
        return message;

    }


}
