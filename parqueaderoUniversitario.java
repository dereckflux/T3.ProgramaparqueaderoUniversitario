import java.util.Scanner;

public class parqueaderoUniversitario {
    /*
    ANÁLISIS DEL SISTEMA DE PARQUEADERO UNIVERSITARIO 
    La universidad necesita calcular el valor de estacionamiento.

    El programa ofrece un menú con las opciones:
    1. Calcular tarifa
    2. Ver tarifas
    3. Salir

    Para "Calcular tarifa" se pide:
    - Tipo de vehículo (carro, moto, bicicleta) (Tener en cuenta que para cada uno es diferente )
    - Rol del usuario (estudiante, profesor, administrativo, visitante)(Tener en cuenta que para cada uno es diferente )
    - Día de la semana (lunes-viernes, sábado, domingo)(Tener en cuenta que para cada uno es diferente )
    - Horas de estacionamiento (1-24 horas)
    - Si perdió el boleto (0=No, 1=Sí) - recargo del 50%

    Lo que hace es calcular
    - Tarifa base según vehículo
    - Multiplica por horas
    - Aplica factor según día (fin de semana cuesta más)
    - Aplica descuento según rol
    - Aplica recargo si perdió boleto

    Para "Ver tarifas" simplemente se muestran en pantalla las tarifas,
    descuentos y factores que usa el sistema, sin pedir ningún dato.
    */

