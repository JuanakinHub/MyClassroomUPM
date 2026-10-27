package CITSIM_06.etsisi.upm.myupmclassroom;

import static org.junit.Assert.*;

import controller.CAula;
import controller.CUsuario;
import modelo.IAula;
import modelo.IUsuario;
import modelo.Usuario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CITSIM21_06.etsisi.upm.myupmclassroom.App;

import java.io.IOException;
import java.sql.SQLException;

public class TestCAula {

    private CAula c;
    private CUsuario previo;


    @Before
    public void setUp() throws Exception {
        //previo.crear("PAS","PAS","PAS","pas@upm.es","123","123","55555555G","PAS");
        //previo.login("55555555G");
    	App.GLOBAL_USUARIO = new Usuario("","","","a@upm.es","","","44444444Q","PAS");
        c=new CAula();
        c.crear("Aula1","30","68","Laboratorio");
    }

    @After
    public  void tearDown() throws Exception{

    }
    
    //CAJA NEGRA
    //CP1 V1.V2.V3.V4 {nombre="Aula203",superficie="30",aforo="50",tipo="Laboratorio"}
    //CP2 N1.V2.V3.V4 {nombre="",superficie="30",aforo="50",tipo="Laboratorio"}
    //CP3 N2.V2.V3.V4 {nombre="BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB",superficie="30",aforo="50",tipo="Laboratorio"}
    //CP4 V1.N3.V3.V4 {nombre="Aula204",superficie="",aforo="50",tipo="Laboratorio"}
    //CP5 V1.N4.V3.V4 {nombre="Aula205",superficie="50",aforo="50",tipo="Laboratorio"}
    //CP6 V1.N5.V3.V4 {nombre="Aula206",superficie="A0",aforo="50",tipo="Laboratorio"}
    //CP7 V1.V2.N6.V4 {nombre="Aula207",superficie="30",aforo="",tipo="Laboratorio"}
    //CP8 V1.V2.N7.V4 {nombre="Aula208",superficie="30",aforo="100",tipo="Laboratorio"}
    //CP9 V1.V2.V8.V4 {nombre="Aula209",superficie="30",aforo="1B",tipo="Laboratorio"}
    //CP10 V1.V2.V3.N9 {nombre="Aula210",superficie="30",aforo="50",tipo=""}
    //CP11 V1.V2.V3.N10 {nombre="Aula211",superficie="30",aforo="50",tipo="BBBBBBBBBBBBBBBB"}

    @Test
    public void testCP1() throws SQLException, IOException, ClassNotFoundException {

        IAula aa = null;

        aa=c.crear("hola1","30","50","Laboratorio");
        assertNotNull("El aula debe ser no nulo", aa);

    }
    @Test
    public void testCP2() throws SQLException, IOException, ClassNotFoundException {

        IAula aa = null;

        aa=c.crear("","30","50","Laboratorio");
        assertNull("El aula debe ser nulo porque nombre vacio", aa);

    }
    @Test
    public void testCP3() throws SQLException, IOException, ClassNotFoundException {

        IAula aa = null;

        aa=c.crear("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB","30","50","Laboratorio");
        assertNull("El aula debe ser nulo porque nombre > 30 caracteres", aa);

    }
    @Test
    public void testCP4() throws SQLException, IOException, ClassNotFoundException {

        IAula aa = null;

        aa=c.crear("Aula204","","50","Laboratorio");
        assertNull("El aula debe ser nulo porque superficie es vacio", aa);

    }
    @Test
    public void testCP5() throws SQLException, IOException, ClassNotFoundException {

        IAula aa = null;

        aa=c.crear("Aula205","50","50","Laboratorio");
        assertNull("El aula debe ser nulo porque superficie > 49", aa);

    }
    @Test
    public void testCP6() throws SQLException, IOException, ClassNotFoundException {

        IAula aa = null;

        aa=c.crear("Aula206","A0","50","Laboratorio");
        assertNull("El aula debe ser nulo porque superficie contiene letras", aa);

    }
    @Test
    public void testCP7() throws SQLException, IOException, ClassNotFoundException {

        IAula aa = null;

        aa=c.crear("Aula207","30","","Laboratorio");
        assertNull("El aula debe ser nulo porque aforo vacio", aa);

    }
    @Test
    public void testCP8() throws SQLException, IOException, ClassNotFoundException {

        IAula aa = null;

        aa=c.crear("Aula208","30","100","Laboratorio");
        assertNull("El aula debe ser nulo porque aforo > 99", aa);

    }
    @Test
    public void testCP9() throws SQLException, IOException, ClassNotFoundException {

        IAula aa = null;

        aa=c.crear("Aula209","30","1B","Laboratorio");
        assertNull("El aula debe ser nulo porque aforo contiene letras", aa);

    }
/*
    @Test
    public void testCP10() throws SQLException, IOException, ClassNotFoundException {

        IAula aa = null;

        aa=c.crear("Aula210","30","50","");
        assertNull("El aula debe ser nulo porque tipo vacio", aa);

    }

    @Test
    public void testCP11() throws SQLException, IOException, ClassNotFoundException {

        IAula aa = null;

        aa=c.crear("Aula211","30","50","BBBBBBBBBBBBBBBB");
        assertNull("El aula debe ser nulo porque tipo > 15 caracteres", aa);

    }
*/
    
