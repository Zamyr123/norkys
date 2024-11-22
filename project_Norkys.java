import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;

public class project_Norkys {
    String Nombre = "Andre";
    Scanner f1 = new Scanner(System.in);
    String DNiIngresado;
    String ContrasenaIngresado;
    String ApellidoIngresado;
    String NombreIngresado;
    double TotalPago = 0;
    ArrayList<String>f2=new ArrayList<>();
    ArrayList<Double>f3=new ArrayList<>();
    ArrayList<String> ArraysNombresReclamos = new ArrayList<>();
    ArrayList<String> ArraysTituloReclamos = new ArrayList<>();
    ArrayList<String> ArraysReclamos = new ArrayList<>();
    public static void main(String[] args) {
        project_Norkys Andre = new project_Norkys();
        Andre.Empezar();
    }

    public void Empezar() {
        String Eleccion;
        do {
            System.out.println("Seleccione Una Opcion:");
            System.out.println("Opcion 1: Iniciar Sesion ");
            System.out.println("Opcion 2: Crear Cuenta");
            System.out.println("Opcion 0: Salir");
            Eleccion = f1.nextLine();
            switch (Eleccion) {
                case "1":
                    Inicio();
                    break;
                case "2":
                    Registro();
                    break;
                case "0":
                    System.out.println("Saliendo de Programa");
                    break;
                default:
                    System.out.println("Esta Opcion No Existe");
                    break;
            }
        } while (!Eleccion.equals("0"));
    }

    public void Inicio() {
        boolean iniciar = false;
        int contador = 0;
        while (!iniciar && contador <= 2) {
            System.out.println("Iniciar sesion");
            System.out.println("Ingrese DNI");
            String DNISC = f1.nextLine();
            System.out.println("Ingrese su Contraseña");
            String ClaveSC = f1.nextLine();
            if (DNiIngresado.equals(DNISC) && ContrasenaIngresado.equals(ClaveSC)) {
                System.out.println("Se a Iniciado Sesion\n");
                System.out.println("Bienvenido a Norkys ");
                iniciar = true;
                MenuPrincipal();
            } else {
                System.out.println("Datos Incorrectos");
                contador++;
                System.out.println("Se realizo el Intento N°: " + contador);
            }
        }
        if (contador > 2) {
            System.out.println("El Acceso a sido Bloqueado");
        }
    }

    public void Registro() {
        System.out.println("Crear Una Cuenta");
        System.out.println("Ingrese fecha de nacimiento");
        System.out.println("Ingrese el dia");
        int dia = f1.nextInt();
        System.out.println("Ingrese el Mes (MM)");
        int mes = f1.nextInt();
        System.out.println("Ingrese el Año (AAAA)");
        int ano = f1.nextInt();
        LocalDate fechanacimiento = LocalDate.of(ano, mes, dia);
        LocalDate fechaActual = LocalDate.now();
        int edad = Period.between(fechanacimiento, fechaActual).getYears();
        f1.nextLine();
        if (edad >= 18 && edad <= 90) {
            System.out.println("Crear cuenta");
            System.out.println("Ingrese Nombres");
            NombreIngresado = f1.nextLine();
            System.out.println("Ingrese Apellidos");
            ApellidoIngresado = f1.nextLine();
            while (true) {
                System.out.println("Ingrese DNI");
                DNiIngresado = f1.nextLine();
                if (DNiIngresado.length() == 8 && DNiIngresado.matches("[0-9]+")) {
                    System.out.println("DNI Valido");
                    break;
                } else {
                    System.out.println("DNI no Valido");
                }
            }
            while (true) {
                System.out.println("ingrese su email (debe ser Gmail): ");
                String CorreoIngresado = f1.nextLine();
                if (CorreoIngresado.endsWith("@gmail.com")) {
                    System.out.println("Correo aceptado");
                    break;
                } else {
                    System.out.println("Correo no valido");
                }
            }
            while (true) {
                System.out.println("Ingrese una contraseña");
                ContrasenaIngresado = f1.nextLine();
                if (Requisitos(ContrasenaIngresado)) {
                    System.out.println("Contraseña valida");
                    break;
                } else {
                    System.out.println("Error");
                }
            }
            System.out.println("Se a Creado Su Cuenta Exitosamente");
        } else if (edad >= 1 && edad <= 17) {
            System.out.println("Usted es Menor de Edad  no puede  Crear una cuenta en esta Aplicacion");

        } else {
            System.out.println("edad no valida");
        }
        f1.nextLine();
    }