    public static void main(String[] args) {
        // DECLARAR TODAS LAS VARIABLES AL INICIO
        // Constantes: tarifas, descuentos y factores
        double tarifaCarro = 3.0;
        double tarifaMoto = 1.5;
        double tarifaBicicleta = 0.5;

        double descuentoEstudiante = 0.20;
        double descuentoProfesor = 0.15;
        double descuentoAdministrativo = 0.10;
        double descuentoVisitante = 0.0;

        double factorLaboral = 1.0;
        double factorSabado = 1.3;
        double factorDomingo = 1.5;

        double recargoBoletoPerdido = 0.50;

        // Variables de entrada
        String tipoVehiculo;
        String rol;
        String dia;
        int horas;
        int perdioBoleo;

        // Variables de proceso
        double tarifaBase;
        double tarifaPorHoras;
        double factorDia;
        double tarifaConFactor;
        double descuento;
        double tarifaConDescuento;
        double recargo;
        double tarifaFinal;

        // Variable para el menú
        int opcion;

        // creamos el scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nSISTEMA DE PARQUEADERO UNIVERSITARIO\n");

        // hago un ciclo do-while para que el menú se repita hasta que el usuario elija Salir
        do {
            // muestro el menú de opciones
            System.out.println("\n========== MENÚ ==========");
            System.out.println("1. Calcular tarifa");
            System.out.println("2. Ver tarifas");
            System.out.println("3. Salir");
            System.out.println("===========================");
            System.out.print("Elija una opción: ");

            String entradaOpcion = scanner.nextLine();
            try {
                opcion = Integer.parseInt(entradaOpcion);
            } catch (NumberFormatException e) {
                opcion = -1; // valor inválido para que caiga en el "default"
            }

            switch (opcion) {

                case 1:
                    // ===================== CALCULAR TARIFA =====================
                    // hago una validación de los datos de entrada, para que el usuario no pueda ingresar valores incorrectos
                    // uso el equalsIgnoreCase para que no importe si el usuario ingresa mayusculas o minusculas
                    // el || significa "o" y el && significa "y", entonces si el usuario ingresa un valor incorrecto, le muestra un mensaje de error y le pide que ingrese un valor correcto
                    // uso la estructura de repeticion while para que el usuario pueda ingresar los datos hasta que sean correctos, y uso el break para salir del ciclo cuando el usuario ingresa un valor correcto
                    do {
                        System.out.print("Tipo de vehículo (carro/moto/bicicleta): ");
                        tipoVehiculo = scanner.nextLine();
                        if (tipoVehiculo.equalsIgnoreCase("carro") || tipoVehiculo.equalsIgnoreCase("moto") || tipoVehiculo.equalsIgnoreCase("bicicleta")) {
                            // valor correcto
                        } else {
                            System.out.println("Ingrese un valor correcto para el vehículo.");
                        }
                    } while (!(tipoVehiculo.equalsIgnoreCase("carro") || tipoVehiculo.equalsIgnoreCase("moto") || tipoVehiculo.equalsIgnoreCase("bicicleta")));

                    do {
                        System.out.print("Rol (estudiante/profesor/administrativo/visitante): ");
                        rol = scanner.nextLine();
                        if (rol.equalsIgnoreCase("estudiante") || rol.equalsIgnoreCase("profesor") || rol.equalsIgnoreCase("administrativo") || rol.equalsIgnoreCase("visitante")) {
                            // valor correcto
                        } else {
                            System.out.println("Ingrese un valor correcto para el rol.");
                        }
                    } while (!(rol.equalsIgnoreCase("estudiante") || rol.equalsIgnoreCase("profesor") || rol.equalsIgnoreCase("administrativo") || rol.equalsIgnoreCase("visitante")));

                    do {
                        System.out.print("Día de la semana (lunes-martes-miercoles-jueves-viernes-sabado-domingo): ");
                        dia = scanner.nextLine();
                        if (dia.equalsIgnoreCase("lunes") || dia.equalsIgnoreCase("martes") || dia.equalsIgnoreCase("miercoles") || dia.equalsIgnoreCase("miércoles") || dia.equalsIgnoreCase("jueves") || dia.equalsIgnoreCase("viernes") || dia.equalsIgnoreCase("sabado") || dia.equalsIgnoreCase("sábado") || dia.equalsIgnoreCase("domingo")) {
                            // valor correcto
                        } else {
                            System.out.println("Ingrese un valor correcto para el día.");
                        }
                    } while (!(dia.equalsIgnoreCase("lunes") || dia.equalsIgnoreCase("martes") || dia.equalsIgnoreCase("miercoles") || dia.equalsIgnoreCase("miércoles") || dia.equalsIgnoreCase("jueves") || dia.equalsIgnoreCase("viernes") || dia.equalsIgnoreCase("sabado") || dia.equalsIgnoreCase("sábado") || dia.equalsIgnoreCase("domingo")));

                    do {
                        System.out.print("Horas estacionado (1-24): ");
                        String entradaHoras = scanner.nextLine();
                        try {
                            horas = Integer.parseInt(entradaHoras);
                            if (horas >= 1 && horas <= 24) {
                                // valor correcto
                            } else {
                                System.out.println("Ingrese un valor correcto para las horas.");
                            }
                        } catch (NumberFormatException e) {
                            horas = 0;
                            System.out.println("Ingrese un valor correcto para las horas.");
                        }
                    } while (horas < 1 || horas > 24);

                    do {
                        System.out.print("¿Perdió boleto? (0=No, 1=Sí): ");
                        String entradaBoleto = scanner.nextLine();
                        try {
                            perdioBoleo = Integer.parseInt(entradaBoleto);
                            if (perdioBoleo == 0 || perdioBoleo == 1) {
                                // valor correcto
                            } else {
                                System.out.println("Ingrese un valor correcto para el boleto.");
                            }
                        } catch (NumberFormatException e) {
                            perdioBoleo = -1;
                            System.out.println("Ingrese un valor correcto para el boleto.");
                        }
                    } while (perdioBoleo != 0 && perdioBoleo != 1);

                    // CALCULAR TARIFA BASE
                    tarifaBase = 0;
                    if (tipoVehiculo.equalsIgnoreCase("carro")) {
                        tarifaBase = tarifaCarro;
                    } else if (tipoVehiculo.equalsIgnoreCase("moto")) {
                        tarifaBase = tarifaMoto;
                    } else if (tipoVehiculo.equalsIgnoreCase("bicicleta")) {
                        tarifaBase = tarifaBicicleta;
                    }

                    // MULTIPLICAR POR HORAS
                    tarifaPorHoras = tarifaBase * horas;

                    // APLICAR FACTOR DEL DÍA
                    factorDia = factorLaboral;
                    if (dia.equalsIgnoreCase("sabado") || dia.equalsIgnoreCase("sábado")) {
                        factorDia = factorSabado;
                    } else if (dia.equalsIgnoreCase("domingo")) {
                        factorDia = factorDomingo;
                    }
                    tarifaConFactor = tarifaPorHoras * factorDia;

                    // APLICAR DESCUENTO POR ROL
                    descuento = 0;
                    if (rol.equalsIgnoreCase("estudiante")) {
                        descuento = tarifaConFactor * descuentoEstudiante;
                    } else if (rol.equalsIgnoreCase("profesor")) {
                        descuento = tarifaConFactor * descuentoProfesor;
                    } else if (rol.equalsIgnoreCase("administrativo")) {
                        descuento = tarifaConFactor * descuentoAdministrativo;
                    } else if (rol.equalsIgnoreCase("visitante")) {
                        descuento = tarifaConFactor * descuentoVisitante;
                    }

                    tarifaConDescuento = tarifaConFactor - descuento;

                    // APLICAR RECARGO SI PERDIÓ BOLETO
                    recargo = 0;
                    if (perdioBoleo == 1) {
                        recargo = tarifaConDescuento * recargoBoletoPerdido;
                    }

                    tarifaFinal = tarifaConDescuento + recargo;

                    // MOSTRAR RESULTADO
                    System.out.println("\n========== RESULTADO ==========");
                    System.out.println("Vehículo: " + tipoVehiculo);
                    System.out.println("Rol: " + rol);
                    System.out.println("Día: " + dia);
                    System.out.println("Horas: " + horas);
                    System.out.println("Perdió boleto: " + (perdioBoleo == 1 ? "Sí" : "No"));
                    System.out.println("---");
                    System.out.println("Tarifa base: $" + tarifaBase);
                    System.out.println("Por " + horas + " horas: $" + tarifaPorHoras);
                    System.out.println("Factor día: " + factorDia);
                    System.out.println("Con factor: $" + tarifaConFactor);
                    System.out.println("Descuento: $" + descuento);
                    System.out.println("Con descuento: $" + tarifaConDescuento);
                    if (perdioBoleo == 1) {
                        System.out.println("Recargo boleto: $" + recargo);
                    }
                    System.out.println("---");
                    System.out.printf("TOTAL: $%.2f\n", tarifaFinal);
                    System.out.println("===============================");
                    break;

                case 2:
                    // ===================== VER TARIFAS =====================
                    // aquí solo se muestra información, no se piden datos
                    System.out.println("\n========== TARIFAS DEL SISTEMA ==========");
                    System.out.println("-- Tarifa base por hora --");
                    System.out.println("Carro:      $" + tarifaCarro);
                    System.out.println("Moto:       $" + tarifaMoto);
                    System.out.println("Bicicleta:  $" + tarifaBicicleta);
                    System.out.println("\n-- Descuento por rol --");
                    System.out.println("Estudiante:     " + (descuentoEstudiante * 100) + "%");
                    System.out.println("Profesor:       " + (descuentoProfesor * 100) + "%");
                    System.out.println("Administrativo: " + (descuentoAdministrativo * 100) + "%");
                    System.out.println("Visitante:      " + (descuentoVisitante * 100) + "%");
                    System.out.println("\n-- Factor según el día --");
                    System.out.println("Lunes a viernes: x" + factorLaboral);
                    System.out.println("Sábado:          x" + factorSabado);
                    System.out.println("Domingo:         x" + factorDomingo);
                    System.out.println("\n-- Recargo por boleto perdido --");
                    System.out.println("Recargo: " + (recargoBoletoPerdido * 100) + "%");
                    System.out.println("==========================================");
                    break;

                case 3:
                    // ===================== SALIR =====================
                    System.out.println("\nGracias por usar el sistema. ¡Hasta pronto!");
                    break;

                default:
                    // si el usuario ingresa una opción que no es 1, 2 o 3
                    System.out.println("Opción inválida. Por favor elija 1, 2 o 3.");
                    break;
            }

        } while (opcion != 3); // el menú se repite hasta que el usuario elija Salir

        scanner.close();
    }
}