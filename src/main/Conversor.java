/*
    - Convertir de la moneda de tu país a Dólar
    - Convertir de la moneda de tu país  a Euros
    - Convertir de la moneda de tu país  a Libras Esterlinas
    - Convertir de la moneda de tu país  a Yen Japonés
    - Convertir de la moneda de tu país  a Won sul-coreano
    - Convertir de Euros a la moneda de tu país
    - Convertir de Libras Esterlinas a la moneda de tu país
    - Convertir de Dólar a la moneda de tu país
    - Convertir de Yen Japonés a la moneda de tu país
    - Convertir de Won sul-coreano a la moneda de tu país
*/
package main;
import javax.swing.*;
import java.text.DecimalFormat;

/**
 *
 * @author elias
 */
public class Conversor{
    //formato
    DecimalFormat formato = new DecimalFormat("#.###");
    
    //creacion de objetos divisas, unicamente se crearon estos objetos para las divisas
    private Divisa Dolar = new Divisa("Dolar", (float) 16.99);
    private Divisa Euro = new Divisa("Euro", (float) 18.90);
    private Divisa Libras = new Divisa("Libras Esterlinas", (float) 21.88);
    private Divisa Yen = new Divisa("Yen", (float) 0.12);
    private Divisa Won = new Divisa("Won", (float) 0.013);
    //creacion de medidas en cm
    private static float pulgada = (float) 2.54;
    private static float pies = (float) 30.48;
    private static float metros = (float) 100.0;
    
    public float pesosm_to_dolar(float dolar){
        return dolar / Dolar.getValor();
    }
    
    public float pesosm_to_euro(float euros){
        return euros / Euro.getValor();
    }
    
    public float pesosm_to_librasesterlinas(float libras){
        return libras / Libras.getValor();
    }
    
    public float pesosm_to_yen(float yen){
        return yen / Yen.getValor();
    }
    
    public float pesosm_to_won(float won){
        return won / Won.getValor();
    }
    
    //divisas a pesos mexicanos
    public float dolar_to_pesosm(float pesos){
        return pesos * Dolar.getValor();
    }
    
    public float euro_to_pesosm(float pesos){
        return pesos * Euro.getValor();
    }
    
    public float libraesterlinas_to_pesosm(float pesos){
        return pesos * Libras.getValor();
    }
    
    public float yen_to_pesosm(float pesos){
        return pesos * Yen.getValor();
    }
    
    public float won_to_pesosm(float pesos){
        return pesos * Won.getValor();
    }
    
