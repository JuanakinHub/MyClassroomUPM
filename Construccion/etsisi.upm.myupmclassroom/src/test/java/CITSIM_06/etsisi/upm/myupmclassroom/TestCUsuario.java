package CITSIM_06.etsisi.upm.myupmclassroom;

import static org.junit.Assert.*;

import controller.CUsuario;
import modelo.IUsuario;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

public class TestCUsuario {

    private CUsuario c;

    @Before
    public void setUp() throws Exception {
        c=new CUsuario();
        c.crear("A","A","B","alguien@upm.es","123","123","99999999P" ,"jefe");
    }

    @After
    public void tearDown() throws Exception {
    }
    //CAJA NEGRA
    //CP1 V1.V2.V3.V4.V5.V6.V7.V8 {nombre="A",apellido1="A",apellido2="A",correo="alguien@upm.es",psw="123",confirmarPsw="123",dni="44444444Q",rol="jefe"}
    //CP2 V1.N3.V3.V4.V5.V6.V7.V8 {nombre="A",apellido1="",apellido2="A",correo="alguien@upm.es",psw="123",confirmarPsw="123",dni="44444444W",rol="jefe"}
    //CP3 V1.V2.N5.V4.V5.V6.v7.V8 {nombre="A",apellido1="A",apellido2="",correo="alguien@upm.es",psw="123",confirmarPsw="123",dni="44444444E",rol="jefe"}
    //CP4 N1.V2.V3.V4.V5.V6.v7.V8 {nombre="",apellido1="A",apellido2="",correo="alguien@upm.es",psw="123",confirmarPsw="123",dni="44444444R",rol="jefe"}
    //CP5 N2.V2.V3.V4.V5.V6.v7.V8 {nombre="BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB",apellido1="A",apellido2="A",correo="alguien@upm.es",psw="123",confirmarPsw="123",dni="44444444T",rol="jefe"}
    //CP6 V1.N4.V3.V4.V5.V6.v7.V8 {nombre="A",apellido1="BBBBBBBBBBBBBBBBBBBBB",apellido2="A",correo="alguien@upm.es",psw="123",confirmarPsw="123",dni="44444444Y",rol="jefe"}
    //CP7 V1.V2.N6.V4.V5.V6.V7.V8 {nombre="A",apellido1="A",apellido2="BBBBBBBBBBBBBBBBBBBBB",correo="alguien@upm.es",psw="123",confirmarPsw="123",dni="44444444U",rol="jefe"}
    //CP8 V1.V2.V3.N7.V5.V6.V7.V8 {nombre="A",apellido1="A",apellido2="A",correo="",psw="123",confirmarPsw="123",dni="44444444I",rol="jefe"}
    //CP9 V1.V2.V3.N8.V5.V6.V7.V8 {nombre="A",apellido1="A",apellido2="A",correo="BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB",psw="123",confirmarPsw="123",dni="44444444O",rol="jefe"}
    //CP10 V1.V2.V3.V4.N9.V6.V7.V8 {nombre="A",apellido1="A",apellido2="A",correo="alguien@upm.es",psw="",confirmarPsw="123",dni="44444444P",rol="jefe"}
    //CP11 V1.V2.V3.V4.N10.V6.V7.V8 {nombre="A",apellido1="A",apellido2="A",correo="alguien@upm.es",psw="BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB",confirmarPsw="123",dni="44444444A",rol="jefe"}
    //CP12 V1.V2.V3.V4.V5.N11.V7.V8 {nombre="A",apellido1="A",apellido2="A",correo="alguien@upm.es",psw="123",confirmarPsw="",dni="44444444S",rol="jefe"}
    //CP13 V1.V2.V3.V4.V5.N12.V7.V8 {nombre="A",apellido1="A",apellido2="A",correo="alguien@upm.es",psw="123",confirmarPsw="BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB",dni="44444444D",rol="jefe"}
    //CP14 V1.V2.V3.V4.V5.V6.N13.V8 {nombre="A",apellido1="A",apellido2="A",correo="alguien@upm.es",psw="123",confirmarPsw="123",dni="",rol="jefe"}