  //CAJA BLANCA
    //R1: 1,2,38,39,40 {nombre="Aula1",superficie="30",aforo="68",tipo="Laboratorio"}
    //R2: 1,2,3,4,7,8,9,10,11,12,14,15,20,21,22,23,24,25,26,27,28,29,33,34,35,363,7,38,39,40 {nombre="",superficie="30",aforo="68",tipo="Laboratorio"}
    //R3: 1,2,3,5,4,7,8,10,11,13,12,14,15,17,16,20,21,24,25,27,28,30,29,33,34,37,38,40 {nombre="Aula304",superficie="",aforo="70",tipo="Mixta"}
    //R4: 1,2,3,5,6,4,7,8,10,11,13,14,15,17,18,16,20,21,22,24,25,27,28,30,31,29,33,34,35,37,38,40 {nombre="Aula305",superficie="40",aforo="",tipo="Mixta"}
    //R5: 1,2,3,5,6,7,8,9,10,11,13,14,15,17,18,19,16,20,21,24,25,27,28,30,31,32,29,33,34,37,38,40 {nombre="BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB",superficie="40",aforo="30",tipo="Mixta"}
    //R6: 1,2,3,5,6,7,8,10,11,12,14,15,17,18,19,20,21,24,25,27,28,30,31,32,33,34,37,38,40 {nombre="Aula306",superficie="400",aforo="70",tipo="Mixta"}
    //R7: 1,2,3,5,6,7,8,10,13,12,14,15,17,18,19,20,21,24,25,27,28,30,31,32,33,34,37,38,40 {nombre="Aula307",superficie="60",aforo="70",tipo="Mixta"}
    //R8: 1,2,3,5,6,7,8,10,11,13,14,15,16,20,21,24,25,27,28,30,31,32,33,34,37,38,40  {nombre="Aula308",superficie="A3",aforo="70",tipo="Mixta"}
    //R9: 1,2,3,5,6,7,8,10,11,13,14,15,17,18,16,20,21,24,25,27,28,30,31,32,33,34,37,38,40 {nombre="Aula309",superficie="3A",aforo="70",tipo="Mixta"}
    //R10: 1,2,3,5,6,7,8,10,11,13,14,15,17,18,19,20,21,22,23,24,25,27,28,30,31,32,33,34,37,38,40 {nombre="Aula310",superficie="00",aforo="70",tipo="Mixta"}
    //R11: 1,2,3,5,6,7,8,10,11,13,14,15,17,18,19,20,21,24,25,26,27,28,30,31,32,33,34,37,38,40 {nombre="Aula311",superficie="30",aforo="100",tipo="Mixta"}
    //R12: 1,2,3,5,6,7,8,10,11,13,14,15,17,18,19,20,21,24,25,27,28,30,29,33,34,37,38,40 {nombre="Aula312",superficie="30",aforo="A4",tipo="Mixta"}
    //R13: 1,2,3,5,6,7,8,10,11,13,14,15,17,18,19,20,21,24,25,27,28,30,31,29,33,34,37,38,40 {nombre="Aula313",superficie="30",aforo="4A",tipo="Mixta"}
    //R14: 1,2,3,5,6,7,8,10,11,13,14,15,17,18,19,20,21,24,25,27,28,30,31,32,33,34,35,36,37,38,40 {nombre="Aula313",superficie="30",aforo="00",tipo="Mixta"}

    @Test
    public void testR1() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El aula deberia ser null, porque ya existe", c.crear("Aula1","30","68","Laboratorio"));
    }
    @Test
    public void testR2() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El aula deberia ser null, porque el nombre esta vacio", c.crear("","40","80","Mixta"));
    }
    @Test
    public void testR3() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El aula deberia ser null, porque superficie esta vacio", c.crear("Aula304","","70","Mixta"));
    }
    @Test
    public void testR4() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El aula deberia ser null, porque aforo esta vacio", c.crear("Aula305","40","","Mixta"));
    }
    @Test
    public void testR5() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El aula deberia ser null, porque el numbre supera el limite de caracteres", c.crear("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB","40","30","Mixta"));
    }
    @Test
    public void testR6() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El aula deberia ser null, porque superficie supera los 2 dÃ­gitos", c.crear("Aula306","400","70","Mixta"));
    }
    @Test
    public void testR7() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El aula deberia ser null, porque superficie debe ser menor que 50", c.crear("Aula307","60","70","Mixta"));
    }
    @Test
    public void testR8() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El aula deberia ser null, porque el caracter(0) de superficie es una letra", c.crear("Aula308","A3","70","Mixta"));
    }
    @Test
    public void testR9() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El aula deberia ser null, porque el caracter(1) de superficie es una letra", c.crear("Aula309","3A","70","Mixta"));
    }
    @Test
    public void testR10() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El aula deberia ser null, porque superficie es igual a 0", c.crear("Aula310","00","70","Mixta"));
    }
    @Test
    public void testR11() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El aula deberia ser null, porque aforo debe ser menor que 100", c.crear("Aula311","30","100","Mixta"));
    }
    @Test
    public void testR12() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El aula deberia ser null, porque el caracter(0) de aforo es una letra", c.crear("Aula312","30","A4","Mixta"));
    }
    @Test
    public void testR13() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El aula deberia ser null, porque el caracter(1) de aforo es una letra", c.crear("Aula313","30","4A","Mixta"));
    }
    @Test
    public void testR14() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El aula deberia ser null, porque aforo es igual a 0", c.crear("Aula314","30","00","Mixta"));
    }
    @Test
    public void testR15() throws SQLException, IOException, ClassNotFoundException {
        assertNotNull("El aula deberia ser correcta", c.crear("Aula315","30","60","Mixta"));
    }
    
}