    public static boolean Requisitos(String password) {
        if (password.length() < 12) {
            return false;
        }
        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        boolean tieneNumero = false;
        boolean tieneSimbolo = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) tieneMayuscula = true;
            else if (Character.isLowerCase(c)) tieneMinuscula = true;
            else if (Character.isDigit(c)) tieneNumero = true;
            else tieneSimbolo = true;
        }

        return tieneMayuscula && tieneMinuscula && tieneNumero && tieneSimbolo;
    }

    public void MenuPrincipal() {
        String OpcPrin;
        do {
            System.out.println("""
                    MENU PRINCIPAL
                    Opcion 1: Carta Restaurante
                    Opcion 2: Carta Patio De Comida
                    Opcion 3: Libro De Reclamos
                    Opcion 4: Promociones
                    Opcion 5: Realizar Pago
                    Opcion 0: Salir Del Programa
                    Seleccione Una Opcion""");
            OpcPrin = f1.nextLine();
            switch (OpcPrin) {
                case "1":
                    Carta_Restaurante();
                    break;
                case "2":
                    String OpcPatioComida;
                    do {
                        System.out.println("""
                                    CARTA PATIO DE COMIDA
                                Opcion 1: Pollo a la Brasa
                                Opcion 2: Mixchaufero
                                Opcion 3: Combo Broaster
                                Opcion 4: Salchipapas
                                Opcion 5: Snacks
                                Opcion 0: Regresas a Menu Principal
                                Seleccione Una Opcion""");
                        OpcPatioComida = f1.nextLine();
                        switch (OpcPatioComida) {
                            case "1":
                                String OpcPolloBrasa;
                                do {
                                    OpcionPolloLaBrasa();
                                    OpcPolloBrasa = f1.nextLine();
                                    switch (OpcPolloBrasa) {
                                        case "1":
                                            VentasPolloLaBrasa1();
                                            break;
                                        case "2":
                                            VentasPolloLaBrasa2();
                                            break;
                                        case "3":
                                            VentasPolloLaBrasa3();
                                            break;
                                        case "4":
                                            VentasPolloLaBrasa4();
                                            break;
                                        case "0":
                                            System.out.println("Regresando al Menu Carta Patio de Comida");
                                            break;
                                        default:
                                            System.out.println("Esta Opcion No Existe");
                                            break;
                                    }
                                } while (!OpcPolloBrasa.equals("0"));
                                break;
                            case "2":
                                String OpcMixChaufa;
                                do {
                                    OpcionMixChaufero();
                                    OpcMixChaufa = f1.nextLine();
                                    switch (OpcMixChaufa) {
                                        case "1":
                                            VentasMixChaufero1();
                                            break;
                                        case "2":
                                            VentasMixchaufero2();
                                            break;
                                        case "3":
                                            VentasMixChaufero3();
                                            break;
                                        case "4":
                                            VentasMixChaufero4();
                                            break;
                                        case "0":
                                            System.out.println("Regresando al Menu Carta Patio de Comida");
                                            break;
                                        default:
                                            System.out.println("Esta Opcion No Existe");
                                            break;
                                    }
                                } while (!OpcMixChaufa.equals("0"));
                                break;
                            case "3":
                                String OpcBroaster;
                                do {
                                    OpcionComboBroaster();
                                    OpcBroaster = f1.nextLine();
                                    switch (OpcBroaster) {
                                        case "1":
                                            VentasBrostear1();
                                            break;
                                        case "2":
                                            VentasBrostear2();
                                            break;
                                        case "3":
                                            VentasBrostear3();
                                            break;
                                        case "0":
                                            System.out.println("Regresando al Menu Carta Patio de Comida");
                                            break;
                                        default:
                                            System.out.println("Esta Opcion No Existe");
                                            break;
                                    }
                                } while (!OpcBroaster.equals("0"));
                                break;
                            case "4":
                                String OpcSalchipapa;
                                do {
                                    OpcionSalchipapas();
                                    OpcSalchipapa = f1.nextLine();
                                    switch (OpcSalchipapa) {
                                        case "1":
                                            VentasSalchipapas1();
                                            break;
                                        case "2":
                                            VentasSalchipapas2();
                                            break;
                                        case "3":
                                            VentasSalchipapas3();
                                            break;
                                        case "4":
                                            VentasSalchipapas4();
                                            break;
                                        case "0":
                                            System.out.println("Regresando al Menu Carta Patio de Comida");
                                            break;
                                        default:
                                            System.out.println("Esta Opcion No Existe");
                                            break;
                                    }
                                } while (!OpcSalchipapa.equals("0"));
                                break;
                            case "5":
                                String OpcSnack;
                                do {
                                    OpcionSnacks();
                                    OpcSnack = f1.nextLine();
                                    switch (OpcSnack) {
                                        case "1":
                                            VentasSnacks1();
                                            break;
                                        case "2":
                                            VentasSnacks2();
                                            break;
                                        case "3":
                                            VentasSnacks3();
                                            break;
                                        case "4":
                                            VentasSnacks4();
                                            break;
                                        case "0":
                                            System.out.println("Regresando al Menu Carta Patio de Comida");
                                            break;
                                        default:
                                            System.out.println("Esta Opcion No Existe");
                                            break;
                                    }
                                } while (!OpcSnack.equals("0"));
                                break;
                            case "0":
                                System.out.println("Regresando al Menu Principal");
                                break;
                            default:
                                System.out.println("Esta Opcion No Existe");
                                break;
                        }
                    } while (!OpcPatioComida.equals("0"));
                    break;

                case "3":
                    String OpcionReclamos;
                    do {
                        System.out.println("Opcion 1: Realizar Reclamo");
                        System.out.println("Opcioo 2: Ver Reclamos");
                        System.out.println("Opcion 0: Salir");
                        OpcionReclamos=f1.nextLine();
                        switch (OpcionReclamos){
                            case "1":
                                agregarNombres();
                                break;
                            case "2":
                                MostrarReclamos();
                                break;
                            case "0":
                                System.out.println("Saliendo");
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                break;
                        }
                    }while (!OpcionReclamos.equals("0"));
                    break;

                case "4":
                    System.out.println("El Intregante no realizo su trabaj0 ");
                    break;
                case "5":
                    RealizarPago();
                    break;
                case "0":
                    System.out.println("Saliento del Programa");
                    break;
                default:
                    System.out.println("Esta Opcion no Existe UwU");
                    break;
            }
        } while (!OpcPrin.equals("0"));
    }
    public void MostrarReclamos() {
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String fechaFormateada = fechaActual.format(formatoFecha);
        String horaFormateada = horaActual.format(formatoHora);
        System.out.println("Lista de Reclamos:\n--------------------");
        for (int i = 0; i < ArraysNombresReclamos.size(); i++) {
            System.out.println("Nombre del Cliente   : " + ArraysNombresReclamos.get(i));
            System.out.println("Titulo Del Reclamo   : " + ArraysTituloReclamos.get(i));
            System.out.println("Contexto Del Reclamo : " + ArraysReclamos.get(i));
            System.out.println("-----------------------------------");
        }
        System.out.println("Fecha Del Reclamo : " + fechaFormateada);
        System.out.println("Hora De Emision  : " + horaFormateada);
        System.out.println("---------------------------------------");
    }
    public void agregarNombres() {
        System.out.println("¿Cuántas Reclamos desea agregar?");
        int cantidad = f1.nextInt();
        f1.nextLine();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Reclamo N° " + (i + 1) + ":");
            System.out.println("Ingrese Su nombre:");
            String nombre = f1.nextLine();
            ArraysNombresReclamos.add(nombre);
            System.out.println("Ingrese el tema Del Reclamo:");
            String titulo = f1.nextLine();
            ArraysTituloReclamos.add(titulo);
            System.out.println("Ingrese el Contexto del reclamo:");
            String texto = f1.nextLine();
            ArraysReclamos.add(texto);
        }
        System.out.println("Reclamos agregados a la lista.");
    }

    public void Carta_Restaurante() {
        System.out.println("Bienvenido a su carta de restaurante ");
        System.out.println("¿Que clase de combo va a pedir? \n tenemos los siguientes combos");
        System.out.println("1 |Pollos a la brasa ");
        System.out.println("2 |Parrillas ");
        System.out.println("3 |Saltados ");
        System.out.println("4 |Mix chauferos ");
        System.out.println("5 |Adicionales  ");
        System.out.println("Seleccione una de las opciones");
        int opcion = f1.nextInt();
        switch (opcion) {
            case 1:
                Pollosalabrasa();
                break;
            case 2:
                Parrillas();
                break;
            case 3:
                Saltados();
                break;
            case 4:
                MixChauferos();
                break;
            case 5:
                Adicionales();
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    public void Pollosalabrasa() {
        System.out.println("Tenemos los siguientes tipos de combo de pollos a la brasa");
        System.out.println("1°|1/4 de pollo+papas+ensalada");
        System.out.println("2°|1/2 de pollo+papas+ensalada");
        System.out.println("3°|Pollo oferta");
        System.out.println("4°|Combo familiar");
        System.out.println("5°|Combo familiar 2");
        System.out.println("6°|1/4 de pollo+papas+ensalada+gaseosa");
        System.out.println("7°|1/2 de pollo+papas+ensalada+gaseosa");
        System.out.println("Seleccione una de las opciones que se muestra");
        int opcion = f1.nextInt();
        switch (opcion) {
            case 1:
                this.unCuartodepollopapasensalada();
                break;
            case 2:
                this.unMediodepollopapasensalada();
                break;
            case 3:
                this.Pollooferta();
                break;
            case 4:
                this.ComboFamiliar();
                break;
            case 5:
                this.ComboFamiliar2();
                break;
            case 6:
                this.unCuartodepollopapasensaladagaseosa();
                break;
            case 7:
                this.unMediodepollopapasensaladagaseosa();
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    public void unCuartodepollopapasensalada() {
        System.out.println("El 1/4 de pollo+papas+ensalada esta a 12.90 soles");
        System.out.println("¿Cuantos desa comprar?");
        int cuarto_sinGaseosa = f1.nextInt();
        double costocuartoSinGas = 12.90;
        double totalCuartoSinGas = cuarto_sinGaseosa * costocuartoSinGas;
        double igv1 = totalCuartoSinGas * 0.18;
        double subtotal1 = totalCuartoSinGas - igv1;
        System.out.println("El total a pagar es de " + totalCuartoSinGas + " soles");
        System.out.println("El IGV es de " + igv1 + " soles ");
        System.out.println("Y el sub total es de " + subtotal1 + " soles ");
        System.out.println();
        TotalPago += totalCuartoSinGas;
        f1.nextLine();
    }

    public void unMediodepollopapasensalada() {
        System.out.println("El 1/2 de pollo+papas+ensalada esta a 19.90 soles");
        System.out.println("¿Cuantos desa comprar?");
        int medio_sinGaseosa = f1.nextInt();
        double costomedioSinGas = 19.90;
        double totalMedioSinGas = medio_sinGaseosa * costomedioSinGas;
        double igv2 = totalMedioSinGas * 0.18;
        double subtotal2 = totalMedioSinGas - igv2;
        System.out.println("El total a pagar es de " + totalMedioSinGas + " soles");
        System.out.println("El IGV es de " + igv2 + " soles ");
        System.out.println("Y el sub total es de " + subtotal2 + " soles ");
        System.out.println();
        TotalPago += totalMedioSinGas;
        f1.nextLine();
    }

    public void Pollooferta() {
        System.out.println("El Pollo oferta esta a 74.90 soles");
        System.out.println("¿Cuantos desa comprar?");
        int PolloOferta = f1.nextInt();
        double costoPolloOferta = 74.90;
        double totalPolloOferta = PolloOferta * costoPolloOferta;
        double igv3 = totalPolloOferta * 0.18;
        double subtotal3 = totalPolloOferta - igv3;
        System.out.println("El total a pagar es de " + totalPolloOferta + " soles");
        System.out.println("El IGV es de " + igv3 + " soles ");
        System.out.println("Y el sub total es de " + subtotal3 + " soles ");
        System.out.println();
        TotalPago += totalPolloOferta;
        f1.nextLine();

    }

    public void ComboFamiliar() {
        System.out.println("El Combo Familiar esta a 96.00 soles");
        System.out.println("¿Cuantos desa comprar?");
        int ComboFamiliar = f1.nextInt();
        double costoComboFamiliar = 96.00;
        double totalComboFamiliar = ComboFamiliar * costoComboFamiliar;
        double igv4 = totalComboFamiliar * 0.18;
        double subtotal4 = totalComboFamiliar - igv4;
        System.out.println("El total a pagar es de " + totalComboFamiliar + " soles");
        System.out.println("El IGV es de " + igv4 + " soles ");
        System.out.println("Y el sub total es de " + subtotal4 + " soles ");
        System.out.println();
        TotalPago += totalComboFamiliar;
        f1.nextLine();
    }

    public void ComboFamiliar2() {
        System.out.println("El Combo Familiar 2 esta a 96.00 soles");
        System.out.println("¿Cuantos desa comprar?");
        int ComboFamiliar = f1.nextInt();
        double costoComboFamiliar = 96.00;
        double totalComboFamiliar = ComboFamiliar * costoComboFamiliar;
        double igv4 = totalComboFamiliar * 0.18;
        double subtotal4 = totalComboFamiliar - igv4;
        System.out.println("El total a pagar es de " + totalComboFamiliar + " soles");
        System.out.println("El IGV es de " + igv4 + " soles ");
        System.out.println("Y el sub total es de " + subtotal4 + " soles ");
        System.out.println();
        TotalPago += totalComboFamiliar;
        f1.nextLine();
    }

    public void unCuartodepollopapasensaladagaseosa() {
        System.out.println("El 1/4 de pollo+papas+ensalada+gaseosa esta a 25.90 soles");
        System.out.println("¿Cuantos desa comprar?");
        int cuarto_sconGaseosa = f1.nextInt();
        double costocuartoConGas = 25.90;
        double totalCuartoConGas = cuarto_sconGaseosa * costocuartoConGas;
        double igv3 = totalCuartoConGas * 0.18;
        double subtotal3 = totalCuartoConGas - igv3;
        System.out.println("El total a pagar es de " + totalCuartoConGas + " soles");
        System.out.println("El IGV es de " + igv3 + " soles ");
        System.out.println("Y el sub total es de " + subtotal3 + " soles ");
        System.out.println();
        TotalPago += totalCuartoConGas;
        f1.nextLine();
    }

    public void unMediodepollopapasensaladagaseosa() {
        System.out.println("El 1/4 de pollo+papas+ensalada+gaseosa esta a 29.90 soles");
        System.out.println("¿Cuantos desa comprar?");
        int medio_sconGaseosa = f1.nextInt();
        double costomedioConGas = 29.90;
        double totalMedioConGas = medio_sconGaseosa * costomedioConGas;
        double igv3 = totalMedioConGas * 0.18;
        double subtotal3 = totalMedioConGas - igv3;
        System.out.println("El total a pagar es de " + totalMedioConGas + " soles");
        System.out.println("El IGV es de " + igv3 + " soles ");
        System.out.println("Y el sub total es de " + subtotal3 + " soles ");
        System.out.println();
        TotalPago += totalMedioConGas;
        f1.nextLine();
    }

    public void Parrillas() {
        System.out.println("Tenemos los siguientes tipos de combo de Parrillas");
        System.out.println("1°|Parrilla Norkys");
        System.out.println("2°|Parrilla del chef");
        System.out.println("3°|Churrasco simple");
        System.out.println("4°|Churrasco a la pobre");
        System.out.println("5°|Brasa extremo");
        System.out.println("6°|Pechuga Light");
        System.out.println("7°|Pechuga Norkys");
        System.out.println("Seleccione una de las opciones que se muestra");
        int opcion = f1.nextInt();
        switch (opcion) {
            case 1:
                this.ParrillaNorkys();
                break;
            case 2:
                this.ParrilladelChef();
                break;
            case 3:
                this.ChurrascoSimple();
                break;
            case 4:
                this.ChurrascoalaPobre();
                break;
            case 5:
                this.BrasaExtremo();
                break;
            case 6:
                this.PechugaLight();
                break;
            case 7:
                this.PechugaNorkys();
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    public void ParrillaNorkys() {
        System.out.println("La Parrilla Norkys esta a 12.90 soles");
        System.out.println("¿Cuantos desa comprar?");
        int cuarto_sinGaseosa = f1.nextInt();
        double costocuartoSinGas = 12.90;
        double totalCuartoSinGas = cuarto_sinGaseosa * costocuartoSinGas;
        double igv3 = totalCuartoSinGas * 0.18;
        double subtotal3 = totalCuartoSinGas - igv3;
        System.out.println("El total a pagar es de " + totalCuartoSinGas + " soles");
        System.out.println("El IGV es de " + igv3 + " soles ");
        System.out.println("Y el sub total es de " + subtotal3 + " soles ");
        System.out.println();
        TotalPago += totalCuartoSinGas;
        f1.nextLine();
    }

    public void ParrilladelChef() {
        System.out.println("La Parrilla del Chef esta a 19.90 soles");
        System.out.println("¿Cuantos desa comprar?");
        int medio_sinGaseosa = f1.nextInt();
        double costomedioSinGas = 19.90;
        double totalMedioSinGas = medio_sinGaseosa * costomedioSinGas;
        double igv3 = totalMedioSinGas * 0.18;
        double subtotal3 = totalMedioSinGas - igv3;
        System.out.println("El total a pagar es de " + totalMedioSinGas + " soles");
        System.out.println("El IGV es de " + igv3 + " soles ");
        System.out.println("Y el sub total es de " + subtotal3 + " soles ");
        System.out.println();
        TotalPago += totalMedioSinGas;
        f1.nextLine();
    }

    public void ChurrascoSimple() {
        System.out.println("El Churrasco Simple esta a 74.90 soles");
        System.out.println("¿Cuantos desa comprar?");
        int PolloOferta = f1.nextInt();
        double costoPolloOferta = 74.90;
        double totalPolloOferta = PolloOferta * costoPolloOferta;
        double igv3 = totalPolloOferta * 0.18;
        double subtotal3 = totalPolloOferta - igv3;
        System.out.println("El total a pagar es de " + totalPolloOferta + " soles");
        System.out.println("El IGV es de " + igv3 + " soles ");
        System.out.println("Y el sub total es de " + subtotal3 + " soles ");
        System.out.println();
        TotalPago += totalPolloOferta;
        f1.nextLine();
    }

    public void ChurrascoalaPobre() {
        System.out.println("El Churrasco a la Pobre esta a 96.00 soles");
        System.out.println("¿Cuantos desa comprar?");
        int ComboFamiliar = f1.nextInt();
        double costoComboFamiliar = 96.00;
        double totalComboFamiliar = ComboFamiliar * costoComboFamiliar;
        double igv4 = totalComboFamiliar * 0.18;
        double subtotal4 = totalComboFamiliar - igv4;
        System.out.println("El total a pagar es de " + totalComboFamiliar + " soles");
        System.out.println("El IGV es de " + igv4 + " soles ");
        System.out.println("Y el sub total es de " + subtotal4 + " soles ");
        System.out.println();
        TotalPago += totalComboFamiliar;
        f1.nextLine();

    }

    public void BrasaExtremo() {
        System.out.println("El Brasa Extremo esta a 96.00 soles");
        System.out.println("¿Cuantos desa comprar?");
        int ComboFamiliar = f1.nextInt();
        double costoComboFamiliar = 96.00;
        double totalComboFamiliar = ComboFamiliar * costoComboFamiliar;
        double igv4 = totalComboFamiliar * 0.18;
        double subtotal4 = totalComboFamiliar - igv4;
        System.out.println("El total a pagar es de " + totalComboFamiliar + " soles");
        System.out.println("El IGV es de " + igv4 + " soles ");
        System.out.println("Y el sub total es de " + subtotal4 + " soles ");
        System.out.println();
        TotalPago += totalComboFamiliar;
        f1.nextLine();
    }

    public void PechugaLight() {
        System.out.println("La Pechuga Light esta a 25.90 soles");
        System.out.println("¿Cuantos desa comprar?");
        int cuarto_sconGaseosa = f1.nextInt();
        double costocuartoConGas = 25.90;
        double totalCuartoConGas = cuarto_sconGaseosa * costocuartoConGas;
        double igv3 = totalCuartoConGas * 0.18;
        double subtotal3 = totalCuartoConGas - igv3;
        System.out.println("El total a pagar es de " + totalCuartoConGas + " soles");
        System.out.println("El IGV es de " + igv3 + " soles ");
        System.out.println("Y el sub total es de " + subtotal3 + " soles ");
        System.out.println();
        TotalPago += totalCuartoConGas;
        f1.nextLine();
    }

    public void PechugaNorkys() {
        System.out.println("La Pechuga Norkys esta a 29.90 soles");
        System.out.println("¿Cuantos desa comprar?");
        int medio_sconGaseosa = f1.nextInt();
        double costomedioConGas = 29.90;
        double totalMedioConGas = medio_sconGaseosa * costomedioConGas;
        double igv3 = totalMedioConGas * 0.18;
        double subtotal3 = totalMedioConGas - igv3;
        System.out.println("El total a pagar es de " + totalMedioConGas + " soles");
        System.out.println("El IGV es de " + igv3 + " soles ");
        System.out.println("Y el sub total es de " + subtotal3 + " soles ");
        System.out.println();
        TotalPago += totalMedioConGas;
        f1.nextLine();
    }

    public void Saltados() {
        System.out.println("Tenemos los siguientes tipos de combo de Saltados");
        System.out.println("1°|Arroz Chaufa De Carne");
        System.out.println("2°|Arroz Chaufa De Pollo");
        System.out.println("3°|Tallarin Saltado de Carne");
        System.out.println("4°|Tallarin Saltado de Pollo");
        System.out.println("5°|Lomo Saltado");
        System.out.println("6°|Pollo Saltado");
        System.out.println("Seleccione una de las opciones que se muestra");
        int opcion = f1.nextInt();
        switch (opcion) {
            case 1:
                this.ArrozChaufaDeCarne();
                break;
            case 2:
                this.ArrozChaufaDePollo();
                break;
            case 3:
                this.TallarinSaltadodeCarne();
                break;
            case 4:
                this.TallarinSaltadodePollo();
                break;
            case 5:
                this.LomoSaltado();
                break;
            case 6:
                this.PolloSaltado();
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    public void ArrozChaufaDeCarne() {
        System.out.println("El Arroz Chaufa De Carne esta a 12.90 soles");
        System.out.println("¿Cuantos desa comprar?");
        int cuarto_sinGaseosa = f1.nextInt();
        double costocuartoSinGas = 12.90;
        double totalCuartoSinGas = cuarto_sinGaseosa * costocuartoSinGas;
        double igv3 = totalCuartoSinGas * 0.18;
        double subtotal3 = totalCuartoSinGas - igv3;
        System.out.println("El total a pagar es de " + totalCuartoSinGas + " soles");
        System.out.println("El IGV es de " + igv3 + " soles ");
        System.out.println("Y el sub total es de " + subtotal3 + " soles ");
        System.out.println();
        TotalPago += totalCuartoSinGas;
        f1.nextLine();
    }

    public void ArrozChaufaDePollo() {
        System.out.println("El Arroz Chaufa De Pollo esta a 19.90 soles");
        System.out.println("¿Cuantos desa comprar?");
        int medio_sinGaseosa = f1.nextInt();
        double costomedioSinGas = 19.90;
        double totalMedioSinGas = medio_sinGaseosa * costomedioSinGas;
        double igv3 = totalMedioSinGas * 0.18;
        double subtotal3 = totalMedioSinGas - igv3;
        System.out.println("El total a pagar es de " + totalMedioSinGas + " soles");
        System.out.println("El IGV es de " + igv3 + " soles ");
        System.out.println("Y el sub total es de " + subtotal3 + " soles ");
        System.out.println();
        TotalPago += totalMedioSinGas;
        f1.nextLine();
    }

    public void TallarinSaltadodeCarne() {
        System.out.println("El Tallarin Saltado de Carne esta a 74.90 soles");
        System.out.println("¿Cuantos desa comprar?");
        int PolloOferta = f1.nextInt();
        double costoPolloOferta = 74.90;
        double totalPolloOferta = PolloOferta * costoPolloOferta;
        double igv3 = totalPolloOferta * 0.18;
        double subtotal3 = totalPolloOferta - igv3;
        System.out.println("El total a pagar es de " + totalPolloOferta + " soles");
        System.out.println("El IGV es de " + igv3 + " soles ");
        System.out.println("Y el sub total es de " + subtotal3 + " soles ");
        System.out.println();
        TotalPago += totalPolloOferta;
        f1.nextLine();
    }

    public void TallarinSaltadodePollo() {
        System.out.println("El Tallarin Saltado de Carne esta a 96.00 soles");
        System.out.println("¿Cuantos desa comprar?");
        int ComboFamiliar = f1.nextInt();
        double costoComboFamiliar = 96.00;
        double totalComboFamiliar = ComboFamiliar * costoComboFamiliar;
        double igv4 = totalComboFamiliar * 0.18;
        double subtotal4 = totalComboFamiliar - igv4;
        System.out.println("El total a pagar es de " + totalComboFamiliar + " soles");
        System.out.println("El IGV es de " + igv4 + " soles ");
        System.out.println("Y el sub total es de " + subtotal4 + " soles ");
        System.out.println();
        TotalPago += totalComboFamiliar;
        f1.nextLine();
    }

    public void LomoSaltado() {
        System.out.println("El Lomo Saltado esta a 96.00 soles");
        System.out.println("¿Cuantos desa comprar?");
        int ComboFamiliar = f1.nextInt();
        double costoComboFamiliar = 96.00;
        double totalComboFamiliar = ComboFamiliar * costoComboFamiliar;
        double igv4 = totalComboFamiliar * 0.18;
        double subtotal4 = totalComboFamiliar - igv4;
        System.out.println("El total a pagar es de " + totalComboFamiliar + " soles");
        System.out.println("El IGV es de " + igv4 + " soles ");
        System.out.println("Y el sub total es de " + subtotal4 + " soles ");
        System.out.println();
        TotalPago += totalComboFamiliar;
        f1.nextLine();
    }

    public void PolloSaltado() {
        System.out.println("El Pollo Saltado esta a 25.90 soles");
        System.out.println("¿Cuantos desa comprar?");
        int cuarto_sconGaseosa = f1.nextInt();
        double costocuartoConGas = 25.90;
        double totalCuartoConGas = cuarto_sconGaseosa * costocuartoConGas;
        double igv3 = totalCuartoConGas * 0.18;
        double subtotal3 = totalCuartoConGas - igv3;
        System.out.println("El total a pagar es de " + totalCuartoConGas + " soles");
        System.out.println("El IGV es de " + igv3 + " soles ");
        System.out.println("Y el sub total es de " + subtotal3 + " soles ");
        System.out.println();
        TotalPago += totalCuartoConGas;
        f1.nextLine();
    }


    public void MixChauferos() {
        System.out.println("Tenemos los siguientes tipos de combo de Mix Chauferos");
        System.out.println("1°|Chaufa Brasa");
        System.out.println("2°|Chorichaufa Brasa");
        System.out.println("3°|Chaufa con Trozos de Pollo a la Brasa");
        System.out.println("Seleccione una de las opciones que se muestra");
        int opcion = f1.nextInt();
        switch (opcion) {
            case 1:
                this.ChaufaBrasa();
                break;
            case 2:
                this.ChorichaufaBrasa();
                break;
            case 3:
                this.ChaufaconTrozosdePolloalaBrasa();
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    public void ChaufaBrasa() {
        System.out.println("La Chaufa Brasa esta a 12.90 soles");
        System.out.println("¿Cuantos desa comprar?");
        int cuarto_sinGaseosa = f1.nextInt();
        double costocuartoSinGas = 12.90;
        double totalCuartoSinGas = cuarto_sinGaseosa * costocuartoSinGas;
        double igv3 = totalCuartoSinGas * 0.18;
        double subtotal3 = totalCuartoSinGas - igv3;
        System.out.println("El total a pagar es de " + totalCuartoSinGas + " soles");
        System.out.println("El IGV es de " + igv3 + " soles ");
        System.out.println("Y el sub total es de " + subtotal3 + " soles ");
        System.out.println();
        TotalPago += totalCuartoSinGas;
        f1.nextLine();
    }

    public void ChorichaufaBrasa() {
        System.out.println("La Chorichaufa Brasa esta a 19.90 soles");
        System.out.println("¿Cuantos desa comprar?");
        int medio_sinGaseosa = f1.nextInt();
        double costomedioSinGas = 19.90;
        double totalMedioSinGas = medio_sinGaseosa * costomedioSinGas;
        double igv3 = totalMedioSinGas * 0.18;
        double subtotal3 = totalMedioSinGas - igv3;
        System.out.println("El total a pagar es de " + totalMedioSinGas + " soles");
        System.out.println("El IGV es de " + igv3 + " soles ");
        System.out.println("Y el sub total es de " + subtotal3 + " soles ");
        System.out.println();
        TotalPago += totalMedioSinGas;
        f1.nextLine();
    }

    public void ChaufaconTrozosdePolloalaBrasa() {
        System.out.println("La Chaufa con Trozos de Pollo a la Brasa esta a 74.90 soles");
        System.out.println("¿Cuantos desa comprar?");
        int PolloOferta = f1.nextInt();
        double costoPolloOferta = 74.90;
        double totalPolloOferta = PolloOferta * costoPolloOferta;
        double igv3 = totalPolloOferta * 0.18;
        double subtotal3 = totalPolloOferta - igv3;
        System.out.println("El total a pagar es de " + totalPolloOferta + " soles");
        System.out.println("El IGV es de " + igv3 + " soles ");
        System.out.println("Y el sub total es de " + subtotal3 + " soles ");
        System.out.println();
        TotalPago += totalPolloOferta;
        f1.nextLine();
    }

    public void Adicionales() {
        System.out.println("1°|Gaseosa 500 ml");
        System.out.println("2°|Gaseosa 1.5 L");
        System.out.println("3°|1/4 de Pollo Adicional");
        System.out.println("4°|Porcion Papa Familiar");
        System.out.println("5°|Porcion de chaufa");
        System.out.println("Seleccione una de las opciones que se muestra");
        int opcion = f1.nextInt();
        switch (opcion) {
            case 1:
                this.Gaseosa500ml();
                break;
            case 2:
                this.Gaseosa1Litroy500ml();
                break;
            case 3:
                this.UnCuartodePolloAdicional();
                break;
            case 4:
                this.PorcionPapaFamiliar();
                break;
            case 5:
                this.Porciondechaufa();
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    public void Gaseosa500ml() {
        System.out.println("La Gaseosa 500 ml esta a 12.90 soles");
        System.out.println("¿Cuantos desa comprar?");
        int cuarto_sinGaseosa = f1.nextInt();
        double costocuartoSinGas = 12.90;
        double totalCuartoSinGas = cuarto_sinGaseosa * costocuartoSinGas;
        double igv4 = totalCuartoSinGas * 0.18;
        double subtotal4 = totalCuartoSinGas - igv4;
        System.out.println("El total a pagar es de " + totalCuartoSinGas + " soles");
        System.out.println("El IGV es de " + igv4 + " soles ");
        System.out.println("Y el sub total es de " + subtotal4 + " soles ");
        System.out.println();
        TotalPago += totalCuartoSinGas;
        f1.nextLine();
    }

    public void Gaseosa1Litroy500ml() {
        System.out.println("La Gaseosa 1.5 L esta a 19.90 soles");
        System.out.println("¿Cuantos desa comprar?");
        int medio_sinGaseosa = f1.nextInt();
        double costomedioSinGas = 19.90;
        double totalMedioSinGas = medio_sinGaseosa * costomedioSinGas;
        double igv4 = totalMedioSinGas * 0.18;
        double subtotal4 = totalMedioSinGas - igv4;
        System.out.println("El total a pagar es de " + totalMedioSinGas + " soles");
        System.out.println("El IGV es de " + igv4 + " soles ");
        System.out.println("Y el sub total es de " + subtotal4 + " soles ");
        System.out.println();
        TotalPago += totalMedioSinGas;
        f1.nextLine();
    }

    public void UnCuartodePolloAdicional() {
        System.out.println("Un Cuarto de Pollo Adicional esta a 74.90 soles");
        System.out.println("¿Cuantos desa comprar?");
        int PolloOferta = f1.nextInt();
        double costoPolloOferta = 74.90;
        double totalPolloOferta = PolloOferta * costoPolloOferta;
        double igv3 = totalPolloOferta * 0.18;
        double subtotal3 = totalPolloOferta - igv3;
        System.out.println("El total a pagar es de " + totalPolloOferta + " soles");
        System.out.println("El IGV es de " + igv3 + " soles ");
        System.out.println("Y el sub total es de " + subtotal3 + " soles ");
        System.out.println();
        TotalPago += totalPolloOferta;
        f1.nextLine();
    }

    public void PorcionPapaFamiliar() {
        System.out.println("El Porcion Papa Familiar esta a 96.00 soles");
        System.out.println("¿Cuantos desa comprar?");
        int ComboFamiliar = f1.nextInt();
        double costoComboFamiliar = 96.00;
        double totalComboFamiliar = ComboFamiliar * costoComboFamiliar;
        double igv4 = totalComboFamiliar * 0.18;
        double subtotal4 = totalComboFamiliar - igv4;
        System.out.println("El total a pagar es de " + totalComboFamiliar + " soles");
        System.out.println("El IGV es de " + igv4 + " soles ");
        System.out.println("Y el sub total es de " + subtotal4 + " soles ");
        System.out.println();
        TotalPago += totalComboFamiliar;
        f1.nextLine();
    }

    public void Porciondechaufa() {
        System.out.println("La Porcion de chaufa esta a 96.00 soles");
        System.out.println("¿Cuantos desa comprar?");
        int ComboFamiliar = f1.nextInt();
        double costoComboFamiliar = 96.00;
        double totalComboFamiliar = ComboFamiliar * costoComboFamiliar;
        double igv4 = totalComboFamiliar * 0.18;
        double subtotal4 = totalComboFamiliar - igv4;
        System.out.println("El total a pagar es de " + totalComboFamiliar + " soles");
        System.out.println("El IGV es de " + igv4 + " soles ");
        System.out.println("Y el sub total es de " + subtotal4 + " soles ");
        System.out.println();
        TotalPago += totalComboFamiliar;
        f1.nextLine();
    }


    public void OpcionComboBroaster() {
        System.out.println("""
                                 COMBO BROASTER
                Opcion 1: (Combo 1 Pieza) | 1 Pieza Broaster    |
                Precio: $ 14.90           | 100gr de Chicharron |
                                          | Papas personal      |
                                          | Gaseosa 12oz        |
                
                Opcion 2: (Combo 2 Pieza) | 2 Pieza Broaster    |
                Precio: $ 17.90           | 100gr de Chicharron |
                                          | Papas personal      |
                                          | Gaseosa 12oz        |
                
                Opcion 3: (Combo 3 Pieza) | 3 Pieza Broaster    |
                Precio: $ 20.90           | 100gr de Chicharron |
                                          | Papas personal      |
                                          | Gaseosa 12oz        |
                
                Opcion 0: Regresar al Menu Carta Patio de Comida
                Seleccione Una Opcion""");
    }

    public void VentasBrostear1() {
        System.out.println("Cuantos Unidades va a Llevar");
        int cantidad1 = f1.nextInt();
        double Total1 = cantidad1 * 14.90;
        double IGV1 = Total1 * 0.18;
        double SubTotal1 = Total1 - IGV1;
        System.out.println("El SubTotal es de: $" + SubTotal1);
        System.out.println("El Total a Pagar es: $" + Total1);
        System.out.println("El IGV es de: " + IGV1);

        f3.add(Total1);
        f2.add("|---"+cantidad1+"---|Combos Broster 1 pieza                       |"+Total1+"--|");
        f1.nextLine();
    }

    public void VentasBrostear2() {
        System.out.println("Cuantos Unidades Va a Llevar");
        int cantidad2 = f1.nextInt();
        double Total2 = cantidad2 * 17.90;
        double IGV2 = Total2 * 0.18;
        double SubTotal2 = Total2 - IGV2;
        System.out.println("El Total a Pagar es: $" + Total2);
        System.out.println("El SubTotal es de: $" + SubTotal2);
        System.out.println("El IGV es de: " + IGV2);

        f3.add(Total2);
        f2.add("|---"+cantidad2+"---|Combos Broster 2 pieza                       |"+Total2+"--|");
        f1.nextLine();
    }

    public void VentasBrostear3() {
        System.out.println("Cuantos Unidades va a Llevar ");
        int cantidad3 = f1.nextInt();
        double Total3 = cantidad3 * 20.90;
        double IGV3 = Total3 * 0.18;
        double SubTotal3 = Total3 - IGV3;
        System.out.println("El SubTotal es de: $" + SubTotal3);
        System.out.println("El Total a Pagar es: $" + Total3);
        System.out.println("El IGV es de: " + IGV3);

        f3.add(Total3);
        f2.add("|---"+cantidad3+"---|Combos Broster 3 pieza                       |"+Total3+"--|");
        f1.nextLine();
    }

    public void OpcionPolloLaBrasa() {
        System.out.println("""
                                 POLLO A LA BRASA
                Opcion 1: (1/4 pollo)       | 1/4 pollo    |
                Precio: $ 21.90             | papas fritas |
                                            | ensalada     |
                
                Opcion 2: (1/4 pollo)       | 1/4 pollo       |
                Precio: $ 25.00             | papas fritas    |
                                            | ensalada        |
                                            | gaseosa de 500ml|
                
                Opcion 3: (1/2 pollo)       | 1/2 pollo           |
                Precio: $ 38.90             | papas fritas        |
                                            | ensalada            |
                
                Opcion 4: (1/2 pollo)       | 1/2 pollo           |
                Precio: $ 42.00             | papas fritas        |
                                            | ensalada            |
                                            | 2 gaseosas de 500ml |
                
                Opcion 0: Regresar al Menu Carta Patio de Comida
                Seleccione Una Opcion""");
    }

    public void VentasPolloLaBrasa1() {
        System.out.println("Cuantos Unidades va a Llevar");
        int cantidad1 = f1.nextInt();
        double Total1 = cantidad1 * 21.90;
        double IGV1 = Total1 * 0.18;
        double SubTotal1 = Total1 - IGV1;
        System.out.println("El SubTotal es de: $" + SubTotal1);
        System.out.println("El IGV es de: " + IGV1);
        System.out.println("El Total a Pagar es: $" + Total1);
        f3.add(Total1);
        f2.add("|---"+cantidad1+"---|1/4 de pollo                                 |"+Total1+"--|");
        f1.nextLine();
    }

    public void VentasPolloLaBrasa2() {
        System.out.println("Cuantos Unidades Va a Llevar");
        int cantidad2 = f1.nextInt();
        double Total2 = cantidad2 * 25.00;
        double IGV2 = Total2 * 0.18;
        double SubTotal2 = Total2 - IGV2;
        System.out.println("El SubTotal es de: $" + SubTotal2);
        System.out.println("El IGV es de: " + IGV2);
        System.out.println("El Total a Pagar es: $" + Total2);
        f3.add(Total2);
        f2.add("|---"+cantidad2+"---|1/4 de pollo Con Gaseosa                     |"+Total2+"--|");
        f1.nextLine();
    }

    public void VentasPolloLaBrasa3() {
        System.out.println("Cuantos Unidades va a Llevar ");
        int cantidad3 = f1.nextInt();
        double Total3 = cantidad3 * 38.90;
        double IGV3 = Total3 * 0.18;
        double SubTotal3 = Total3 - IGV3;
        System.out.println("El SubTotal es de: $" + SubTotal3);
        System.out.println("El IGV es de: " + IGV3);
        System.out.println("El Total a Pagar es: $" + Total3);
        f3.add(Total3);
        f2.add(cantidad3+" 1/2 de Pollo "+Total3);
        f2.add("|---"+cantidad3+"---|1/2 de pollo                                 |"+Total3+"--|");
        f1.nextLine();
    }

    public void VentasPolloLaBrasa4() {
        System.out.println("Cuantos Unidades va a Llevar ");
        int cantidad4 = f1.nextInt();
        double Total4 = cantidad4 * 42.00;
        double IGV4 = Total4 * 0.18;
        double SubTotal4 = Total4 - IGV4;
        System.out.println("El SubTotal es de: $" + SubTotal4);
        System.out.println("El IGV es de: " + IGV4);
        System.out.println("El Total a Pagar es: $" + Total4);

        f3.add(Total4);
        f2.add("|---"+cantidad4+"---|1/2 de pollo Con Gaseosa                     |"+Total4+"--|");
        f1.nextLine();
    }

    public void OpcionMixChaufero() {
        System.out.println("""
                                 MIX CHAUFERO
                Opcion 1: (Chaufa Brasa)       | 1/4 de pollo   |
                Precio: $ 26.90                | arroz chaufa   |
                                               | gaseosa 12oz   |
                
                Opcion 2: (ChoriChaufa)        | 1/4 de pollo   |
                Precio: $ 28.00                | chaufa         |
                                               | 1 chorizo      |
                                               | gaseosa 12oz   |
                
                Opcion 3: (Chaufa con pollo)   | arroz chaufa     |
                Precio: $ 28.90                | trozos de pollo  |
                                               | Gaseosa 12oz     |
                
                Opcion 4: (Chaufero 4 poiezas) | 4 piezas boraster|
                Precio: $ 30.00                | 1/2 porcion papas|
                                               | 2 porciones arroz|
                                               | 2 gaseosas 500ml |
                Opcion 0: Regresar al Menu Carta Patio de Comida
                Seleccione Una Opcion""");
    }

    public void VentasMixChaufero1() {
        System.out.println("Cuantos Unidades va a Llevar");
        int cantidad1 = f1.nextInt();
        double Total1 = cantidad1 * 26.90;
        double IGV1 = Total1 * 0.18;
        double SubTotal1 = Total1 - IGV1;
        System.out.println("El SubTotal es de: $" + SubTotal1);
        System.out.println("El IGV es de: " + IGV1);
        System.out.println("El Total a Pagar es: $" + Total1);

        f3.add(Total1);
        f2.add("|---"+cantidad1+"---|Chaufa Brasa                                 |"+Total1+"--|");
        f1.nextLine();
    }

    public void VentasMixchaufero2() {
        System.out.println("Cuantos Unidades Va a Llevar");
        int cantidad2 = f1.nextInt();
        double Total2 = cantidad2 * 28.00;
        double IGV2 = Total2 * 0.18;
        double SubTotal2 = Total2 - IGV2;
        System.out.println("El SubTotal es de: $" + SubTotal2);
        System.out.println("El IGV es de: " + IGV2);
        System.out.println("El Total a Pagar es: $" + Total2);

        f3.add(Total2);
        f2.add("|---"+cantidad2+"---|Chorichaufa                                  |"+Total2+"--|");
        f1.nextLine();
    }

    public void VentasMixChaufero3() {
        System.out.println("Cuantos Unidades va a Llevar ");
        int cantidad3 = f1.nextInt();
        double Total3 = cantidad3 * 28.90;
        double IGV3 = Total3 * 0.18;
        double SubTotal3 = Total3 - IGV3;
        System.out.println("El SubTotal es de: $" + SubTotal3);
        System.out.println("El IGV es de: " + IGV3);
        System.out.println("El Total a Pagar es: $" + Total3);

        f3.add(Total3);
        f2.add("|---"+cantidad3+"---|Chaufa con Pollo                             |"+Total3+"--|");
        f1.nextLine();
    }

    public void VentasMixChaufero4() {
        System.out.println("Cuantos Unidades va a Llevar ");
        int cantidad4 = f1.nextInt();
        double Total4 = cantidad4 * 30.00;
        double IGV4 = Total4 * 0.18;
        double SubTotal4 = Total4 - IGV4;
        System.out.println("El SubTotal es de: $" + SubTotal4);
        System.out.println("El IGV es de: " + IGV4);
        System.out.println("El Total a Pagar es: $" + Total4);

        f3.add(Total4);
        f2.add("|---"+cantidad4+"---|Chaufero 4 pieza                             |"+Total4+"--|");
        f1.nextLine();
    }

    public void OpcionSalchipapas() {
        System.out.println("""
                                 SALCHIPAPAS
                Opcion 1: (Salchipapa Clásica)  | salchicha         |
                Precio: $ 9.90                  | papas fritas      |
                                                | gaseosa 12oz      |
                
                Opcion 2: (Salchichorizo)       | salchicha         |
                Precio: $ 12.90                 | chorizo           |
                                                | papas fritas      |
                                                | gaseosa 12oz      |
                
                Opcion 3: (Salchipapa Norkys)   | salchipapa        |
                Precio: $ 13.00                 | papas fritas      |
                                                | huevo             |
                                                | Gaseosa 12oz      |
                
                Opcion 4: (Salchicharrón)       | salchicha         |
                Precio: $ 18.90                 | 50gr de chicharron|
                                                | papas fritas      |
                                                | gaseosa 12oz      |
                Opcion 0: Regresar al Menu Carta Patio de Comida
                Seleccione Una Opcion""");
    }

    public void VentasSalchipapas1() {
        System.out.println("Cuantos Unidades va a Llevar");
        int cantidad1 = f1.nextInt();
        double Total1 = cantidad1 * 9.90;
        double IGV1 = Total1 * 0.18;
        double SubTotal1 = Total1 - IGV1;
        System.out.println("El SubTotal es de: $" + SubTotal1);
        System.out.println("El IGV es de: " + IGV1);
        System.out.println("El Total a Pagar es: $" + Total1);

        f3.add(Total1);
        f2.add("|---"+cantidad1+"---|Salchipapa Clasica                           |"+Total1+"--|");
        f1.nextLine();
    }

    public void VentasSalchipapas2() {
        System.out.println("Cuantos Unidades Va a Llevar");
        int cantidad2 = f1.nextInt();
        double Total2 = cantidad2 * 12.90;
        double IGV2 = Total2 * 0.18;
        double SubTotal2 = Total2 - IGV2;
        System.out.println("El SubTotal es de: $" + SubTotal2);
        System.out.println("El IGV es de: " + IGV2);
        System.out.println("El Total a Pagar es: $" + Total2);

        f3.add(Total2);
        f2.add("|---"+cantidad2+"---|Salchichorizo                                |"+Total2+"--|");
        f1.nextLine();
    }

    public void VentasSalchipapas3() {
        System.out.println("Cuantos Unidades va a Llevar ");
        int cantidad3 = f1.nextInt();
        double Total3 = cantidad3 * 13.00;
        double IGV3 = Total3 * 0.18;
        double SubTotal3 = Total3 - IGV3;
        System.out.println("El SubTotal es de: $" + SubTotal3);
        System.out.println("El IGV es de: " + IGV3);
        System.out.println("El Total a Pagar es: $" + Total3);

        f3.add(Total3);
        f2.add("|---"+cantidad3+"---|Salchipapa Norkys                            |"+Total3+"--|");
        f1.nextLine();
    }

    public void VentasSalchipapas4() {
        System.out.println("Cuantos Unidades va a Llevar ");
        int cantidad4 = f1.nextInt();
        double Total4 = cantidad4 * 18.90;
        double IGV4 = Total4 * 0.18;
        double SubTotal4 = Total4 - IGV4;
        System.out.println("El SubTotal es de: $" + SubTotal4);
        System.out.println("El IGV es de: " + IGV4);
        System.out.println("El Total a Pagar es: $" + Total4);
        f3.add(Total4);
        f2.add("|---"+cantidad4+"---|Salchicharon                                 |"+Total4+"--|");
        f1.nextLine();
    }

    public void OpcionSnacks() {
        System.out.println("""
                                 Snacks
                Opcion 1: (Chicken box broaster)  | 1 pierna broaster  |
                Precio: $ 11.90                    | arroz chaufa       |
                
                Opcion 2: (Cicken box alitas)     | alitas broaster    |
                Precio: $ 14.90                   | arroz chaufa       |
                
                Opcion 3: (Chicken box chicharron)| chicharron broaster|
                Precio: $ 13.00                   | arroz chaufa       |
                
                Opcion 4: (Chicken box alitas BBQ)| alitas BBQ         |
                Precio: $ 16.90                   | arroz chaufa       |
                
                Opcion 0: Regresar al Menu Carta Patio de Comida
                Seleccione Una Opcion""");
    }

    public void VentasSnacks1() {
        System.out.println("Cuantos Unidades va a Llevar");
        int cantidad1 = f1.nextInt();
        double Total1 = cantidad1 * 11.90;
        double IGV1 = Total1 * 0.18;
        double SubTotal1 = Total1 - IGV1;
        System.out.println("El SubTotal es de: $" + SubTotal1);
        System.out.println("El IGV es de: " + IGV1);
        System.out.println("El Total a Pagar es: $" + Total1);

        f3.add(Total1);
        f2.add("|---"+cantidad1+"---|Chicken box Broaster                         |"+Total1+"--|");
        f1.nextLine();
    }

    public void VentasSnacks2() {
        System.out.println("Cuantos Unidades Va a Llevar");
        int cantidad2 = f1.nextInt();
        double Total2 = cantidad2 * 14.90;
        double IGV2 = Total2 * 0.18;
        double SubTotal2 = Total2 - IGV2;
        System.out.println("El SubTotal es de: $" + SubTotal2);
        System.out.println("El IGV es de: " + IGV2);
        System.out.println("El Total a Pagar es: $" + Total2);

        f3.add(Total2);
        f2.add("|---"+cantidad2+"---|Chicken box Alitas                           |"+Total2+"--|");
        f1.nextLine();
    }

    public void VentasSnacks3() {
        System.out.println("Cuantos Unidades va a Llevar ");
        int cantidad3 = f1.nextInt();
        double Total3 = cantidad3 * 13.00;
        double IGV3 = Total3 * 0.18;
        double SubTotal3 = Total3 - IGV3;
        System.out.println("El SubTotal es de: $" + SubTotal3);
        System.out.println("El IGV es de: " + IGV3);
        System.out.println("El Total a Pagar es: $" + Total3);
        f3.add(Total3);
        f2.add("|---"+cantidad3+"---|Chicken box Chicharron                       |"+Total3+"--|");
        f1.nextLine();
    }

    public void VentasSnacks4() {
        System.out.println("Cuantos Unidades va a Llevar ");
        int cantidad4 = f1.nextInt();
        double Total4 = cantidad4 * 16.90;
        double IGV4 = Total4 * 0.18;
        double SubTotal4 = Total4 - IGV4;
        System.out.println("El SubTotal es de: $" + SubTotal4);
        System.out.println("El IGV es de: " + IGV4);
        System.out.println("El Total a Pagar es: $" + Total4);
        f3.add(Total4);
        f2.add("|---"+cantidad4+"---|Chicken box alitas BBQ                       |"+Total4+"--|");
        f1.nextLine();
    }

    public void RealizarPago() {
        double neto1=RealizarPago2();
        double IGV = neto1 * 0.18;
        double SubTotal = neto1 - IGV;
        System.out.println("El subTotal es: " + SubTotal);
        System.out.println("El IGV es: " + IGV);
        System.out.println("El Total a Pagar de Sus Compras es: " + neto1);
        System.out.println("Relizar el Pago");
        System.out.println("  1 Si  | 2 NO   ");
        String Pago = f1.nextLine();
        switch (Pago) {
            case "1":
                System.out.println("Metodo de Pago");
                System.out.println("Opcion 1: Yape");
                System.out.println("Ocpion 2: Tarjeta de credito");
                String OpcPago = f1.nextLine();
                switch (OpcPago) {
                    case "1":
                        while (true) {
                            System.out.println("Ingrese Numero Con una Cuenta Yape");
                            String yape = f1.nextLine();
                            if (yape.length() == 9 && yape.matches("[0-9]+")) {
                                System.out.println("Numero Valido");
                                while (true){
                                    System.out.println("Ingrese Su Codigo De Validacion");
                                    String CodidoYape= f1.nextLine();
                                    if (CodidoYape.length() == 6 && CodidoYape.matches("[0-9]+")){
                                        System.out.println("Codigo Aceptado");
                                        break;
                                    }
                                    else {
                                        System.out.println("Codigo Incorrect0 UwU");
                                    }
                                }
                                break;
                            }else {
                                System.out.println("Numero no Valido");
                            }
                        }
                        System.out.println("Se realizo el pago");
                        SoliFactura();
                        break;
                    case "2":
                        while (true) {
                            System.out.println("Ingrese Numero de Tarjeta");
                            String Tarjeta = f1.nextLine();
                            if (Tarjeta.length() == 16 && Tarjeta.matches("[0-9]+")) {
                                System.out.println("Numero Valido");
                                while (true){
                                    System.out.println("Ingrese ICV");
                                    String ICV = f1.nextLine();
                                    if (ICV.length() == 3 && ICV.matches("[0-9]+")){
                                        System.out.println("Numero Valido");
                                        while (true){
                                            System.out.println("Ingrese el año de caducidad:");
                                            int anioCaducidad = f1.nextInt();
                                            System.out.println("Ingrese el mes de caducidad (1-12):");
                                            int mesCaducidad = f1.nextInt();
                                            LocalDate fechaActual = LocalDate.now();
                                            int anioActual = fechaActual.getYear();
                                            int mesActual = fechaActual.getMonthValue();

                                            if (anioCaducidad > anioActual || (anioCaducidad == anioActual && mesCaducidad < mesActual)) {
                                                System.out.println("La tarjeta Esta Vencida.");
                                            } else {
                                                System.out.println("Tarjeta Vigente.\nSe realizo el Pago");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else {
                                        System.out.println("Numero no Valido");
                                    }
                                }
                                f1.nextLine();
                                SoliFactura();
                                break;
                            }else {
                                System.out.println("Numero no Valido");
                            }
                        }
                        break;
                    default:
                        System.out.println("Esta opcion no existe");
                        break;
                }
                break;
            case "2":
                System.out.println("La compra ha sido cancelada");
                f2.clear();
                f3.clear();
                break;
            default:
                System.out.println("Esta Ocion No Existe");
                break;
        }
    }
    public double RealizarPago2() {
        double Total=0;
        for(double f4:f3){
            Total+=f4;
        }
        return Total;
    }
    public void SoliFactura() {
        System.out.println("""
                Desea Exportar Una Factura?
                (1)  Si        (2) No""");
        String OpcFactura = f1.nextLine();
        switch (OpcFactura) {
            case "1":
                LocalDate fechaActual = LocalDate.now();
                LocalTime horaActual = LocalTime.now();
                DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
                String fechaFormateada = fechaActual.format(formatoFecha);
                String horaFormateada = horaActual.format(formatoHora);
                double neto1=RealizarPago2();
                String nombreRutaArchivo = "D:\\FacturitaUwU.txt";
                try (FileWriter impr = new FileWriter(nombreRutaArchivo)) {
                    impr.write("|-------------------------NORKYS-----------------------------|\n");
                    impr.write("|-Ruc: 20123456789-------------------------------------------|\n");
                    impr.write("|-Direccion: Jr. Bag Bunny N°: 777---------------------------|\n");
                    impr.write("|-Comprador: "+NombreIngresado+" "+ApellidoIngresado+"\n");
                    impr.write("|-Fecha De Emision : " + fechaFormateada+"\n");
                    impr.write("|-Hora De Emision  : " + horaFormateada+"\n");
                    impr.write("|Cantidad|------------------Productos-----------------|Precio|\n");
                    for (String sau : f2) {
                        impr.write(sau + "\n");
                    }
                    impr.write("|------------------------------------------------------------|\n");
                    double Igvsau = neto1 * 0.18;
                    double ResultadoIGV = neto1 - Igvsau;
                    impr.write("| SUB TOTAL     : S/" + ResultadoIGV + "\n");
                    impr.write("| IGV           : S/" + Igvsau + "\n");
                    impr.write("| TOTAL A PAGAR : S/" + neto1 + "\n");
                    impr.write("|-----------------------------------------------------|------|\n");
                    System.out.println("Exportado correctamente en: " + nombreRutaArchivo);
                }catch (IOException e) {
                    System.err.println("Error al crear el archivo en: " + nombreRutaArchivo);
                }
                break;
            case "2":
                System.out.println("La compra se realizo");
                f2.clear();
                f3.clear();
                break;
            default:
                System.out.println("Esta Opcion no existe");
                break;
        }
    }
}