    //CP15 V1.V2.V3.V4.V5.V6.N14.V8 {nombre="A",apellido1="A",apellido2="A",correo="alguien@upm.es",psw="123",confirmarPsw="123",dni="444444444",rol="jefe"}
    //CP16 V1.V2.V3.V4.V5.V6.N15.V8 {nombre="A",apellido1="A",apellido2="A",correo="alguien@upm.es",psw="123",confirmarPsw="123",dni="4444L444F",rol="jefe"}
    //CP17 V1.V2.V3.V4.V5.V6.N16.V8 {nombre="A",apellido1="A",apellido2="A",correo="alguien@upm.es",psw="123",confirmarPsw="123",dni="444444444G",rol="jefe"}
    //CP18 V1.V2.V3.V4.V5.V6.N17.V8 {nombre="A",apellido1="A",apellido2="A",correo="alguien@upm.es",psw="123",confirmarPsw="123",dni="4444444H",rol="jefe"}
    //CP19 V1.V2.V3.V4.V5.V6.V7.N18 {nombre="A",apellido1="A",apellido2="A",correo="alguien@upm.es",psw="123",confirmarPsw="123",dni="44444444J",rol=""}
    //CP20 V1.V2.V3.V4.V5.V6.V7.N19 {nombre="A",apellido1="A",apellido2="A",correo="alguien@upm.es",psw="123",confirmarPsw="123",dni="44444444K",rol="BBBBBBBBBBBBBBBB"}

    @Test
    public void testCP1() throws SQLException, IOException, ClassNotFoundException {

        IUsuario aa = null;

        aa=c.crear("A","A",
                "A","a@upm.es","123","123","44444444Q","jefe");
        assertNotNull("El usuario debe ser no nulo", aa);

    }

    @Test
    public void testCP2() throws SQLException, IOException, ClassNotFoundException {

        IUsuario aa = null;

        aa=c.crear("A","",
                "A","a@upm.es","123","123","44444444W","jefe");
        assertNull("El usuario debe ser nulo porque apellido1 vacio", aa);

    }

    @Test
    public void testCP3() throws SQLException, IOException, ClassNotFoundException {

        IUsuario aa = null;

        aa=c.crear("A","A",
                "","a@upm.es","123","123","44444444E","jefe");
        assertNull("El usuario debe ser nulo porque apellido2 vacio", aa);

    }

    @Test
    public void testCP4() throws SQLException, IOException, ClassNotFoundException {

        IUsuario aa = null;

        aa=c.crear("","A",
                "A","a@upm.es","123","123","44444444R","jefe");
        assertNull("El usuario debe ser nulo porque nombre vacio", aa);

    }
    @Test
    public void testCP5() throws SQLException, IOException, ClassNotFoundException {

        IUsuario aa = null;

        aa=c.crear("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB","A",
                "A","a@upm.es","123","123","44444444T","jefe");
        assertNull("El usuario debe ser nulo porque nombre > 30", aa);

    }
    @Test
    public void testCP6() throws SQLException, IOException, ClassNotFoundException {

        IUsuario aa = null;

        aa=c.crear("A","BBBBBBBBBBBBBBBBBBBBB",
                "A","a@upm.es","123","123","44444444Y","jefe");
        assertNull("El usuario debe ser nulo porque apellido1 >20", aa);

    }

    @Test
    public void testCP7() throws SQLException, IOException, ClassNotFoundException {

        IUsuario aa = null;

        aa=c.crear("A","A",
                "BBBBBBBBBBBBBBBBBBBBB","a@upm.es","123","123","44444444U","jefe");
        assertNull("El usuario debe ser nulo porque apellido2 >20", aa);

    }