    //conversor de temperaturas
    public float celsius_to_fahrenheit(float celsius){
        return celsius * (9/5) + 32;
    }
    /**
     * Este método implementa un menú de conversión para diferentes tipos de unidades de medida. 
     * Utiliza un menú desplegable (combobox) con múltiples opciones de conversión. Además, 
     * se incluye un manejo de excepciones para evitar detener abruptamente el programa en caso de errores.
     * @throws Exception
     * @return void
     */
    public void medicion() throws Exception{
        //Objeto de la clase
        Conversor c = new Conversor();
        //Guardamos el valor de la medida
        String medida =  JOptionPane.showInputDialog(null,"Ingrese la Medida","");
        //Arreglo de opciones disponibles
        String[] mediciones = {"cm a pulgadas", "cm a pies", "cm a metros", 
                               "pulgadas a cm", "pulgadas a pies", "pulgadas a metros",
                               "pies a cm", "pies a pulgadas", "pies a metros", 
                               "metros a cm", "metros a pulgadas", "metros a pies"};
        //creacion de comboBox de tipo String
        JComboBox<String> comboBox = new JComboBox<>(mediciones);
        
        // Crear un JPanel para personalizar el contenido del JOptionPane
        JPanel panel = new JPanel();
        panel.add(new JLabel("Seleccione una opción:"));
        panel.add(comboBox);

        // Mostrar el JOptionPane con el JPanel personalizado
        int resultado = JOptionPane.showConfirmDialog(null, panel, "Menú de Medidas", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        //Si se oprime el boton de aceptar entra a este bloque
        if(resultado == JOptionPane.OK_OPTION){
            try{
            String opcion = (String) comboBox.getSelectedItem();
            //Para todas las opciones se hizo uso de un objeto formato, el cual imprime solo 3 decimales
            //Para todas las opciones se hizo uso de la clase Float, para cambiar el tipo de dato del input(String) a float
            switch(opcion){
                case "cm a pulgadas":
                    JOptionPane.showMessageDialog(null, formato.format((float) Float.parseFloat(medida)/pulgada)+" Pulgadas");
                    c.subMenu();
                    break;
                case "cm a pies":
                    JOptionPane.showMessageDialog(null, formato.format((float) Float.parseFloat(medida)/pies) + " Pies");
                    c.subMenu();
                    break;
                case "cm a metros":
                    JOptionPane.showMessageDialog(null, formato.format((float) Float.parseFloat(medida)/metros) + " Metros");
                    c.subMenu();
                    break;
                case "pulgadas a cm":
                    JOptionPane.showMessageDialog(null, formato.format((float) Float.parseFloat(medida)*pulgada) + " cm");
                    c.subMenu();
                    break;
                case "pulgadas a pies":
                    JOptionPane.showMessageDialog(null, formato.format((float) Float.parseFloat(medida)/(12)) + " Pies");// 12 pulgadas equivalen a 1 pie
                    c.subMenu();
                    break;
                case "pulgadas a metros":
                    JOptionPane.showMessageDialog(null, formato.format((float) Float.parseFloat(medida)*(pulgada/metros)) + " Metros");
                    c.subMenu();                    
                    break;
                case "pies a cm":
                    JOptionPane.showMessageDialog(null, formato.format((float) Float.parseFloat(medida)*pies) + " cm");
                    c.subMenu();
                    break;
                case "pies a pulgadas":
                    JOptionPane.showMessageDialog(null, formato.format((float) Math.round(Float.parseFloat(medida)*(pulgada*4.72440945))) + "Pulgadas"); // redondeamos el valor final debido a que se pierden decimales
                    c.subMenu();
                    break;
                case "pies a metros":
                    JOptionPane.showMessageDialog(null, formato.format((float) Float.parseFloat(medida)*(pies/10)) + " Metros");//Movemos una posicion el punto decimal para su equivalencia en metros
                    c.subMenu();   
                    break;
                case "metros a cm":
                    JOptionPane.showMessageDialog(null, formato.format((float) Float.parseFloat(medida)*metros) + " cm");
                    c.subMenu();   
                    break;
                case "metros a pulgadas":
                    JOptionPane.showMessageDialog(null, formato.format((float) Float.parseFloat(medida)*(39.3701)) + "Pulgadas");//El valor 39.3701 es la equivalencia en pulgadas para los metros
                    c.subMenu();  
                    break;
                case "metros a pies":
                    JOptionPane.showMessageDialog(null, formato.format((float) Float.parseFloat(medida)/(3.28084)) + "Pies");// El valor 3.28084 es la equivalencia de pies en metros
                    c.subMenu();  
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no reconocida");
                    break;
            
                }
            } catch(Exception e){// Si el valor ingresado no es un numero entra este bloque
                JOptionPane.showMessageDialog(null, "Valor no valido");
                c.subMenu();
            }
        } else if(resultado == JOptionPane.OK_CANCEL_OPTION){
            c.menuPrincipal();
        }
    }
    
    public void temperatura() throws Exception{
        Conversor c = new Conversor();
        
        String grados = JOptionPane.showInputDialog(null, "Ingrese la cantidad de grados", "");
        
        //Lista de opciones de temperatura
        String[] temperatura = {"Celsius a Fahrenheit","Celsius a Kelvin", 
                               "Fahrenheit a Celsius", "Fahrenheit a Kelvin",
                               "Kelvin a Celsius", "Kelvin a Fahrenheit"};
        
        //creacion  de combobox
        JComboBox<String> comboBox = new JComboBox<>(temperatura);
        
        //creacion de un Jpanel
        JPanel panel = new JPanel();
        panel.add(new JLabel("Seleccione una opcion"));
        panel.add(comboBox);
        
        int resultado = JOptionPane.showConfirmDialog(null, panel, "Menú de Temperatura", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if(resultado == JOptionPane.OK_OPTION){
            String opcion = (String) comboBox.getSelectedItem();
            try{
                switch(opcion){
                    case "Celsius a Fahrenheit":
                        JOptionPane.showMessageDialog(null, formato.format((Float.parseFloat(grados) * 9/5) + 32) + "°F");//°F = (°C * 9/5) + 32
                        c.subMenu();
                        break;
                    case "Celsius a Kelvin":
                        JOptionPane.showMessageDialog(null, formato.format(Float.parseFloat(grados) + 273.15) + "°K");//K = °C + 273.15
                        c.subMenu();
                        break;
                    case "Fahrenheit a Celsius":
                        JOptionPane.showMessageDialog(null, formato.format((Float.parseFloat(grados) - 32) * 5/9) + "°C");//°C = (°F - 32) * 5/9
                        c.subMenu();
                        break;
                    case "Fahrenheit a Kelvin":
                        JOptionPane.showMessageDialog(null, formato.format((Float.parseFloat(grados) + 459.67) * 5/9) + "°K");//K = (°F + 459.67) * 5/9
                        c.subMenu();
                        break;
                    case "Kelvin a Celsius":
                        JOptionPane.showMessageDialog(null, formato.format((Float.parseFloat(grados) - 273.15)) + "°C");//°C = K - 273.15
                        c.subMenu();
                        break;
                    case "Kelvin a Fahrenheit":
                        JOptionPane.showMessageDialog(null, formato.format((Float.parseFloat(grados) - 273.15) * 9/5 + 32) + "°F");//°F = (K - 273.15) * 9/5 + 32
                        break;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Valor invalido");
                c.subMenu();
            }
        }
    }
    
    //metodos para solicitar datos
    public void ingresarDivisas() throws Exception{
       Conversor c = new Conversor();
       String divisa =  JOptionPane.showInputDialog(null,"Ingrese la cantidad de Divisas","");
       String[] divisas = {"Convertir de Pesos Mexicanos a Dólar","Convertir de Pesos Mexicanos a Euros",
                           "Convertir de Pesos Mexicanos a Libras Esterlinas","Convertir de Pesos Mexicanos a Yen Japones",
                           "Convertir de Pesos Mexicanos a Won", "Convertir de Dólar a Pesos Mexicanos", "Convertir de Euros a Pesos Mexicanos",
                           "Convertir de Libras Esterlinas a Pesos Mexicanos", "Convertir de Yen Japones a Pesos Mexicanos", "Convertir de Won a Pesos Mexicanos"};
       JComboBox<String> comboBox = new JComboBox<>(divisas);
       
        //creacion de un Jpanel
        JPanel panel = new JPanel();
        panel.add(new JLabel("Seleccione una opcion"));
        panel.add(comboBox);
        
        int resultado = JOptionPane.showConfirmDialog(null, panel, "Menú de Divisas", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if(resultado == JOptionPane.OK_OPTION){
            String opcion = (String) comboBox.getSelectedItem();
            try{
                switch(opcion){
                    case "Convertir de Pesos Mexicanos a Dólar":
                        JOptionPane.showMessageDialog(null, pesosm_to_dolar(Float.parseFloat(divisa)));
                        c.subMenu();
                        break;
                    case "Convertir de Pesos Mexicanos a Euros":
                        JOptionPane.showMessageDialog(null, pesosm_to_euro(Float.parseFloat(divisa)));
                        c.subMenu();
                        break;
                    case "Convertir de Pesos Mexicanos a Libras Esterlinas":
                        JOptionPane.showMessageDialog(null, pesosm_to_librasesterlinas(Float.parseFloat(divisa)));
                        c.subMenu();
                        break;
                    case "Convertir de Pesos Mexicanos a Yen Japones":
                        JOptionPane.showMessageDialog(null, pesosm_to_yen(Float.parseFloat(divisa)));
                        c.subMenu();
                        break;
                    case "Convertir de Pesos Mexicanos a Won":
                        JOptionPane.showMessageDialog(null, pesosm_to_won(Float.parseFloat(divisa)));
                        c.subMenu();
                        break;
                    case "Convertir de Dólar a Pesos Mexicanos":
                        JOptionPane.showMessageDialog(null, dolar_to_pesosm(Float.parseFloat(divisa)));
                        c.subMenu();
                        break;
                    case "Convertir de Euros a Pesos Mexicanos":
                        JOptionPane.showMessageDialog(null, dolar_to_pesosm(Float.parseFloat(divisa)));
                        c.subMenu();
                        break;
                    case "Convertir de Libras Esterlinas a Pesos Mexicanos":
                        JOptionPane.showMessageDialog(null, dolar_to_pesosm(Float.parseFloat(divisa)));
                        c.subMenu();
                        break;
                    case "Convertir de Yen Japones a Pesos Mexicanos":
                        JOptionPane.showMessageDialog(null, dolar_to_pesosm(Float.parseFloat(divisa)));
                        c.subMenu();
                        break;
                    case "Convertir de Won a Pesos Mexicanos":
                        JOptionPane.showMessageDialog(null, dolar_to_pesosm(Float.parseFloat(divisa)));
                        c.subMenu();
                        break;

                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Valor invalido");
                c.subMenu();
            }
        }else if(resultado == JOptionPane.OK_CANCEL_OPTION){
            c.menuPrincipal();
        }
    }

    public void menuPrincipal() throws Exception{
        Conversor c = new Conversor();
        // Crear un array de opciones para el JComboBox
        String[] opciones = {"Conversor de Divisas", "Conversor de Temperatura", "Conversor de Medidas"};

        // Crear un JComboBox con las opciones del array
        JComboBox<String> comboBox = new JComboBox<>(opciones);

        // Crear un JPanel para personalizar el contenido del JOptionPane
        JPanel panel = new JPanel();
        panel.add(new JLabel("Seleccione una opción:"));
        panel.add(comboBox);

        // Mostrar el JOptionPane con el JPanel personalizado
        int resultado = JOptionPane.showConfirmDialog(null, panel, "Menú con JComboBox", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Verificar si se seleccionó "OK" y obtener la opción seleccionada
        if (resultado == JOptionPane.OK_OPTION) {
            String opcionSeleccionada = (String) comboBox.getSelectedItem();
            if (opcionSeleccionada != null) {
                if(opcionSeleccionada == "Conversor de Divisas") c.ingresarDivisas();
                else if(opcionSeleccionada == "Conversor de Temperatura") c.temperatura();
                else if(opcionSeleccionada == "Conversor de Medidas") c.medicion();
            } else {
                System.out.println("Ninguna opción seleccionada.");
            }
        } else {
            System.out.println("Operación cancelada.");
        }
    }

    public void subMenu() throws Exception{
        int resultado = JOptionPane.showConfirmDialog(null, "Desea hacer otra conversión?");
        if(resultado == JOptionPane.OK_OPTION){
            Conversor c = new Conversor();
            c.menuPrincipal();
        }
    }
}