    @Test
    public void testCP8() throws SQLException, IOException, ClassNotFoundException {

        IUsuario aa = null;

        aa=c.crear("A","A",
                "A","","123","123","44444444I","jefe");
        assertNull("El usuario debe ser nulo porque correo vario", aa);

    }
    @Test
    public void testCP9() throws SQLException, IOException, ClassNotFoundException {

        IUsuario aa = null;

        aa=c.crear("A","A",
                "A","BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB","123","123","44444444O","jefe");
        assertNull("El usuario debe ser nulo porque correo >100.", aa);

    }

    @Test
    public void testCP10() throws SQLException, IOException, ClassNotFoundException {

        IUsuario aa = null;

        aa=c.crear("A","A",
                "A","a@upm.es","","123","44444444P","jefe");
        assertNull("El usuario debe ser nulo porque pwd vacia.", aa);

    }

    @Test
    public void testCP11() throws SQLException, IOException, ClassNotFoundException {

        IUsuario aa = null;

        aa=c.crear("A","A",
                "A","a@upm.es","BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB",
                "123","44444444A","jefe");
        assertNull("El usuario debe ser nulo porque pwd > 255.", aa);

    }
    @Test
    public void testCP12() throws SQLException, IOException, ClassNotFoundException {

        IUsuario aa = null;

        aa=c.crear("A","A",
                "A","a@upm.es","123",
                "","44444444S","jefe");
        assertNull("El usuario debe ser nulo porque confirmarContra vacio.", aa);

    }
    @Test
    public void testCP13() throws SQLException, IOException, ClassNotFoundException {

        IUsuario aa = null;

        aa=c.crear("A","A",
                "A","a@upm.es","123",
                "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB",
                "44444444D","jefe");
        assertNull("El usuario debe ser nulo porque confirmarContra > 255.", aa);

    }
    @Test
    public void testCP14() throws SQLException, IOException, ClassNotFoundException {

        IUsuario aa = null;

        aa=c.crear("A","A",
                "A","a@upm.es","123",
                "123","","jefe");
        assertNull("El usuario debe ser nulo porque dni vacio.", aa);

    }
    @Test
    public void testCP15() throws SQLException, IOException, ClassNotFoundException {

        IUsuario aa = null;

        aa=c.crear("A","A",
                "A","a@upm.es","123","123","444444444","jefe");
        assertNull("El usuario debe ser nulo porque dni sin letra.", aa);

    }
    @Test
    public void testCP16() throws SQLException, IOException, ClassNotFoundException {

        IUsuario aa = null;

        aa=c.crear("A","A",
                "A","a@upm.es","123","123","4444L444F","jefe");
        assertNull("El usuario debe ser nulo porque el dni tiene mas de una letra.", aa);

    }
    @Test
    public void testCP17() throws SQLException, IOException, ClassNotFoundException {

        IUsuario aa = null;

        aa=c.crear("A","A",
                "A","a@upm.es","123","123","444444444G","jefe");
        assertNull("El usuario debe ser nulo porque el dni > 9.", aa);

    }
    @Test
    public void testCP18() throws SQLException, IOException, ClassNotFoundException {

        IUsuario aa = null;

        aa=c.crear("A","A",
                "A","a@upm.es","123","123","4444444H","jefe");
        assertNull("El usuario debe ser nulo porque el dni < 9.", aa);

    }
/*
    @Test
    public void testCP19() throws SQLException, IOException, ClassNotFoundException {

        IUsuario aa = null;

        aa=c.crear("A","A",
                "A","a@upm.es","123","123","44444444J","");
        assertNull("El usuario debe ser nulo porque rol vacio.", aa);

    }
    @Test
    public void testCP20() throws SQLException, IOException, ClassNotFoundException {

        IUsuario aa = null;

        aa=c.crear("A","A",
                "A","a@upm.es","123","123","44444444K","BBBBBBBBBBBBBBBB");
        assertNull("El usuario debe ser nulo porque rol > 15", aa);

    }
*/    
    
  //CAJA BLANCA
    //R1 1,2,3,4,29
    //R2 1,2,3,5,4,29
    //R3 1,2,3,5,6,4,29
    //R4 1,2,3,5,6,7,4,29
    //R5 1,2,3,5,6,7,8,4,29
    //R6 1,2,3,5,6,7,8,9,4,29
    //R7 1,2,3,5,6,7,8,9,10,4,29
    //R8 1,2,3,5,6,7,8,9,10,11,4,29
    //R9 1,2,3,5,6,7,8,9,10,11,12,4,29
    //R10 1,2,3,5,6,7,8,9,10,11,12,13,4,29
    //R11 1,2,3,5,6,7,8,9,10,11,12,13,14,4,29
    //R12 1,2,3,5,6,7,8,9,10,11,12,13,14,15,4,29
    //R13 1,2,3,5,6,7,8,9,10,11,12,13,14,15,16,17,4,29
    //R14 1,2,3,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,4,29
    //R15 1,2,3,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,26,27,4,29
    @Test
    public void testR1() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El usuario deberia ser null, porque el nombre está vacio", c.crear("","apellido1","apellido2","correo@upm.es","123","123","12345678A","jefe"));
    }
    @Test
    public void testR2() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El usuario deberia ser null, porque el apellido1 está vacio", c.crear("nombre","","apellido2","correo@upm.es","123","123","12345678A","jefe"));
    }
    @Test
    public void testR3() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El usuario deberia ser null, porque el apellido2 está vacio", c.crear("nombre","apellido1","","correo@upm.es","123","123","12345678A","jefe"));
    }
    @Test
    public void testR4() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El usuario deberia ser null, porque el correo está vacio", c.crear("nombre","apellido1","apellido2","","123","123","12345678A","jefe"));
    }
    @Test
    public void testR5() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El usuario deberia ser null, porque la contraseña está vacia", c.crear("nombre","apellido1","apellido2","correo@upm.es","","123","12345678A","jefe"));
    }
    @Test
    public void testR6() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El usuario deberia ser null, porque confirmarcontra está vacio", c.crear("nombre","apellido1","apellido2","correo@upm.es","123","","12345678A","jefe"));
    }
    @Test
    public void testR7() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El usuario deberia ser null, porque el dni está vacio", c.crear("nombre","apellido1","apellido2","correo@upm.es","123","123","","jefe"));
    }
    @Test
    public void testR8() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El usuario deberia ser null, porque el nombre tiene más de 30 char está vacio", c.crear("nombrenombrenombrenombrenombren","apellido1","apellido2","correo@upm.es","123","123","12345678A","jefe"));
    }
    @Test
    public void testR9() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El usuario deberia ser null, porque apellido1 tiene más de 20", c.crear("nombre","apellido1aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","apellido2","correo@upm.es","123","123","12345678A","jefe"));
    }
    @Test
    public void testR10() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El usuario deberia ser null, porque apellido2 tiene más de 20", c.crear("nombre","apellido1","apellido2aaaaaaaaaaaaaaaaaaaaaaaaa","correo@upm.es","123","123","12345678A","jefe"));
    }
    @Test
    public void testR11() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El usuario deberia ser null, porque correo tiene más de 100", c.crear("nombre","apellido1","apellido2","correo@upm.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","123","123","12345678A","jefe"));
    }
    @Test
    public void testR12() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El usuario deberia ser null, porque el dni es diferente a 9", c.crear("nombre","apellido1","apellido2","correo@upm.es","123","123","123456789A","jefe"));
    }
    @Test
    public void testR13() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El usuario deberia ser null, porque la letra dni es diferente a letra", c.crear("nombre","apellido1","apellido2","correo@upm.es","123","123","123456789","jefe"));
    }
    @Test
    public void testR14() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El usuario deberia ser null, porque hay letras en los primeros digitos del dni", c.crear("nombre","apellido1","apellido2","correo@upm.es","123","123","123456bd9A","jefe"));
    }
    @Test
    public void testR15() throws SQLException, IOException, ClassNotFoundException {
        assertNull("El usuario deberia ser null, porque el @ en el correo está mal ", c.crear("nombre","apellido1","apellido2","correo","123","123","123456bd9A","jefe"));
    }
}
